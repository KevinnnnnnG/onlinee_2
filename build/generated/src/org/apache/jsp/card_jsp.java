package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class card_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("\t<title>Cards - Tarjetas con efecto Hover</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"estilos.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!--   Tarjetas-->\n");
      out.write("<div class=\"title-cards\">\n");
      out.write("\t\t<h2>Servicios que Ofrecemos</h2>\n");
      out.write("\t</div>\n");
      out.write("<div class=\"container-card\">\n");
      out.write("\t\n");
      out.write("<div class=\"card\">\n");
      out.write("\t<figure>\n");
      out.write("\t\t<img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRZ9DMNFHxwZcfPXJrJeBMITxPMP3FMZk_ixXzTfzt4G_C-G058\">\n");
      out.write("\t</figure>\n");
      out.write("\t<div class=\"contenido-card\">\n");
      out.write("\t\t<h3>Diseño Gràfico</h3>\n");
      out.write("\t\t<p>Podemos crear la identidad corporativa de tu empresa. Diseño , Maquetación de folletos, Catálogos, Papelería y mucho más.</p>\n");
      out.write("\t\t<a href=\"#\">Leer Màs</a>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"card\">\n");
      out.write("\t<figure>\n");
      out.write("\t\t<img src=\"https://colmayorbolivar.edu.co/blog/wp-content/uploads/2017/06/imagen-administracion.jpg\">\n");
      out.write("\t</figure>\n");
      out.write("\t<div class=\"contenido-card\">\n");
      out.write("\t\t<h3>Gestión de Redes</h3>\n");
      out.write("\t\t<p>Nosotros creamos y optimizamos tus perfiles en las Redes Sociales. Importantes para que tu presencia online sea completa.</p>\n");
      out.write("\t\t<a href=\"#\">Leer Màs</a>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<div class=\"card\">\n");
      out.write("\t<figure>\n");
      out.write("\t\t<img src=\"https://image.freepik.com/foto-gratis/desarrollo-programadores-desarrollo-tecnologias-diseno-codificacion-sitios-web_18497-1090.jpg\">\n");
      out.write("\t</figure>\n");
      out.write("\t<div class=\"contenido-card\">\n");
      out.write("\t\t<h3>Desarrollo Web</h3>\n");
      out.write("\t\t<p>Creamos tu página web utilizando las últimas tecnologías disponibles. Una Web adaptativa a tu móvil o Tablet y con un gestor de contenido fácil.</p>\n");
      out.write("\t\t<a href=\"#\">Leer Màs</a>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<!--Fin   Tarjetas-->\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
