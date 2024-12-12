/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
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

        Paragraph header = new Paragraph("BOLETA DE VENTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20));
        header.setAlignment(Element.ALIGN_CENTER);
        document.add(header);
        document.add(new Paragraph("\n"));

        Paragraph clienteInfo = new Paragraph(
            "Fecha: " + currentDate + "\n" +
            "Vendedor: " + usuario.getName() + "\n" +
            "Correo: " + usuario.getEmail() + "\n" +
            "Teléfono: " + usuario.getPhoneNumber() + "\n",
            FontFactory.getFont(FontFactory.HELVETICA, 12)
        );
        clienteInfo.setSpacingAfter(10);
        document.add(clienteInfo);

        LineSeparator separator = new LineSeparator();
        separator.setLineWidth(1f);
        document.add(separator);
        document.add(new Paragraph("\n"));

        Paragraph detallesHeader = new Paragraph("Detalles de la Compra", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
        detallesHeader.setSpacingAfter(10);
        document.add(detallesHeader);

        double totalf = 0;
        for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
            Ropa ropa = entry.getKey();
            int cantidad = entry.getValue();
            double subtotal = ropa.getPrecio() * cantidad;
            totalf += subtotal;

            Paragraph productoFicha = new Paragraph(
                ropa.getNombre() + "\n" +
                "Cantidad: " + cantidad + "\n" +
                "Precio Unitario: $" + String.format("%.2f", ropa.getPrecio()) + "\n" +
                "Subtotal: $" + String.format("%.2f", subtotal),
                FontFactory.getFont(FontFactory.HELVETICA, 12)
            );
            productoFicha.setSpacingAfter(10);
            productoFicha.setIndentationLeft(20);
            productoFicha.setIndentationRight(20);
            productoFicha.setLeading(1.5f, 1.5f); 
            document.add(productoFicha);

            document.add(new LineSeparator());
            document.add(new Paragraph("\n"));
        }


        Paragraph total = new Paragraph("Total: $" + String.format("%.2f", totalf),
            FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
        total.setAlignment(Element.ALIGN_RIGHT);
        total.setSpacingBefore(20);
        document.add(total);

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
