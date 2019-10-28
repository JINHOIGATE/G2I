/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.ProfilDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Profil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class ProfilServiceBean extends BaseServiceBean<Profil, Integer> implements ProfilServiceBeanLocal {
    @EJB
    private ProfilDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Profil, Integer> getDao() {
        return this.dao;
    }
    
    
}
