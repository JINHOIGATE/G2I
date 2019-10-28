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
import com.ipsofts.gestionIntervention.entities.Technicien;
import com.ipsofts.gestionIntervention.services.ActionServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.EntrepriseServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.PersonnelServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.ProfilServiceBeanLocal;
import com.ipsofts.gestionIntervention.services.TechnicienServiceBeanLocal;
import com.ipsofts.gestionIntervention.util.Mtm;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author HP Envy i7
 */
@ManagedBean
@ViewScoped
public class EntrepriseBean implements Serializable {

    @EJB
    private EntrepriseServiceBeanLocal entrepriseService;
    //LES ATTRIBUTS ENTREPRISE
    private Entreprise selectObject, formObject;
    private List<Entreprise> entrepriseList, controleList;
    private String message = "";
    //LES ATTRIBUTS ENTREPRISE
    @EJB
    private ActionServiceBeanLocal actionService;
    private Action action;
    private ActionBean actionBean = new ActionBean();
    //LES ATTRIBUTS PROFIL
    @EJB
    private ProfilServiceBeanLocal profilService;
    private Profil profil;
    //LES ATTRIBUTS PROFIL
    @EJB
    private TechnicienServiceBeanLocal technicienService;
    private List<Technicien> controleListeTech;
    @EJB
    private PersonnelServiceBeanLocal personnelService;
    private List<Personnel> controleListePerso;
    //LES ATTRIBUTS AUTO A AJOUTER
    private String motDePasse;
//    private boolean actif;
    private Date datecreation;
    private boolean entrepriseSup;
    private boolean param;
  //LES ATTRIBUTS AUTO A AJOUTER

    //LE CONSTRUCTEUR
    public EntrepriseBean() {

        this.profil = new Profil();
        this.formObject = new Entreprise();

    }
    //LE CONSTRUCTEUR

    @PostConstruct
    public void chargerElement() { //REMPLIR LA LISTE DES ENTREPRISES A L'OUVERTUR DE LA PAGE
        this.entrepriseList = new ArrayList<>();
        this.entrepriseList = this.entrepriseService.selectionnerTout();
        this.controleList = new ArrayList<>();
        this.controleList = this.entrepriseService.selectionnerTout();
        this.controleListeTech = new ArrayList<>();
        this.controleListeTech = technicienService.selectionnerTout();
        this.controleListePerso = new ArrayList<>();
        this.controleListePerso = personnelService.selectionnerTout();
    }

    /**
     * Enregistrer une action
     *
     * @param description
     * @param action
     */
    private void enregistrer_action(String description, String action) {

//        System.out.println("libelle pro:"+this.profilService.selectionner(2).getLibelleProfil());
        this.actionBean.setNomUtilisateur(formObject.getNomE());//Nom du faiseur d'action
        this.actionBean.getFormObject().setDateAction(this.dateJour());//date heure de l'action
        this.actionBean.getFormObject().setDescriptionAction(description);//description de l'action
        this.actionBean.getFormObject().setIdProfil(formObject.getIdProfil());
        this.actionBean.getFormObject().setIdUtilisateur(this.formObject.getIdUtilisateurE());//l'identifiant du faiseur d'action
        this.actionBean.getFormObject().setNomUtilisateur(this.formObject.getNomE());//l'identifiant du faiseur d'action
        this.actionBean.getFormObject().setLibelleAction(action);
        this.actionService.ajouter(this.actionBean.getFormObject());
    }

    public void modifier() {
        String description = "Une modification a été effectuée sur le compte entreprise";
        String travail = "Modification";
        try {
            /*FAIRE APPEL A LA METHODE MODIFIER*/
            this.entrepriseService.modifier(formObject);
            this.enregistrer_action(description, travail);
            System.out.println("Ajout effectif dans action");
            Mtm.messageInfoPerso("Modification effectué avec succès!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMessageContrat() {
        String codeEntreprise = formObject.getNomE();
        String summary = formObject.getEstSousContrat() ? "L'entreprise: " + codeEntreprise + " est sous contrat"
                : "L' entreprise :" + codeEntreprise + " n'est pas sous contrat";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public void addMessageActiver() {
        String codeEntreprise = formObject.getNomE();
        String summary = formObject.getActifE() ? "Le compte de :" + codeEntreprise + " est actif"
                : "Le compte de:" + codeEntreprise + " est inactif";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    //MODIFICATION DU MOT DE PASSE
    /**
     * MODIFIER LE MOT DE PASSE
     *
     * @param newPass LE NOUVEAU MOT DE PASSE
     */
    public void changerMotDePasse(String newPass) {
        try {
            if (controleModifPass(formObject.getLoginE(), formObject.getMotDePasseE())) {
                formObject.setMotDePasseE(newPass);
                formObject = this.entrepriseService.modifier(formObject);
                message = "Modification effectuée avec succès";
            } else {
                System.out.println("Erreur d'identification");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * renvoie actif si l'attribut actif est à true et inactif au cas contraire
     *
     * @return
     */
    public String gestionActif() {
        String retour = null;
        if (formObject.getActifE() == true) {
            retour = "Actif";
        } else {
            retour = "Inactif";
        }
        return retour;
    }

    /**
     * CONTROLER LA MODIFICATION DU MOT DE PASSE
     *
     * @param login verifier si le login ancien est correct
     * @param oldPass verifier si le old passe est correct
     * @return true si les identifiants sont corrects
     */
    public boolean controleModifPass(String login, String oldPass) {
        boolean modifier = false;
        try {
            if (entrepriseService.existEntite("loginE", "motDePasseE",
                    login.trim().toLowerCase(), oldPass.trim().toLowerCase()) == true) {
                modifier = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modifier;
    }

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

    private Integer getId() {//retourner l'id de l'entreprise
        Integer i = null;
        try {

            i = this.entrepriseService.compter() + 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * AJOUTER UNE NOUVELLE ENTITE
     *
     */
    public void ajouter() {
        String description = "Un nouveau compte d'entreprise vient d'être crée";
        String travail = "Ajout";
        try {
            this.datecreation = dateJour();
            this.entrepriseSup = false;//entreprise n' est pas supprimé
            this.param = false;//ne s'est pas encore connecté au système
            this.profil = this.profilService.selectionner(2);
            //le profil de l'entreprise a toujours la valeur no 2.
            this.motDePasse = this.formObject.getNomE() + this.getId() + ".Ip." + annee();//nom+numero+.Ip.+annee
            formObject.setContactE(formObject.getContactE().trim());
            formObject.setNomE(formObject.getNomE().trim());
            formObject.setEmailE(formObject.getEmailE().trim());
            formObject.setLoginE(formObject.getLoginE().trim());
            formObject.setMotDePasseE(motDePasse.trim());
            formObject.setDateCreationE(datecreation);
            formObject.setEntrepriseSup(entrepriseSup);
            formObject.setParamE(param);
            formObject.setIdProfil(profil);

            /*FAIRE APPEL A LA METHODE AJOUTER*/
            this.entrepriseService.ajouter(formObject);
            Mtm.messageInfoPerso("Enrégistrement effectué avec succès!");
            /*Faire la mise à jour du journal d'action*/
            this.enregistrer_action(description, travail);
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
    /**
     * Controle de contact , renvoie true si le contact est correct et false au
     * cas contraire
     *
     * @return
     */
    public boolean controleContact() {//true l'ajout peut etre effectué
        String contact = formObject.getContactE().trim();
        char premierCarater;
        boolean controle = false;
        if ((contact.length() == 11) && contact.matches("\\d{2}\\-\\d{2}\\-\\d{2}\\-\\d{2}")) {
            premierCarater = contact.charAt(0);
            if ((String.valueOf(premierCarater)).equals("9") || (String.valueOf(premierCarater)).equals("2")) {
                controle = true;
            } else {
                controle = false;
                Mtm.messageErrorPerso("Veuillez saisir un contact valide!Svp");
            }
        } else {
            controle = false;
            Mtm.messageErrorPerso("Veuillez saisir un contact valide!Svp");
        }
        return controle;
    }

    /**
     * Controle si tous les champs de l'interface sont remplis renvoie true si
     * un champ n'est pas rempli et false si tous les champs sont remplis
     *
     * @return
     */
    public boolean controleVide() {
        boolean vide = false; // false ce n'est pas vide
        if (formObject.getNomE() == null) {
            vide = true;
            Mtm.messageWarnSaisir("le nom de l'entreprise");
        }
        if (formObject.getEmailE() == null) {
            vide = true;
            Mtm.messageWarnSaisir("l'email de l'entreprise");
        }
        if (formObject.getContactE() == null) {
            vide = true;
            Mtm.messageWarnSaisir("le contact de l'entreprise");
        }
        if (formObject.getLoginE() == null) {
            vide = true;
            Mtm.messageWarnSaisir("l'identifiant de l'entreprise");
        }
        return vide;
    }

    /* CONTROLE CONTACT et EMAIL*/
    private boolean controleExisteContactE() {
        boolean contact = true;
        boolean email = true;
        boolean ajouter = true;
        int u = 0;
        while (u < controleList.size()) {
            if (this.formObject.getContactE().equals(controleList.get(u).getContactE())) {
                contact = false;
            }
            if (this.formObject.getEmailE().trim().equals(controleList.get(u).getEmailE())) {
                email = false;
            }
            u++;
        }
        if (contact == false) {
            ajouter = false;
            Mtm.messageWarn("Cet contact existe déjà dans le système");
        }
        if (email == false) {
            System.out.println("je verifie l'email");
            ajouter = false;
            Mtm.messageWarn("Cet email existe déjà dans le système");
        }
        return ajouter;
    }

    private boolean controleExisteContactT() {
        boolean contact = true;
        boolean email = true;
        boolean ajouter = true;
        int u = 0;
        while (u < controleListeTech.size()) {
            if (this.formObject.getContactE().equals(controleListeTech.get(u).getContactT())) {
                contact = false;
            }
            if (this.formObject.getEmailE().trim().equals(controleListeTech.get(u).getEmailT())) {
                email = false;
            }
            u++;
        }
        if (contact == false) {
            ajouter = false;
            Mtm.messageWarn("Cet contact existe déjà dans le système");
        }
        if (email == false) {
            System.out.println("je verifie l'email");
            ajouter = false;
            Mtm.messageWarn("Cet email existe déjà dans le système");
        }
        return ajouter;
    }

    private boolean controleExisteContactP() {
        boolean contact = true;
        boolean email = true;
        boolean ajouter = true;
        int u = 0;
        while (u < controleListePerso.size()) {
            if (this.formObject.getContactE().equals(controleListePerso.get(u).getContactP())) {
                contact = false;
            }
            if (this.formObject.getEmailE().trim().equals(controleListePerso.get(u).getEmailP())) {
                email = false;
            }
            u++;
        }
        if (contact == false) {
            ajouter = false;
            Mtm.messageWarn("Cet contact existe déjà dans le système");
        }
        if (email == false) {
            System.out.println("je verifie l'email");
            ajouter = false;
            Mtm.messageWarn("Cet email existe déjà dans le système");
        }
        return ajouter;
    }

    /****
     *true le nom n' existe pas
     * */
    private boolean controleExisteNom() {
        boolean ajouter = true;
        int i = 0;
        while (i < this.controleList.size()) {
            System.out.println("nom1" + formObject.getNomE().trim() + "nom2 " + controleList.get(i).getNomE());
            if (this.formObject.getNomE().trim().equals(controleList.get(i).getNomE())) {
                //existence du nom de l'entreprise
                System.out.println("Ce nom existe déjà");
                ajouter = false;
            }
            i++;
        }

        if (ajouter == false) {
            Mtm.messageWarn("Ce nom d'entreprise existe déjà dans le système!");
        }
        return ajouter;
    }


    
    /**
     *Méthode pour enrégistrer 
     * 
     **/
    public void enregistrer() {
        if (selectObject != null) {
            if (controleVide() == false) {
                if (controleContact() == true) {                        
                        modifier();
                        this.rafraichir();
                }
            }

        } else {

            if ((controleVide() == false)) {
                if (controleContact() == true) {
                    if ((controleExisteNom() == true) && (controleExisteContactE() == true)
                            && (controleExisteContactP() == true) && (controleExisteContactT() == true)) {
                        ajouter();
                        this.rafraichir();

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
                    }
                }
            }

        }
    }


    /**
     * ROW SELECT PERMET DE RECOPIER L OBJET SELECTIONNE DANS LA FORME DE L
     * OBJET
     */
    public void rowSelect() {
        formObject = selectObject;
    }

    /**
     * RAFRAICHIR PERMET D ACTUALISER UNE PAGE ET DE REMETTRE TOUT A DEFAUT
     */
    public void rafraichir() {
        this.chargerElement();
        this.effacer();
    }

    private boolean skip;

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;

    }

    private static Logger logger = Logger.getLogger(Entreprise.class
            .getName());

    public String onFlowProcess(FlowEvent event) {

        logger.info("Current wizard step:" + event.getOldStep());
        logger.info("Next step:" + event.getNewStep());
        if (skip) {
            //reset in case user goes back
            skip = false;
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    /**
     * EFFACER PERMET DE CREER UNE NOUVELLE ENTITE : ELLE REINITIALISE OFT L
     * ENTITE
     *
     */
    public void effacer() {
        formObject = new Entreprise();
        selectObject = null;
    }

    /**
     * SI AUCUN OBJET N EST SELECTIONNE; LA FORME DE L OBJET EST REINITIALISE
     * SINON ELLE PREND LES DONNE SELECTIONNEES
     */
    public void remplirFormulaire() {
        formObject = (selectObject != null) ? selectObject : new Entreprise();
    }

    /* LES GETTEURS ET SETTEURS*/
    public EntrepriseServiceBeanLocal getEntrepriseService() {
        return entrepriseService;
    }

    public void setEntrepriseService(EntrepriseServiceBeanLocal entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    public Entreprise getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Entreprise selectObject) {
        this.selectObject = selectObject;
    }

    public Entreprise getFormObject() {
        return formObject;
    }

    public void setFormObject(Entreprise formObject) {
        this.formObject = formObject;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

//    public boolean isActif() {
//        return actif;
//    }
//
//    public void setActif(boolean actif) {
//        this.actif = actif;
//    }
    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public boolean isEntrepriseSup() {
        return entrepriseSup;
    }

    public void setEntrepriseSup(boolean entrepriseSup) {
        this.entrepriseSup = entrepriseSup;
    }

    public boolean isParam() {
        return param;
    }

    public void setParam(boolean param) {
        this.param = param;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public ProfilServiceBeanLocal getProfilService() {
        return profilService;
    }

    public void setProfilService(ProfilServiceBeanLocal profilService) {
        this.profilService = profilService;
    }
//Méthode pour tout récupérer

    public List<Entreprise> entreprises() {
        this.entrepriseList = entrepriseService.selectionnerTout();
        return this.entrepriseList;
    }
}
