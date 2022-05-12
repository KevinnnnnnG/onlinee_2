
<%-- Pagina de visualizacion de los productos del administrador --%>

<%@page import="DAO.registroProductoDAO"%>
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
        <%@include file = "commons/administrador/CabeceraA.jsp" %>
        <%@include file = "card.jsp" %>   
    </body>
</html>