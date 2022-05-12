/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.RegistroDAO;
import beans.RegistroBeans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SENA
 */
@WebServlet(name = "RegistroControl", urlPatterns = {"/RegistroControl"})
public class RegistroControl extends HttpServlet {
    
    RegistroBeans regisB = new RegistroBeans();
    RegistroDAO regisD = new RegistroDAO();

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
        
        String opc = request.getParameter("accion");
        PrintWriter salida = response.getWriter();
        
        if (opc.equals("insertar")) {
            
            if (request.getParameter("nombres").toString().length()>0 && request.getParameter("contacto").toString().length()>0 &&
                    request.getParameter("correo").toString().length()>0 && request.getParameter("password").toString().length()>0)
            {
                String nom = request.getParameter("nombres");
                String con = request.getParameter("contacto");
                String ema = request.getParameter("correo");
                String cont = request.getParameter("password");
                String role = request.getParameter("rol");
                
                regisB.setNombres(nom);
                regisB.setContacto(con);
                regisB.setCorreo(ema);
                regisB.setPassword(cont);
                regisB.setRol("usuario");
                
                regisD.insertar(regisB);
                
                if (regisB.getNombres() != null) {
                if (regisB.getRol().equals("admin")) {
                    request.setAttribute("administrador", regisB);
                    request.getRequestDispatcher("AdminPrincipal.jsp").forward(request, response);
                    
                }
                else
                {
                    if (regisB.getRol().equals("usuario")) {
                        request.getSession().setAttribute("usu", regisB);
                        request.getRequestDispatcher("indexUsu.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("registro.jsp").forward(request, response);
                    }
                }
            }
            
            else
            {
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
                 
            }
            
            else
            {
                response.sendRedirect("registro.jsp");
            }
        }  
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
