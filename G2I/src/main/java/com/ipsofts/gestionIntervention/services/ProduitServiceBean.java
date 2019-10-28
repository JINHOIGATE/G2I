/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.ProduitDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Produit;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class ProduitServiceBean extends BaseServiceBean<Produit, String> implements ProduitServiceBeanLocal {
    @EJB
    private ProduitDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Produit, String> getDao() {
        return this.dao;
    }
    
    
}
