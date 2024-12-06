<%-- 
    Document   : inventario
    Created on : 23-11-2024, 12:54:30 p. m.
    Author     : tobar
--%>
<%@page import="logica.Controlador"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/componentes/headerContent.jsp" %>
<%@ page import="logica.Ropa"%>
<%@ include file="/componentes/head.jsp" %>
<%@ include file="/componentes/header.jsp" %>

<div class="clearfix"></div>

<section id="content">
    <h3>Productos en el Inventario</h3>

    <div class="producto-container">
        <%
            Controlador controlador = new Controlador();
            int pageSize = 9;  
            int currentPage = 1;  
            if (request.getParameter("pagef") != null) {
                currentPage = Integer.parseInt(request.getParameter("pagef")); 
            }
        
            List<Ropa> productos = controlador.listaDeRopa();
            int totalProductos = productos.size();
            int totalPages = (int) Math.ceil((double) totalProductos / pageSize); 
        
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, totalProductos);
        
            List<Ropa> productosPagina = productos.isEmpty() ? null : productos.subList(startIndex, endIndex); 
        %>

        <% if (productos.isEmpty()) { %>
            <p>No hay ropa para mostrar en el inventario.</p>
        <% } else { %>
            <% for (Ropa producto : productosPagina) { %>
                <div class="producto">
                    <img src="<%= producto.getImagen() %>" alt="<%= producto.getNombre() %>">
                    <div class="producto-details">
                        <h4><%= producto.getNombre() %></h4>
                        <p><strong>Descripción:</strong> <%= producto.getDescripcion() %></p>
                        <p><strong>Precio:</strong> $<%= producto.getPrecio() %></p>
                        <p><strong>Talla:</strong> <%= producto.getTalla() %></p>
                        <p><strong>Color:</strong> <%= producto.getColor() %></p>
                        <p><strong>Stock:</strong> <%= producto.getStock() %></p>
                    </div>
                    <div class="producto-actions">
                        <a href="editarProducto.jsp?id=<%= producto.getId() %>" class="edit">Editar</a>
                        <form action="EliminarProductoServlet" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="<%= producto.getId() %>">
                            <button type="submit" class="delete">Eliminar</button>
                        </form>
                    </div>
                </div>
            <% } %>
        <% } %>
    </div>

    <% if (!productos.isEmpty()) { %>
        <div class="pagination">
            <% for (int i = 1; i <= totalPages; i++) { %>
                <a href="inventario.jsp?pagef=<%= i %>"><%= i %></a>
            <% } %>
        </div>
    <% } %>

    <div class="agregar-producto">
        <a href="añadirProducto.jsp" class="btn">Añadir Producto</a>
    </div>
</section>

<div class="clearfix"></div>

<%@ include file="/componentes/footer.jsp" %>
<%@ include file="/componentes/footerContent.jsp" %>
