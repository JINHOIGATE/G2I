/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Typedemande;
//import com.ipsofts.gestionIntervention.errorMessage.Mtm;
import com.ipsofts.gestionIntervention.services.TypedemandeServiceBeanLocal;
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
public class TypedemandeBean implements Serializable{
    
     @EJB
     private TypedemandeServiceBeanLocal typeDemandeService;
     private Typedemande formObject,selectObject;
     private List<Typedemande> typeDemandeList;
     private String message="";
     
     public TypedemandeBean(){
         this.formObject=new Typedemande();
     }
     
     
     @PostConstruct
    public  void chargerElement() {
        this.typeDemandeList=new ArrayList<>();
        this.typeDemandeList=this.typeDemandeService.selectionnerTout();
    }
    
    public void modifier() {
        try {
            formObject=this.typeDemandeService.modifier(formObject);
            message = "Modification effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void ajouter() {
        try {
            this.typeDemandeService.ajouter(formObject);
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
            this.typeDemandeService.supprimer(formObject);
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
        formObject = new Typedemande();
        selectObject = null;
    }

    public void remplirFormulaire() {
        formObject = selectObject != null ? selectObject : new Typedemande();
    }

    public TypedemandeServiceBeanLocal getTypeDemandeService() {
        return typeDemandeService;
    }

    public void setTypeDemandeService(TypedemandeServiceBeanLocal typeDemandeService) {
        this.typeDemandeService = typeDemandeService;
    }

    public Typedemande getFormObject() {
        return formObject;
    }

    public void setFormObject(Typedemande formObject) {
        this.formObject = formObject;
    }

    public Typedemande getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Typedemande selectObject) {
        this.selectObject = selectObject;
    }

    public List<Typedemande> getTypeDemandeList() {
        return typeDemandeList;
    }

    public void setTypeDemandeList(List<Typedemande> typeDemandeList) {
        this.typeDemandeList = typeDemandeList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

     
}
