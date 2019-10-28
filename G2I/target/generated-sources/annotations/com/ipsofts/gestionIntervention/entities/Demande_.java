package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.entities.Intervention;
import com.ipsofts.gestionIntervention.entities.Planification;
import com.ipsofts.gestionIntervention.entities.Poste;
import com.ipsofts.gestionIntervention.entities.Produit;
import com.ipsofts.gestionIntervention.entities.Service;
import com.ipsofts.gestionIntervention.entities.Typedemande;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Demande.class)
public class Demande_ extends BaseEntity_ {

    public static volatile SingularAttribute<Demande, String> pieceJointe;
    public static volatile ListAttribute<Demande, Intervention> interventionList;
    public static volatile SingularAttribute<Demande, Poste> codePoste;
    public static volatile ListAttribute<Demande, Planification> planificationList;
    public static volatile SingularAttribute<Demande, Integer> idDemande;
    public static volatile SingularAttribute<Demande, Entreprise> idUtilisateurE;
    public static volatile SingularAttribute<Demande, Typedemande> idTypeDemande;
    public static volatile SingularAttribute<Demande, Date> dateDemande;
    public static volatile SingularAttribute<Demande, Produit> codeProduit;
    public static volatile SingularAttribute<Demande, String> libelleDemande;
    public static volatile SingularAttribute<Demande, Boolean> etatDemande;
    public static volatile SingularAttribute<Demande, Service> codeService;

}