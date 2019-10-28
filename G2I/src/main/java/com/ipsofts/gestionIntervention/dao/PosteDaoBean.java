/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.dao;

import com.ipsofts.gestionIntervention.entities.Poste;
import javax.ejb.Stateless;

/**
 *
 * @author HP Envy i7
 */
@Stateless
public class PosteDaoBean extends BaseDaoBean<Poste, String> implements PosteDaoBeanLocal{
    
    public PosteDaoBean(){
        super(Poste.class);
    }
    
}
