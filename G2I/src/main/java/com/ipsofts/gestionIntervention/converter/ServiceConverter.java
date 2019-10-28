/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.converter;

import com.ipsofts.gestionIntervention.entities.Service;
import com.ipsofts.gestionIntervention.services.ServiceServiceBean;
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
@FacesConverter(value="serviceConverter")
public class ServiceConverter implements Converter{
    
    ServiceServiceBean service;
    
    public ServiceConverter(){
        try {
            service=new ServiceServiceBean();
        } catch (Exception ex) {
            Logger.getLogger(EntrepriseConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//          Profil result = null;
//        Entreprise result=null;
        Service result=null;
        try {
            if(value != null && !value.isEmpty()) {
//                result = service.findByPk(Integer.parseInt(value));
                result=service.selectionner(value);
            }
        } catch (Exception ex) {
            //Logger.getLogger(ProfilConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          if(!(value instanceof Service)){
            return String.valueOf(value);
        }
        String result = null;
        try {
            result = ((Service)value).getCodeService();
        } catch (Exception ex) {
            //Logger.getLogger(ProfilConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
