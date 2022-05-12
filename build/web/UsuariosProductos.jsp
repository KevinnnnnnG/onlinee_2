<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indice</title>
        <%@include file = "commons/index/cdn.jsp" %>
        <link rel="stylesheet" href="CSS/card.css" type="text/css">
    </head>
    <body>
        <%@include file = "commons/usuarios/cabecera.jsp" %>
        <div class="container mt-4">
            <div class="card-deck">
                <c:forEach var="p" items="${productos}">
                    <div class="card text-center">
                        <figure>
                             <img height="100" width="100" src="img/producto.png" alt="Card image cap">
                        </figure>
                        <div class="card-body">
                            <h5 class="card-title">${p.getNombres()}</h5>
                            <p class="card-text">${p.getDescripcion()}</p>
                            <p class="card-text">$${p.getCosto()}0</p>
                            <a href="ControladorCC?action=Agregar&id=${p.getId()}" class="btn btn-primary btn-block">Agregar a carrito</a>
                            <a href="ControladorCC?action=Comprar&id=${p.getId()}" class="btn btn-warning btn-block">Comprar</a>
                        </div>
                    </div>                    
                </c:forEach> 
            </div>                    
        </div>
    </body>
</html>
