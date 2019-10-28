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
@Table(name = "poste")

public class Poste extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "codePoste")
    private String codePoste;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nomPoste")
    private String nomPoste;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "utilisateur")
    private String utilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posteSup")
    private boolean posteSup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codePoste")
    private List<Demande> demandeList;
    @JoinColumn(name = "codeService", referencedColumnName = "codeService")
    @ManyToOne(optional = false)
    private Service codeService;
    @JoinColumn(name = "idUtilisateurE", referencedColumnName = "idUtilisateurE")
    @ManyToOne(optional = false)
    private Entreprise idUtilisateurE;

    public Poste() {
    }

    public Poste(String codePoste) {
        this.codePoste = codePoste;
    }

    public Poste(String codePoste, String nomPoste, String utilisateur, boolean posteSup) {
        this.codePoste = codePoste;
        this.nomPoste = nomPoste;
        this.utilisateur = utilisateur;
        this.posteSup = posteSup;
    }

    public String getCodePoste() {
        return codePoste;
    }

    public void setCodePoste(String codePoste) {
        this.codePoste = codePoste;
    }

    public String getNomPoste() {
        return nomPoste;
    }

    public void setNomPoste(String nomPoste) {
        this.nomPoste = nomPoste;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public boolean getPosteSup() {
        return posteSup;
    }

    public void setPosteSup(boolean posteSup) {
        this.posteSup = posteSup;
    }

  
    

    @XmlTransient
    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePoste != null ? codePoste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        if ((this.codePoste == null && other.codePoste != null) || (this.codePoste != null && !this.codePoste.equals(other.codePoste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Poste[ codePoste=" + codePoste + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
