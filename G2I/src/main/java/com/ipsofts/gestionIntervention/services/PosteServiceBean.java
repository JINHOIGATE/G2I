/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.PosteDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Poste;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class PosteServiceBean extends BaseServiceBean<Poste, String> implements PosteServiceBeanLocal {
    @EJB
    private PosteDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Poste, String> getDao() {
        return this.dao;
    }
    
    
}
