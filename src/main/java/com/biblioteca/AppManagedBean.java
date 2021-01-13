/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author user
 */
@Named(value = "appMB")
@ApplicationScoped
public class AppManagedBean {

    private String formatoFecha="dd/MM/yyyy";
    private int numMinDecimales=2;

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public int getNumMinDecimales() {
        return numMinDecimales;
    }
    
    
    
    public AppManagedBean() {
    }
    
}
