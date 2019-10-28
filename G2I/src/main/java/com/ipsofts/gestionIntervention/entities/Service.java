
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
@Table(name = "service")

public class Service extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "codeService")
    private String codeService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nomService")
    private String nomService;
    @Size(max = 120)
    @Column(name = "descriptionService")
    private String descriptionService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "responsable")
    private String responsable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serviceSup")
    private boolean serviceSup;
    @JoinColumn(name = "idUtilisateurE", referencedColumnName = "idUtilisateurE")
    @ManyToOne(optional = false)
    private Entreprise idUtilisateurE;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeService")
    private List<Poste> posteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeService")
    private List<Demande> demandeList;

    public Service() {
    }

    public Service(String codeService) {
        this.codeService = codeService;
    }

    public Service(String codeService, String nomService, String responsable, boolean serviceSup) {
        this.codeService = codeService;
        this.nomService = nomService;
        this.responsable = responsable;
        this.serviceSup = serviceSup;
    }
   

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public boolean getServiceSup() {
        return serviceSup;
    }

    public void setServiceSup(boolean serviceSup) {
        this.serviceSup = serviceSup;
    }

    public Entreprise getIdUtilisateurE() {
        return idUtilisateurE;
    }

    public void setIdUtilisateurE(Entreprise idUtilisateurE) {
        this.idUtilisateurE = idUtilisateurE;
    }

    @XmlTransient
    public List<Poste> getPosteList() {
        return posteList;
    }

    public void setPosteList(List<Poste> posteList) {
        this.posteList = posteList;
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
        hash += (codeService != null ? codeService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.codeService == null && other.codeService != null) || (this.codeService != null && !this.codeService.equals(other.codeService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Service[ codeService=" + codeService + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
