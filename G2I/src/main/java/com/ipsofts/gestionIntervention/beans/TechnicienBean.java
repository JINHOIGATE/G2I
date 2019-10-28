/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans;

import com.ipsofts.gestionIntervention.entities.Profil;
import com.ipsofts.gestionIntervention.entities.Technicien;
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
public class TechnicienBean implements Serializable {

    @EJB
    private TechnicienServiceBeanLocal technicienService;
    private Technicien formObject, selectObject;
    private List<Technicien> technicienList, controleList;
    @EJB
    private ProfilServiceBeanLocal profilService;
    private Profil profil;
    //LES ATTRIBUTS PROFIL
    @EJB
    private PersonnelServiceBeanLocal personnelService;

    @EJB
    private EntrepriseServiceBeanLocal entrepriseService;
    //LES ATTRIBUTS AUTO A AJOUTER
    private String motDePasse;
    private Date datecreation;
    private boolean Sup;
    private boolean param;

    //LE CONSTRUCTEUR
    public TechnicienBean() {

        this.profil = new Profil();
        this.formObject = new Technicien();

    }
    //LE CONSTRUCTEUR

    @PostConstruct
    public void chargerElement() { //REMPLIR LA LISTE DES ENTREPRISES A L'OUVERTUR DE LA PAGE
        this.technicienList = new ArrayList<>();
        this.technicienList = this.technicienService.selectionnerTout();
    }

    /**
     * MODIFIER UNE ENTITE
     */
    public void modifier() {
        try {
            /*FAIRE APPEL A LA METHODE MODIFIER*/
            this.technicienService.modifier(formObject);
            Mtm.messageInfoPerso("Modification réussie!");
//            System.out.println("Modification réussie!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //MODIFICATION DU MOT DE PASSE
    /**
     * MODIFIER LE MOT DE PASSE
     *
     * @param newPass LE NOUVEAU MOT DE PASSE
     */
    public void changerMotDePasse(String newPass) {
        try {
            if (controleModifPass(formObject.getLoginT(), formObject.getMotDePasseT())) {
                formObject.setMotDePasseT(newPass);
                formObject = this.technicienService.modifier(formObject);
//                message = "Modification effectuée avec succès";
                System.out.println("mot de passe bien modifié");
            } else {
                System.out.println("Erreur d'identification");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            if (technicienService.existEntite("loginT", "motDePasseT", login.trim().toLowerCase(), oldPass) == true) {
                modifier = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modifier;
    }

    /**
     * LES AJOUTS DES ATTRIBUTS AUTOMATIQUES*
     */
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

    private Integer getId() {
        Integer i = null;
        try {

            i = this.technicienService.compter() + 1;

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
        try {

            System.out.println("date naissance " + this.formObject.getDateNaissanceT());
            this.datecreation = dateJour();
            this.Sup = false;//entreprise n' est pas supprimé
            this.param = false;//ne s'est pas encore connecté au système
            this.profil = this.profilService.selectionner(3);//entreprise est le premier profil alors
            System.out.println("Nombre de technicien:" + getId());
            this.motDePasse = formObject.getNomT() + "Ip" + this.getId() + annee();
            formObject.setIdUtilisateurT(this.getId());
            System.out.println("sexe" + formObject.getSexeT());
            formObject.setMotDePasseT(motDePasse);
            System.out.println("Mot de passe" + formObject.getMotDePasseT());
            formObject.setDateCreationT(datecreation);
            formObject.setTechnicienSup(Sup);
            formObject.setParamT(param);
            formObject.setIdProfil(profil);
            System.out.println("profil" + profil.getLibelleProfil());
            /*FAIRE APPEL A LA METHODE AJOUTER*/
            this.technicienService.ajouter(formObject);
            Mtm.messageInfoPerso("Enrégistrement effectué succès!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CONTROLER LE CONTACT SOUS FORMAT 98-28-60-58
     */
    public boolean controleContact() {//true l'ajout peut etre effectué
        String contact = formObject.getContactT().trim();
        char premierCarater;
        boolean controle = false;
        if ((contact.length() == 11) && contact.matches("\\d{2}\\-\\d{2}\\-\\d{2}\\-\\d{2}")) {
            premierCarater = contact.charAt(0);
            if ((String.valueOf(premierCarater)).equals("9") || (String.valueOf(premierCarater)).equals("2")) {
                controle = true;
            }
        }
        return controle;
    }

    /**
     * CONTROLE DE LA DATE SOUS LA FORME JJ-MM-AAAA age compris entre 18 et 66
     *
     * @param strDate
     * @return
     */
//    public static Date getSQLDate(String strDate) {
//    java.sql.Date sqlDate = null;
//    try {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        java.util.Date dt = formatter.parse(strDate);
//        sqlDate = new java.sql.Date(dt.getTime());
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    return sqlDate;
//}
    public boolean controleDate() {//true l'ajout peut etre effectué
        String date = formObject.getDateNaissanceT().toString().trim();
        System.out.println("date calendar:" + date);
        boolean controle = true;//a revoir le controle de la date de naissance
        String annee;
        int age;
        if ((date.length() == 10) && date.matches("\\d{2}\\-\\d{2}\\-\\d{4}")) {
            annee = date.substring(6, 10);
            age = Integer.parseInt(this.annee()) - Integer.parseInt(annee);
            System.out.println("age:" + age);
            if ((age <= 66) && (age >= 18)) {
                controle = true;
            }
        }
        return controle;
    }

    public boolean controleExisteAjout() {
        boolean ajouter = true;
        if ((controleContact() == true) && (formObject.getNomT().trim().length() >= 3)
                && (formObject.getPrenomT().trim().length() >= 3) && (formObject.getLoginT().trim().length() >= 6)
                && (formObject.getSexeT() != null) && (controleDate() == true)) {//controle du contact

            //verifions l'existence d'un technicien
            if ((entrepriseService.exists(this.formObject.getContactT().trim(), "contactE") == true)
                    || (technicienService.exists(this.formObject.getContactT().trim().toLowerCase(), "contactT") == true)
                    || (personnelService.exists(this.formObject.getContactT().trim().toLowerCase(), "contactP") == true)) {
                //existence du contact
                ajouter = false;
                System.out.println("Ce contact est deja utilisé");
            }

            if ((entrepriseService.exists(this.formObject.getEmailT().trim().toLowerCase(), "emailE") == true)
                    || (technicienService.exists(this.formObject.getEmailT().trim().toLowerCase(), "emailT") == true)
                    || (personnelService.exists(this.formObject.getEmailT().trim().toLowerCase(), "emailP")) == true) {
                //existence de l'email
                ajouter = false;
                System.out.println("Ce email est deja utilise");
            }
        } else {
            ajouter = false;
            if (controleContact() == false) {
                System.out.println("Saisie contact incorrect!");
            } else if (formObject.getNomT().trim().length() < 3) {
                System.out.println("Saisie incorrect nom!");
            } else if (formObject.getPrenomT().trim().length() < 3) {
                System.out.println("Saisie incorrect prenom!");
            } else if (formObject.getLoginT().trim().length() < 6) {
                System.out.println("Erreur saisie login");
            } else if (formObject.getSexeT() == null) {
                System.out.println("Veuillez selectionner le sexe");
            } else {
                System.out.println("Date incorrect!");
                System.out.println("age:" + formObject.getDateNaissanceT());

            }
        }
        return ajouter;
    }

    public boolean controleModif() {//modif true on peut modifier
        boolean modif = true;
        if (selectObject != null) {// au moment de la modification
            System.out.println("La verification de la modification est effective");
            if ((controleContact() == true) && (formObject.getNomT().trim().length() >= 3)
                    && (formObject.getPrenomT().trim().length() >= 3) && (formObject.getLoginT().trim().length() >= 6)
                    && (formObject.getSexeT() != null) && (controleDate() == true)) {//controle du contact

                if (!selectObject.getEmailT().trim().toLowerCase().equals(formObject.getEmailT().trim().toLowerCase())) {
                    //s'il modifie l'email
                    System.out.println("Controle avant existence de l email");
                    if ((entrepriseService.exists(this.formObject.getEmailT().trim().toLowerCase(), "emailE") == true)
                            || (technicienService.exists(this.formObject.getEmailT().trim().toLowerCase(), "emailT") == true)
                            || (personnelService.exists(this.formObject.getEmailT().trim().toLowerCase(), "emailP")) == true) {
                        //existence de l'email
                        modif = false;
                        System.out.println("Ce email est deja utilise dans la modification");
                    }
                }
                if (!selectObject.getContactT().trim().equals(formObject.getContactT().trim())) {// s'il modifie le contact
                    if ((entrepriseService.exists(this.formObject.getContactT().trim(), "contactE") == true)
                            || (technicienService.exists(this.formObject.getContactT().trim().toLowerCase(), "contactT") == true)
                            || (personnelService.exists(this.formObject.getContactT().trim().toLowerCase(), "contactP") == true)) {
                        //existence du contact
                        modif = false;
                        System.out.println("Ce contact est deja utilisé");
                    }
                }
            } else {
                modif = false;
                System.out.println("Erreur de la modification , les saisies sont mal faites !");
            }
        }
        return modif;

    }

    /**
     * CONTROLE AVANT L'AJOUT METHODE AJOUT A APPELER SUR L INTERFACE /*
     */
    public void enregistrer() {
        if (selectObject != null) {//MODE MODIFICATION
            if (controleModif() == true) {
                modifier();
                this.rafraichir();
                System.out.println("Mise a jour succcès modification");
            } else {
                System.out.println("Impossible de modifier modification");
            }
        } else { //MODE AJOUT
            if (controleExisteAjout() == true) {
                this.ajouter();
                this.rafraichir();
                System.out.println("AJOUT EFFECTUE AVEC SUCCCES");
                // Envoi de SMS
//                SendSms sendSms = new SendSms();
//                sendSms.init();
//                sendSms.setServer("http://127.0.0.1:8800/");
//                sendSms.setUser("ipsofts");
//                sendSms.setPassword("ipsofts");
//                sendSms.setPhonenumber(formObject.getContactE()); // Numéro du destinataire
//
//                String message = "";
//                message += "L'identifiant de votre compte est: "+formObject.getLoginE();
//                message += " ";
//                message += "Avec le mot de passe suivant: "+formObject.getMotDePasseE();
////                message += recharge.getMontant();
////                message += " ";
////                message += recharge.getUniteMonetaire();
////                message += " via une transaction SYR";
//
//                sendSms.setText(message);
//                System.out.println(sendSms.send());
//                System.out.println("Notification SMS effectuée");
//                // Fin
//                System.out.println("Enregistrement effectué avec succès");
//                this.rafraichir();
            } else {
                System.out.println("Message d'erreur");
            }
//            }

        }
    }

    /**
     * ROW SELECT PERMET DE RECOPIER L OBJET SELECTIONNE DANS LA FORME DE L
     * OBJET
     */
    boolean editActif;
    boolean editDesc;

    public boolean isEditDesc() {
        return editDesc;
    }

    public void setEditDesc(boolean editDesc) {
        this.editDesc = editDesc;
    }

    public boolean isEditActif() {
        return editActif;
    }

    public void setEditActif(boolean editActif) {
        this.editActif = editActif;
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
//             this.entrepriseService.supprimer(formObject);
//            message = "Suppression effectuée avec succès";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * RAFRAICHIR PERMET D ACTUALISER UNE PAGE ET DE REMETTRE TOUT A DEFAUT
     */
    public void rafraichir() {
        this.chargerElement();
        this.effacer();
    }

    /**
     * EFFACER PERMET DE CREER UNE NOUVELLE ENTITE : ELLE REINITIALISE OFT L
     * ENTITE
     *
     */
    public void effacer() {
        formObject = new Technicien();
        selectObject = null;
//        activerModification=false;
    }

    /**
     * SI AUCUN OBJET N EST SELECTIONNE; LA FORME DE L OBJET EST REINITIALISE
     * SINON ELLE PREND LES DONNE SELECTIONNEES
     */
    public void remplirFormulaire() {
        formObject = (selectObject != null) ? selectObject : new Technicien();
    }

    /*GETTEURS SENTEURS*/
    public TechnicienServiceBeanLocal getTechnicienService() {
        return technicienService;
    }

    public void setTechnicienService(TechnicienServiceBeanLocal technicienService) {
        this.technicienService = technicienService;
    }

    public Technicien getFormObject() {
        return formObject;
    }

    public void setFormObject(Technicien formObject) {
        this.formObject = formObject;
    }

    public Technicien getSelectObject() {
        return selectObject;
    }

    public void setSelectObject(Technicien selectObject) {
        this.selectObject = selectObject;
    }

    public List<Technicien> getTechnicienList() {
        return technicienList;
    }

    public void setTechnicienList(List<Technicien> technicienList) {
        this.technicienList = technicienList;
    }

    public List<Technicien> getControleList() {
        return controleList;
    }

    public void setControleList(List<Technicien> controleList) {
        this.controleList = controleList;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public boolean isSup() {
        return Sup;
    }

    public void setSup(boolean Sup) {
        this.Sup = Sup;
    }

    public boolean isParam() {
        return param;
    }

    public void setParam(boolean param) {
        this.param = param;
    }

}
