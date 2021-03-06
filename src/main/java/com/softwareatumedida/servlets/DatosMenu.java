/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareatumedida.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.softwareatumedida.ejb.MenuFacadeLocal;
import com.softwareatumedida.model.Menu;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author martin
 */
@WebServlet(name = "DatosMenu", urlPatterns = {"/DatosMenu"})
public class DatosMenu extends HttpServlet {

    @EJB
    private MenuFacadeLocal menufacadeEJB;
    private List<Menu> lista;
    private MenuModel model;
    private String textJson;
    private Gson json;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        json = new Gson();
        lista = this.listar();
        textJson = json.toJson(lista);  
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet DatosMenu</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet DatosMenu at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
              //String userName = request.getParameter("userName").trim();
              out.println(textJson);
        }
    }
    
    public List<Menu> listar() {
        return menufacadeEJB.findAll();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
