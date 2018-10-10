/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.util;

import java.io.IOException;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author a
 */
@Named(value = "jSFUtil")
@RequestScoped
public class JSFUtil {

    FacesMessage message = null; 
    RequestContext context;    
    @Dependent
    final String index;
    
    /**
     * Creates a new instance of JSFUtil
     */
    public JSFUtil() {
        this.index = "../index.xhtml";
        context = RequestContext.getCurrentInstance();
    }
    
    public void regresar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try{
            ec.redirect(index);
        }catch(IOException e){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Imposible acceder","A ocurrido un error al intentar ir a la pagina");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", null);
        }        
        
    }
    public void loguot(){
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if( session != null){
                session.invalidate();
            }
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            
            ec.redirect("../index.xhtml");
            
        } catch (IOException ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Imposible acceder",ex.getLocalizedMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", null);
        }
        
    }
       
    public void loadEntes(){
        
    }
}
