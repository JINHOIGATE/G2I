/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.dao;

import com.ipsofts.gestionIntervention.entities.Produit;
import javax.ejb.Local;

/**
 *
 * @author HP Envy i7
 */
@Local
public interface ProduitDaoBeanLocal extends BaseDaoBeanLocal<Produit, String> {
    
}
