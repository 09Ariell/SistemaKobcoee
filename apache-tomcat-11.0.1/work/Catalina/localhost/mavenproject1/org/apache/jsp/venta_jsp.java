/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.1
 * Generated at: 2024-12-05 13:09:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import logica.Carrito;
import logica.Ropa;
import logica.Carrito;
import logica.User;
import logica.Ropa;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public final class venta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/componentes/footerContent.jsp", Long.valueOf(1732378497000L));
    _jspx_dependants.put("/componentes/footer.jsp", Long.valueOf(1732378498000L));
    _jspx_dependants.put("/componentes/headerContent.jsp", Long.valueOf(1733345375207L));
    _jspx_dependants.put("/componentes/header.jsp", Long.valueOf(1733340871901L));
    _jspx_dependants.put("/componentes/head.jsp", Long.valueOf(1733345968910L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(8);
    _jspx_imports_classes.add("logica.User");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.text.DecimalFormat");
    _jspx_imports_classes.add("java.util.HashMap");
    _jspx_imports_classes.add("logica.Ropa");
    _jspx_imports_classes.add("logica.Carrito");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\"/>\n");
      out.write("    <title>KOBCOEE</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"logo-container\">\n");
      out.write("        <img src=\"img/png.png\" alt=\"Logo de KOBCOEE\" class=\"logo\">\n");
      out.write("        <h1 id=\"nombreEsq\">KOBCOEE</h1>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"container\">\n");
      out.write("<body>\n");
      out.write("\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\">\n");

    User currentUser = (User) session.getAttribute("currentUser");
    String role = "";
    if (currentUser != null) {
        role = currentUser.getRole();
    }
    Carrito carrito = (Carrito) session.getAttribute("carrito");
    double total = 0;
    if (carrito != null) {
        for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue(); 
        }
    }
    DecimalFormat df = new DecimalFormat("0.00");

      out.write("\n");
      out.write("\n");
      out.write("<nav class=\"navbar\">\n");
      out.write("    <ul class=\"nav-menu\">\n");
      out.write("        <li><a href=\"index.jsp\">Inicio</a></li>\n");
      out.write("        <li><a href=\"https://www.instagram.com/kobcoee_/\">Instagram</a></li>\n");
      out.write("        <li><a href=\"mailto:coee1x1490@gmail.com\">Correo electrónico</a></li>\n");
      out.write("        <li><a href=\"acercaDe.jsp\">Acerca de</a></li>\n");
      out.write("           \n");
      out.write("        ");
 if (currentUser == null) { 
      out.write("\n");
      out.write("            <li><a href=\"login.jsp\">Iniciar Sesión</a></li>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        ");
 if (currentUser != null) { 
      out.write("\n");
      out.write("            <li><a href=\"LogoutServlet\">Cerrar Sesión</a></li>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </ul>\n");
      out.write("        \n");
      out.write("    <div class=\"nav-icons\">\n");
      out.write("        ");
 if (currentUser != null) { 
      out.write("\n");
      out.write("            <a href=\"detallesUsuario.jsp\">\n");
      out.write("            <img src=\"img/usuario.png\" alt=\"Usuario\" class=\"nav-logo\">\n");
      out.write("            </a>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <img src=\"img/carrito.png\" alt=\"Carrito\" class=\"nav-logo\" onclick=\"toggleCart()\">\n");
      out.write("    </div>\n");
      out.write("    <div id=\"cartWindow\" class=\"cart-window\">\n");
      out.write("         <div class=\"cart-content\">\n");
      out.write("            <h2>Tu Carrito</h2>\n");
      out.write("            ");
 if (carrito != null && !carrito.getRopas().isEmpty()) { 
      out.write("\n");
      out.write("                <ul id=\"cartItems\">\n");
      out.write("                    ");
 
                        for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
                            Ropa ropa = entry.getKey();
                            int quantity = entry.getValue();
                    
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            <img src=\"");
      out.print( ropa.getImagen() );
      out.write("\" alt=\"");
      out.print( ropa.getNombre() );
      out.write("\" width=\"50\">\n");
      out.write("                            ");
      out.print( ropa.getNombre() );
      out.write(" - Talla: ");
      out.print( ropa.getTalla() );
      out.write(" - Color: ");
      out.print( ropa.getColor() );
      out.write("<br>\n");
      out.write("                            Precio unitario: $");
      out.print( df.format(ropa.getPrecio()) );
      out.write("<br>\n");
      out.write("                            Cantidad: ");
      out.print( quantity );
      out.write("\n");
      out.write("                            <a href=\"EliminardelCarritoServlet?id=");
      out.print( ropa.getId() );
      out.write("\" class=\"eliminarProducto\">\n");
      out.write("                               <img src=\"img/x.png\" alt=\"Eliminar\" width=\"13\">\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <hr>\n");
      out.write("                <p><strong>Total: $");
      out.print( df.format(total) );
      out.write("</strong></p>\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("                <p>Tu carrito está vacío.</p>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            <button onclick=\"window.location.href='venta.jsp'\">Ir a Comprar</button>\n");
      out.write("            <button id=\"cerrarCarrito\" onclick=\"toggleCart()\">Cerrar</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function toggleCart() {\n");
      out.write("        var cartWindow = document.getElementById('cartWindow');\n");
      out.write("        cartWindow.classList.toggle('open');\n");
      out.write("    }\n");
      out.write("</script>");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("<head>\n");
      out.write("    <style>\n");
      out.write("        .header-content {\n");
      out.write("        color: white; /* Asegúrate de que el texto sea legible */\n");
      out.write("        font-size: 3rem;\n");
      out.write("        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7); /* Agrega sombra para mayor contraste */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .header-container {\n");
      out.write("        width: 100%;\n");
      out.write("        height: 400px;\n");
      out.write("        background: url('img/imagenfondo.jpg') no-repeat center center;\n");
      out.write("        background-size: cover; /* Para ajustar la imagen */\n");
      out.write("        display: flex;\n");
      out.write("        justify-content: center;\n");
      out.write("        align-items: center;\n");
      out.write("        position: relative;\n");
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<html>\n");
      out.write("    <div class=\"header-container\">\n");
      out.write("        <div class=\"header-content\">\n");
      out.write("            <h1>KOBCOEE</h1>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<section id=\"content\" class=\"product-detail\">\n");
      out.write("    <h2>Detalles de tu compra</h2>\n");
      out.write("    ");

        if (carrito == null || carrito.getRopas().isEmpty()) {
    
      out.write("\n");
      out.write("        <p>No tienes productos en tu carrito.</p>\n");
      out.write("    ");

        } else {
            double totalf = 0;  
    
      out.write("\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th></th>\n");
      out.write("            <th>Producto</th>\n");
      out.write("            <th>Cantidad</th>\n");
      out.write("            <th>Precio Unitario</th>\n");
      out.write("            <th>Subtotal</th>\n");
      out.write("        </tr>\n");
      out.write("       ");

    for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
        Ropa ropa = entry.getKey();
        int cantidad = entry.getValue();
        System.out.println("Stock en JSP para " + ropa.getNombre() + ": " + ropa.getStock());  // Depuración
        double subtotal = ropa.getPrecio() * cantidad;
        totalf += subtotal;
    
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td><img src=\"");
      out.print( ropa.getImagen() );
      out.write("\" alt=\"");
      out.print( ropa.getNombre() );
      out.write("\" width=\"50\"></td>\n");
      out.write("            <td>");
      out.print( ropa.getNombre() );
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <button class=\"decrementar\" data-product-id=\"");
      out.print( ropa.getId() );
      out.write('"');
      out.write(' ');
 if (cantidad <= 1) { 
      out.write(" disabled ");
 } 
      out.write(">-</button>\n");
      out.write("\n");
      out.write("                <span id=\"cantidad_");
      out.print( ropa.getId() );
      out.write("\" data-stock=\"");
      out.print( ropa.getStock() );
      out.write("\" class=\"cantidad-display\">");
      out.print( cantidad );
      out.write("</span>\n");
      out.write("\n");
      out.write("                <button class=\"incrementar\" data-product-id=\"");
      out.print( ropa.getId() );
      out.write('"');
      out.write(' ');
 if (cantidad >= ropa.getStock()) { 
      out.write(" disabled ");
 } 
      out.write(">+</button>\n");
      out.write("\n");
      out.write("                <button class=\"eliminar\" data-product-id=\"");
      out.print( ropa.getId() );
      out.write("\">\n");
      out.write("                    <img src=\"img/x.png\" alt=\"Eliminar\" style=\"width: 15px; height: 15px;\">\n");
      out.write("                </button>\n");
      out.write("            </td>\n");
      out.write("            <td>$");
      out.print( ropa.getPrecio() );
      out.write("</td>\n");
      out.write("            <td>$");
      out.print( subtotal );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            } 
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("    <p><strong>Total: $");
      out.print( totalf );
      out.write("</strong></p>\n");
      out.write("    \n");
      out.write("    <form action=\"PagarServlet\" method=\"post\">\n");
      out.write("        <button type=\"submit\" class=\"btn-add-to-cart\">Pagar</button>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<footer>\n");
      out.write("    KOBCOEE WEB &copy; 2024\n");
      out.write("</footer>\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("    </div> \n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write(" document.addEventListener('DOMContentLoaded', function() {\n");
      out.write("    // Incrementar cantidad\n");
      out.write("    const incrementarButtons = document.querySelectorAll('.incrementar');\n");
      out.write("    incrementarButtons.forEach(button => {\n");
      out.write("        button.addEventListener('click', function() {\n");
      out.write("            const productId = button.getAttribute('data-product-id');\n");
      out.write("            const cantidadSpan = document.getElementById('cantidad_' + productId);\n");
      out.write("            let cantidad = parseInt(cantidadSpan.textContent);\n");
      out.write("            const stock = parseInt(cantidadSpan.getAttribute('data-stock'));\n");
      out.write("            \n");
      out.write("            if (cantidad < stock) {\n");
      out.write("                cantidad += 1;\n");
      out.write("                cantidadSpan.textContent = cantidad;\n");
      out.write("                updateCarrito(productId, cantidad);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Deshabilitar el botón si se alcanzó el stock máximo\n");
      out.write("            if (cantidad >= stock) {\n");
      out.write("                button.disabled = true;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Habilitar el botón de decremento si la cantidad es mayor que 1\n");
      out.write("            const decrementarButton = document.querySelector(`button.decrementar[data-product-id='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productId}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("']`);\n");
      out.write("            if (cantidad > 1) {\n");
      out.write("                decrementarButton.disabled = false;\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    // Decrementar cantidad\n");
      out.write("    const decrementarButtons = document.querySelectorAll('.decrementar');\n");
      out.write("    decrementarButtons.forEach(button => {\n");
      out.write("        button.addEventListener('click', function() {\n");
      out.write("            const productId = button.getAttribute('data-product-id');\n");
      out.write("            const cantidadSpan = document.getElementById('cantidad_' + productId);\n");
      out.write("            let cantidad = parseInt(cantidadSpan.textContent);\n");
      out.write("\n");
      out.write("            if (cantidad > 1) {\n");
      out.write("                cantidad -= 1;\n");
      out.write("                cantidadSpan.textContent = cantidad;\n");
      out.write("                updateCarrito(productId, cantidad);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Habilitar el botón de incrementar si ya no está en su máximo\n");
      out.write("            const incrementarButton = document.querySelector(`button.incrementar[data-product-id='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productId}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("']`);\n");
      out.write("            if (cantidad < stock) {\n");
      out.write("                incrementarButton.disabled = false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // Deshabilitar el botón de decremento si la cantidad es 1\n");
      out.write("            if (cantidad <= 1) {\n");
      out.write("                button.disabled = true;\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("   // Eliminar producto\n");
      out.write("    const eliminarButtons = document.querySelectorAll('.eliminar');\n");
      out.write("    eliminarButtons.forEach(button => {\n");
      out.write("        button.addEventListener('click', function() {\n");
      out.write("            const productId = button.getAttribute('data-product-id');\n");
      out.write("            // Llamada al servlet para eliminar el producto del carrito\n");
      out.write("            eliminarProductoDelCarrito(productId);\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("});\n");
      out.write("\n");
      out.write("// Función para eliminar producto del carrito\n");
      out.write("function eliminarProductoDelCarrito(productId) {\n");
      out.write("    // Llamamos al servlet para eliminar el producto completamente\n");
      out.write("    const form = document.createElement('form');\n");
      out.write("    form.action = 'EliminarCompletamenteCarritoServlet';  // URL del servlet\n");
      out.write("    form.method = 'GET';\n");
      out.write("\n");
      out.write("    const inputId = document.createElement('input');\n");
      out.write("    inputId.type = 'hidden';\n");
      out.write("    inputId.name = 'id';\n");
      out.write("    inputId.value = productId;\n");
      out.write("\n");
      out.write("    form.appendChild(inputId);\n");
      out.write("    document.body.appendChild(form);\n");
      out.write("    form.submit();\n");
      out.write("}\n");
      out.write("\n");
      out.write("// Función para actualizar el carrito con la nueva cantidad\n");
      out.write("function updateCarrito(productId, cantidad) {\n");
      out.write("    const form = document.createElement('form');\n");
      out.write("    form.action = 'ActualizarCarritoServlet';  // Asegúrate de que esta ruta sea correcta\n");
      out.write("    form.method = 'POST';\n");
      out.write("\n");
      out.write("    const inputId = document.createElement('input');\n");
      out.write("    inputId.type = 'hidden';\n");
      out.write("    inputId.name = 'productId';\n");
      out.write("    inputId.value = productId;\n");
      out.write("\n");
      out.write("    const inputCantidad = document.createElement('input');\n");
      out.write("    inputCantidad.type = 'hidden';\n");
      out.write("    inputCantidad.name = 'cantidad';\n");
      out.write("    inputCantidad.value = cantidad;\n");
      out.write("\n");
      out.write("    form.appendChild(inputId);\n");
      out.write("    form.appendChild(inputCantidad);\n");
      out.write("    document.body.appendChild(form);\n");
      out.write("    form.submit();\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
