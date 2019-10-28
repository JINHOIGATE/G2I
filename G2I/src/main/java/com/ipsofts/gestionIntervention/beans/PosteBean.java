/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Poste;
import com.ipsofts.gestionIntervention.entities.Service;
import com.ipsofts.gestionIntervention.services.EntrepriseServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.PosteServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ServiceServiceBeanLocal;
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
public class PosteBean implements Serializable {

    @EJB
    private PosteServiceBeanLocal posteService;
    private Poste selectObject, formObject;
    private List<Poste> posteList, controleListe;
    private String message = "";

    @EJB
    private ServiceServiceBeanLocal serviceService;
    private Service service;
    private List<Service> serviceList,serviceFiltre;

    @EJB
    private EntrepriseServiceBeanLocal entrepriseService;
    private Entreprise entreprise;
    private List<Entreprise> entrepriseList;

    public PosteBean() {
        this.service = new Service();
        this.formObject = new Poste();
    }

    private Integer idEntreprise;

    @PostConstruct
    public void chargerElement() {

        this.posteList = new ArrayList<>();
        this.posteList = this.posteService.selectionnerTout();
        this.controleListe = this.posteService.selectionnerTout();
        this.entrepriseList = new ArrayList<>();
        this.entrepriseList = this.entrepriseService.selectionnerParTableAttribut(true, "actifE");
        this.serviceList = new ArrayList<>();
        this.serviceList = this.serviceService.selectionnerTout();
    }

    public void comboRemplir (){
        try{
            this.serviceFiltre=new ArrayList<>();
            int taille=serviceList.size();
            
            if (taille!=0){
                for (int i=0; i<=taille-1;i++){
                    if (serviceList.get(i).getIdUtilisateurE().getIdUtilisateurE().equals(formObject.getIdUtilisateurE().getIdUtilisateurE())){
                        serviceFiltre.add(serviceList.get(i));
                    }
                }
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    
    public void modifier() {
        try {
            this.formObject.setCodeService(formObject.getCodeService());
            this.posteService.modifier(formObject);
//            message = "Modification effectuée avec succès";
            Mtm.messageInfoPerso("Modification effectuée avec succès");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ajouter() {
        String codePoste = null;
        try {

            codePoste = this.formObject.getCodeService().getNomService().trim().toLowerCase() + "." + this.formObject.getNomPoste().trim().toLowerCase();
            this.formObject.setCodePoste(codePoste);
            this.formObject.setPosteSup(false);
            System.out.println("service:" + formObject.getCodeService().getNomService());
//            this.formObject.setCodeService(formObject.getCodeService());
            this.posteService.ajouter(formObject);
            Mtm.messageInfoPerso("Enrégistrement effectué avec succès!");
//            rafraichir();
//            message = "Ajouter avec succès";
//            System.out.println("Ajout réussi!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enregistrer() {
        System.out.println("Methode enrégistrée");
        if (selectObject != null) {//si c 'est la modification
            modifier();
            this.rafraichir();
        } else {
            ajouter();
            message = "Enregistrement effectué avec succès";
            this.rafraichir();
        }

    }

    public void rowSelect() {
            formObject = selectObject;
            comboRemplir();
    }


    public void rafraichir() {
        this.chargerElement();
        this.effacer();
        
    }

    public void effacer() {
        formObject = new Poste();
        selectObject = null;
    }

    public void remplirFormulaire() {
        formObject = selectObject != null ? selectObject : new Poste();
    }

    /*GETTEURS SETTEURS*/
    public PosteServiceBeanLocal getPosteService() {
        return posteService;
    }

    public void setPosteService(PosteServiceBeanLocal posteService) {
        this.posteService = posteService;
    }

    public Poste getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Poste selectObject) {
        this.selectObject = selectObject;
    }

    public Poste getFormObject() {
        return formObject;
    }

    public void setFormObject(Poste formObject) {
        this.formObject = formObject;
    }

    public List<Poste> getPosteList() {
        return posteList;
    }

    public void setPosteList(List<Poste> posteList) {
        this.posteList = posteList;
    }

    public List<Poste> getControleListe() {
        return controleListe;
    }

    public void setControleListe(List<Poste> controleListe) {
        this.controleListe = controleListe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public List<Service> getServiceFiltre() {
        return serviceFiltre;
    }

    public void setServiceFiltre(List<Service> serviceFiltre) {
        this.serviceFiltre = serviceFiltre;
    }

    
}
