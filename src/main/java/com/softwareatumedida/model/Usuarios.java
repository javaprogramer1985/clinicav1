/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuarioUsr", query = "SELECT u FROM Usuarios u WHERE u.usuarioUsr = :usuarioUsr")
    , @NamedQuery(name = "Usuarios.findByUsuarioPass", query = "SELECT u FROM Usuarios u WHERE u.usuarioPass = :usuarioPass")
    , @NamedQuery(name = "Usuarios.findByUsuarioNombre", query = "SELECT u FROM Usuarios u WHERE u.usuarioNombre = :usuarioNombre")
    , @NamedQuery(name = "Usuarios.findByUsuarioApellido", query = "SELECT u FROM Usuarios u WHERE u.usuarioApellido = :usuarioApellido")
    , @NamedQuery(name = "Usuarios.findByUsuarioFecAlta", query = "SELECT u FROM Usuarios u WHERE u.usuarioFecAlta = :usuarioFecAlta")
    , @NamedQuery(name = "Usuarios.findByUsuarioEstado", query = "SELECT u FROM Usuarios u WHERE u.usuarioEstado = :usuarioEstado")
    , @NamedQuery(name = "Usuarios.findByUsuarioFecBaja", query = "SELECT u FROM Usuarios u WHERE u.usuarioFecBaja = :usuarioFecBaja")
    , @NamedQuery(name = "Usuarios.findByUsuarioTipo", query = "SELECT u FROM Usuarios u WHERE u.usuarioTipo = :usuarioTipo")
    , @NamedQuery(name = "Usuarios.findByUsuarioDomicilio", query = "SELECT u FROM Usuarios u WHERE u.usuarioDomicilio = :usuarioDomicilio")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioUsr")
    private String usuarioUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioPass")
    private String usuarioPass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioNombre")
    private String usuarioNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UsuarioApellido")
    private String usuarioApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioFecAlta")
    @Temporal(TemporalType.DATE)
    private Date usuarioFecAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioEstado")
    private boolean usuarioEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UsuarioFecBaja")
    @Temporal(TemporalType.DATE)
    private Date usuarioFecBaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UsuarioTipo")
    private String usuarioTipo;
    @Size(max = 250)
    @Column(name = "UsuarioDomicilio")
    private String usuarioDomicilio;

    public Usuarios() {
    }

    public Usuarios(String usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    public Usuarios(String usuarioUsr, String usuarioPass, String usuarioNombre, String usuarioApellido, Date usuarioFecAlta, boolean usuarioEstado, Date usuarioFecBaja, String usuarioTipo) {
        this.usuarioUsr = usuarioUsr;
        this.usuarioPass = usuarioPass;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
        this.usuarioFecAlta = usuarioFecAlta;
        this.usuarioEstado = usuarioEstado;
        this.usuarioFecBaja = usuarioFecBaja;
        this.usuarioTipo = usuarioTipo;
    }

    public String getUsuarioUsr() {
        return usuarioUsr;
    }

    public void setUsuarioUsr(String usuarioUsr) {
        this.usuarioUsr = usuarioUsr;
    }

    public String getUsuarioPass() {
        return usuarioPass;
    }

    public void setUsuarioPass(String usuarioPass) {
        this.usuarioPass = usuarioPass;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public Date getUsuarioFecAlta() {
        return usuarioFecAlta;
    }

    public void setUsuarioFecAlta(Date usuarioFecAlta) {
        this.usuarioFecAlta = usuarioFecAlta;
    }

    public boolean getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(boolean usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public Date getUsuarioFecBaja() {
        return usuarioFecBaja;
    }

    public void setUsuarioFecBaja(Date usuarioFecBaja) {
        this.usuarioFecBaja = usuarioFecBaja;
    }

    public String getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(String usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    public String getUsuarioDomicilio() {
        return usuarioDomicilio;
    }

    public void setUsuarioDomicilio(String usuarioDomicilio) {
        this.usuarioDomicilio = usuarioDomicilio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioUsr != null ? usuarioUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuarioUsr == null && other.usuarioUsr != null) || (this.usuarioUsr != null && !this.usuarioUsr.equals(other.usuarioUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softwareatumedida.model.Usuarios[ usuarioUsr=" + usuarioUsr + " ]";
    }
    
}
