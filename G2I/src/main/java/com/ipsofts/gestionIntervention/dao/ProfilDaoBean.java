/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.dao;

import com.ipsofts.gestionIntervention.entities.Profil;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class ProfilDaoBean extends BaseDaoBean<Profil, Integer> implements ProfilDaoBeanLocal{
    
    public ProfilDaoBean(){
        super(Profil.class);
    }
    
}
