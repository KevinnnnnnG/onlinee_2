

<%@page import="DAO.registroProductoDAO"%>
<%@page import="beans.CatBeans"%>
<%@page import="beans.ProductoBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Productos</title>
        <%@include file="commons/index/cdn.jsp" %>
        <link rel="stylesheet" href="CSS/card.css">
    </head>
    <body>
      <%@include file = "commons/usuarios/CabeceraU.jsp" %>   
        <!--   Tarjetas-->
        <div class="title-cards">
            <h2>Productos que ofrecemos</h2>
        </div>
        <div class="container-card">
            <%
                List lis = new registroProductoDAO().getAll();
                ListIterator list = lis.listIterator();
                while (list.hasNext()) {
                    ProductoBeans productoB = (ProductoBeans) list.next();

            %>
            <div class="card">
                <figure>
                    <img src="img/producto.png" height="200" width="200">
                </figure>
                <div class="contenido-card">
                    <h3><%= productoB.getNombre_prod()%></h3>
                    <h3><%= productoB.getCosto()%></h3>
                    <p><%= productoB.getDescripcion()%></p>
                    <a href="ControladorCC?action=Comprar&id=<%= productoB.getId_producto() %>">  Pedir Orden</a>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <!--Fin   Tarjetas-->
    </body>
</html>