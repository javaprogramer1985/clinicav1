package com.softwareatumedida.controller;

import com.softwareatumedida.ejb.UsuariosFacadeLocal;
import com.softwareatumedida.model.Usuarios;
import com.softwareatumedida.util.Codificador;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped//Quizas  se hagan actualizaciones usando Ajax y no de tipo Request
public class IndexController implements Serializable{
    
    @EJB
    UsuariosFacadeLocal usuarioEJB;
    Usuarios usuario;
    
    @PostConstruct
    public void init(){
        usuario = new Usuarios();
    }
    
    
    public String login(){
        
        Codificador cod = new Codificador();
        /*Codificamos la clave para buscarla en la base de datos*/
        String clavecodificada = cod.CODIDECO(usuario.getUsuarioPass(), 1);
        
        System.out.println("Clave Introducida Codificada: " + clavecodificada);
        
        usuario.setUsuarioPass(clavecodificada);
        
        Usuarios us=null;
        String redireccion=null;
        
        try {            
            us = usuarioEJB.iniciarSesion(usuario);
            if (us!=null){
                
                //Almacenar session de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SessionUsuario", us);                
                redireccion="/dashboard/principal?faces-redirect=true";
            
            }else{
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"El Nombre de usuario o contraseña son incorrectos", ""));
                toast("El Nombre de usuario o contraseña son incorrectos");
                message(FacesMessage.SEVERITY_ERROR,"El Nombre de usuario o contraseña son incorrectos");
            }            
        } catch (Exception e) {            
            toast("El Nombre de usuario o contraseña son incorrectos");
            message(FacesMessage.SEVERITY_ERROR,"Ocurrio un error al tratar de iniciar sesion");
        }
        
        return redireccion;
        
    }
    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    private void toast(String message) {
        RequestContext.getCurrentInstance().execute("Materialize.toast('" + message +"',4000);");
    }
    
    private void message(FacesMessage.Severity SEVERITY, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY, message, message));
    }
}
