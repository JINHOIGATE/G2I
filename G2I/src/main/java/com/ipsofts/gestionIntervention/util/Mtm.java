/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.util;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author Mikel
 */
public class Mtm {

    /**
     * 
     * @param miki le message à afficher en mode severity_warn
     */
    public static void messageWarn(String miki) {
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, miki, "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * 
     * @param miki le message à afficher en mode severity_info
     */
    public static void messageInfoPerso(String miki) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, miki, "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    /**
     * 
     * @param miki le message à afficher en severity_warn genre Veuillez saisir "+miki+" svp !
     */
    public static void messageWarnSaisir(String miki) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Veuillez saisir "+miki+" svp !", "Avertissement!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    /**
     * 
     * @param miki le message à afficher en severity_warn genre Veuillez choisir "+miki+" svp !
     */
    public static void messageWarnChoisir(String miki) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Veuillez choisir "+miki+" svp !", "Avertissement!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    /**
     * 
     * @param miki le message à afficher en severity_warn genre Veuillez sélectionner "+miki+" svp !
     */
    public static void messageWarnSelectionner(String miki) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Veuillez sélectionner "+miki+" svp !", "Avertissement!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     *  Message à afficher en severity_info genre Opération effectuée avec succès !
     */
    public static void messageInfo() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Opération effectuée avec succès !", "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Message à afficher en severity_error genre Echec de l'opération
     */
    public static void messageError() {
        FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec de l'opération", "");
        FacesContext.getCurrentInstance().addMessage(null, message2);
    }
    
    
    /**
     * 
     * @param miki le message à afficher en mode severity_error
     */
    public static void messageErrorPerso(String miki) {
        FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, miki, "");
        FacesContext.getCurrentInstance().addMessage(null, message2);
    }

    /**
     * Message à afficher en severity_warn genre Opération interrompue : Absence de droit permettant d'effectuer cette opération, veuillez contacter l'administrateur Svp !
     */
    public static void mikiLog4jMessageError() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Opération interrompue : Absence de droit permettant d'effectuer cette opération, veuillez contacter l'administrateur Svp !", "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Enregistre dans le journal grace a log4j
     * @param loggerName le nom de la classe concernée
     * @param priority priorité
     * @param message le message qui suit le log
     */
    public static void logMikiLog4j(String loggerName, Level priority, String message) {
        try {
            Logger loggerMiki = Logger.getLogger(loggerName);
            DOMConfigurator.configure("log4j2.xml");
            loggerMiki.log(priority, message);
        } catch (Exception e) {
            messageError();
        }

    }
   

    public static void mikiWebAppDirectory(){
        try {
            File fl = new File("C:\\cabinetmekanmanpene-webapp");
            if (!fl.exists() && !fl.isDirectory()) {
                fl.mkdirs();
            }
        } catch (Exception e) {
            messageError();
        }
    }
    /**
    *Supprime les fichiers chargés sur le serveur lorsque l'opération est annulé 
    *
    */
    public static void mikiSuppFileInDirectory(){
        try {
            File fl = new File("\\resources\\images\\7943160Validation_3_année.moo");
            System.out.println(fl);
            if (fl.exists()) {
                fl.delete();
            }
        } catch (Exception e) {
            messageError();
        }
    }

}
