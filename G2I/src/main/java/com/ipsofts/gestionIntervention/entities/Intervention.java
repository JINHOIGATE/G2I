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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "intervention")

public class Intervention extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInterveniton")
    private Integer idInterveniton;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "contenuSolution")
    private String contenuSolution;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateIntervention")
    @Temporal(TemporalType.DATE)
    private Date dateIntervention;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureDebutIntervention")
    private int heureDebutIntervention;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureFinIntervention")
    private int heureFinIntervention;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duree")
    private Float duree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resolution")
    private boolean resolution;
    @JoinColumn(name = "idDemande", referencedColumnName = "idDemande")
    @ManyToOne(optional = false)
    private Demande idDemande;
    @JoinColumn(name = "idModeIntervention", referencedColumnName = "idModeIntervention")
    @ManyToOne(optional = false)
    private Modeintervention idModeIntervention;
    @JoinColumn(name = "idUtilisateurT", referencedColumnName = "idUtilisateurT")
    @ManyToOne(optional = false)
    private Technicien idUtilisateurT;

    public Intervention() {
    }

    public Intervention(Integer idInterveniton) {
        this.idInterveniton = idInterveniton;
    }

    public Intervention(Integer idInterveniton, String contenuSolution, Date dateIntervention, int heureDebutIntervention, int heureFinIntervention, boolean resolution) {
        this.idInterveniton = idInterveniton;
        this.contenuSolution = contenuSolution;
        this.dateIntervention = dateIntervention;
//        this.dateFinIntervention = dateFinIntervention;
        this.heureDebutIntervention = heureDebutIntervention;
        this.heureFinIntervention = heureFinIntervention;
        this.resolution = resolution;
    }

    public Integer getIdInterveniton() {
        return idInterveniton;
    }

    public void setIdInterveniton(Integer idInterveniton) {
        this.idInterveniton = idInterveniton;
    }

    public String getContenuSolution() {
        return contenuSolution;
    }

    public void setContenuSolution(String contenuSolution) {
        this.contenuSolution = contenuSolution;
    }

    public Date getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(Date dateDebutIntervention) {
        this.dateIntervention = dateDebutIntervention;
    }

////    public Date getDateFinIntervention() {
////        return dateFinIntervention;
////    }
////
////    public void setDateFinIntervention(Date dateFinIntervention) {
////        this.dateFinIntervention = dateFinIntervention;
//    }

    public int getHeureDebutIntervention() {
        return heureDebutIntervention;
    }

    public void setHeureDebutIntervention(int heureDebutIntervention) {
        this.heureDebutIntervention = heureDebutIntervention;
    }

    public int getHeureFinIntervention() {
        return heureFinIntervention;
    }

    public void setHeureFinIntervention(int heureFinIntervention) {
        this.heureFinIntervention = heureFinIntervention;
    }

    public Float getDuree() {
        return duree;
    }

    public void setDuree(Float duree) {
        this.duree = duree;
    }

    public boolean getResolution() {
        return resolution;
    }

    public void setResolution(boolean resolution) {
        this.resolution = resolution;
    }

    public Demande getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Demande idDemande) {
        this.idDemande = idDemande;
    }

    public Modeintervention getIdModeIntervention() {
        return idModeIntervention;
    }

    public void setIdModeIntervention(Modeintervention idModeIntervention) {
        this.idModeIntervention = idModeIntervention;
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
        hash += (idInterveniton != null ? idInterveniton.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervention)) {
            return false;
        }
        Intervention other = (Intervention) object;
        if ((this.idInterveniton == null && other.idInterveniton != null) || (this.idInterveniton != null && !this.idInterveniton.equals(other.idInterveniton))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Intervention[ idInterveniton=" + idInterveniton + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
