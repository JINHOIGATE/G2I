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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP Envy i7
 */
@Entity
@Table(name = "entreprise")

public class Entreprise extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUtilisateurE")
    private Integer idUtilisateurE;
    @Basic(optional = false)
    @Column(name = "estSousContrat")
    private boolean estSousContrat;
    @Basic(optional = false)
    @Size(min = 1, max = 60)
    @Column(name = "nomE")
    private String nomE;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "loginE")
    private String loginE;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "motDePasseE")
    private String motDePasseE;
    @Basic(optional = false)
    @Column(name = "actifE")
    private boolean actifE;
    @Basic(optional = false)
    @Size(min = 1, max = 31)
    @Column(name = "contactE")
    private String contactE;
//    @Null
    @Basic(optional = false)
//    @Size(min = 1, max = 150)
    @Column(name = "adresseE")
    private String adresseE;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "emailE")
    private String emailE;
    @Basic(optional = false)
    @Column(name = "dateCreationE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreationE;
    @Basic(optional = false)
    @Column(name = "entrepriseSup")
    private boolean entrepriseSup;
    @Basic(optional = false)
    @Column(name = "paramE")
    private boolean paramE;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateurE")
    private List<Produit> produitList;
    @JoinColumn(name = "idProfil", referencedColumnName = "idProfil")
    @ManyToOne(optional = false)
    private Profil idProfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateurE")
    private List<Service> serviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateurE")
    private List<Poste> posteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateurE")
    private List<Demande> demandeList;

    public Entreprise() {
    }

    public Entreprise(Integer idUtilisateurE) {
        this.idUtilisateurE = idUtilisateurE;
    }

    public Entreprise(Integer idUtilisateurE, boolean estSousContrat, String nomE, String loginE, String motDePasseE, boolean actifE, String contactE, String adresseE, String emailE, Date dateCreationE, boolean entrepriseSup, boolean paramE) {
        this.idUtilisateurE = idUtilisateurE;
        this.estSousContrat = estSousContrat;
        this.nomE = nomE;
        this.loginE = loginE;
        this.motDePasseE = motDePasseE;
        this.actifE = actifE;
        this.contactE = contactE;
        this.adresseE = adresseE;
        this.emailE = emailE;
        this.dateCreationE = dateCreationE;
        this.entrepriseSup = entrepriseSup;
        this.paramE = paramE;
    }
    
    /*CONSTRUCTEUR D'AJOUT ET DE MODIFICATION*/
     public Entreprise( boolean estSousContrat, String nomE, String loginE, String motDePasseE, boolean actifE, String contactE, String adresseE, String emailE, Date dateCreationE, boolean entrepriseSup, boolean paramE) {
        this.estSousContrat = estSousContrat;
        this.nomE = nomE;
        this.loginE = loginE;
        this.motDePasseE = motDePasseE;
        this.actifE = actifE;
        this.contactE = contactE;
        this.adresseE = adresseE;
        this.emailE = emailE;
        this.dateCreationE = dateCreationE;
        this.entrepriseSup = entrepriseSup;
        this.paramE = paramE;
    }

    public Integer getIdUtilisateurE() {
        return idUtilisateurE;
    }

    public void setIdUtilisateurE(Integer idUtilisateurE) {
        this.idUtilisateurE = idUtilisateurE;
    }

    public boolean getEstSousContrat() {
        return estSousContrat;
    }

    public void setEstSousContrat(boolean estSousContrat) {
        this.estSousContrat = estSousContrat;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getLoginE() {
        return loginE;
    }

    public void setLoginE(String loginE) {
        this.loginE = loginE;
    }

    public String getMotDePasseE() {
        return motDePasseE;
    }

    public void setMotDePasseE(String motDePasseE) {
        this.motDePasseE = motDePasseE;
    }

    public boolean getActifE() {
        return actifE;
    }

    public void setActifE(boolean actifE) {
        this.actifE = actifE;
    }

    public String getContactE() {
        return contactE;
    }

    public void setContactE(String contactE) {
        this.contactE = contactE;
    }

    public String getAdresseE() {
        return adresseE;
    }

    public void setAdresseE(String adresseE) {
        this.adresseE = adresseE;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }

    public Date getDateCreationE() {
        return dateCreationE;
    }

    public void setDateCreationE(Date dateCreationE) {
        this.dateCreationE = dateCreationE;
    }

    public boolean getEntrepriseSup() {
        return entrepriseSup;
    }

    public void setEntrepriseSup(boolean entrepriseSup) {
        this.entrepriseSup = entrepriseSup;
    }

    public boolean getParamE() {
        return paramE;
    }

    public void setParamE(boolean paramE) {
        this.paramE = paramE;
    }

    @XmlTransient
    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    public Profil getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Profil idProfil) {
        this.idProfil = idProfil;
    }

    @XmlTransient
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
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
        hash += (idUtilisateurE != null ? idUtilisateurE.hashCode() : 0);
        return hash;
    }

   

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.idUtilisateurE == null && other.idUtilisateurE != null) || (this.idUtilisateurE != null && !this.idUtilisateurE.equals(other.idUtilisateurE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ipsofts.gestionIntervention.entities.Entreprise[ idUtilisateurE=" + idUtilisateurE + " ]";
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
