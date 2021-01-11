/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.model.*;
import com.biblioteca.servicios.GeneroService;
import com.biblioteca.servicios.LibrosService;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author user
 */
@Named(value = "generosMB")
@Dependent
public class GenerosManagedBean {

    private Collection<Genero> coleccionGeneros;
    private Collection<Libro> coleccionLibros;
    private LibrosService servicioLibro= new LibrosService();
    private GeneroService servicioGenero=new GeneroService();
    public GenerosManagedBean() {
        this.coleccionGeneros=servicioGenero.getAllGenres();
        this.coleccionLibros=servicioLibro.getAllLibros();
    }

    public Collection<Genero> getColeccionGeneros() {
        return coleccionGeneros;
    }

    public Collection<Libro> getColeccionLibros() {
        return coleccionLibros;
    }
    
    
}
