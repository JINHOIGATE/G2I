/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.dao;

import com.ipsofts.gestionIntervention.entities.Planification;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class PlanificationDaoBean extends BaseDaoBean<Planification, Integer> implements PlanificationDaoBeanLocal{
    
    public PlanificationDaoBean(){
        super(Planification.class);
    }
    
}
