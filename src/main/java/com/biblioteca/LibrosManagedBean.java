/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.servicios.LibrosService;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@Named(value = "libros")
@RequestScoped
public class LibrosManagedBean {

    
    private Collection<Libro> coleccionLibros;
    private Collection<Usuario> coleccionUsuarios;
    private LibrosService servicio= new LibrosService();
    
    private String userSeleccionado;
    
    public LibrosManagedBean() {
        this.coleccionLibros=servicio.getAllLibros();
        this.coleccionUsuarios=servicio.getAllusuarios();
    }

    public Collection<Libro> getColeccionLibros() {
        return coleccionLibros;
    }

    public Collection<Usuario> getColeccionUsuarios() {
        return coleccionUsuarios;
    }
    public String getUserSeleccionado() {
        return userSeleccionado;
    }

    
    public void setUserSeleccionado(String userSeleccionado) {
        this.userSeleccionado = userSeleccionado;
    }
    
   public String alquilar(int id){
       servicio.alquilar(id,userSeleccionado);
       FacesContext ctx=FacesContext.getCurrentInstance();
       FacesMessage msg=new FacesMessage("Alquilo el libro "+this.userSeleccionado);
       ctx.addMessage(null, msg);
       return null;
   } 
}
