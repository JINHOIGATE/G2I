/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Produit;
import com.ipsofts.gestionIntervention.services.EntrepriseServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ProduitServiceBeanLocal;
import com.ipsofts.gestionIntervention.util.Mtm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author HP Envy i7
 */
@ManagedBean
@ViewScoped
public class ProduitBean implements Serializable {

    @EJB
    private ProduitServiceBeanLocal produitService;
    private Produit formObject, selectObject;
    private List<Produit> produitList, controleList;

    @EJB
    private EntrepriseServiceBeanLocal entrepriseProduit;
    private Entreprise entrepriseObject;
    private List<Entreprise> entrepriseList;

    private String message;
    private int idEntreprise;

    public ProduitBean() {
        this.formObject = new Produit();
        this.entrepriseObject = new Entreprise();
    }

    @PostConstruct
    public final void chargerElement() {

//    this.produitList.clear();
        this.produitList = new ArrayList<>();
        this.produitList = this.produitService.selectionnerTout();
//    this.controleList.clear();
        this.controleList = new ArrayList<>();
        this.controleList = this.produitService.selectionnerTout();
//    this.entrepriseList.clear();
        this.entrepriseList = new ArrayList<>();
        entrepriseList = entrepriseProduit.selectionnerParTableAttribut(true, "actifE");

    }

    public void modifier() {
        try {
//            this.entrepriseObject=entrepriseProduit.selectionner(idEntreprise);
//            formObject.setIdUtilisateurE(entrepriseObject);
            formObject.setIdUtilisateurE(formObject.getIdUtilisateurE());
            this.produitService.modifier(formObject);
            message = "Modification effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //LES ATTRIBUTS AUTOMATIQUES A AJOUTER
    public void ajouter() {
        try {

            String codeProduit;
            boolean produitSup = false;
            String nomE;

            nomE = formObject.getIdUtilisateurE().getNomE().trim().toLowerCase();

            codeProduit = nomE + "." + formObject.getNomProduit();

            formObject.setTypeProduit(formObject.getTypeProduit());
            formObject.setCodeProduit(codeProduit.trim().toLowerCase());
            formObject.setProduitSup(produitSup);

            formObject.setIdUtilisateurE(formObject.getIdUtilisateurE());

            this.produitService.ajouter(formObject);
            message = "Ajouter avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
//    public boolean controleExisteAjout() {
//        boolean ajouter = true;
//        
//        return ajouter;
//    }

    public void enregistrer() {
        if (selectObject != null) {
//            if (controleExisteAjout() == true) {
                modifier();
                this.rafraichir();
                Mtm.messageInfoPerso("Modification effectuée avec succès!");
                System.out.println("Modification réussie");
//            } else {
//                System.out.println("Erreur de modification");
//            }
        } else {
//            if (controleExisteAjout() == true) {
                ajouter();
                Mtm.messageInfoPerso("Produit bien renseigné pour l'entreprise: "+formObject.getIdUtilisateurE().getNomE().trim());
                this.rafraichir();
//            } else {
//                System.out.println("Erreur d'ajout");
//            }

        }

    }

    public void rowSelect() {
        formObject = selectObject;
//        formObject.setIdUtilisateurE(selectObject.getIdUtilisateurE
        formObject.getIdUtilisateurE().setNomE(selectObject.getIdUtilisateurE().getNomE());
    }

    public void supprimer() {
        if (selectObject == null) {
            return;
        }
        try {
            //this.clientsProduit.supprimer(formObject);
            this.produitService.supprimer(formObject);
            message = "Suppression effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rafraichir() {
        this.chargerElement();
        this.effacer();
    }

    public void effacer() {
        formObject = new Produit();
        selectObject = null;
    }

    public void remplirFormulaire() {
        formObject = selectObject != null ? selectObject : new Produit();
    }

    public ProduitServiceBeanLocal getProduitService() {
        return produitService;
    }

    public void setProduitService(ProduitServiceBeanLocal produitService) {
        this.produitService = produitService;
    }

    public Produit getFormObject() {
        return formObject;
    }

    public void setFormObject(Produit formObject) {
        this.formObject = formObject;
    }

    public Produit getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Produit selectObject) {
        this.selectObject = selectObject;
    }

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    public EntrepriseServiceBeanLocal getEntrepriseProduit() {
        return entrepriseProduit;
    }

    public void setEntrepriseProduit(EntrepriseServiceBeanLocal entrepriseProduit) {
        this.entrepriseProduit = entrepriseProduit;
    }

    public Entreprise getEntrepriseObject() {
        return entrepriseObject;
    }

    public void setEntrepriseObject(Entreprise entrepriseObject) {
        this.entrepriseObject = entrepriseObject;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public List<Entreprise> getEntrepriseList() {
        return entrepriseList;
    }

    public void setEntrepriseList(List<Entreprise> entrepriseList) {
        this.entrepriseList = entrepriseList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
