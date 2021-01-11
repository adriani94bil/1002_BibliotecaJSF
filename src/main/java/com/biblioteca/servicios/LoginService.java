/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.servicios;

import com.biblioteca.excepcion.LoginException;
import com.biblioteca.model.DB;
import com.biblioteca.model.Usuario;
import java.util.Collection;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class LoginService {
    public void login(String email, String clave,HttpSession session) throws LoginException{
        //Si existe email y clave
        Collection<Usuario> usuarios= DB.getAllUsers();
        Usuario userEncontrado=null;
        for (Usuario u:usuarios) {
            if (u.getEmail().equals(email)) {
                userEncontrado=u;
                break;
            }
        }
        //si existe añadir a session
        if (userEncontrado==null) {
            throw new LoginException("El usuario no existe. Debe registrarse.");
        } else {
            if (userEncontrado.getPassword().equals(clave)) {
                session.setAttribute("usuario", userEncontrado);
                
            }else{
                throw new LoginException("Clave no valida");
            }
        }
        // sino exuste lanzo excepcion
        
    }
    public void logout(HttpSession session){
        session.invalidate();
    }
}
