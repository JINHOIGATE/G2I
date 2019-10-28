package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Demande;
import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Service;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Poste.class)
public class Poste_ extends BaseEntity_ {

    public static volatile ListAttribute<Poste, Demande> demandeList;
    public static volatile SingularAttribute<Poste, String> codePoste;
    public static volatile SingularAttribute<Poste, String> utilisateur;
    public static volatile SingularAttribute<Poste, String> nomPoste;
    public static volatile SingularAttribute<Poste, Entreprise> idUtilisateurE;
    public static volatile SingularAttribute<Poste, Boolean> posteSup;
    public static volatile SingularAttribute<Poste, Service> codeService;

}