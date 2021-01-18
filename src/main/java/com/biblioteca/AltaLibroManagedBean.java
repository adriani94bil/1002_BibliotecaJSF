/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.excepcion.DBException;
import com.biblioteca.model.Libro;
import com.biblioteca.servicios.GeneroService;
import com.biblioteca.servicios.LibrosService;
import com.sun.faces.util.MessageFactory;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
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
    
    //Validadores
    
    public void validarAutor(FacesContext fc,
            UIComponent componente,
            Object value){
        String autor=(String) value;
        if(autor.contains("*")){
            ((UIInput) componente).setValid(false);
            FacesMessage msg= MessageFactory.getMessage("libros_alta_validacion_autor",null);
            fc.addMessage(componente.getClientId(fc), msg);
            
        }
    }
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
            FacesMessage msg= MessageFactory.getMessage("libro_alta_ok", libroNuevo.getNombre());
            ctx.addMessage(null, msg);
            return "index";
        } catch (DBException ex) {
            log.severe("No dio de alta libro. "+ex.getMessage());
            FacesMessage msg= MessageFactory.getMessage("libro_alta_error", libroNuevo.getNombre(),ex.getMessage());
            ctx.addMessage(null, msg);
            return "lista-libros";
        }
    }
    
    
}
