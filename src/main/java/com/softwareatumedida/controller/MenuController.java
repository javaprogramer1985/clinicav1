/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.controller;

import com.google.gson.Gson;
import com.softwareatumedida.ejb.MenuFacadeLocal;
import com.softwareatumedida.model.Menu;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import javax.inject.Named;
import lombok.Data;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@Named
@ViewScoped
@Data
public class MenuController implements Serializable {

    @EJB
    private MenuFacadeLocal menufacadeEJB;
    private List<Menu> lista;
    private MenuModel model;
    private String textJson;
    private Gson json;

    @PostConstruct
    public void init() {
        json = new Gson();
        lista = this.listar();
        model = new DefaultMenuModel();
        textJson = json.toJson(lista);        
        //this.establecerPermisos();
        
    }

    public void mostrar(){
        System.out.println("---> " + textJson);
    }
    
    public List<Menu> listar() {
        return menufacadeEJB.findAll();
    }

//    public void establecerPermisos() {
//        for (Menu m : lista) {
//            if (m.getMenuTipo().equals("S")) {
//                DefaultSubMenu firstsubmenu = new DefaultSubMenu(m.getMenuNombre());
//                for (Menu i : lista) {
//                    Menu submenu = i.getMenuCodigoSubmenu();
//                    if (submenu != null) {
//                        if (Objects.equals(submenu.getMenuCodigo(), m.getMenuCodigo())) {
//                            DefaultMenuItem item = new DefaultMenuItem(i.getMenuNombre());
//                            item.setCommand(i.getMenuCommando());
//                            item.setIcon(i.getMenuIcon());
//                            firstsubmenu.addElement(item);
//                            item.setUpdate("form");//El Id del formulario que se tendra que actualizar para mostrar la nueva pestaña
//                        }
//                    }
//                }
//                model.addElement(firstsubmenu);
//            } else {
//                if (m.getMenuCodigoSubmenu() == null) {
//                    DefaultMenuItem item = new DefaultMenuItem(m.getMenuNombre());
//                    item.setCommand(m.getMenuCommando());
//                    item.setIcon(m.getMenuIcon());
//                    model.addElement(item);
//                }
//            }
//        }
//    }

}
