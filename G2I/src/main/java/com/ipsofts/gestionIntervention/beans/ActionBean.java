/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Action;
import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Personnel;
import com.ipsofts.gestionIntervention.entities.Profil;
import com.ipsofts.gestionIntervention.entities.Service;
import com.ipsofts.gestionIntervention.services.ActionServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.EntrepriseServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.PersonnelServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ProfilServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.TechnicienServiceBeanLocal;
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
public class ActionBean implements Serializable{
    
    @EJB
    private ActionServiceBeanLocal actionService;
    private  Action formObject,selectObject;
    private List<Action> actionList;
    @EJB
    private EntrepriseServiceBeanLocal entrepriseService;
    private Entreprise entreprise;
    private List<Entreprise> entrepriseList;
    
    @EJB
    private TechnicienServiceBeanLocal technicienService;
    private Service service;
    private List<Service> serviceList;
    
    @EJB
    private PersonnelServiceBeanLocal personnelService;
    private Personnel personnel;
    private List<Personnel> personnelList;
    
    @EJB
    private ProfilServiceBeanLocal profilService;
    private Profil profil;
    
  
    private String nomUtilisateur;
    private Integer idUtilisateur;
    
    public ActionBean(){
         this.formObject=new Action();
     }
     
     
     @PostConstruct
    public  void chargerElement() {
        this.actionList=new ArrayList<>();
        this.actionList=this.actionService.selectionnerTout();
    }
    
     private Date dateJour() {//SOUSTRAIRE LA DATE DU JOUR
        DateFormat date = new SimpleDateFormat("dd'-'MM'-'yyyy' 'hh':'mm':'ss ", Locale.FRANCE);
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
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
           // this.clientsService.ajouter(formObject);
            formObject.setIdAction(getId());
            this.actionService.ajouter(formObject);
            this.rafraichir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 public void rafraichir() {
        this.chargerElement();
        this.effacer();
    }

    public void effacer() {
        formObject = new Action();
        selectObject = null;
    }

    public ActionServiceBeanLocal getActionService() {
        return actionService;
    }

    public void setActionService(ActionServiceBeanLocal actionService) {
        this.actionService = actionService;
    }

    public Action getFormObject() {
        return formObject;
    }

    public void setFormObject(Action formObject) {
        this.formObject = formObject;
    }

    public Action getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Action selectObject) {
        this.selectObject = selectObject;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
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

    public TechnicienServiceBeanLocal getTechnicienService() {
        return technicienService;
    }

    public void setTechnicienService(TechnicienServiceBeanLocal technicienService) {
        this.technicienService = technicienService;
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

    public PersonnelServiceBeanLocal getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(PersonnelServiceBeanLocal personnelService) {
        this.personnelService = personnelService;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }


    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    
    
    
    
    
    
}
