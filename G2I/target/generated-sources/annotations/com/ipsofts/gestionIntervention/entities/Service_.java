package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Demande;
import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Poste;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Service.class)
public class Service_ extends BaseEntity_ {

    public static volatile ListAttribute<Service, Demande> demandeList;
    public static volatile SingularAttribute<Service, String> responsable;
    public static volatile ListAttribute<Service, Poste> posteList;
    public static volatile SingularAttribute<Service, Boolean> serviceSup;
    public static volatile SingularAttribute<Service, String> descriptionService;
    public static volatile SingularAttribute<Service, Entreprise> idUtilisateurE;
    public static volatile SingularAttribute<Service, String> nomService;
    public static volatile SingularAttribute<Service, String> codeService;

}