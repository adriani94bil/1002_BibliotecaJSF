/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.servicios;

import com.biblioteca.excepcion.DBException;
import com.biblioteca.model.DB;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import java.util.Collection;

/**
 *
 * @author user
 */
public class LibrosService {
    
    public void altaLibro(Libro libro)throws DBException{
        DB.altaLibro(libro);
    }
    public Collection<Libro> getAllLibros(){
        return DB.getAllLibros();
    }
    public void alquilar(int id, String email){
        DB.alquilar(id,email);
    }
    public Collection<Usuario> getAllusuarios(){
        return DB.getAllUsers();
    }
    public Collection<Libro> getLibrosAlquilados(String email){
        return DB.getLibrosAlquilados(email);
    }
}
