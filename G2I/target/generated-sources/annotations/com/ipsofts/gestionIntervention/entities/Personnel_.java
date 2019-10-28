package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Profil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Personnel.class)
public class Personnel_ extends BaseEntity_ {

    public static volatile SingularAttribute<Personnel, String> prenomP;
    public static volatile SingularAttribute<Personnel, Boolean> personnelSup;
    public static volatile SingularAttribute<Personnel, Date> dateNaissanceP;
    public static volatile SingularAttribute<Personnel, Integer> idUtilisateurP;
    public static volatile SingularAttribute<Personnel, Boolean> paramP;
    public static volatile SingularAttribute<Personnel, Boolean> actifP;
    public static volatile SingularAttribute<Personnel, String> adresseP;
    public static volatile SingularAttribute<Personnel, String> loginP;
    public static volatile SingularAttribute<Personnel, String> emailP;
    public static volatile SingularAttribute<Personnel, Date> dateCreationP;
    public static volatile SingularAttribute<Personnel, Character> sexeP;
    public static volatile SingularAttribute<Personnel, String> nomP;
    public static volatile SingularAttribute<Personnel, String> contactP;
    public static volatile SingularAttribute<Personnel, String> motDePasseP;
    public static volatile SingularAttribute<Personnel, Profil> idProfil;

}