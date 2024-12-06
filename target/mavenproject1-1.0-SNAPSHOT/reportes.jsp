<%-- 
    Document   : reportes
    Created on : 03-12-2024, 7:33:38 p. m.
    Author     : tobar
--%>
<%@page import="logica.ReporteSemanal"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/componentes/headerContent.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Reportes Semanales</title>
    <style>

        .main-content {
            flex: 1; /* Esto asegura que el contenido principal ocupe el espacio disponible */
            padding: 20px;
            overflow: auto;
        }


        /* Opcional: Ajustes de estilo para la tabla */
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

        /* Clearfix para el footer */
        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }

    </style>
</head>
<body>
    <%@ include file="/componentes/head.jsp" %>

    <%@ include file="/componentes/header.jsp" %>

    <div class="main-content">

        <%
            List<ReporteSemanal> reportes = (List<ReporteSemanal>) request.getAttribute("reportes");
            List<String> fechasFormateadas = (List<String>) request.getAttribute("fechasFormateadas");
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
                out.println("<p>" + mensaje + "</p>");
            }
        %>

        <table>
            <tr>
                <th>Fecha Generado</th>
                <th>Ganancias Totales</th>
                <th>Detalles</th>
            </tr>

            <c:choose>
                <c:when test="${not empty reportes}">
                    <c:forEach var="reporte" items="${reportes}" varStatus="status">
                        <tr>
                            <td>${fechasFormateadas[status.index]}</td>
                            <td>$${reporte.totalGenerado}</td>
                            <td>
                                <a href="DetalleReporteServlet?id=${reporte.id}" target="_blank">Ver Reporte</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="3">No existen reportes disponibles.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>

        <form action="GenerarReporteServlet" method="POST">
            <input type="hidden" name="accion" value="generarReporte">
            <button type="submit">Generar Reporte Semanal</button>
        </form>
    </div>


    <div class="clearfix"></div>

</body>