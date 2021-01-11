/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.excepcion.DBException;
import com.biblioteca.model.Genero;
import com.biblioteca.servicios.GeneroService;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@Named(value = "altageneroMB")
@Dependent
public class AltaGeneroManagedBean {

    private Genero genero;
    
    public AltaGeneroManagedBean() {
        this.genero=new Genero();
        
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
     private Logger log=Logger.getLogger("AltaGeneroManagedBean");
     
     public String altaGenero(){
        GeneroService s=new GeneroService();
        FacesContext ctx=FacesContext.getCurrentInstance();
        try {
            s.altaGenero(genero);
            log.info("Alta genero OK");
            FacesMessage msg= new FacesMessage("Alta genero ok");
            ctx.addMessage(null, msg);
            return "index";
        } catch (DBException ex) {
            log.severe("No dio de alta genero. "+ex.getMessage());
            FacesMessage msg= new FacesMessage("Fallo alta genero.  "+ex.getMessage());
            ctx.addMessage(null, msg);
            return "lista-generos";
        }
    }
     
}
