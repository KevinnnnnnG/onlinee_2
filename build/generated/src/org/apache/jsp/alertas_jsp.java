package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class alertas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
String error;
if(session.getAttribute("usuario")==null){ //si el usuario no estaba autentificado
	error=new String("Para poder enviar mensajes al foro debes Atentificarte o en su defecto Registrarte.");
	session.setAttribute("error",error);
	response.sendRedirect("index.jsp");
}
else{  //si el usuario si estaba autentificado continuamos la carga de la pagina
      out.write("\n");
      out.write("<!-- CABECERA -->\n");
      out.write("<head>\n");
      out.write("<title>Foros TW . Nuevo Mensaje</title>\n");
      out.write("<link href=\"estilo.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"></link>\n");
      out.write("</style>\n");
      out.write("<script src=\"javascript/mensaje.js\"></script>\n");
      out.write("<script src=\"javascript/aviso.js\"></script>\n");
      out.write("</head>\n");
      out.write("<!-- CUERPO -->          \n");
      out.write("<body>\n");
      out.write("<div id=\"todo\">\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("<!-- TITULO NUEVO MENSAJE -->\n");
      out.write("<p class=\"titulopagina2\"> Nuevo Mensaje </p>\n");
      out.write("<!-- FORMULARIO DATOS DEL MENSAJE - GET PORQUE NO HAY VALORES IMPORTANTES QUE NO SE PUEDAN MOSTRAR -->\n");
      out.write("<form class=\"nuevomensaje\" name=\"FormNuevoMensaje\"  action=\"nuevoMensaje.jsp\"  method=\"get\">\n");
      out.write("Asunto del Mensaje -> <input type=\"text\" name=\"asunto\" id=\"asunto\"></input><br>\n");
      out.write("Texto del Mensaje <br> <textarea name=\"texto\" id=\"texto\" cols=\"60\" rows=\"10\"></textarea> <br>\n");
      out.write("<button class=\"neg\" type=\"button\" onclick=\"formato('b')\">Negrita</button>\n");
      out.write("<button class=\"curs\" type=\"button\" onclick=\"formato('i')\">Cursiva</button>\n");
      out.write("<button class=\"sub\" type=\"button\" onclick=\"formato('ins')\">Subrayado</button>\n");
      out.write("<button class=\"url\" type=\"button\" onclick=\"insrUrl()\">Insertar URL</button>\n");
      out.write("<button class=\"prev\" type=\"button\" onclick=\"prevMensaje()\">Previsualizar</button> <br>\n");
      out.write("Insertar Smileys\n");
      out.write("<img       src=\"smilies/feliz.gif\" onclick=\"insrSmil('[:-)]')\"></img>\n");
      out.write("<img      src=\"smilies/triste.gif\" onclick=\"insrSmil('[:-(]')\"></img>\n");
      out.write("<img     src=\"smilies/enojado.gif\" onclick=\"insrSmil('[:-/]')\"></img>\n");
      out.write("<img   src=\"smilies/durmiendo.gif\" onclick=\"insrSmil('[:-$]')\"></img>\n");
      out.write("<img    src=\"smilies/colorado.gif\" onclick=\"insrSmil('[:-%]')\"></img>\n");
      out.write("<img src=\"smilies/exclamacion.gif\" onclick=\"insrSmil('[:-!]')\"></img> <br>\n");
      out.write("Opciones del Mensaje: \n");
      out.write("<input type=\"checkbox\" name=\"firma\" value=\"ok\">aduntar firma</input>\n");
      out.write("<input type=\"checkbox\" name=\"aviso\" value=\"ok\">avisar si recibe respuesta</input>\n");
      out.write("<input type=\"hidden\" name=\"tipo\" value=\"");
      out.print(request.getParameter("tipo"));
      out.write("\"></input><br>\n");
      out.write("<button class=\"envmens\" type=\"submit\">Enviar Mensaje</button> <br>\n");
      out.write("</form>\n");
      out.write("<!-- DIV PARA LA PREVISUALIZACION DEL MENSAJE APARECERA DEBAJO DEL BOTON ENVIAR -->\n");
      out.write("<div id=\"prevMensaje\"></div>\n");
      out.write("</div>\n");
      out.write("<!-- DIV PARA EL AVISO DINAMICO DE LOS NUEVOS MENSAJES ENVIADOS AL SITIO WEB -->\n");
      out.write("<div id=\"aviso\"><span id=\"mensajeAviso\"></span> \n");
      out.write("<img src=\"imagenes/cerraraviso.gif\" onclick=\"cerrarAviso(reglas,timer);\"></img>\n");
      out.write("</div>\n");
if(session.getAttribute("error2")!=null){
      out.write("\n");
      out.write("<script>alert(\"");
      out.print(session.getAttribute("error2"));
      out.write("\");</script>\n");
session.setAttribute("error2",null);
  }
}
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
