/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import DAO.registroCategoriaDAO;
import beans.CatBeans;
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
@WebServlet(name = "ControladorrC", urlPatterns = {"/ControladorrC"})
public class ControladorrC extends HttpServlet {
    registroCategoriaDAO categoriaD = new registroCategoriaDAO();
    CatBeans categoriaB = new CatBeans();
    int idusr;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("action");
       
        
        if (op.equals("categoria")) {
            switch (opc)
            {
                case "eliminar":
                    idusr = Integer.parseInt(request.getParameter("id"));
                    categoriaD.eliminar(idusr);
                    request.getRequestDispatcher("AdminCategoria.jsp").forward(request, response);
                    break;
                    
                case "guardar":
                if (request.getParameter("txtCategoria").toString().length()>0)
                {
                String cat = request.getParameter("txtCategoria");
                
                categoriaB.setNombre_cat(cat);
                
                categoriaD.insertar(categoriaB);
                request.getRequestDispatcher("AdminCategoria.jsp").forward(request, response);
                    }
                    break;
                    
                    case "carga":
                    idusr = Integer.parseInt(request.getParameter("id"));
                    CatBeans cBeans = categoriaD.carga(idusr);
                    request.setAttribute("categoria", cBeans);
                    request.getRequestDispatcher("AdminCategoria.jsp").forward(request, response);
                    break;
                    
                    case "modifica":

                String nom = request.getParameter("txtCategoria");
                
                categoriaB.setNombre_cat(nom);
                categoriaB.setId_categoria(idusr);
                
                categoriaD.modificar(categoriaB);
                request.getRequestDispatcher("AdminCategoria.jsp").forward(request, response);
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
