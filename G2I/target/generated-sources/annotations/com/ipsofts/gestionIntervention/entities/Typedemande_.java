package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Demande;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Typedemande.class)
public class Typedemande_ extends BaseEntity_ {

    public static volatile ListAttribute<Typedemande, Demande> demandeList;
    public static volatile SingularAttribute<Typedemande, String> descriptionTypeDemande;
    public static volatile SingularAttribute<Typedemande, Boolean> typeDemandeSup;
    public static volatile SingularAttribute<Typedemande, Integer> idTypeDemande;
    public static volatile SingularAttribute<Typedemande, String> libTypeDemande;

}