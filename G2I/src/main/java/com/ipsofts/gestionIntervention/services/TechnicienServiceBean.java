/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.TechnicienDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Technicien;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class TechnicienServiceBean extends BaseServiceBean<Technicien, Integer> implements TechnicienServiceBeanLocal {
    @EJB
    private TechnicienDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Technicien, Integer> getDao() {
        return this.dao;
    }
    
    
}
