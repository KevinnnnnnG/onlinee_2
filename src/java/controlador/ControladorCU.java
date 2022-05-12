package controlador;

import DAO.CarritoDAO;
import beans.CarritoBeans;
import beans.ProductoBeans;
import beans.ProductoBeanss;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorCU", urlPatterns = {"/ControladorCU"})
public class ControladorCU extends HttpServlet {

    CarritoDAO CDAO = new CarritoDAO();
    ProductoBeanss p = new ProductoBeanss();
    List<ProductoBeans> productos = new ArrayList<>();

    List<CarritoBeans> listacarrito = new ArrayList<>();
    int item;
    float total = 0;
    int cantidad = 1;

    int id;
    CarritoBeans cc;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        productos = CDAO.lcar();
        switch (action) {
            case "Agregar":
                int pos = 0;
                cantidad = 1;
                id = Integer.parseInt(request.getParameter("id"));
                p = CDAO.lId(id);
                if (listacarrito.size() > 0) {
                    for (int i = 0; i < listacarrito.size(); i++) {
                        if (id == listacarrito.get(i).getId()) {
                            pos = i;
                        }
                    }
                    if (id == listacarrito.get(pos).getId()) {
                        cantidad = listacarrito.get(pos).getCantidad() + cantidad;
                        float subtotal = listacarrito.get(pos).getPrecio() * cantidad;
                        listacarrito.get(pos).setCantidad(cantidad);
                        listacarrito.get(pos).setSubtotal(subtotal);
                    } else {
                        item = item + 1;
                        cc = new CarritoBeans();
                        cc.setItem(item);
                        cc.setId(p.getId());
                        cc.setNombres(p.getNombres());
                        cc.setPrecio(p.getCosto());
                        cc.setCantidad(cantidad);
                        cc.setDescripcion(p.getDescripcion());
                        cc.setSubtotal(cantidad * p.getCosto());
                        listacarrito.add(cc);
                    }
                } else {
                    item = item + 1;
                    cc = new CarritoBeans();
                    cc.setItem(item);
                    cc.setId(p.getId());
                    cc.setNombres(p.getNombres());
                    cc.setPrecio(p.getCosto());
                    cc.setCantidad(cantidad);
                    cc.setDescripcion(p.getDescripcion());
                    cc.setSubtotal(cantidad * p.getCosto());
                    listacarrito.add(cc);
                }
                request.setAttribute("contador", listacarrito.size());
                request.getRequestDispatcher("ControladorCU?action=inicio").forward(request, response);
                break;

            case "Comprar":
                total=0;
                int id = Integer.parseInt(request.getParameter("id"));
                p = CDAO.lId(id);
                item = item + 1;
                CarritoBeans cc = new CarritoBeans();
                cc.setItem(item);
                cc.setId(p.getId());
                cc.setNombres(p.getNombres());
                cc.setPrecio(p.getCosto());
                cc.setCantidad(cantidad);
                cc.setDescripcion(p.getDescripcion());
                cc.setSubtotal(cantidad * p.getCosto());
                listacarrito.add(cc);
                for (int i = 0; i < listacarrito.size(); i++) {
                    total = total + listacarrito.get(i).getSubtotal();
                }
                request.setAttribute("total", total);
                request.setAttribute("carrito", listacarrito);
                request.setAttribute("contador", listacarrito.size());
                request.getRequestDispatcher("UsuarioCarrito.jsp").forward(request, response);
                break;

            case "Borrar":
                int idp = Integer.parseInt(request.getParameter("id"));
                for (int i = 0; i < listacarrito.size(); i++) {
                    if (listacarrito.get(i).getId() == idp) {
                        listacarrito.remove(i);
                    }
                }
                break;

            case "ActualizarCant":
                int idprod = Integer.parseInt(request.getParameter("id"));
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                for (int i = 0; i < listacarrito.size(); i++) {
                    if (listacarrito.get(i).getId() == idprod) {
                        listacarrito.get(i).setCantidad(cant);
                        float st = listacarrito.get(i).getPrecio() * cant;
                        listacarrito.get(i).setSubtotal(st);
                    }
                }
                break;

            case "Carrito":
                total = 0;
                request.setAttribute("carrito", listacarrito);
                for (int i = 0; i < listacarrito.size(); i++) {
                    total = total + listacarrito.get(i).getSubtotal();
                }
                request.setAttribute("total", total);
                request.getRequestDispatcher("UsuarioCarrito.jsp").forward(request, response);
            default:
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("UsuarioPrincipal.jsp").forward(request, response);
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
