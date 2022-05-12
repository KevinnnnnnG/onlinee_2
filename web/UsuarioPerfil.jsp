<%@page import="beans.RegistroBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RegistroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil del usuario</title>
        <%@include file="commons/index/cdn.jsp" %>
    </head>
    <body>
        <%@include file="commons/usuarios/cabecera.jsp" %>
        <div class="container">
               <div class="d-flex">
                   <div class="card col-sm-3 mt-4">
                       <div class="card-body">
                           <form action="ControladorUsu?menu=usuario" method="POST">
                               <div class="form-group">
                                   <center><img src="img/Usr.png"  style="width:100px;"></center>
                                   <h3 class="text-center">Editar su perfil</h3>
                               </div>
                               <div class="form-group">
                                   <label>Nombre</label>
                                   <input type="text" value="${usuario.getNombres()}" name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Contacto</label>
                                <input type="text" value="${usuario.getContacto()}" name="txtCont" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Correo</label>
                                <input type="text" value="${usuario.getCorreo()}" name="txtEma" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Clave</label>
                                <input type="text" value="${usuario.getPassword()}" name="txtPass" class="form-control">
                            </div>
                            <button type="submit" name="action" value="modifica" class="btn btn-outline-primary ">
                                <i class="fas fa-user-plus"></i> Modificar
                            </button>
                          </form>
                    </div>
                </div>
                <div class="col-sm-10 mt-4">
                    <table class="table table-bordered">
                        <th  class="bg-dark text-white text-center" colspan="7"><h1>Datos Personales</h1></th>
                        <tr>
                            <th>Nombre</th>
                            <th>Contacto</th>
                            <th>Correo</th>
                            <th>Rol</th>
                            <th>Opcion</th>
                        </tr>

                        <tr>
                            <td> ${usu.getNombres()}</td>
                            <td> ${usu.getContacto()}</td>
                            <td> ${usu.getCorreo()}</td>
                            <td> ${usu.getRol()}</td>
                            <td><a class="btn btn-outline-primary" href="ControladorUsu?menu=usuario&action=carga&id=${usu.getId_registro()}">Actualizar</a></td>

                        </tr>
                    </table>
                </div>
               </div>
        </div>
    </body>
</html>

                    
        <%--            
        <%@include file="commons/usuarios/CabeceraU.jsp" %>
        <div class="container-fluid">
            <div class="row">

                <div class="col-sm-9 main-col">

                    <form action="ControladorUsu?menu=usuario" method="POST">

                        <div class="form-group d-flex">
                            <div class="col-sm-3">
                                <label>Nombre</label>
                                <input type="text" value="${usuario.getNombres()}" name="txtNombres" class="form-control">
                            </div>

                            <div class="col-sm-3">
                                <label>Contacto</label>
                                <input type="text" value="${usuario.getContacto()}" name="txtCont" class="form-control">
                            </div>

                            <div class="col-sm-3">
                                <label>Correo</label>
                                <input type="text" value="${usuario.getCorreo()}" name="txtEma" class="form-control">
                            </div>

                            <div class="col-sm-3">
                                <label>Clave</label>
                                <input type="text" value="${usuario.getPassword()}" name="txtPass" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <button type="submit" name="action" value="modifica" class="btn btn-outline-primary">
                                <i class="fas fa-user-plus"></i> Modificar
                            </button>
                        </div>
                    </form>

                    <br>
                    <br>
                    <table class="table table-bordered">
                        <th  class="bg-danger text-white" colspan="7"><h1><center>Perfil</center></h1></th>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Contacto</th>
                            <th>Correo</th>
                            <th>Rol</th>
                            <th>Opcion</th>
                        </tr>

                        <tr>
                            <td> ${usu.getId_registro()}</td>
                            <td> ${usu.getNombres()}</td>
                            <td> ${usu.getContacto()}</td>
                            <td> ${usu.getCorreo()}</td>
                            <td> ${usu.getRol()}</td>
                            <td><a class="btn btn-outline-primary" href="ControladorUsu?menu=usuario&action=carga&id=${usu.getId_registro()}">Actualizar</a></td>

                        </tr>


                    </table>
                </div>
            </div>
        </div> --%>
