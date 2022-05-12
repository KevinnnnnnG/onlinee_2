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
 * @author kgome
 */
@WebServlet(name = "ControladorUsu", urlPatterns = {"/ControladorUsu"})
public class ControladorUsu extends HttpServlet {

    RegistroDAO registroUD = new RegistroDAO();
    RegistroBeans registroUB = new RegistroBeans();
    int idusr;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("menu");
        String opc = request.getParameter("action");

        if (op.equals("usuario")) {
            switch (opc) {
                /*case "carga":
                    idusr = Integer.parseInt(request.getParameter("id"));
                    RegistroBeans rBeans = registroUD.carga(idusr);
                    request.setAttribute("usu", rBeans);
                    request.getRequestDispatcher("UsuarioPerfil.jsp").forward(request, response);
                    break;*/
                case "carga":
                    idusr = Integer.parseInt(request.getParameter("id"));
                    RegistroBeans regB = registroUD.carga(idusr);
                    request.setAttribute("usuario", regB);
                    request.getRequestDispatcher("UsuarioPerfil.jsp").forward(request, response);
                    break;

                case "modifica":

                    String nom = request.getParameter("txtNombres");
                    String con = request.getParameter("txtCont");
                    String ema = request.getParameter("txtEma");
                    String cla = request.getParameter("txtPass");

                    registroUB.setNombres(nom);
                    registroUB.setContacto(con);
                    registroUB.setCorreo(ema);
                    registroUB.setPassword(cla);
                    registroUB.setId_registro(idusr);

                    registroUD.modificar(registroUB);
                    registroUD.validar(ema, cla);
                    request.setAttribute("usu", registroUB);
                    request.getRequestDispatcher("UsuarioPerfil.jsp").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
        }

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
