<%-- 
    Document   : detalleReporte
    Created on : 03-12-2024, 11:17:45 p. m.
    Author     : tobar
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/componentes/headerContent.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Detalle del Reporte</title>
    <style>
        /* Asegurarse de que html y body ocupen toda la altura de la página */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        /* Estructura del body para flexbox */
        body {
            display: flex;
            flex-direction: column;
        }

        /* Asegurarse de que el contenido principal ocupe el espacio restante */
        .main-content {
            flex: 1;
            padding: 20px;
            overflow: auto;
        }

        /* Estilo para el pie de página */
        footer {
            background-color: #2c3e50;
            color: white;
            text-align: center;
            padding: 15px 0;
            width: 100%;
            margin-top: auto; /* Asegura que el footer se mantenga al final de la página */
        }

        footer p {
            margin: 0;
        }

        /* Estilo de la tabla */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #f4f4f4;
        }

        /* Estilo de los botones */
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Estilo del enlace de regreso */
        a {
            text-decoration: none;
            color: #2c3e50;
            font-size: 16px;
        }

        a:hover {
            color: #4CAF50;
        }

        /* Opcional: Ajustes para el pre-formato del detalle de ventas */
        pre {
            white-space: pre-wrap;
            word-wrap: break-word;
            background-color: #f4f4f4;
            padding: 15px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <%@ include file="/componentes/head.jsp" %>

    <%@ include file="/componentes/header.jsp" %>
    <div class="main-content">
        <h2>Detalle del Reporte</h2>

        <c:choose>
            <c:when test="${not empty reporte}">
                <table>
                    <tr>
                        <th>Fecha</th>
                        <td>${fecha}</td> 
                    </tr>
                    <tr>
                        <th>Detalle de Ventas</th>
                        <td>
                            <pre>${reporte.detallesVentas}</pre>
                        </td>
                    </tr>
                    <tr>
                        <th>Total Generado</th>
                        <td>$${reporte.totalGenerado}</td>
                    </tr>
                </table>

                <form action="DetalleReporteServlet" method="POST">
                    <input type="hidden" name="reporteId" value="${reporte.id}">
                    <button type="submit">Generar PDF</button>
                </form>
            </c:when>
            <c:otherwise>
                <p>El reporte no está disponible o ocurrió un error.</p>
            </c:otherwise>
        </c:choose>

        <p><a href="GenerarReporteServlet">Volver a Reportes Semanales</a></p>
    </div>

    <div class="clearfix"></div>
</body>
</html>
