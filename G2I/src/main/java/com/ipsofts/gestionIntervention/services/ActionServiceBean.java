/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.ActionDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Action;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class ActionServiceBean extends BaseServiceBean<Action, Integer> implements ActionServiceBeanLocal {
    @EJB
    private ActionDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Action, Integer> getDao() {
        return this.dao;
    }
    
    
}
