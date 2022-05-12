<%@page import="DAO.registroProductoDAO"%>
<%@page import="DAO.registroCategoriaDAO"%>
<%@page import="beans.CatBeans"%>
<%@page import="beans.ProductoBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <%@include file="commons/index/cdn.jsp" %>
    </head>
    <body>
        <%@include file="commons/administrador/CabeceraA.jsp" %>
        <div class="container">
            <div class="d-flex">
                <div class="card col-sm-3 mt-4">
                    <div class="card-body">
                        <form action="ControladorP?menu=producto" method="POST">
                            <div class="form-group">
                                <h3 class="text-center">Formulario de productos</h3>
                            </div>
                            <div class="form-group">
                                <label>Nombre producto</label>
                                <input type="text" value="${producto.getNombre_prod()}" name="txtProd" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Costo</label>
                                <input type="text" value="${producto.getCosto()}" name="txtCost" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Cantidad</label>
                                <input type="text" value="${producto.getCantidad()}" name="txtCant" class="form-control">
                            </div>
                                <div class="form-group">
                                    <label>Categoria</label>
                                    <select name="txtCat" class="form-control">
                                        <%-- Listar las categorias --%>
                                        <%
                                            List lisP = new registroCategoriaDAO().getAll();
                                            ListIterator listaI = lisP.listIterator();
                                            while (listaI.hasNext()) {
                                                CatBeans categoriaB = (CatBeans) listaI.next();

                                        %>

                                        <option value="<%=categoriaB.getId_categoria()%>"><%=categoriaB.getNombre_cat()%>

                                        </option>

                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                             <div class="form-group">
                                <label>Descripcion</label>
                                 <textarea name="txtDesc" id="desc" class="form-control"></textarea>
                             </div>
                            <button type="submit" name="action" value="guardar" class="btn btn-outline-warning btn-block">
                                <i class="fas fa-user-plus"></i> 
                                Guardar
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
                                <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z"/>
                                </svg>
                            </button>
                            <button type="submit" name="action" value="modifica" class="btn btn-outline-primary btn-block">
                                <i class="fas fa-user-plus"></i>
                                Modificar
                            </button>
                        </form>
                    </div>
                </div>
                <div class="col-sm-10 mt-4">
                          <table class="table table-bordered">
                        <th  class="bg-dark text-white text-center" colspan="9"><h1>Lista de Productos</h1></th>
                        <tr>
                            <th>ID</th>
                            <th>Producto</th>
                            <th>Costo</th>
                            <th>Descripcion</th>
                            <th>Cantidad</th>
                            <th>Estado</th>
                            <th>ID Categoria</th>
                            <th colspan="2">Opciones</th>
                        </tr>
                        <%-- Mostrar los resultados de la lista  --%>
                        <%
                            List lis = new registroProductoDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                ProductoBeans productoB = (ProductoBeans) list.next();

                        %>

                        <tr>           
                            <%-- Mostrar los resultados de la lista  --%>
                            <td><%= productoB.getId_producto()%></td>
                            <td><%= productoB.getNombre_prod()%></td>
                            <td><%= productoB.getCosto()%></td>
                            <td><%= productoB.getDescripcion()%></td>
                            <td><%= productoB.getCantidad()%></td>
                            <td><%= productoB.getEstado()%></td>
                            <td><%= productoB.getId_categoria()%></td>
                            <td><a class="btn btn-outline-primary"  href="ControladorP?menu=producto&action=carga&id=<%=productoB.getId_producto()%>">Actualizar</a></td>
                            <td><a class="btn btn-outline-danger"  href="ControladorP?menu=producto&action=eliminar&id=<%=productoB.getId_producto()%>">Eliminar</a></td>
                        </tr>

                        <%
                            }
                        %>
                    </table>                
               </div>
            </div>
        </div>
    </body>
</html>

