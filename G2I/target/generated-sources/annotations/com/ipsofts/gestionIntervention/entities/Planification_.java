package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Demande;
import com.ipsofts.gestionIntervention.entities.Technicien;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Planification.class)
public class Planification_ extends BaseEntity_ {

    public static volatile SingularAttribute<Planification, Integer> heureFinEstimation;
    public static volatile SingularAttribute<Planification, Boolean> planificationSup;
    public static volatile SingularAttribute<Planification, Integer> heureDebutEstimation;
    public static volatile SingularAttribute<Planification, Demande> idDemande;
    public static volatile SingularAttribute<Planification, Integer> idPlanification;
    public static volatile SingularAttribute<Planification, Date> datePlanification;
    public static volatile SingularAttribute<Planification, Technicien> idUtilisateurT;

}