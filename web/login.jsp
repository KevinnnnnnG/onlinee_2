<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="commons/index/cdn.jsp" %>
        <title>Inicio Session</title> 
    </head>
    <body>
        <%@include file="commons/index/cabecera.jsp"%>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sing" action="ValidarIngreso" method="POST">
                          <div class="form-group text-center">
                              <h3>Login</h3>
                              <img src="img/Usr.png" alt="70" width="170">
                              <br><br>
                              <label>Ingresar al sistema</label>
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" name="txtCorreo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="txtPass" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="ingresar" class="btn btn-outline-primary btn-block">
                        <a href="registro.jsp" class="btn btn-outline-danger btn-block">Crear Cuenta</a>
                    </form>  
                </div> 
            </div>
        </div>
    </body>
</html>
