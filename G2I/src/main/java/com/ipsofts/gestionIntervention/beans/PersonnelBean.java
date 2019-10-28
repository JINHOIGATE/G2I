/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Personnel;
import com.ipsofts.gestionIntervention.entities.Profil;
import com.ipsofts.gestionIntervention.services.PersonnelServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ProfilServiceBeanLocal;
import com.ipsofts.gestionIntervention.util.Mtm;
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
public class PersonnelBean implements Serializable{
    
    @EJB
    private PersonnelServiceBeanLocal personnelService;
    private Personnel formObject,selectObject;
    private List<Personnel> personnelList,controlPersonnel;
    
    @EJB
    private ProfilServiceBeanLocal profilService;
    private Profil profil;
    private List<Profil> profilList;

    public PersonnelBean() {
        this.formObject = new Personnel();
        this.profil = new Profil();
    }

    @PostConstruct

    public final void chargerElement() {
        this.personnelList = new ArrayList<>();
        this.personnelList = this.personnelService.selectionnerTout();
        this.profilList=this.remplirCombo();
    }

    public void modifier() {
        try {
            this.profil = formObject.getIdProfil();
            this.formObject.setIdProfil(profil);
            this.personnelService.modifier(formObject);
            Mtm.messageInfoPerso("Modification réussie!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*LE CODE DU SERVICE SERA GENERE*/
    private String annee() { //SOUSTRAIRE L'ANNEE ACTUELLE
        String texte;
        DateFormat date = new SimpleDateFormat("yyyy", Locale.FRANCE);
        Calendar cal = Calendar.getInstance();
        texte = date.format(cal.getTime());
        return texte;
    }

    private Date dateJour() {//SOUSTRAIRE LA DATE DU JOUR
        DateFormat date = new SimpleDateFormat("dd'-'MM'-'yyyy' 'hh':'mm':'ss ", Locale.FRANCE);
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public List<Profil> remplirCombo(){
       this.profilList=new ArrayList<>();
       this.profilList.add(this.profilService.selectionner(4));
       this.profilList.add(this.profilService.selectionner(5));
        return this.profilList;
    }
    
    private Integer getId (){
        Integer i=null;
        try{
            
            i=this.personnelService.compter()+1;
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    public void ajouter() {
        try {
//            boolean actif;
            String motDePasse;
            boolean paramT;
            boolean sup;
            Date dateCreation;

//            actif = true;
            paramT = false;//la personne ne s'est jamais connecté
            sup = false;//pas supprimé
            motDePasse = formObject.getNomP().trim()+this.getId() +".Ip."+ annee();
            dateCreation = dateJour();

//            this.formObject.setActifP(actif);
            this.formObject.setDateCreationP(dateCreation);
            this.formObject.setMotDePasseP(motDePasse);
            this.formObject.setPersonnelSup(sup);
            this.formObject.setParamP(paramT);
            this.formObject.setIdProfil(formObject.getIdProfil());
            this.formObject.setIdUtilisateurP(this.getId());
            personnelService.ajouter(formObject);
            Mtm.messageInfoPerso("Enrégistrement effectué avec succès!");
            System.out.println("Enrégistrement effectué avec succès!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * *
     * EFFECTUER LE CONTROLE AVANT AJOUT
     *
     * @return
     */
//    public boolean controleModification() {//true modifcation possible
//        boolean modifier = true;
//        if (selectObject != null) {
//            Entreprise entrepriseControleForme = formObject.getIdUtilisateurE();
//            Entreprise entrepriseSelect = selectObject.getIdUtilisateurE();
//            String nomServiceForme = formObject.getNomService().trim().toLowerCase();
//            String nomServiceSelect = selectObject.getNomService().trim().toLowerCase();
//            String nomEForme = entrepriseControleForme.getNomE().trim().toLowerCase();
//            String nomESelect = entrepriseSelect.getNomE().trim().toLowerCase();
//            if ((!nomEForme.equals(nomESelect)) || (!nomServiceForme.equals(nomServiceSelect))) {
//                //s il y aeu modification lors de la modifcation de l'entreprise ou du nom service; verifier au'il n ya pas repetion
//                modifier = this.controleExisteAjout();//false pas de modification
//                System.out.println("Effectuer le controle ici");
//            }
//        } else {
//            modifier = false;
//        }
//        return modifier;
//    }

//    public boolean controleExisteAjout() {
//        String nomE = null;
//        boolean ajouter = true;
//        Entreprise entrepriseControle = formObject.getIdUtilisateurE();
//        nomE = formObject.getIdUtilisateurE().getNomE().trim().toLowerCase();
//        String nomService = formObject.getNomService().trim().toLowerCase();
//        String responsable = formObject.getResponsable().trim();
//        int i = 0;
//        if ((nomService.length() < 3) || (responsable.length() < 3)
//                || entrepriseControle == null) {
//            ajouter = false;
//        } else {
//            //tous les champs sont bien remplis
//            while (i < controleList.size()) {
//                if ((nomE.equals(controleList.get(i).getIdUtilisateurE().getNomE().trim().toLowerCase()))
//                        && (nomService.equals(controleList.get(i).getNomService().trim().toLowerCase()))) {
//                    ajouter = false;
//                }
//                i++;
//            }
//        }
//
//        return ajouter;
//    }

    public void enregistrer() {
        if (selectObject!=null){
            modifier();
            this.rafraichir();
            System.out.println("Modification réussie avec succès");
        }else{
            ajouter();
            this.rafraichir();
            System.out.println("Ajout effectué avec succès");
        }

    }

    public void rowSelect() {
        formObject = selectObject;

    }

//    public void supprimer() {
//        if (selectObject == null) {
//            return;
//        }
//        try {
//            //this.clientsService.supprimer(formObject);
//            this.serviceService.supprimer(formObject);
//            message = "Suppression effectuée avec succès";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void rafraichir() {
        this.chargerElement();
        this.effacer();
    }

    public void effacer() {
        formObject = new Personnel();
        selectObject = null;
    }

    public void remplirFormulaire() {
        formObject = selectObject != null ? selectObject : new Personnel();
    }

    public PersonnelServiceBeanLocal getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(PersonnelServiceBeanLocal personnelService) {
        this.personnelService = personnelService;
    }

    public Personnel getFormObject() {
        return formObject;
    }

    public void setFormObject(Personnel formObject) {
        this.formObject = formObject;
    }

    public Personnel getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Personnel selectObject) {
        this.selectObject = selectObject;
    }

    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }

    public List<Personnel> getControlPersonnel() {
        return controlPersonnel;
    }

    public void setControlPersonnel(List<Personnel> controlPersonnel) {
        this.controlPersonnel = controlPersonnel;
    }

    public ProfilServiceBeanLocal getProfilService() {
        return profilService;
    }

    public void setProfilService(ProfilServiceBeanLocal profilService) {
        this.profilService = profilService;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public List<Profil> getProfilList() {
        return profilList;
    }

    public void setProfilList(List<Profil> profilList) {
        this.profilList = profilList;
    }

    
}
