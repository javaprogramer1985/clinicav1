/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martin
 */
@ManagedBean
@RequestScoped
public class ServletController implements Serializable{
    
    private String htmlMenu;

    public String getHtmlMenu() {
        return htmlMenu;
    }

    public void setHtmlMenu(String htmlMenu) {
        this.htmlMenu = htmlMenu;
    }
    
    public void callServlet(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
            RequestDispatcher dispacher = request.getRequestDispatcher("/DatosMenu");
            dispacher.forward(request, response);
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            context.responseComplete();
        }
    }
    
}
