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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "technicien")

public class Technicien extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUtilisateurT")
    private Integer idUtilisateurT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "prenomT")
    private String prenomT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexeT")
    private Character sexeT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateNaissanceT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissanceT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nomT")
    private String nomT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "loginT")
    private String loginT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "motDePasseT")
    private String motDePasseT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actifT")
    private boolean actifT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 31)
    @Column(name = "contactT")
    private String contactT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "adresseT")
    private String adresseT;
    @Pattern(regexp = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?", message = "Invalid email")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "emailT")
    private String emailT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreationT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreationT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "technicienSup")
    private boolean technicienSup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paramT")
    private boolean paramT;
    @JoinColumn(name = "idProfil", referencedColumnName = "idProfil")
    @ManyToOne(optional = false)
    private Profil idProfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateurT")
    private List<Planification> planificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateurT")
    private List<Intervention> interventionList;

    public Technicien() {
    }

    public Technicien(Integer idUtilisateurT) {
        this.idUtilisateurT = idUtilisateurT;
    }

    public Technicien(Integer idUtilisateurT, String prenomT, Character sexeT, Date dateNaissanceT, String nomT, String loginT, String motDePasseT, boolean actifT, String contactT, String adresseT, String emailT, Date dateCreationT, boolean technicienSup, boolean paramT) {
        this.idUtilisateurT = idUtilisateurT;
        this.prenomT = prenomT;
        this.sexeT = sexeT;
        this.dateNaissanceT = dateNaissanceT;
        this.nomT = nomT;
        this.loginT = loginT;
        this.motDePasseT = motDePasseT;
        this.actifT = actifT;
        this.contactT = contactT;
        this.adresseT = adresseT;
        this.emailT = emailT;
        this.dateCreationT = dateCreationT;
        this.technicienSup = technicienSup;
        this.paramT = paramT;
    }
    public Technicien( String prenomT, Character sexeT, Date dateNaissanceT, String nomT, String loginT, String motDePasseT, boolean actifT, String contactT, String adresseT, String emailT, Date dateCreationT, boolean technicienSup, boolean paramT) {
        this.prenomT = prenomT;
        this.sexeT = sexeT;
        this.dateNaissanceT = dateNaissanceT;
        this.nomT = nomT;
        this.loginT = loginT;
        this.motDePasseT = motDePasseT;
        this.actifT = actifT;
        this.contactT = contactT;
        this.adresseT = adresseT;
        this.emailT = emailT;
        this.dateCreationT = dateCreationT;
        this.technicienSup = technicienSup;
        this.paramT = paramT;
    }

    public Integer getIdUtilisateurT() {
        return idUtilisateurT;
    }

    public void setIdUtilisateurT(Integer idUtilisateurT) {
        this.idUtilisateurT = idUtilisateurT;
    }

    public String getPrenomT() {
        return prenomT;
    }

    public void setPrenomT(String prenomT) {
        this.prenomT = prenomT;
    }

    public Character getSexeT() {
        return sexeT;
    }

    public void setSexeT(Character sexeT) {
        this.sexeT = sexeT;
    }

    public Date getDateNaissanceT() {
        return dateNaissanceT;
    }

    public void setDateNaissanceT(Date dateNaissanceT) {
        this.dateNaissanceT = dateNaissanceT;
    }

    public String getNomT() {
        return nomT;
    }

    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    public String getLoginT() {
        return loginT;
    }

    public void setLoginT(String loginT) {
        this.loginT = loginT;
    }

    public String getMotDePasseT() {
        return motDePasseT;
    }

    public void setMotDePasseT(String motDePasseT) {
        this.motDePasseT = motDePasseT;
    }

    public boolean getActifT() {
        return actifT;
    }

    public void setActifT(boolean actifT) {
        this.actifT = actifT;
    }

    public String getContactT() {
        return contactT;
    }

    public void setContactT(String contactT) {
        this.contactT = contactT;
    }

    public String getAdresseT() {
        return adresseT;
    }

    public void setAdresseT(String adresseT) {
        this.adresseT = adresseT;
    }

    public String getEmailT() {
        return emailT;
    }

    public void setEmailT(String emailT) {
        this.emailT = emailT;
    }

    public Date getDateCreationT() {
        return dateCreationT;
    }

    public void setDateCreationT(Date dateCreationT) {
        this.dateCreationT = dateCreationT;
    }

    public boolean getTechnicienSup() {
        return technicienSup;
    }

    public void setTechnicienSup(boolean technicienSup) {
        this.technicienSup = technicienSup;
    }

    public boolean getParamT() {
        return paramT;
    }

    public void setParamT(boolean paramT) {
        this.paramT = paramT;
    }

    public Profil getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Profil idProfil) {
        this.idProfil = idProfil;
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
        hash += (idUtilisateurT != null ? idUtilisateurT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Technicien)) {
            return false;
        }
        Technicien other = (Technicien) object;
        if ((this.idUtilisateurT == null && other.idUtilisateurT != null) || (this.idUtilisateurT != null && !this.idUtilisateurT.equals(other.idUtilisateurT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Technicien[ idUtilisateurT=" + idUtilisateurT + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
