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
@Table(name = "profil")

public class Profil extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfil")
    private Integer idProfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "libelleProfil")
    private String libelleProfil;
    @Size(max = 100)
    @Column(name = "descriptionProfil")
    private String descriptionProfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "profilSup")
    private boolean profilSup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfil")
    private List<Technicien> technicienList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfil")
    private List<Entreprise> entrepriseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfil")
    private List<Personnel> personnelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfil")
    private List<Action> actionList;

    public Profil() {
    }

    public Profil(Integer idProfil) {
        this.idProfil = idProfil;
    }

    public Profil(Integer idProfil, String libelleProfil, boolean profilSup) {
        this.idProfil = idProfil;
        this.libelleProfil = libelleProfil;
        this.profilSup = profilSup;
    }

    public Integer getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Integer idProfil) {
        this.idProfil = idProfil;
    }

    public String getLibelleProfil() {
        return libelleProfil;
    }

    public void setLibelleProfil(String libelleProfil) {
        this.libelleProfil = libelleProfil;
    }

    public String getDescriptionProfil() {
        return descriptionProfil;
    }

    public void setDescriptionProfil(String descriptionProfil) {
        this.descriptionProfil = descriptionProfil;
    }

    public boolean getProfilSup() {
        return profilSup;
    }

    public void setProfilSup(boolean profilSup) {
        this.profilSup = profilSup;
    }

    @XmlTransient
    public List<Technicien> getTechnicienList() {
        return technicienList;
    }

    public void setTechnicienList(List<Technicien> technicienList) {
        this.technicienList = technicienList;
    }

    @XmlTransient
    public List<Entreprise> getEntrepriseList() {
        return entrepriseList;
    }

    public void setEntrepriseList(List<Entreprise> entrepriseList) {
        this.entrepriseList = entrepriseList;
    }

    @XmlTransient
    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }

    @XmlTransient
    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfil != null ? idProfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.idProfil == null && other.idProfil != null) || (this.idProfil != null && !this.idProfil.equals(other.idProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Profil[ idProfil=" + idProfil + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
