/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca;

import com.biblioteca.excepcion.LoginException;
import com.biblioteca.servicios.LoginService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@Named(value = "usuarioMB")
@SessionScoped
public class UsuarioManagedBean implements Serializable {
    private String email;
    private String clave;
    
    private Date fecha=new Date();
    private double precio=1213.5593;
    
    
            
    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUser() {
        return email;
    }

    public void setUser(String user) {
        this.email = user;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    public String login(){
        LoginService loginService= new LoginService();
        FacesContext ctx=FacesContext.getCurrentInstance();
        try {
            loginService.login(email, clave, (HttpSession) ctx.getExternalContext().getSession(true));
            return "index";
        } catch (LoginException ex) {
            Logger.getLogger(UsuarioManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            this.email="";
            this.clave="";
            
            FacesMessage msg=new FacesMessage(ex.getMessage());
            ctx.addMessage(null, msg);
            return "login";
        }
    }
    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login?faces-redirect=true";
        
    }
}
