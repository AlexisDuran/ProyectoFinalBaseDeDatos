package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ejemploScript_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script>\n");
      out.write("    function validar(cadena)\n");
      out.write("    {\n");
      out.write("        var cadena1 = cadena.value;\n");
      out.write("        alert(\"Automata   \" + cadena1);\n");
      out.write("        var numcaracter = cadena1.length;\n");
      out.write("        var a;\n");
      out.write("        var letra;\n");
      out.write("        var valido = 0;\n");
      out.write("        var letra;\n");
      out.write("\n");
      out.write("        for (a = 0; a < numcaracter; a++) {\n");
      out.write("            letra = cadena1.charAt(a);\n");
      out.write("\n");
      out.write("            if (letra === 'a') {\n");
      out.write("                valido = 1;\n");
      out.write("                a++;\n");
      out.write("            } else {\n");
      out.write("                valido = 0;\n");
      out.write("                break;\n");
      out.write("            }\n");
      out.write("            letra = cadena1.charAt(a);\n");
      out.write("            if (letra === 'b') {\n");
      out.write("                valido = 1;\n");
      out.write("            } else {\n");
      out.write("                valido = 0;\n");
      out.write("                break;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        if (valido === 1) {\n");
      out.write("            alert(\"Es Valido \\n Felicidades !\");\n");
      out.write("        } else {\n");
      out.write("            alert(\"Es Invalido\");\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Automatas</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        Ingresa Autómata <input name=\"cadena\" type=\"text\" value=\"abab\">\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <input name=\"Ver suma \" onclick=\"validar(cadena)\" type=\"button\" value=\"Aceptar\">\n");
      out.write("    </center>\n");
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
