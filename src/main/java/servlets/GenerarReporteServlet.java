/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import logica.Controlador;
import logica.ReporteSemanal;

/**
 *
 * @author tobar
 */
@WebServlet(name = "GenerarReporteServlet", urlPatterns = {"/GenerarReporteServlet"})
public class GenerarReporteServlet extends HttpServlet {
    Controlador controlador = new Controlador();
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
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReporteSemanal> reportes = controlador.obtenerReportes();
        List<String> fechas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy HH:mm:ss", new Locale("es", "ES"));
        for (ReporteSemanal reporte : reportes) {
            String fechaFormateada = sdf.format(reporte.getFecha());
            fechas.add(fechaFormateada);
        }
        request.setAttribute("reportes", reportes);
        request.setAttribute("fechasFormateadas", fechas);

        request.getRequestDispatcher("/reportes.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String accion = request.getParameter("accion");

    if ("generarReporteSemanal".equals(accion)) {
        controlador.generarReporte();
    }
    response.sendRedirect("GenerarReporteServlet");
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
