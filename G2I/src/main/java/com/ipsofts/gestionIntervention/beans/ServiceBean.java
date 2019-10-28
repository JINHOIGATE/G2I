/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Service;
import com.ipsofts.gestionIntervention.services.EntrepriseServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ServiceServiceBeanLocal;
import com.ipsofts.gestionIntervention.util.Mtm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import static org.eclipse.persistence.expressions.ExpressionOperator.trim;

/**
 *
 * @author HP Envy i7
 */
@ManagedBean
@ViewScoped
public class ServiceBean implements Serializable {

    @EJB
    private ServiceServiceBeanLocal serviceService;
    private Service formObject, selectObject;
    private List<Service> serviceList, controleList;

    @EJB
    private EntrepriseServiceBeanLocal entrepriseService;
    private Entreprise entrepriseObject;
    private List<Entreprise> entrepriseList;
    private String message;

    private Integer idEntreprise;

    public ServiceBean() {
        this.formObject = new Service();
        this.entrepriseObject = new Entreprise();
    }

    @PostConstruct

    public final void chargerElement() {

        this.serviceList = new ArrayList<>();
        this.serviceList = this.serviceService.selectionnerTout();
        this.controleList = new ArrayList<>();
        this.controleList = this.serviceService.selectionnerTout();
        this.entrepriseList = new ArrayList<>();
//        entrepriseList = entrepriseService.selectionnerTout();
        this.entrepriseList=entrepriseService.selectionnerParCleEtrangere(true, "actifE");
    }

    public void modifier() {
        try {
            this.entrepriseObject = formObject.getIdUtilisateurE();
            this.formObject.setIdUtilisateurE(entrepriseObject);
             this.serviceService.modifier(formObject);
            message = "Modification effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*LE CODE DU SERVICE SERA GENERE*/
    public void ajouter() {
        String codeService;
        String nomE;
        try {
            this.entrepriseObject = formObject.getIdUtilisateurE();
            codeService = this.entrepriseObject.getNomE() + "." + this.formObject.getNomService();
            formObject.setServiceSup(false);//service non supprimé
            formObject.setCodeService(codeService);
            formObject.setIdUtilisateurE(entrepriseObject);
            this.serviceService.ajouter(formObject);
            message = "Ajouter avec succès";
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
//        if (selectObject!=null){
//        Entreprise entrepriseControleForme = formObject.getIdUtilisateurE();
//        Entreprise entrepriseSelect = selectObject.getIdUtilisateurE();
//        String nomServiceForme = formObject.getNomService().trim().toLowerCase();
//        String nomServiceSelect = selectObject.getNomService().trim().toLowerCase();
//        String nomEForme = entrepriseControleForme.getNomE().trim().toLowerCase();
//        String nomESelect = entrepriseSelect.getNomE().trim().toLowerCase();
//        if ((!nomEForme.equals(nomESelect)) || (!nomServiceForme.equals(nomServiceSelect))) {
//            //s il y aeu modification lors de la modifcation de l'entreprise ou du nom service; verifier au'il n ya pas repetion
//            modifier = this.controleExisteAjout();//false pas de modification
//            System.out.println("Effectuer le controle ici");
//        }
//        }else {
//            modifier=false;
//        }
//        return modifier;
//    }
//
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
        if (selectObject != null) {
//            if (controleModification() == true) {
                modifier();
                Mtm.messageInfoPerso("Modificatoin effectuée avec succès");
                this.rafraichir();
                System.out.println("modification réussie dans le service");
//            } else {
//                System.out.println("Impossible de modifier dans le service");
//            }
        } else {
//            if (controleExisteAjout() == true) {
//                System.out.println("ajout avec succès");
                ajouter();
//                message = "Enregistrement effectué avec succès";
                Mtm.messageInfoPerso("Service bien renseigné pour l'entreprise: "+formObject.getIdUtilisateurE().getNomE().trim());
                this.rafraichir();
//            } else {
//                System.out.println("erreur d'ajout dans le service");
//            }
        }

    }

    public void rowSelect() {
        formObject = selectObject;

    }

    public void supprimer() {
        if (selectObject == null) {
            return;
        }
        try {
            //this.clientsService.supprimer(formObject);
            this.serviceService.supprimer(formObject);
            message = "Suppression effectuée avec succès";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rafraichir() {
        this.chargerElement();
        this.effacer();
        this.idEntreprise = null;
    }

    public void effacer() {
        formObject = new Service();
        selectObject = null;
    }

    public void remplirFormulaire() {
        formObject = selectObject != null ? selectObject : new Service();
    }

    public ServiceServiceBeanLocal getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceServiceBeanLocal serviceService) {
        this.serviceService = serviceService;
    }

    public Service getFormObject() {
        return formObject;
    }

    public void setFormObject(Service formObject) {
        this.formObject = formObject;
    }

    public Service getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Service selectObject) {
        this.selectObject = selectObject;
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

    public Entreprise getEntrepriseObject() {
        return entrepriseObject;
    }

    public void setEntrepriseObject(Entreprise entrepriseObject) {
        this.entrepriseObject = entrepriseObject;
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

    public List<Service> getControleList() {
        return controleList;
    }

    public void setControleList(List<Service> controleList) {
        this.controleList = controleList;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

}
