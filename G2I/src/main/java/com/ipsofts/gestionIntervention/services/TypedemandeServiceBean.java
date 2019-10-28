/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.services;

import com.ipsofts.gestionIntervention.dao.BaseDaoBeanLocal;
import com.ipsofts.gestionIntervention.dao.TypedemandeDaoBeanLocal;
import com.ipsofts.gestionIntervention.entities.Typedemande;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class TypedemandeServiceBean extends BaseServiceBean<Typedemande, Integer> implements TypedemandeServiceBeanLocal {
    @EJB
    private TypedemandeDaoBeanLocal dao;

    @Override
    protected BaseDaoBeanLocal<Typedemande, Integer> getDao() {
        return this.dao;
    }
    
    
}
