<%-- 
    Document   : header
    Created on : 23-11-2024, 1:08:39 p. m.
    Author     : tobar
--%>
<%@page import="logica.Carrito"%>
<%@ page import="logica.User, logica.Ropa, java.text.DecimalFormat, java.util.HashMap, java.util.Map" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<%
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
%>

<nav class="navbar">
    <ul class="nav-menu">
        <li><a href="index.jsp">Inicio</a></li>
        <li><a href="https://www.instagram.com/kobcoee_/">Instagram</a></li>
        <li><a href="mailto:coee1x1490@gmail.com">Correo electrónico</a></li>
        <li><a href="acercaDe.jsp">Acerca de</a></li>
           
        <% if (currentUser == null) { %>
            <li><a href="login.jsp">Iniciar Sesión</a></li>
        <% } %>
        <% if (currentUser != null) { %>
            <li><a href="LogoutServlet">Cerrar Sesión</a></li>
        <% } %>
    </ul>
        
    <div class="nav-icons">
        <% if (currentUser != null) { %>
            <a href="detallesUsuario.jsp">
            <img src="img/usuario.png" alt="Usuario" class="nav-logo">
            </a>
        <% } %>
        <img src="img/carrito.png" alt="Carrito" class="nav-logo" onclick="toggleCart()">
    </div>
    <div id="cartWindow" class="cart-window">
         <div class="cart-content">
            <h2>Tu Carrito</h2>
            <% if (carrito != null && !carrito.getRopas().isEmpty()) { %>
                <ul id="cartItems">
                    <% 
                        for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
                            Ropa ropa = entry.getKey();
                            int quantity = entry.getValue();
                    %>
                        <li>
                            <img src="<%= ropa.getImagen() %>" alt="<%= ropa.getNombre() %>" width="50">
                            <%= ropa.getNombre() %> - Talla: <%= ropa.getTalla() %> - Color: <%= ropa.getColor() %><br>
                            Precio unitario: $<%= df.format(ropa.getPrecio()) %><br>
                            Cantidad: <%= quantity %>
                            <a href="EliminardelCarritoServlet?id=<%= ropa.getId() %>" class="eliminarProducto">
                               <img src="img/x.png" alt="Eliminar" width="13">
                            </a>
                        </li>
                    <% } %>
                </ul>
                <hr>
                <p><strong>Total: $<%= df.format(total) %></strong></p>
            <% } else { %>
                <p>Tu carrito está vacío.</p>
            <% } %>
            <button onclick="window.location.href='venta.jsp'">Ir a Comprar</button>
            <button id="cerrarCarrito" onclick="toggleCart()">Cerrar</button>
        </div>
    </div>
</nav>

<script>
    function toggleCart() {
        var cartWindow = document.getElementById('cartWindow');
        cartWindow.classList.toggle('open');
    }
</script>