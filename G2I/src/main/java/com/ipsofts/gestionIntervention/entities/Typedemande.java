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
@Table(name = "typedemande")

public class Typedemande extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTypeDemande")
    private Integer idTypeDemande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "libTypeDemande")
    private String libTypeDemande;
    @Size(max = 120)
    @Column(name = "descriptionTypeDemande")
    private String descriptionTypeDemande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeDemandeSup")
    private boolean typeDemandeSup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeDemande")
    private List<Demande> demandeList;

    public Typedemande() {
    }

    public Typedemande(Integer idTypeDemande) {
        this.idTypeDemande = idTypeDemande;
    }

    public Typedemande(Integer idTypeDemande, String libTypeDemande, boolean typeDemandeSup) {
        this.idTypeDemande = idTypeDemande;
        this.libTypeDemande = libTypeDemande;
        this.typeDemandeSup = typeDemandeSup;
    }

    public Integer getIdTypeDemande() {
        return idTypeDemande;
    }

    public void setIdTypeDemande(Integer idTypeDemande) {
        this.idTypeDemande = idTypeDemande;
    }

    public String getLibTypeDemande() {
        return libTypeDemande;
    }

    public void setLibTypeDemande(String libTypeDemande) {
        this.libTypeDemande = libTypeDemande;
    }

    public String getDescriptionTypeDemande() {
        return descriptionTypeDemande;
    }

    public void setDescriptionTypeDemande(String descriptionTypeDemande) {
        this.descriptionTypeDemande = descriptionTypeDemande;
    }

    public boolean getTypeDemandeSup() {
        return typeDemandeSup;
    }

    public void setTypeDemandeSup(boolean typeDemandeSup) {
        this.typeDemandeSup = typeDemandeSup;
    }

    @XmlTransient
    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeDemande != null ? idTypeDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typedemande)) {
            return false;
        }
        Typedemande other = (Typedemande) object;
        if ((this.idTypeDemande == null && other.idTypeDemande != null) || (this.idTypeDemande != null && !this.idTypeDemande.equals(other.idTypeDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Typedemande[ idTypeDemande=" + idTypeDemande + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
