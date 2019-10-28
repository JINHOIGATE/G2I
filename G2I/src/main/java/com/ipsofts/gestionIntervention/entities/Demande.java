/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "demande")
public class Demande extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDemande")
    private Integer idDemande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "libelleDemande")
    private String libelleDemande;
    @Size(max = 254)
    @Column(name = "pieceJointe")
    private String pieceJointe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDemande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDemande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etatDemande")
    private Boolean etatDemande;
    @JoinColumn(name = "codePoste", referencedColumnName = "codePoste")
    @ManyToOne(optional = false)
    private Poste codePoste;
    @JoinColumn(name = "codeProduit", referencedColumnName = "codeProduit")
    @ManyToOne(optional = false)
    private Produit codeProduit;
    @JoinColumn(name = "codeService", referencedColumnName = "codeService")
    @ManyToOne(optional = false)
    private Service codeService;
    @JoinColumn(name = "idUtilisateurE", referencedColumnName = "idUtilisateurE")
    @ManyToOne(optional = false)
    private Entreprise idUtilisateurE;
    @JoinColumn(name = "idTypeDemande", referencedColumnName = "idTypeDemande")
    @ManyToOne(optional = false)
    private Typedemande idTypeDemande;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDemande")
    private List<Planification> planificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDemande")
    private List<Intervention> interventionList;

    public Demande() {
    }

    public Demande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Demande(Integer idDemande, String libelleDemande, Date dateDemande, Boolean etatDemande) {
        this.idDemande = idDemande;
        this.libelleDemande = libelleDemande;
        this.dateDemande = dateDemande;
        this.etatDemande = etatDemande;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getLibelleDemande() {
        return libelleDemande;
    }

    public void setLibelleDemande(String libelleDemande) {
        this.libelleDemande = libelleDemande;
    }

    public String getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(String pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Boolean getEtatDemande() {
        return etatDemande;
    }
//
//    public void setEtatDemande(boolean etatDemande) {
//        this.etatDemande = etatDemande;
//    }

    public Poste getCodePoste() {
        return codePoste;
    }

    public void setCodePoste(Poste codePoste) {
        this.codePoste = codePoste;
    }

    public Produit getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(Produit codeProduit) {
        this.codeProduit = codeProduit;
    }

    public Typedemande getIdTypeDemande() {
        return idTypeDemande;
    }

    public void setIdTypeDemande(Typedemande idTypeDemande) {
        this.idTypeDemande = idTypeDemande;
    }


    public void setEtatDemande(Boolean etatDemande) {
        this.etatDemande = etatDemande;
    }

    public Service getCodeService() {
        return codeService;
    }

    public void setCodeService(Service codeService) {
        this.codeService = codeService;
    }

    public Entreprise getIdUtilisateurE() {
        return idUtilisateurE;
    }

    public void setIdUtilisateurE(Entreprise idUtilisateurE) {
        this.idUtilisateurE = idUtilisateurE;
    }
    
    

    @XmlTransient
    public List<Planification> getPlanificationList() {
        return planificationList;
    }

    public void setPlanificationList(List<Planification> planificationList) {
        this.planificationList = planificationList;
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
        hash += (idDemande != null ? idDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.idDemande == null && other.idDemande != null) || (this.idDemande != null && !this.idDemande.equals(other.idDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Demande[ idDemande=" + idDemande + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
