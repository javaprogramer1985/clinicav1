/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author martin
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByMenuCodigo", query = "SELECT m FROM Menu m WHERE m.menuCodigo = :menuCodigo")
    , @NamedQuery(name = "Menu.findByMenuNombre", query = "SELECT m FROM Menu m WHERE m.menuNombre = :menuNombre")
    , @NamedQuery(name = "Menu.findByMenuTipo", query = "SELECT m FROM Menu m WHERE m.menuTipo = :menuTipo")
    , @NamedQuery(name = "Menu.findByMenuTipoUsuario", query = "SELECT m FROM Menu m WHERE m.menuTipoUsuario = :menuTipoUsuario")
    , @NamedQuery(name = "Menu.findByMenuEstado", query = "SELECT m FROM Menu m WHERE m.menuEstado = :menuEstado")
    , @NamedQuery(name = "Menu.findByMenuUrl", query = "SELECT m FROM Menu m WHERE m.menuUrl = :menuUrl")
    , @NamedQuery(name = "Menu.findByMenuIcon", query = "SELECT m FROM Menu m WHERE m.menuIcon = :menuIcon")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MenuCodigo")
    private Short menuCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MenuNombre")
    private String menuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MenuTipo")
    private String menuTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MenuTipoUsuario")
    private String menuTipoUsuario;
    @Column(name = "MenuEstado")
    private Boolean menuEstado;
    @Size(max = 150)
    @Column(name = "MenuUrl")
    private String menuUrl;
    @Size(max = 50)
    @Column(name = "MenuIcon")
    private String menuIcon;
    @Size(max = 150)
    @Column(name = "MenuSeleccionado")
    private String menuSeleccionado;
    @OneToMany(mappedBy = "menuCodigoSubmenu")
    private Collection<Menu> menuCollection;
    @JoinColumn(name = "MenuCodigoSubmenu", referencedColumnName = "MenuCodigo")
    @ManyToOne
    private Menu menuCodigoSubmenu;

    public Menu() {
    }

    public Menu(Short menuCodigo) {
        this.menuCodigo = menuCodigo;
    }

    public Menu(Short menuCodigo, String menuNombre, String menuTipo, String menuTipoUsuario) {
        this.menuCodigo = menuCodigo;
        this.menuNombre = menuNombre;
        this.menuTipo = menuTipo;
        this.menuTipoUsuario = menuTipoUsuario;
    }

    public Short getMenuCodigo() {
        return menuCodigo;
    }

    public void setMenuCodigo(Short menuCodigo) {
        this.menuCodigo = menuCodigo;
    }

    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    public String getMenuTipo() {
        return menuTipo;
    }

    public void setMenuTipo(String menuTipo) {
        this.menuTipo = menuTipo;
    }

    public String getMenuTipoUsuario() {
        return menuTipoUsuario;
    }

    public void setMenuTipoUsuario(String menuTipoUsuario) {
        this.menuTipoUsuario = menuTipoUsuario;
    }

    public Boolean getMenuEstado() {
        return menuEstado;
    }

    public void setMenuEstado(Boolean menuEstado) {
        this.menuEstado = menuEstado;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuCommando) {
        this.menuUrl = menuCommando;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuSeleccionado() {
        return menuSeleccionado;
    }

    public void setMenuSeleccionado(String menuSeleccionado) {
        this.menuSeleccionado = menuSeleccionado;
    }
    
    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    public Menu getMenuCodigoSubmenu() {
        return menuCodigoSubmenu;
    }

    public void setMenuCodigoSubmenu(Menu menuCodigoSubmenu) {
        this.menuCodigoSubmenu = menuCodigoSubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuCodigo != null ? menuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuCodigo == null && other.menuCodigo != null) || (this.menuCodigo != null && !this.menuCodigo.equals(other.menuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.controldepagosv.model.Menu[ menuCodigo=" + menuCodigo + " ]";
    }
    
}
