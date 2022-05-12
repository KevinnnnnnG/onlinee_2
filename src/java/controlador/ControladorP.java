/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.registroProductoDAO;
import beans.ProductoBeans;
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
@WebServlet(name = "ControladorP", urlPatterns = {"/ControladorP"})
public class ControladorP extends HttpServlet {

    registroProductoDAO productoD = new registroProductoDAO();
    ProductoBeans productoB = new ProductoBeans();
    int idusr;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("menu");
        String opc = request.getParameter("action");

        if (op.equals("producto")) {

            switch (opc) {
                case "eliminar":
                    idusr = Integer.parseInt(request.getParameter("id"));
                    productoD.eliminar(idusr);
                    request.getRequestDispatcher("AdminProductos.jsp").forward(request, response);
                    break;

                case "guardar":

                    String pro = request.getParameter("txtProd");
                    int cos = Integer.parseInt(request.getParameter("txtCost"));
                    int can = Integer.parseInt(request.getParameter("txtCant"));
                    String des = request.getParameter("txtDesc");
                    int cat = Integer.parseInt(request.getParameter("txtCat"));

                    productoB.setNombre_prod(pro);
                    productoB.setCosto(cos);
                    productoB.setCantidad(can);
                    productoB.setDescripcion(des);
                    productoB.setId_categoria(cat);

                    productoD.insertar(productoB);
                    request.getRequestDispatcher("AdminProductos.jsp").forward(request, response);
                    break;

                case "carga":
                    idusr = Integer.parseInt(request.getParameter("id"));
                    ProductoBeans proB = productoD.carga(idusr);
                    request.setAttribute("producto", proB);
                    request.getRequestDispatcher("AdminProductos.jsp").forward(request, response);
                    break;

                case "modifica":
                    String prd = request.getParameter("txtProd");
                    int cost = Integer.parseInt(request.getParameter("txtCost"));
                    String desc = request.getParameter("txtDesc");
                    int cant = Integer.parseInt(request.getParameter("txtCant"));
                    int cate = Integer.parseInt(request.getParameter("txtCat"));

                    productoB.setNombre_prod(prd);
                    productoB.setCosto(cost);
                    productoB.setDescripcion(desc);
                    productoB.setCantidad(cant);
                    productoB.setId_categoria(cate);

                    productoB.setId_producto(idusr);

                    productoD.modificar(productoB);
                    request.getRequestDispatcher("AdminProductos.jsp").forward(request, response);
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
