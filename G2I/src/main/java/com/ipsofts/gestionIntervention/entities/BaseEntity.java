/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 *
 * @author poste
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Version
    @Column(nullable = false)
    protected Integer version = 0;

    public Integer getVersion() {
        return version;
    }

    public BaseEntity() {
    }

    /*
     * Methode à implementer par chaque entity pour renvoyer son identifiant
     */
    public abstract String getId();

    /*
     * Methode à implementer par chaque entity qui permettra de renseigner son identifiant
     */
    public void setIdSequence(String id) {

    }

    /*
     * Methode à overrider par chaque entity lui permettrant
     *  de renvoyer le code de sa sequence
     */
    public String getCodeSequence() {
        System.out.println("getCodeSequence BASE ENTITY");
        return "S_DEFAULT";
    }

    public String getLibelleForMembre() {
        return null;
    }
}
