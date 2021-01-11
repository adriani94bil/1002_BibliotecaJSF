/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.model.Libro;
import com.biblioteca.servicios.LibrosService;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "librosAlquiladosMB")
@Dependent
public class LibrosAlquiladosManagedBean {
    
    
    //Atributos
    private String emailLogeado="a@ruiz.es";
    private Collection<Libro> collectionAlquilados;
    private LibrosService servicio= new LibrosService();
    
    
    //Inject el Managed Bena de Session UsuarioManaaed Bean
    
    @Inject
    private UsuarioManagedBean usuario;
    
    @PostConstruct
    public void iniciar(){
        this.emailLogeado=usuario.getUser();
        this.collectionAlquilados=servicio.getLibrosAlquilados(emailLogeado);
    }
    
    public LibrosAlquiladosManagedBean() {
        //Se manda al post construct
//        this.collectionAlquilados=servicio.getLibrosAlquilados(emailLogeado);
    }

    public Collection<Libro> getCollectionAlquilados() {
        return collectionAlquilados;
    }
    
    
}
