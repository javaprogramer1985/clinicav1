package com.softwareatumedida.controller;

import com.softwareatumedida.ejb.UsuariosFacadeLocal;
import com.softwareatumedida.model.Usuarios;
import com.softwareatumedida.util.Codificador;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
@Data
public class UsuarioController implements Serializable{
    @EJB
    UsuariosFacadeLocal usuariosEJB;
    Usuarios entityUsuario;
    Usuarios usuario;
    List<Usuarios> usuarios;
    Usuarios usrSelected;

    private boolean btnEliminar;
    private boolean btnGuardar;
    private boolean btnModificar;
    private boolean btnNuevo;
    
    Codificador cod;
    
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (Usuarios) context.getExternalContext().getSessionMap().get("SessionUsuario");
        entityUsuario = new Usuarios();
        entityUsuario.setUsuarioUsr(usuario.getUsuarioUsr());
        //usuario = new Usuarios();
        usuarios = usuariosEJB.findAll();
        cod = new Codificador();
    }

    public void activarBotones(){
        btnNuevo = false;
        btnEliminar = false;
        btnGuardar = true;
        btnModificar = false;
    }
    
    public void registrar() {
        FacesMessage msg = null;                
        try {
            if (entityUsuario != null) {    
                String clavecodificada = cod.CODIDECO(entityUsuario.getUsuarioPass(),1);
                entityUsuario.setUsuarioPass(clavecodificada);                
                usuariosEJB.create(entityUsuario);
                msg = new FacesMessage("Aviso", "El registro se ha guardado correctamente");
            }
        } catch (Exception e) {
            msg = new FacesMessage("Error", "Ha ocurrido un error al tratar de guardar la colonia");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public void modificar() {
        FacesMessage msg = null;
        try {
            if (entityUsuario != null) {
                String clavecodificada = cod.CODIDECO(entityUsuario.getUsuarioPass(),1);
                entityUsuario.setUsuarioPass(clavecodificada);
                usuariosEJB.edit(entityUsuario);
                msg = new FacesMessage("Aviso", "El registro se ha modificado correctamente");
            }
        } catch (Exception e) {
            msg = new FacesMessage("Error", "Ha ocurrido un error al tratar de guardar la colonia");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public void desctivar(){
        btnNuevo = true;
        btnEliminar = false;
        btnGuardar = false;
        btnModificar = false;
    }
    
    public void eliminar() {
        if (entityUsuario != null) {
            usuariosEJB.remove(entityUsuario);
        }
    }
    public void onRowSelect(SelectEvent evt) throws Exception {
//        Codificador cod = new Codificador();
//        String clavedecodificada = cod.CODIDECO(usrSelected.getUsuarioPass(),2);
//        usrSelected.setUsuarioPass(clavedecodificada);
        entityUsuario = usrSelected;
        btnNuevo = false;
        btnEliminar = false;
        btnGuardar = true;
        btnModificar = false;
    }
}
