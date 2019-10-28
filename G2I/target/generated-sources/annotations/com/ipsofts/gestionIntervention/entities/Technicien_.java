package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Intervention;
import com.ipsofts.gestionIntervention.entities.Planification;
import com.ipsofts.gestionIntervention.entities.Profil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Technicien.class)
public class Technicien_ extends BaseEntity_ {

    public static volatile SingularAttribute<Technicien, Date> dateNaissanceT;
    public static volatile SingularAttribute<Technicien, String> motDePasseT;
    public static volatile SingularAttribute<Technicien, Boolean> actifT;
    public static volatile SingularAttribute<Technicien, String> adresseT;
    public static volatile SingularAttribute<Technicien, Integer> idUtilisateurT;
    public static volatile SingularAttribute<Technicien, Boolean> paramT;
    public static volatile SingularAttribute<Technicien, String> prenomT;
    public static volatile SingularAttribute<Technicien, Date> dateCreationT;
    public static volatile SingularAttribute<Technicien, Character> sexeT;
    public static volatile ListAttribute<Technicien, Intervention> interventionList;
    public static volatile ListAttribute<Technicien, Planification> planificationList;
    public static volatile SingularAttribute<Technicien, String> contactT;
    public static volatile SingularAttribute<Technicien, Boolean> technicienSup;
    public static volatile SingularAttribute<Technicien, String> nomT;
    public static volatile SingularAttribute<Technicien, String> loginT;
    public static volatile SingularAttribute<Technicien, String> emailT;
    public static volatile SingularAttribute<Technicien, Profil> idProfil;

}