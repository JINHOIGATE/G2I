/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Modeintervention;
import com.ipsofts.gestionIntervention.services.ModeinterventionServiceBeanLocal;
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
public class ModeinterventionBean implements Serializable{
    
    @EJB
    //LES ATTRIBUTS
     private ModeinterventionServiceBeanLocal modeinterventinService;
     private Modeintervention formObject,selectObject;
     private List<Modeintervention> modeinterventionList;
     private String message="";
     //LES ATTRIBUTS
    
     
     
     public ModeinterventionBean(){
         this.formObject=new Modeintervention();
     }
     
     
     @PostConstruct
    public  void chargerElement() {
         //this.listeClients = new ArrayList();
        //this.listeClients = this.clientsService.selectionnerTout();
        this.modeinterventionList=new ArrayList<>();
        this.modeinterventionList=this.modeinterventinService.selectionnerTout();
    }
    
    public void modifier() {
        try {
            //formObject = this.clientsService.modifier(formObject);
            formObject=this.modeinterventinService.modifier(formObject);
            message = "Modification effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void ajouter() {
        try {
           // this.clientsService.ajouter(formObject);
            this.modeinterventinService.ajouter(formObject);
            message="Ajouter avec succès";
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
            // message = "Enregistrement effectué avec succès";
             this.rafraichir();
        }
        
    }
    
    public void rowSelect (){
        formObject=selectObject;
        
    }
    
    public void supprimer() {
        if (selectObject == null) {
            return;
        }
        try {
            //this.clientsService.supprimer(formObject);
            this.modeinterventinService.supprimer(formObject);
            message = "Suppression effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
//    public void enregistrement(){
////        System.out.println("mp: "+mp);
////        System.out.println("mpConf: "+mpConf);
//        if ()
//        if(mp.equals(mpConf)){
//            formObject.setMdpClient(mpConf);
//            enregistrer();
//        } else {
//        message="Vérifier vos mos de passe";
//        }
//    }
    
    public void rafraichir() {
        this.chargerElement();
        this.effacer();
    }

    public void effacer() {
        formObject = new Modeintervention();
        selectObject = null;
    }

    public void remplirFormulaire() {
        formObject = selectObject != null ? selectObject : new Modeintervention();
    }

    public ModeinterventionServiceBeanLocal getModeinterventinService() {
        return modeinterventinService;
    }

    public void setModeinterventinService(ModeinterventionServiceBeanLocal modeinterventinService) {
        this.modeinterventinService = modeinterventinService;
    }

    public Modeintervention getFormObject() {
        return formObject;
    }

    public void setFormObject(Modeintervention formObject) {
        this.formObject = formObject;
    }

    public Modeintervention getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Modeintervention selectObject) {
        this.selectObject = selectObject;
    }

    public List<Modeintervention> getModeinterventionList() {
        return modeinterventionList;
    }

    public void setModeinterventionList(List<Modeintervention> modeinterventionList) {
        this.modeinterventionList = modeinterventionList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

     
    
    
}
