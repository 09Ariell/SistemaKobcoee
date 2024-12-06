/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import logica.Carrito;
import logica.Controlador;
import logica.Ropa;
import logica.User;

/**
 *
 * @author tobar
 */
@WebServlet(name = "PagarServlet", urlPatterns = {"/PagarServlet"})
public class PagarServlet extends HttpServlet {
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
        Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");
        User usuario = (User) request.getSession().getAttribute("currentUser");
        if (carrito != null && !carrito.getRopas().isEmpty()) {
            try {
                generarBoletaPDF(carrito, usuario, response);
                registrarVenta(carrito, usuario);
                actualizarInventario(carrito);
                carrito.getRopas().clear();
                response.sendRedirect("compraExitosa.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp"); 
            }
        } else {
            response.sendRedirect("carritoVacio.jsp");  
        }
    }

    private void generarBoletaPDF(Carrito carrito, User usuario, HttpServletResponse response) throws Exception {
    Document document = new Document();
    String pdfPath = getServletContext().getRealPath("/") + "boleta_venta.pdf";
    PdfWriter.getInstance(document, new java.io.FileOutputStream(pdfPath));
    document.open();
    
    Locale locale = new Locale("es", "ES");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", locale);
    String currentDate = sdf.format(new Date());
    
    document.add(new Paragraph("BOLETA DE VENTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
    document.add(new Paragraph("Fecha: " + currentDate, FontFactory.getFont(FontFactory.HELVETICA, 12)));
    document.add(new Paragraph("Nombre: " + usuario.getName(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
    document.add(new Paragraph("Correo: " + usuario.getEmail(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
    document.add(new Paragraph("Teléfono: " + usuario.getPhoneNumber(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
    document.add(new Paragraph("\nDetalles de la Compra:\n"));
    document.add(new Paragraph("\n"));
    PdfPTable table = new PdfPTable(4); 
    table.addCell("Producto");
    table.addCell("Cantidad");
    table.addCell("Precio Unitario");
    table.addCell("Subtotal");

    double totalf = 0;
    for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
        Ropa ropa = entry.getKey();
        int cantidad = entry.getValue();
        double subtotal = ropa.getPrecio() * cantidad;
        totalf += subtotal;
        
 
        table.addCell(ropa.getNombre());
        table.addCell(String.valueOf(cantidad));
        table.addCell(String.format("$%.2f", ropa.getPrecio()));
        table.addCell(String.format("$%.2f", subtotal));
       
    }

    document.add(table);
    document.add(new Paragraph("\nTotal: $" + String.format("%.2f", totalf), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
    document.close();
}

    private void actualizarInventario(Carrito carrito) {
        for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
            Ropa ropa = entry.getKey();
            int cantidad = entry.getValue();
            controlador.actualizarRopa(ropa, cantidad);
        }
    }
    
    private void registrarVenta(Carrito carrito, User usuario) {
        controlador.registrarVenta(carrito,usuario);
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
