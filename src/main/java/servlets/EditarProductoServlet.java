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

/**
 *
 * @author tobar
 */
@WebServlet(name = "EditarProductoServlet", urlPatterns = {"/EditarProductoServlet"})
public class EditarProductoServlet extends HttpServlet {
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
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            response.sendRedirect("editarProducto.jsp?error=ID%20del%20producto%20falta");
            return;
        }
        
        int productoId = 0;
        try {
            productoId = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("editarProducto.jsp?id=" + idStr + "&error=ID%20inválido");
            return;
        }
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = 0;
        int stock = 0;
        String imagen = request.getParameter("imagen");
        String talla = request.getParameter("talla");
        String color = request.getParameter("color");
        String tipo = request.getParameter("tipo");
        if (nombre == null || nombre.trim().isEmpty() || descripcion == null || descripcion.trim().isEmpty()
            || imagen == null || imagen.trim().isEmpty() || talla == null || talla.trim().isEmpty()
            || color == null || color.trim().isEmpty()) {
            response.sendRedirect("editarProducto.jsp?id=" + productoId + "&error=Campos%20vacíos");
            return;
        }
        try {
            precio = Double.parseDouble(request.getParameter("precio"));
        } catch (NumberFormatException e) {
            response.sendRedirect("editarProducto.jsp?id=" + productoId + "&error=Precio%20inválido");
            return;
        }
        try {
            stock = Integer.parseInt(request.getParameter("stock"));
        } catch (NumberFormatException e) {
            response.sendRedirect("editarProducto.jsp?id=" + productoId + "&error=Stock%20inválido");
            return;
        }
        boolean actualizado = controlador.editarProducto(nombre, descripcion, tipo, color, talla, imagen,productoId, precio, stock);
        if (actualizado) {
            response.sendRedirect("inventario.jsp");
        } else {
            response.sendRedirect("editarProducto.jsp?id=" + productoId + "&error=Producto%20no%20encontrado");
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("editarProducto.jsp?id=" + request.getParameter("id") + "&error=Ocurrió%20un%20error%20al%20editar");
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
