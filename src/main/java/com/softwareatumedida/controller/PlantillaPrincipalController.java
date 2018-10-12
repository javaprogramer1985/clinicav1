package com.softwareatumedida.controller;

import com.softwareatumedida.model.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class PlantillaPrincipalController implements Serializable{
    
    Usuarios usuario;
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    public void verificarSesion(){           
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            usuario = (Usuarios)context.getExternalContext().getSessionMap().get("SessionUsuario");                        
            
            if(usuario==null){
                context.getExternalContext().redirect("./../permisos.softwareatumedida"); //    "./../ Subir un nivel"
            }
            
            nombre = usuario.getUsuarioNombre() + " " + usuario.getUsuarioApellido(); // Para mandarlo y mostrarlo en la plantilla
            
        } catch (Exception e) {
            
        }
     }
    
    public void cerrarSession() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./../../");
        } catch (IOException ex) {
            Logger.getLogger(PlantillaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
