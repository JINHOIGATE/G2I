/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Demande;
import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Poste;
import com.ipsofts.gestionIntervention.entities.Produit;
import com.ipsofts.gestionIntervention.entities.Service;
import com.ipsofts.gestionIntervention.entities.Typedemande;
import com.ipsofts.gestionIntervention.services.DemandeServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.EntrepriseServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.PosteServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ProduitServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ServiceServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.TypedemandeServiceBeanLocal;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
public class DemandeBean implements Serializable {

    @EJB
    private DemandeServiceBeanLocal demandeService;
    private Demande formObject, selectObject;
    private List<Demande> demandeList;

    @EJB
    private EntrepriseServiceBeanLocal entrepriseService;
    private Entreprise entreprise;
    private List<Entreprise> entrepriseList, controleList;
    @EJB
    private ServiceServiceBeanLocal serviceService;
    private Service service;
    private List<Service> serviceList,serviceFiltre;
    @EJB
    private ProduitServiceBeanLocal produitService;
    private Produit produit;
    private List<Produit> produitList,produitFiltre;
    @EJB
    private PosteServiceBeanLocal posteService;
    private Poste poste;
    private List<Poste> posteList,posteFiltre;
    @EJB
    private TypedemandeServiceBeanLocal typeDemandeService;
    private Typedemande typedemande;
    private List<Typedemande> typedemandeList;

    public DemandeBean() {
        this.formObject = new Demande();
    }

    @PostConstruct
    public void chargerElement() {
        demandeList = new ArrayList<>();
        demandeList = demandeService.selectionnerTout();

        entrepriseList = new ArrayList<>();
        entrepriseList = entrepriseService.selectionnerParTableAttribut(true, "actifE");

        serviceList = new ArrayList<>();
        serviceList = serviceService.selectionnerTout();

        produitList = new ArrayList<>();
        produitList = produitService.selectionnerTout();

        posteList = new ArrayList<>();
        posteList = posteService.selectionnerTout();

        typedemandeList = new ArrayList<>();
        typedemandeList = typeDemandeService.selectionnerTout();

    }

    public void comboRemplirService() {
        try {
            this.serviceFiltre = new ArrayList<>();
            int taille = serviceList.size();

            if (taille != 0) {
                for (int i = 0; i <= taille - 1; i++) {
                    if (serviceList.get(i).getIdUtilisateurE().getIdUtilisateurE().equals(formObject.getIdUtilisateurE().getIdUtilisateurE())) {
                        serviceFiltre.add(serviceList.get(i));
                    }
                }
            }
            
            
            comboRemplirProduit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void comboRemplirProduit() {
        try {
            this.produitFiltre = new ArrayList<>();
            int taille = produitList.size();

            if (taille != 0) {
                for (int i = 0; i <= taille - 1; i++) {
                    if (produitList.get(i).getIdUtilisateurE().getIdUtilisateurE().equals(formObject.getIdUtilisateurE().getIdUtilisateurE())) {
                        produitFiltre.add(produitList.get(i));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void comboRemplirPoste() {
//        List<Poste> posteListfiltre=new ArrayList<>();
//        posteListfiltre = posteService.selectionnerParCleEtrangere(formObject.getIdUtilisateurE().getIdUtilisateurE(),"idUtilisateurE");
        try {
            this.posteFiltre = new ArrayList<>();
            int taille = posteList.size();

            if (taille != 0) {
                for (int i = 0; i <= taille - 1; i++) {
                    if (posteList.get(i).getCodeService().getCodeService().trim().equals(formObject.getCodeService().getCodeService().trim())) {
                        posteFiltre.add(posteList.get(i));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifier() {
        try {
            formObject = this.demandeService.modifier(formObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Date dateJour() {//SOUSTRAIRE LA DATE DU JOUR
        DateFormat date = new SimpleDateFormat("dd'-'MM'-'yyyy' 'hh':'mm':'ss ", Locale.FRANCE);
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public void ajouter() {
        boolean etat_modifie = false;//donc au départ pas encore modifié
        Date datejour = dateJour();
        try {
            this.formObject.setEtatDemande(etat_modifie);
            this.formObject.setDateDemande(datejour);
            this.demandeService.ajouter(formObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enregistrer() {
        if (selectObject != null) {
            modifier();
            this.rafraichir();
        } else {
            ajouter();

            // Envoi de SMS
//                        SendSms sendSms = new SendSms();
//                        sendSms.init();
//                        sendSms.setServer("http://127.0.0.1:8800/");
//                        sendSms.setUser("ipsofts");
//                        sendSms.setPassword("ipsofts");
//                        sendSms.setPhonenumber(formObject.getContactE()); // Numéro du destinataire
//
//                        String message = "";
//                        message += "L'identifiant de votre compte est: " + formObject.getLoginE();
//                        message += " ";
//                        message += "Avec le mot de passe suivant: " + formObject.getMotDePasseE();
//                        sendSms.setText(message);
//                        rafraichir();
//                        System.out.println(sendSms.send());
//                        System.out.println("Notification SMS effectuée");
//                        // Fin
//                        System.out.println("Enregistrement effectué avec succès");
//                    } else {
//                        System.out.println("Message d'erreur");
//                    }
            this.rafraichir();
        }

    }

    public void rowSelect() {
        formObject = selectObject;
        comboRemplirService();
        comboRemplirProduit();
        comboRemplirPoste();

    }

    public void supprimer() {
        if (selectObject == null) {
            return;
        }
        try {
            //this.clientsService.supprimer(formObject);
            this.demandeService.supprimer(formObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rafraichir() {
        this.chargerElement();
        this.effacer();
    }

    public void effacer() {
        formObject = new Demande();
        selectObject = null;
    }

//    public void remplirFormulaire() {
//        formObject = selectObject != null ? selectObject : new Typedemande();
//    }

    public DemandeServiceBeanLocal getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeServiceBeanLocal demandeService) {
        this.demandeService = demandeService;
    }

    public Demande getFormObject() {
        return formObject;
    }

    public void setFormObject(Demande formObject) {
        this.formObject = formObject;
    }

    public Demande getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Demande selectObject) {
        this.selectObject = selectObject;
    }

    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    public EntrepriseServiceBeanLocal getEntrepriseService() {
        return entrepriseService;
    }

    public void setEntrepriseService(EntrepriseServiceBeanLocal entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Entreprise> getEntrepriseList() {
        return entrepriseList;
    }

    public void setEntrepriseList(List<Entreprise> entrepriseList) {
        this.entrepriseList = entrepriseList;
    }

    public List<Entreprise> getControleList() {
        return controleList;
    }

    public void setControleList(List<Entreprise> controleList) {
        this.controleList = controleList;
    }

    public ServiceServiceBeanLocal getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceServiceBeanLocal serviceService) {
        this.serviceService = serviceService;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Service> getServiceFiltre() {
        return serviceFiltre;
    }

    public void setServiceFiltre(List<Service> serviceFiltre) {
        this.serviceFiltre = serviceFiltre;
    }

    public ProduitServiceBeanLocal getProduitService() {
        return produitService;
    }

    public void setProduitService(ProduitServiceBeanLocal produitService) {
        this.produitService = produitService;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    public List<Produit> getProduitFiltre() {
        return produitFiltre;
    }

    public void setProduitFiltre(List<Produit> produitFiltre) {
        this.produitFiltre = produitFiltre;
    }

    public PosteServiceBeanLocal getPosteService() {
        return posteService;
    }

    public void setPosteService(PosteServiceBeanLocal posteService) {
        this.posteService = posteService;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public List<Poste> getPosteList() {
        return posteList;
    }

    public void setPosteList(List<Poste> posteList) {
        this.posteList = posteList;
    }

    public List<Poste> getPosteFiltre() {
        return posteFiltre;
    }

    public void setPosteFiltre(List<Poste> posteFiltre) {
        this.posteFiltre = posteFiltre;
    }

    public TypedemandeServiceBeanLocal getTypeDemandeService() {
        return typeDemandeService;
    }

    public void setTypeDemandeService(TypedemandeServiceBeanLocal typeDemandeService) {
        this.typeDemandeService = typeDemandeService;
    }

    public Typedemande getTypedemande() {
        return typedemande;
    }

    public void setTypedemande(Typedemande typedemande) {
        this.typedemande = typedemande;
    }

    public List<Typedemande> getTypedemandeList() {
        return typedemandeList;
    }

    public void setTypedemandeList(List<Typedemande> typedemandeList) {
        this.typedemandeList = typedemandeList;
    }
    
    
    
}
