<%@page import="DAO.registroCategoriaDAO"%>
<%@page import="beans.CatBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
        <%@include file="commons/index/cdn.jsp" %>
    </head>
    <body>
         <%@include file = "commons/administrador/CabeceraA.jsp" %>
         <div class="container">
             <div class="d-flex">
                 <div class="card col-sm-3 mt-4">
                     <div class="card-body">
                         <form action="ControladorrC?menu=categoria" method="POST">
                             <div class="form-group">
                                 <h3 class="text-center">Formulario de categorias</h3>
                             </div>
                             <div class="form-group">
                                 <label>Nombre de categoria</label>
                                 <input type="text" value="${categoria.getNombre_cat()}" name="txtCategoria" class="form-control">
                             </div>
                             <button type="submit" name="action" value="guardar" class="btn btn-outline-warning btn-block">
                                 <i class="fas fa-user-plus"></i>
                                 Guardar
                                 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-tags-fill" viewBox="0 0 16 16">
                                 <path d="M2 2a1 1 0 0 1 1-1h4.586a1 1 0 0 1 .707.293l7 7a1 1 0 0 1 0 1.414l-4.586 4.586a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 2 6.586V2zm3.5 4a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>
                                 <path d="M1.293 7.793A1 1 0 0 1 1 7.086V2a1 1 0 0 0-1 1v4.586a1 1 0 0 0 .293.707l7 7a1 1 0 0 0 1.414 0l.043-.043-7.457-7.457z"/>
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
                 <div class="col-sm-9 mt-4">
                     <table class="table table-bordered">
                         <th  class="bg-dark text-white text-center" colspan="7"><h1>Lista de Categorias</h1></th> 
                         <tr>
                             <th>ID</th>
                             <th>Categoria</th>
                             <th>Estado</th>
                             <th colspan="2" class="text-center" >Opciones</th>
                         </tr>
                         <%-- Listar todas las categorias --%>
                         <%
                             List lis = new registroCategoriaDAO().getAll();
                             ListIterator list = lis.listIterator();
                             while (list.hasNext()) {
                                 CatBeans categoriaB = (CatBeans) list.next();

                         %>
                         <tr>    
                             <%-- Mostrar los resultados de la lista  --%>
                             <td><%= categoriaB.getId_categoria()%></td>
                             <td><%= categoriaB.getNombre_cat()%></td>
                             <td><%= categoriaB.getEstado()%></td>
                             <td><a class="btn btn-outline-primary" href="ControladorrC?menu=categoria&action=carga&id=<%=categoriaB.getId_categoria()%>">
                                     Actualizar
                                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                     <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                     </svg>
                                 </a>
                             </td>
                             <td><a class="btn btn-outline-danger" href="ControladorrC?menu=categoria&action=eliminar&id=<%=categoriaB.getId_categoria()%>">
                                     Eliminar
                                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
                                     <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
                                     </svg>
                                 </a>
                             </td>

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
