/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "planification")

public class Planification extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanification")
    private Integer idPlanification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datePlanification")
    @Temporal(TemporalType.DATE)
    private Date datePlanification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureDebutEstimation")
    private int heureDebutEstimation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureFinEstimation")
    private int heureFinEstimation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planificationSup")
    private boolean planificationSup;
    @JoinColumn(name = "idDemande", referencedColumnName = "idDemande")
    @ManyToOne(optional = false)
    private Demande idDemande;
    @JoinColumn(name = "idUtilisateurT", referencedColumnName = "idUtilisateurT")
    @ManyToOne(optional = false)
    private Technicien idUtilisateurT;

    public Planification() {
    }

    public Planification(Integer idPlanification) {
        this.idPlanification = idPlanification;
    }

    public Planification(Integer idPlanification, Date datePlanification, int heureDebutEstimation, int heureFinEstimation, boolean planificationSup) {
        this.idPlanification = idPlanification;
        this.datePlanification = datePlanification;
        this.heureDebutEstimation = heureDebutEstimation;
        this.heureFinEstimation = heureFinEstimation;
        this.planificationSup = planificationSup;
    }

    public Integer getIdPlanification() {
        return idPlanification;
    }

    public void setIdPlanification(Integer idPlanification) {
        this.idPlanification = idPlanification;
    }

    public Date getDatePlanification() {
        return datePlanification;
    }

    public void setDatePlanification(Date datePlanification) {
        this.datePlanification = datePlanification;
    }

    public int getHeureDebutEstimation() {
        return heureDebutEstimation;
    }

    public void setHeureDebutEstimation(int heureDebutEstimation) {
        this.heureDebutEstimation = heureDebutEstimation;
    }

    public int getHeureFinEstimation() {
        return heureFinEstimation;
    }

    public void setHeureFinEstimation(int heureFinEstimation) {
        this.heureFinEstimation = heureFinEstimation;
    }

    public boolean getPlanificationSup() {
        return planificationSup;
    }

    public void setPlanificationSup(boolean planificationSup) {
        this.planificationSup = planificationSup;
    }

    public Demande getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Demande idDemande) {
        this.idDemande = idDemande;
    }

    public Technicien getIdUtilisateurT() {
        return idUtilisateurT;
    }

    public void setIdUtilisateurT(Technicien idUtilisateurT) {
        this.idUtilisateurT = idUtilisateurT;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanification != null ? idPlanification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planification)) {
            return false;
        }
        Planification other = (Planification) object;
        if ((this.idPlanification == null && other.idPlanification != null) || (this.idPlanification != null && !this.idPlanification.equals(other.idPlanification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Planification[ idPlanification=" + idPlanification + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
