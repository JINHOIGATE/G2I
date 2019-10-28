package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Demande;
import com.ipsofts.gestionIntervention.entities.Modeintervention;
import com.ipsofts.gestionIntervention.entities.Technicien;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Intervention.class)
public class Intervention_ extends BaseEntity_ {

    public static volatile SingularAttribute<Intervention, Integer> idInterveniton;
    public static volatile SingularAttribute<Intervention, Integer> heureDebutIntervention;
    public static volatile SingularAttribute<Intervention, Date> dateIntervention;
    public static volatile SingularAttribute<Intervention, String> contenuSolution;
    public static volatile SingularAttribute<Intervention, Integer> heureFinIntervention;
    public static volatile SingularAttribute<Intervention, Float> duree;
    public static volatile SingularAttribute<Intervention, Demande> idDemande;
    public static volatile SingularAttribute<Intervention, Modeintervention> idModeIntervention;
    public static volatile SingularAttribute<Intervention, Boolean> resolution;
    public static volatile SingularAttribute<Intervention, Technicien> idUtilisateurT;

}