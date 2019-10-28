/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.DemandeDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Demande;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class DemandeServiceBean extends BaseServiceBean<Demande, Integer> implements DemandeServiceBeanLocal {
    @EJB
    private DemandeDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Demande, Integer> getDao() {
        return this.dao;
    }
    
    
}
