/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.excepcion.DBException;
import com.biblioteca.model.Libro;
import com.biblioteca.servicios.LibrosService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@Named(value = "altaLibro")
@RequestScoped
public class AltaLibroManagedBean {

    private Libro libroNuevo;
    
    public AltaLibroManagedBean() {
        this.libroNuevo=new Libro();
    }

    public Libro getLibroNuevo() {
        return libroNuevo;
    }

    public void setLibroNuevo(Libro libroNuevo) {
        this.libroNuevo = libroNuevo;
    }
    //Logger
    
    private Logger log=Logger.getLogger("AltaLibroManagedBean");
    //acciones
    
    public String altaLibro(){
        LibrosService s=new LibrosService();
        libroNuevo.setDisponible(true);
        FacesContext ctx=FacesContext.getCurrentInstance();
        try {
            s.altaLibro(libroNuevo);
            log.info("Alta libro OK");
            FacesMessage msg= new FacesMessage("Alta libro ok");
            ctx.addMessage(null, msg);
            return "index";
        } catch (DBException ex) {
            log.severe("No dio de alta libro. "+ex.getMessage());
            FacesMessage msg= new FacesMessage("Fallo lata libro.  "+ex.getMessage());
            ctx.addMessage(null, msg);
            return "lista-libros";
        }
    }
    
    
}