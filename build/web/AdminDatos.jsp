<%@page import="beans.RegistroBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RegistroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <%@include file="commons/index/cdn.jsp" %>
    </head>
    <body>
        <%@include file = "commons/administrador/CabeceraA.jsp" %>
        <div class="container">   
            <div class="d-flex">
                <div class="card col-sm-3 mt-4">
                    <div class="card-body">
                        <form action="ControladorD?menu=usuario" method="POST">
                            <div class="form-group">
                                <h3 class="text-center">Formulario de usuarios</h3>
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
                            <button type="submit" name="action" value="guardar" class="btn btn-outline-warning btn-block">
                                <i class="fas fa-user-plus"></i> Agregar
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                                </svg>
                            </button>
                            <button type="submit" name="action" value="modifica" class="btn btn-outline-primary btn-block">
                                <i class="fas fa-user-plus"></i>
                                Modificar
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                </svg>
                            </button>
                        </form>
                    </div>
                </div>
                <div class="col-sm-10 mt-4">
                    <table class="table table-bordered">
                        <th  class="bg-dark text-white text-center" colspan="7"><h1>Lista de Usuarios</h1></th>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Contacto</th>
                            <th>Correo</th>
                            <th>Rol</th>
                            <th colspan="2" class="text-center">Opciones</th>
                        </tr>
                        <%-- Listar todas los usuarios --%>
                        <%
                            List lis = new RegistroDAO().getAll();
                            ListIterator list = lis.listIterator();
                            while (list.hasNext()) {
                                RegistroBeans regB = (RegistroBeans) list.next();

                        %>

                        <tr>
                            <%-- Mostrar los resultados de la lista  --%>
                            <td><%= regB.getId_registro()%></td>
                            <td><%= regB.getNombres()%></td>
                            <td><%= regB.getContacto()%></td>
                            <td><%= regB.getCorreo()%></td>
                            <td><%= regB.getRol()%></td>
                            <td><a class="btn btn-outline-primary" href="ControladorD?menu=usuario&action=carga&id=<%=regB.getId_registro()%>">
                                    Actualizar
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                                    <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                    </svg>
                                </a></td>
                            <td><a class="btn btn-outline-danger" href="ControladorD?menu=usuario&action=eliminar&id=<%=regB.getId_registro()%>">
                                    Eliminar
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-x-fill" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6.146-2.854a.5.5 0 0 1 .708 0L14 6.293l1.146-1.147a.5.5 0 0 1 .708.708L14.707 7l1.147 1.146a.5.5 0 0 1-.708.708L14 7.707l-1.146 1.147a.5.5 0 0 1-.708-.708L13.293 7l-1.147-1.146a.5.5 0 0 1 0-.708z"/>
                                    </svg>
                                </a></td>

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
