/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import logica.Controlador;
import logica.ReporteSemanal;

/**
 *
 * @author tobar
 */
@WebServlet(name = "DetalleReporteServlet", urlPatterns = {"/DetalleReporteServlet"})
public class DetalleReporteServlet extends HttpServlet {
    Controlador controlador=new Controlador();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int idReporte;
        try {
            idReporte = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de reporte inválido.");
            return;
        }

        Controlador controlador = new Controlador();
        ReporteSemanal reporte = controlador.validarReporte(idReporte);

        if (reporte != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy HH:mm:ss", new Locale("es", "ES"));
            String fechaFormateada = sdf.format(reporte.getFecha());
            request.setAttribute("fecha",fechaFormateada);
            request.setAttribute("reporte", reporte);
            RequestDispatcher dispatcher = request.getRequestDispatcher("detalleReporte.jsp");
            dispatcher.forward(request, response);
        } else {
            // Si no se encuentra el reporte, enviar un error
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Reporte no encontrado.");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del reporte desde el formulario
        String idStr = request.getParameter("reporteId");
        int idReporte = Integer.parseInt(idStr);

        // Usar el controlador para obtener el reporte
        Controlador controlador = new Controlador();
        ReporteSemanal reporte = controlador.validarReporte(idReporte);

        if (reporte != null) {
            // Crear el PDF con los datos del reporte
            response.setContentType("application/pdf");

            // Cambiar a "inline" para abrir el PDF en el navegador
            response.setHeader("Content-Disposition", "inline; filename=Reporte_" + idReporte + ".pdf");

            try (OutputStream out = response.getOutputStream()) {
                // Llamar al método para generar el PDF
                controlador.generarPDF(reporte, out);
            }
        } else {
            // Si el reporte no se encuentra, se muestra un error
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Reporte no encontrado.");
        }                                               
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
