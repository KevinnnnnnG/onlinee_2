<%-- 
    Document   : registro
    Created on : 18/11/2021, 03:11:10 PM
    Author     : SENA-WS-H50-1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cuenta</title>
        <%@include file="commons/index/cdn.jsp"%>
    </head>
    <body>
        <%@include file="commons/index/cabecera.jsp"%>
        <br>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-9">
                <div class="card-body">
                    <div class="container registro">
                        <h3 class="text-center">Formularios de registro</h3>
                        <form method="POST" action="RegistroControl?accion=insertar">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input class="form-control" type="text" placeholder="Ingrese nombre" name="nombres">
                            </div>
                            <div class="form-group">
                                <label>Contacto</label>
                                <input  class="form-control" type="text" placeholder="Ingrese el contacto" name="contacto">
                            </div>
                            <div class="form-group">
                                <label>Correo</label>
                                <input class="form-control" type="text" placeholder="Ingrese Correo" name="correo">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input  class="form-control" type="password" placeholder="Ingrese contraseña" name="password">
                            </div>
                            <br>
                            <div class="form-group">
                                <button type="submit" name="accion" value="insertar" class="btn btn-outline-primary btn-block">Enviar</button>
                                <a href="login.jsp" class="btn btn-outline-danger btn-block">Login</a>
                            </div>      
                        </form>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
