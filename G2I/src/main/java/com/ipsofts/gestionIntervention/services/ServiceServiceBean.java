/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.ServiceDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Service;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class ServiceServiceBean extends BaseServiceBean<Service, String> implements ServiceServiceBeanLocal {
    @EJB
    private ServiceDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Service, String> getDao() {
        return this.dao;
    }

   
    

}

    
    
    

