/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.Controlador;
import logica.Ropa;
import logica.Carrito;

/**
 *
 * @author tobar
 */
@WebServlet(name = "AniadirCarritoServlet", urlPatterns = {"/AniadirCarritoServlet"})
public class AniadirCarritoServlet extends HttpServlet {
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int productoId = Integer.parseInt(request.getParameter("id"));
        Ropa ropa = controlador.validarRopa(productoId); // Obtiene la ropa desde la base de datos
        Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");

        if (carrito == null) {
            carrito = new Carrito();
            request.getSession().setAttribute("carrito", carrito);
        }

        boolean productoAgregado = carrito.agregarProducto(ropa);
    
        if (!productoAgregado) {
            response.sendRedirect("detalleProducto.jsp?id=" + productoId + "&error=stock");
        } else {
            response.sendRedirect("detalleProducto.jsp?id=" + productoId);
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