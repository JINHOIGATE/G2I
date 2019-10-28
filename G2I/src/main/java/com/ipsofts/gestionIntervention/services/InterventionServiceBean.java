/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.InterventionDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Intervention;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class InterventionServiceBean extends BaseServiceBean<Intervention, Integer> implements InterventionServiceBeanLocal {
    @EJB
    private InterventionDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Intervention, Integer> getDao() {
        return this.dao;
    }
    
    
}
