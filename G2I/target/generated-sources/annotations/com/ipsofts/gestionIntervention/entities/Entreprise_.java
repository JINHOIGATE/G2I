package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Demande;
import com.ipsofts.gestionIntervention.entities.Poste;
import com.ipsofts.gestionIntervention.entities.Produit;
import com.ipsofts.gestionIntervention.entities.Profil;
import com.ipsofts.gestionIntervention.entities.Service;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Entreprise.class)
public class Entreprise_ extends BaseEntity_ {

    public static volatile SingularAttribute<Entreprise, Boolean> estSousContrat;
    public static volatile SingularAttribute<Entreprise, Boolean> entrepriseSup;
    public static volatile ListAttribute<Entreprise, Poste> posteList;
    public static volatile SingularAttribute<Entreprise, String> contactE;
    public static volatile SingularAttribute<Entreprise, String> nomE;
    public static volatile SingularAttribute<Entreprise, String> loginE;
    public static volatile SingularAttribute<Entreprise, String> emailE;
    public static volatile SingularAttribute<Entreprise, Date> dateCreationE;
    public static volatile SingularAttribute<Entreprise, Boolean> paramE;
    public static volatile ListAttribute<Entreprise, Demande> demandeList;
    public static volatile SingularAttribute<Entreprise, String> motDePasseE;
    public static volatile ListAttribute<Entreprise, Produit> produitList;
    public static volatile SingularAttribute<Entreprise, String> adresseE;
    public static volatile ListAttribute<Entreprise, Service> serviceList;
    public static volatile SingularAttribute<Entreprise, Boolean> actifE;
    public static volatile SingularAttribute<Entreprise, Integer> idUtilisateurE;
    public static volatile SingularAttribute<Entreprise, Profil> idProfil;

}