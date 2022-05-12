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
import javax.servlet.http.HttpSession;

/**
 *
 * @author SENA
 */
@WebServlet(name = "ValidarIngreso", urlPatterns = {"/ValidarIngreso"})
public class ValidarIngreso extends HttpServlet {

    RegistroBeans miregis = new RegistroBeans();
    RegistroDAO midao = new RegistroDAO();
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
        
        String acc = request.getParameter("accion");
        if (acc.equals("ingresar")) {
            String ema = request.getParameter("txtCorreo");
            String pass = request.getParameter("txtPass");
            
            miregis = midao.validar(ema, pass);
            
            if (miregis.getNombres() != null) {
                if (miregis.getRol().equals("admin")) {
                    request.setAttribute("administrador", miregis);
                    request.getRequestDispatcher("AdminPrincipal.jsp").forward(request, response);
                    
                }
                else
                {
                    if (miregis.getRol().equals("usuario")) {
                        request.getSession().setAttribute("usu", miregis);
                        request.getRequestDispatcher("UsuarioPrincipal.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
            }
            
            else
            {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        
        else
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
