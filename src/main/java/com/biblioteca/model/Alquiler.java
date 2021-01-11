/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.model;

import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class Alquiler {
    private Integer id;
    private Libro libro;
    private LocalDateTime fechaIni;
    private LocalDateTime fechaFin;
    private boolean isFinished;

    public Alquiler(Integer id, Libro libro) {
        this.id = id;
        this.libro = libro;
        this.fechaIni = LocalDateTime.now();
        this.fechaFin = null;
        this.isFinished=false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDateTime getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDateTime fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", libro=" + libro + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", isFinished=" + isFinished + '}';
    }
    
    
    
}
