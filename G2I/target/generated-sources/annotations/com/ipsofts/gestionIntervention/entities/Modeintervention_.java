package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Intervention;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Modeintervention.class)
public class Modeintervention_ extends BaseEntity_ {

    public static volatile SingularAttribute<Modeintervention, String> descriptionMode;
    public static volatile SingularAttribute<Modeintervention, String> libModeIntervention;
    public static volatile ListAttribute<Modeintervention, Intervention> interventionList;
    public static volatile SingularAttribute<Modeintervention, Integer> idModeIntervention;
    public static volatile SingularAttribute<Modeintervention, Boolean> modeInterventionSup;

}