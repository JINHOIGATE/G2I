/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.EntrepriseDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Entreprise;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class EntrepriseServiceBean extends BaseServiceBean<Entreprise, Integer> implements EntrepriseServiceBeanLocal {
    @EJB
    private EntrepriseDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Entreprise, Integer> getDao() {
        return this.dao;
    }
    
    
}
