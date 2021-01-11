/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.servicios;

import com.biblioteca.excepcion.DBException;
import com.biblioteca.model.*;
import java.util.Collection;

/**
 *
 * @author user
 */
public class GeneroService {
    public void altaGenero(Genero genero)throws DBException{
        DB.altaGenero(genero);
    }
    public Collection<Genero> getAllGenres(){
        return DB.getAllGeneros();
    }
}
