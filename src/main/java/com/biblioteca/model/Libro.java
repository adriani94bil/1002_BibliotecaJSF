/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.model;

import java.io.Serializable;



/**
 *
 * @author user
 */
public class Libro implements Serializable{
    private Integer isbn;
    private String nombre;
    private String autor;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private boolean disponible;
    private Genero genero;

    public Libro(Integer isbn, String nombre,String autor, String descripcion, Double precio, Integer stock,Genero g) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        if (stock==0) {
            disponible=false;
        } else {
            disponible=true;
        }
        this.genero=genero;
    }

    public Libro(){
        
    }
    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    
    
    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", disponible=" + disponible + '}';
    }
    
    
    
}
