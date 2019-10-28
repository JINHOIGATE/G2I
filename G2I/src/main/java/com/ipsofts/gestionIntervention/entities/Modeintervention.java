/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "modeintervention")

public class Modeintervention extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idModeIntervention")
    private Integer idModeIntervention;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "libModeIntervention")
    private String libModeIntervention;
    @Size(max = 120)
    @Column(name = "descriptionMode")
    private String descriptionMode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modeInterventionSup")
    private boolean modeInterventionSup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModeIntervention")
    private List<Intervention> interventionList;

    public Modeintervention() {
    }

    public Modeintervention(Integer idModeIntervention) {
        this.idModeIntervention = idModeIntervention;
    }

    public Modeintervention(Integer idModeIntervention, String libModeIntervention, boolean modeInterventionSup) {
        this.idModeIntervention = idModeIntervention;
        this.libModeIntervention = libModeIntervention;
        this.modeInterventionSup = modeInterventionSup;
    }

    public Integer getIdModeIntervention() {
        return idModeIntervention;
    }

    public void setIdModeIntervention(Integer idModeIntervention) {
        this.idModeIntervention = idModeIntervention;
    }

    public String getLibModeIntervention() {
        return libModeIntervention;
    }

    public void setLibModeIntervention(String libModeIntervention) {
        this.libModeIntervention = libModeIntervention;
    }

    public String getDescriptionMode() {
        return descriptionMode;
    }

    public void setDescriptionMode(String descriptionMode) {
        this.descriptionMode = descriptionMode;
    }

    public boolean getModeInterventionSup() {
        return modeInterventionSup;
    }

    public void setModeInterventionSup(boolean modeInterventionSup) {
        this.modeInterventionSup = modeInterventionSup;
    }

    @XmlTransient
    public List<Intervention> getInterventionList() {
        return interventionList;
    }

    public void setInterventionList(List<Intervention> interventionList) {
        this.interventionList = interventionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModeIntervention != null ? idModeIntervention.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modeintervention)) {
            return false;
        }
        Modeintervention other = (Modeintervention) object;
        if ((this.idModeIntervention == null && other.idModeIntervention != null) || (this.idModeIntervention != null && !this.idModeIntervention.equals(other.idModeIntervention))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Modeintervention[ idModeIntervention=" + idModeIntervention + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
