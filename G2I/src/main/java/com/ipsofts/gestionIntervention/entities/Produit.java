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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "produit")

public class Produit extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "codeProduit")
    private String codeProduit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nomProduit")
    private String nomProduit;
    @Size(max = 120)
    @Column(name = "descriptionProduit")
    private String descriptionProduit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "typeProduit")
    private String typeProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estIpSoft")
    private boolean estIpSoft;
    @Basic(optional = false)
    @NotNull
    @Column(name = "produitSup")
    private boolean produitSup;
    @JoinColumn(name = "idUtilisateurE", referencedColumnName = "idUtilisateurE")
    @ManyToOne(optional = false)
    private Entreprise idUtilisateurE;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeProduit")
    private List<Demande> demandeList;

    public Produit() {
    }

    public Produit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public Produit(String codeProduit, String nomProduit, String typeProduit, boolean estIpSoft, boolean produitSup) {
        this.codeProduit = codeProduit;
        this.nomProduit = nomProduit;
        this.typeProduit = typeProduit;
        this.estIpSoft = estIpSoft;
        this.produitSup = produitSup;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public boolean getEstIpSoft() {
        return estIpSoft;
    }

    public void setEstIpSoft(boolean estIpSoft) {
        this.estIpSoft = estIpSoft;
    }

    public boolean getProduitSup() {
        return produitSup;
    }

    public void setProduitSup(boolean produitSup) {
        this.produitSup = produitSup;
    }

    public Entreprise getIdUtilisateurE() {
        return idUtilisateurE;
    }

    public void setIdUtilisateurE(Entreprise idUtilisateurE) {
        this.idUtilisateurE = idUtilisateurE;
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
        hash += (codeProduit != null ? codeProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.codeProduit == null && other.codeProduit != null) || (this.codeProduit != null && !this.codeProduit.equals(other.codeProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Produit[ codeProduit=" + codeProduit + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
