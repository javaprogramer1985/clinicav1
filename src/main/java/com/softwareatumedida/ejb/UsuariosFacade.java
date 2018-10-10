/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.ejb;

import com.softwareatumedida.model.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author a
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "clinicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Usuarios iniciarSesion(Usuarios user){
        Usuarios usuario = null;
        String consulta="";
        try {
            consulta = "FROM Usuarios u WHERE u.usuarioUsr=?1 and u.usuarioPass=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, user.getUsuarioUsr());
            query.setParameter(2, user.getUsuarioPass());
            List<Usuarios> lista = query.getResultList();
            
            if (!lista.isEmpty())
                usuario = lista.get(0);
            
            
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
}
