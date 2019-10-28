/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.PlanificationDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Planification;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class PlanificationServiceBean extends BaseServiceBean<Planification, Integer> implements PlanificationServiceBeanLocal {
    @EJB
    private PlanificationDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Planification, Integer> getDao() {
        return this.dao;
    }
    
    
}
