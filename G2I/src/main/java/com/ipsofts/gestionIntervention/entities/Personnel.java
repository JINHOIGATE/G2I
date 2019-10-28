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
import javax.validation.constraints.Size;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "personnel")

public class Personnel extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUtilisateurP")
    private Integer idUtilisateurP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "prenomP")
    private String prenomP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexeP")
    private Character sexeP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateNaissanceP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissanceP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nomP")
    private String nomP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "loginP")
    private String loginP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "motDePasseP")
    private String motDePasseP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actifP")
    private boolean actifP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 31)
    @Column(name = "contactP")
    private String contactP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "adresseP")
    private String adresseP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "emailP")
    private String emailP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreationP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreationP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personnelSup")
    private boolean personnelSup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paramP")
    private boolean paramP;
    @JoinColumn(name = "idProfil", referencedColumnName = "idProfil")
    @ManyToOne(optional = false)
    private Profil idProfil;

    public Personnel() {
    }

    public Personnel(Integer idUtilisateurP) {
        this.idUtilisateurP = idUtilisateurP;
    }

    public Personnel(Integer idUtilisateurP, String prenomP, Character sexeP, Date dateNaissanceP, String nomP, String loginP, String motDePasseP, boolean actifP, String contactP, String adresseP, String emailP, Date dateCreationP, boolean personnelSup, boolean paramP) {
        this.idUtilisateurP = idUtilisateurP;
        this.prenomP = prenomP;
        this.sexeP = sexeP;
        this.dateNaissanceP = dateNaissanceP;
        this.nomP = nomP;
        this.loginP = loginP;
        this.motDePasseP = motDePasseP;
        this.actifP = actifP;
        this.contactP = contactP;
        this.adresseP = adresseP;
        this.emailP = emailP;
        this.dateCreationP = dateCreationP;
        this.personnelSup = personnelSup;
        this.paramP = paramP;
    }

    public Integer getIdUtilisateurP() {
        return idUtilisateurP;
    }

    public void setIdUtilisateurP(Integer idUtilisateurP) {
        this.idUtilisateurP = idUtilisateurP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public Character getSexeP() {
        return sexeP;
    }

    public void setSexeP(Character sexeP) {
        this.sexeP = sexeP;
    }

    public Date getDateNaissanceP() {
        return dateNaissanceP;
    }

    public void setDateNaissanceP(Date dateNaissanceP) {
        this.dateNaissanceP = dateNaissanceP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getLoginP() {
        return loginP;
    }

    public void setLoginP(String loginP) {
        this.loginP = loginP;
    }

    public String getMotDePasseP() {
        return motDePasseP;
    }

    public void setMotDePasseP(String motDePasseP) {
        this.motDePasseP = motDePasseP;
    }

    public boolean getActifP() {
        return actifP;
    }

    public void setActifP(boolean actifP) {
        this.actifP = actifP;
    }

    public String getContactP() {
        return contactP;
    }

    public void setContactP(String contactP) {
        this.contactP = contactP;
    }

    public String getAdresseP() {
        return adresseP;
    }

    public void setAdresseP(String adresseP) {
        this.adresseP = adresseP;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public Date getDateCreationP() {
        return dateCreationP;
    }

    public void setDateCreationP(Date dateCreationP) {
        this.dateCreationP = dateCreationP;
    }

    public boolean getPersonnelSup() {
        return personnelSup;
    }

    public void setPersonnelSup(boolean personnelSup) {
        this.personnelSup = personnelSup;
    }

    public boolean getParamP() {
        return paramP;
    }

    public void setParamP(boolean paramP) {
        this.paramP = paramP;
    }

    public Profil getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Profil idProfil) {
        this.idProfil = idProfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateurP != null ? idUtilisateurP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.idUtilisateurP == null && other.idUtilisateurP != null) || (this.idUtilisateurP != null && !this.idUtilisateurP.equals(other.idUtilisateurP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Personnel[ idUtilisateurP=" + idUtilisateurP + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
