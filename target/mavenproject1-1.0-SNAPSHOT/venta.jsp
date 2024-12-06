<%-- 
    Document   : venta
    Created on : 27-11-2024, 4:28:50 p. m.
    Author     : tobar
--%>
<%@ page import="logica.Carrito, logica.Ropa" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/componentes/headerContent.jsp" %>
<%@ include file="/componentes/header.jsp" %>

<%@ include file="/componentes/head.jsp" %>

<section id="content" class="product-detail">
    <h2>Detalles de tu compra</h2>
    <%
        if (carrito == null || carrito.getRopas().isEmpty()) {
    %>
        <p>No tienes productos en tu carrito.</p>
    <%
        } else {
            double totalf = 0;  
    %>
    <table>
        <tr>
            <th></th>
            <th>Producto</th>
            <th>Cantidad</th>
            <th>Precio Unitario</th>
            <th>Subtotal</th>
        </tr>
       <%
    for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
        Ropa ropa = entry.getKey();
        int cantidad = entry.getValue();
        System.out.println("Stock en JSP para " + ropa.getNombre() + ": " + ropa.getStock());  // Depuración
        double subtotal = ropa.getPrecio() * cantidad;
        totalf += subtotal;
    %>
        <tr>
            <td><img src="<%= ropa.getImagen() %>" alt="<%= ropa.getNombre() %>" width="50"></td>
            <td><%= ropa.getNombre() %></td>
            <td>
                <button class="decrementar" data-product-id="<%= ropa.getId() %>" <% if (cantidad <= 1) { %> disabled <% } %>>-</button>

                <span id="cantidad_<%= ropa.getId() %>" data-stock="<%= ropa.getStock() %>" class="cantidad-display"><%= cantidad %></span>

                <button class="incrementar" data-product-id="<%= ropa.getId() %>" <% if (cantidad >= ropa.getStock()) { %> disabled <% } %>>+</button>

                <button class="eliminar" data-product-id="<%= ropa.getId() %>">
                    <img src="img/x.png" alt="Eliminar" style="width: 15px; height: 15px;">
                </button>
            </td>
            <td>$<%= ropa.getPrecio() %></td>
            <td>$<%= subtotal %></td>
        </tr>
        <%
            } 
        %>
    </table>
    <p><strong>Total: $<%= totalf %></strong></p>
    
    <form action="PagarServlet" method="post">
        <button type="submit" class="btn-add-to-cart">Pagar</button>
    </form>

    <%
        }
    %>
</section>

<%@ include file="/componentes/footer.jsp" %>
<%@ include file="/componentes/footerContent.jsp" %>

<script>
 document.addEventListener('DOMContentLoaded', function() {
    // Incrementar cantidad
    const incrementarButtons = document.querySelectorAll('.incrementar');
    incrementarButtons.forEach(button => {
        button.addEventListener('click', function() {
            const productId = button.getAttribute('data-product-id');
            const cantidadSpan = document.getElementById('cantidad_' + productId);
            let cantidad = parseInt(cantidadSpan.textContent);
            const stock = parseInt(cantidadSpan.getAttribute('data-stock'));
            
            if (cantidad < stock) {
                cantidad += 1;
                cantidadSpan.textContent = cantidad;
                updateCarrito(productId, cantidad);
            }

            // Deshabilitar el botón si se alcanzó el stock máximo
            if (cantidad >= stock) {
                button.disabled = true;
            }

            // Habilitar el botón de decremento si la cantidad es mayor que 1
            const decrementarButton = document.querySelector(`button.decrementar[data-product-id='${productId}']`);
            if (cantidad > 1) {
                decrementarButton.disabled = false;
            }
        });
    });

    // Decrementar cantidad
    const decrementarButtons = document.querySelectorAll('.decrementar');
    decrementarButtons.forEach(button => {
        button.addEventListener('click', function() {
            const productId = button.getAttribute('data-product-id');
            const cantidadSpan = document.getElementById('cantidad_' + productId);
            let cantidad = parseInt(cantidadSpan.textContent);

            if (cantidad > 1) {
                cantidad -= 1;
                cantidadSpan.textContent = cantidad;
                updateCarrito(productId, cantidad);
            }

            // Habilitar el botón de incrementar si ya no está en su máximo
            const incrementarButton = document.querySelector(`button.incrementar[data-product-id='${productId}']`);
            if (cantidad < stock) {
                incrementarButton.disabled = false;
            }

            // Deshabilitar el botón de decremento si la cantidad es 1
            if (cantidad <= 1) {
                button.disabled = true;
            }
        });
    });

   // Eliminar producto
    const eliminarButtons = document.querySelectorAll('.eliminar');
    eliminarButtons.forEach(button => {
        button.addEventListener('click', function() {
            const productId = button.getAttribute('data-product-id');
            // Llamada al servlet para eliminar el producto del carrito
            eliminarProductoDelCarrito(productId);
        });
    });
});

// Función para eliminar producto del carrito
function eliminarProductoDelCarrito(productId) {
    // Llamamos al servlet para eliminar el producto completamente
    const form = document.createElement('form');
    form.action = 'EliminarCompletamenteCarritoServlet';  // URL del servlet
    form.method = 'GET';

    const inputId = document.createElement('input');
    inputId.type = 'hidden';
    inputId.name = 'id';
    inputId.value = productId;

    form.appendChild(inputId);
    document.body.appendChild(form);
    form.submit();
}

// Función para actualizar el carrito con la nueva cantidad
function updateCarrito(productId, cantidad) {
    const form = document.createElement('form');
    form.action = 'ActualizarCarritoServlet';  // Asegúrate de que esta ruta sea correcta
    form.method = 'POST';

    const inputId = document.createElement('input');
    inputId.type = 'hidden';
    inputId.name = 'productId';
    inputId.value = productId;

    const inputCantidad = document.createElement('input');
    inputCantidad.type = 'hidden';
    inputCantidad.name = 'cantidad';
    inputCantidad.value = cantidad;

    form.appendChild(inputId);
    form.appendChild(inputCantidad);
    document.body.appendChild(form);
    form.submit();
}

</script>