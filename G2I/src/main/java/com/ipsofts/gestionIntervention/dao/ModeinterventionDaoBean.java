/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.dao;

import com.ipsofts.gestionIntervention.entities.Modeintervention;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class ModeinterventionDaoBean extends BaseDaoBean<Modeintervention, Integer> implements ModeinterventionDaoBeanLocal{
    
    public ModeinterventionDaoBean(){
        super(Modeintervention.class);
    }
    
}
