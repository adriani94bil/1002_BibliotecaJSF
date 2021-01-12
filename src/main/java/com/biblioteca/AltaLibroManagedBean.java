/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.excepcion.DBException;
import com.biblioteca.model.Genero;
import com.biblioteca.model.Libro;
import com.biblioteca.servicios.GeneroService;
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
    private Integer idGeneroSel;
    
    public AltaLibroManagedBean() {
        this.libroNuevo=new Libro();
    }

    public Libro getLibroNuevo() {
        return libroNuevo;
    }

    public void setLibroNuevo(Libro libroNuevo) {
        this.libroNuevo = libroNuevo;
    }

    public Integer getIdGeneroSel() {
        return idGeneroSel;
    }

    public void setIdGeneroSel(Integer idGeneroSel) {
        this.idGeneroSel = idGeneroSel;
    }
    
    
    //Logger
    
    private Logger log=Logger.getLogger("AltaLibroManagedBean");
    //acciones
    
    public String altaLibro(){
        LibrosService libroService=new LibrosService();
        GeneroService generoService= new GeneroService();
        
        
        libroNuevo.setDisponible(true);
        FacesContext ctx=FacesContext.getCurrentInstance();
        try {
            libroNuevo.setGenero(generoService.getGenero(idGeneroSel));
            libroService.altaLibro(libroNuevo);
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
