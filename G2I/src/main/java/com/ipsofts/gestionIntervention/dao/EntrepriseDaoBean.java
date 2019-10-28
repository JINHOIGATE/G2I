/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.dao;

import com.ipsofts.gestionIntervention.entities.Entreprise;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class EntrepriseDaoBean extends BaseDaoBean<Entreprise, Integer> implements EntrepriseDaoBeanLocal{
    
    public EntrepriseDaoBean(){
        super(Entreprise.class);
    }
    
}
