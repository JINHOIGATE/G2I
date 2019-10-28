/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.ModeinterventionDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Modeintervention;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class ModeinterventionServiceBean extends BaseServiceBean<Modeintervention, Integer> implements ModeinterventionServiceBeanLocal {
    @EJB
    private ModeinterventionDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Modeintervention, Integer> getDao() {
        return this.dao;
    }
    
    
}
