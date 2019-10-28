/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipsofts.gestionIntervention.beans.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author HP Envy i7
 */
public class Main {
    public static  void main (String [] art){
        
         //la date du jour
        String texte;
        DateFormat date=new SimpleDateFormat("yyyy",Locale.FRANCE);
        Calendar cal=Calendar.getInstance();
        texte=date.format(cal.getTime());
        
        System.out.println(texte);
        
    }
}
