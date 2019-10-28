package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Action;
import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Personnel;
import com.ipsofts.gestionIntervention.entities.Technicien;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Profil.class)
public class Profil_ extends BaseEntity_ {

    public static volatile SingularAttribute<Profil, Boolean> profilSup;
    public static volatile ListAttribute<Profil, Technicien> technicienList;
    public static volatile ListAttribute<Profil, Personnel> personnelList;
    public static volatile ListAttribute<Profil, Action> actionList;
    public static volatile ListAttribute<Profil, Entreprise> entrepriseList;
    public static volatile SingularAttribute<Profil, String> libelleProfil;
    public static volatile SingularAttribute<Profil, Integer> idProfil;
    public static volatile SingularAttribute<Profil, String> descriptionProfil;

}