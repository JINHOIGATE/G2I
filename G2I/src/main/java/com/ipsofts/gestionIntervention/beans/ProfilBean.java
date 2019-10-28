/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;


import com.ipsofts.gestionIntervention.entities.Profil;
import com.ipsofts.gestionIntervention.services.ProfilServiceBeanLocal;
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
public class ProfilBean implements Serializable{
    @EJB
     //LES ATTRIBUTS
     private ProfilServiceBeanLocal profilService;
     private Profil formObject,selectObject;
     private List<Profil> profilList;
     private String message="";
     //LES ATTRIBUTS
     
     
      public ProfilBean(){
         this.formObject=new Profil();
     }
     
      @PostConstruct
    public  void chargerElement() {
	//this.listeClients = new ArrayList();
        //this.listeClients = this.clientsService.selectionnerTout();
        this.profilList=new ArrayList<>();
        this.profilList=this.profilService.selectionnerTout();
    }
    
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
    
    public void modifier() {
        try {
            //formObject = this.clientsService.modifier(formObject);
            formObject=this.profilService.modifier(formObject);
            message = "Modification effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void ajouter() {
        try {
           // this.clientsService.ajouter(formObject);
            this.profilService.ajouter(formObject);
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
             message = "Enregistrement effectué avec succès";
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
            this.profilService.supprimer(formObject);
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
        formObject = new Profil();
        selectObject = null;
    }

    public void remplirFormulaire() {
        formObject = selectObject != null ? selectObject : new Profil();
    }

    public ProfilServiceBeanLocal getProfilService() {
        return profilService;
    }

    public void setProfilService(ProfilServiceBeanLocal profilService) {
        this.profilService = profilService;
    }

    public Profil getFormObject() {
        return formObject;
    }

    public void setFormObject(Profil formObject) {
        this.formObject = formObject;
    }

    public Profil getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Profil selectObject) {
        this.selectObject = selectObject;
    }

    public List<Profil> getProfilList() {
        return profilList;
    }

    public void setProfilList(List<Profil> profilList) {
        this.profilList = profilList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
