/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.converter;

import com.ipsofts.gestionIntervention.entities.Entreprise;
import com.ipsofts.gestionIntervention.services.EntrepriseServiceBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author HP Envy i7
 */
@FacesConverter(value="entrepriseConverter")
public class EntrepriseConverter implements Converter{
    
    EntrepriseServiceBean service;
    
    public EntrepriseConverter(){
        try {
            service=new EntrepriseServiceBean();
        } catch (Exception ex) {
            Logger.getLogger(EntrepriseConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//           Profil result = null;
        Entreprise result=null;
        try {
            if(value != null && !value.isEmpty()) {
//                result = service.findByPk(Integer.parseInt(value));
                result=service.selectionner(Integer.parseInt(value));
            }
        } catch (Exception ex) {
            //Logger.getLogger(ProfilConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          if(!(value instanceof Entreprise)){
            return String.valueOf(value);
        }
        String result = null;
        try {
            result = ((Entreprise)value).getIdUtilisateurE().toString();
        } catch (Exception ex) {
            //Logger.getLogger(ProfilConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
