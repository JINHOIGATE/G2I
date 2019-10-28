/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.PersonnelDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Personnel;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class PersonnelServiceBean extends BaseServiceBean<Personnel, Integer> implements PersonnelServiceBeanLocal {
    @EJB
    private PersonnelDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Personnel, Integer> getDao() {
        return this.dao;
    }
    
    
}
