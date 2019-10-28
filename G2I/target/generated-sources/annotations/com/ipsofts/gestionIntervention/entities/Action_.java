package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Profil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Action.class)
public class Action_ extends BaseEntity_ {

    public static volatile SingularAttribute<Action, Date> dateAction;
    public static volatile SingularAttribute<Action, String> nomUtilisateur;
    public static volatile SingularAttribute<Action, Integer> idUtilisateur;
    public static volatile SingularAttribute<Action, String> libelleAction;
    public static volatile SingularAttribute<Action, String> descriptionAction;
    public static volatile SingularAttribute<Action, Integer> idAction;
    public static volatile SingularAttribute<Action, Profil> idProfil;

}