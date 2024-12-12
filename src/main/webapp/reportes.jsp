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
<link rel="stylesheet" href="css/styles.css">
<html lang="es">
<head>
    <title>Reportes Semanales</title>
    <style> 
        .custom-button {
            background-color: #333; 
            color: #fff; 
            border: 1px solid #444; 
            border-radius: 5px;
            padding: 10px 20px; 
            font-size: 16px;
            cursor: pointer; 
            text-align: center; 
            transition: background-color 0.3s ease, transform 0.2s ease; 
            margin: 10px 0; 
            display: block; 
        }

        .custom-button:hover {
            background-color: #555; 
            transform: scale(1.05); 
        }

        .custom-button:active {
            background-color: #222; 
            transform: scale(0.95); 
        }

        .main-content {
            flex: 1; 
            padding: 20px;
            overflow: auto;
        }


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
        <form action="GenerarReporteDiarioServlet" method="POST">
            <button type="submit" class="custom-button">Generar Reporte Diario</button>
        </form>

        <form action="GenerarReporteServlet" method="POST">
            <input type="hidden" name="accion" value="generarReporteSemanal">
            <button type="submit" class="custom-button">Generar Reporte Semanal</button>
        </form>

        <form action="GenerarReporteMensualServlet" method="POST">
            <button type="submit" class="custom-button">Generar Reporte Mensual</button>
        </form>

    <div class="clearfix"></div>

</body>