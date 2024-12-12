<%-- 
    Document   : index
    Created on : 23-11-2024, 12:53:22 p. m.
    Author     : tobar
--%>
<%@page import="logica.Controlador"%>
<%@page import="java.util.List"%>
<%@page import="logica.Ropa"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/componentes/headerContent.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" href="css/styles.css?v=2">

<%@ include file="/componentes/head.jsp" %>
<%@ include file="/componentes/header.jsp" %>

<div class="clearfix"></div>
<section id="content">
    <div class="gallery">
        <%
            Controlador controlador = new Controlador();
            List<Ropa> productosPagina = controlador.listaDeRopa(); 
            int productosPorPagina = 10;
            int totalProductos = productosPagina.size(); 

            int paginaActual = 1;
            String paginaParam = request.getParameter("pagina");
            if (paginaParam != null) {
                paginaActual = Integer.parseInt(paginaParam);
            }

            int startIndex = (paginaActual - 1) * productosPorPagina;
            int endIndex = Math.min(startIndex + productosPorPagina, totalProductos);

            List<Ropa> productosSubLista = (totalProductos > 0) ? productosPagina.subList(startIndex, endIndex) : null;
        %>

        <% if (productosPagina.isEmpty()) { %>
            <p>No hay productos disponibles en el inventario.</p>
        <% } else { %>
            <% for (Ropa ropa : productosSubLista) { %>
            <div class="product-card">
                <a href="detalleProducto.jsp?id=<%= ropa.getId() %>">
                    <img src="<%= ropa.getImagen() %>" alt="<%= ropa.getNombre() %>" class="product-img"/>
                    <div class="product-info">
                        <h3><%= ropa.getNombre() %></h3>
                        <p>Talla: <%= ropa.getTalla() %></p>
                        <p>Color: <%= ropa.getColor() %></p>
                        <p>Stock: <%= ropa.getStock() %></p>
                        <p>Precio Unitario: $<%= ropa.getPrecio() %></p>
                    </div>
                </a>
            </div>
            <% } %>
        <% } %>
    </div>

    <% if (!productosPagina.isEmpty()) { %>
        <div class="pagination">
            <%
                int totalPaginas = (int) Math.ceil((double) totalProductos / productosPorPagina);
                for (int i = 1; i <= totalPaginas; i++) {
            %>
            <a href="index.jsp?pagina=<%= i %>" class="<%= (i == paginaActual) ? "active" : "" %>"><%= i %></a>
            <% } %>
        </div>
    <% } %>
</section>
<div class="clearfix"></div>
<%@ include file="/componentes/footer.jsp" %>
<%@ include file="/componentes/footerContent.jsp" %>
