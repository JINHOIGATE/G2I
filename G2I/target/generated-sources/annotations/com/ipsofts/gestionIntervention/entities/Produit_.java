package com.ipsofts.gestionIntervention.entities;

import com.ipsofts.gestionIntervention.entities.Demande;
import com.ipsofts.gestionIntervention.entities.Entreprise;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-24T04:17:17")
@StaticMetamodel(Produit.class)
public class Produit_ extends BaseEntity_ {

    public static volatile SingularAttribute<Produit, String> descriptionProduit;
    public static volatile ListAttribute<Produit, Demande> demandeList;
    public static volatile SingularAttribute<Produit, Boolean> produitSup;
    public static volatile SingularAttribute<Produit, String> typeProduit;
    public static volatile SingularAttribute<Produit, Boolean> estIpSoft;
    public static volatile SingularAttribute<Produit, String> nomProduit;
    public static volatile SingularAttribute<Produit, Entreprise> idUtilisateurE;
    public static volatile SingularAttribute<Produit, String> codeProduit;

}