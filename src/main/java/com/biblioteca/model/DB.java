/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.model;

import com.biblioteca.model.Alquiler;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.excepcion.DBException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author user
 */
public class DB {
    private static Map<Integer,Libro> libros;
    private static Map<Integer,Alquiler> alquileres;
    private static Set<Usuario> usuarios;
    private static int ultimoISBN=0;
    private static int ultimoIdAlq=0;
    private static int ultimoIdUser=0;
    
    private static Map<String,List<Libro>> librossAlquiladosPorUsuario;
    
    private DB(){}
    
    //Getter y Setters
    public static synchronized Libro getLibro(Integer id){
        Libro p= libros.get(id);
        return p;
    }
    public static synchronized Alquiler getAlquiler(Integer id){
        Alquiler p= alquileres.get(id);
        return p;
    }
    public static int getUltimoISBN() {
        return ultimoISBN;
    }

    public static void setUltimoISBN(int ultimoISBN) {
        DB.ultimoISBN = ultimoISBN;
    }

    public static int getUltimoIdAlq() {
        return ultimoIdAlq;
    }

    public static void setUltimoIdAlq(int ultimoIdAlq) {
        DB.ultimoIdAlq = ultimoIdAlq;
    }

    public static int getUltimoIdUser() {
        return ultimoIdUser;
    }

    public static void setUltimoIdUser(int ultimoIdUser) {
        DB.ultimoIdUser = ultimoIdUser;
    }
    
    //********************************************************************************************
    //Methods
    public static synchronized void add(Libro p){
        p.setIsbn(++ultimoISBN);
        libros.put(ultimoISBN, p);
    }
    public static synchronized void addAlquiler(Alquiler a){
        a.setId(++ultimoIdAlq);
        alquileres.put(ultimoIdAlq, a);
    }
    public static synchronized void addUsuario(Usuario u) throws DBException{
        usuarios.add(u);
    }
    
   public static synchronized Collection <Libro>getAllLibros(){
       return libros.values();
   }
   public static synchronized Collection <Alquiler>getAllAlquileres(){
       return alquileres.values();
   }
   public static synchronized Collection <Usuario> getAllUsers(){
       return usuarios;
   }
    static{
        libros=new HashMap<Integer, Libro>();
        alquileres=new HashMap<Integer, Alquiler>();
        usuarios=new HashSet<Usuario>();
        libros.put(1, new Libro(1,"Ética para Amador","Fernando Savater","Disertación filosófica sobre ....",123.0,10));
        libros.put(2, new Libro(2,"Venado Tuerto","Willy Barcenas","Corbata seda",63.0,22));
        libros.put(3, new Libro(3," La colmena","Camilo Jose Cela","Calcetines algodon",23.0,40));
        alquileres.put(1,new Alquiler(1,libros.get(1)));
        alquileres.put(2,new Alquiler(2,libros.get(1)));
        alquileres.put(3,new Alquiler(3,libros.get(2)));
        usuarios.add(new Usuario(1,"a@ruiz.es","1","adrian","ruiz"));
        usuarios.add(new Usuario(2,"ton@ton.es","1","ser","top"));
        usuarios.add(new Usuario(3,"ser@serz.es","1","ru","ghuo"));
        ultimoISBN=3;
        ultimoIdAlq=3;
        ultimoIdUser=3;
        
        librossAlquiladosPorUsuario= new HashMap<String,List<Libro>>();
        ArrayList<Libro> alquilados01=new ArrayList();
        ArrayList<Libro> alquilados02=new ArrayList();
        ArrayList<Libro> alquilados03=new ArrayList();
        librossAlquiladosPorUsuario.put("a@ruiz.es",alquilados01);
        librossAlquiladosPorUsuario.put("ton@ton.es",alquilados02);
        librossAlquiladosPorUsuario.put("ser@serz.es",alquilados03);
    }
    public synchronized static void alquilar(int id,String email){
        libros.get(id).setDisponible(false);
        librossAlquiladosPorUsuario.get(email).add(libros.get(id));
        
    }
    public static void altaLibro(Libro libro) throws DBException{
        if (libros.containsKey(libro.getIsbn())) {
            throw new DBException("El libro con este id ya existe");
        }
            libros.put(libro.getIsbn(),libro);
    }
    public synchronized static List<Libro> getLibrosAlquilados(String email){
        return librossAlquiladosPorUsuario.get(email);
    }
    
    
}
