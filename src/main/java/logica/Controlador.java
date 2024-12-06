/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import persistencia.ControllerPersistencia;

/**
 *
 * @author tobar
 */
public class Controlador {
    private static final String ARCHIVO_ULTIMA_FECHA = "./persistencia/ultimaFechaReporte.txt";
    ControllerPersistencia controlPersis = new ControllerPersistencia();
    public void crearUsuario ( String nombreUsuario, String contrasena, String rol, String numerotel, String correo){
        User usu=new User();
        usu.setName(nombreUsuario);
        usu.setPassword(contrasena);
        usu.setEmail(correo);
        usu.setRole(rol);
        usu.setPhoneNumber(numerotel);
        controlPersis.crearUsuario(usu);
    }
    public void crearRopa(String nombre, String descripcion, double precio, String imagen, String talla, String color, String tipo, int stock) {
        Ropa rop=new Ropa();
        rop.setNombre(nombre);
        rop.setDescripcion(descripcion);
        rop.setPrecio(precio);
        rop.setImagen(imagen);
        rop.setTalla(talla);
        rop.setColor(color);
        rop.setTipo(tipo);
        rop.setStock(stock);
        controlPersis.crearRopa(rop);
    }

    public User validarUsuario(String username, String password) {
        List<User> userList=controlPersis.getUsuarios();
        for(User u : userList){
            if(u.getName().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
    
    public Ropa validarRopa(int id) {
        List<Ropa> ropaList=controlPersis.getRopa();
        for(Ropa r : ropaList){
            if(r.getId()==id){
                return r;
            }
        }
        return null;
    }
    
    public ReporteSemanal validarReporte(int id) {
        List<ReporteSemanal> reporteList=controlPersis.obtenerReportes();
        for(ReporteSemanal r : reporteList){
            if(r.getId()==id){
                return r;
            }
        }
        return null;
    }
    
    public List<Ropa> listaDeRopa(){
        List<Ropa> ropaList=controlPersis.getRopa();
        if(ropaList!=null){
            return ropaList;
        }
        return null;
    }
    


    public boolean editarProducto(String nombre, String descripcion, String tipo, String color, String talla, String imagen, int productoId, double precio, int stock) {
        Ropa rop=controlPersis.buscarRopaId(productoId);
        if(rop==null){
            return false;
        }
        rop.setNombre(nombre);
        rop.setDescripcion(descripcion);
        rop.setPrecio(precio);
        rop.setImagen(imagen);
        rop.setTalla(talla);
        rop.setColor(color);
        rop.setTipo(tipo);
        rop.setStock(stock);
        return controlPersis.editarRopa(rop);
    }

    public void eliminarRopa(int productoId) {
       controlPersis.borrarRopa(productoId);
    }
    
    public void actualizarRopa(Ropa ropa, int cantidadVendida) {
    Ropa ropaDB = controlPersis.buscarRopaId(ropa.getId());
    if (ropaDB != null) {
        int nuevoStock = ropaDB.getStock() - cantidadVendida;
        if (nuevoStock >= 0) {
            ropaDB.setStock(nuevoStock);
            controlPersis.editarRopa(ropaDB); 
        } else {
            throw new IllegalArgumentException("No hay suficiente stock para el producto: " + ropa.getNombre());
        }
    } else {
        throw new IllegalArgumentException("Producto no encontrado: " + ropa.getId());
    }
}

    public void registrarVenta(Carrito carrito, User usuario) {
    if (carrito == null || carrito.getRopas().isEmpty()) {
        throw new IllegalArgumentException("El carrito está vacío o no es válido.");
    }

    Venta nuevaVenta = new Venta();
    nuevaVenta.setFecha(new Date());
    nuevaVenta.setUsuario(usuario);

    List<ProductoVenta> productosVendidos = new ArrayList<>();

    for (Map.Entry<Ropa, Integer> entry : carrito.getRopas().entrySet()) {
        Ropa ropa = controlPersis.buscarRopaId(entry.getKey().getId());
        int cantidad = entry.getValue();

        if (ropa == null) {
            throw new IllegalArgumentException("Producto no encontrado: " + entry.getKey().getId());
        }
        if (cantidad > ropa.getStock()) {
            throw new IllegalArgumentException("Stock insuficiente para el producto: " + ropa.getNombre());
        }

        ProductoVenta productoVenta = new ProductoVenta();
        productoVenta.setProducto(ropa);
        productoVenta.setCantidad(cantidad);
        productoVenta.setVenta(nuevaVenta);

        productosVendidos.add(productoVenta);
    }

     nuevaVenta.setProductosVendidos(productosVendidos);

    controlPersis.crearVenta(nuevaVenta);

    }
    
   public void generarReporteSemanal(ReporteSemanal reporte) {
    try {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("reporte_semanal.pdf"));
        
        document.open();  
        
        document.add(new Paragraph("Reporte Semanal de Ventas"));
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy HH:mm:ss", new Locale("es", "ES"));
        String fechaFormateada = sdf.format(reporte.getFecha());
        document.add(new Paragraph("Fecha: " + fechaFormateada));
        
        document.add(new Paragraph("Total Generado: " + reporte.getTotalGenerado()));
        
        document.add(new Paragraph("Detalles de las Ventas:"));
        document.add(new Paragraph(reporte.getDetallesVentas()));  
        
        document.close();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    public List<Venta> obtenerVentasDeLaSemana() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.DATE, -7); 

        Date inicioSemana = calendar.getTime();

        calendar.add(Calendar.DATE, 6); 
        Date finSemana = calendar.getTime();

        return controlPersis.obtenerVentasPorFechas(inicioSemana, finSemana);   
    }
    
    public List<ReporteSemanal> obtenerReportes(){
        return controlPersis.obtenerReportes();
    }
    
    public void generarReporte() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    List<Venta> ventas = obtenerVentasDeLaSemana(); 
    
    double totalGenerado = 0.0;
    StringBuilder detallesVentas = new StringBuilder();
    for (Venta venta : ventas) {
        LocalDate fecha = venta.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String fechaFormateada = fecha.format(formatter);
        
        detallesVentas.append("Fecha de la Venta: ").append(fechaFormateada).append("\n");
        
        double subtotalVenta = 0.0;
        
        for (ProductoVenta productoVenta : venta.getProductosVendidos()) {
            Ropa ropa = productoVenta.getProducto();
            int cantidad = productoVenta.getCantidad();
            double precioUnitario = ropa.getPrecio(); 
            

            double subtotal = precioUnitario * cantidad;
            subtotalVenta += subtotal;
            
            detallesVentas.append("Producto: ").append(ropa.getNombre()) 
                            .append(" - Cantidad: ").append(cantidad)
                            .append(" - Subtotal: ").append(subtotal).append("\n");
        }
        
        detallesVentas.append("Total de la venta: ").append(subtotalVenta).append("\n\n");
        totalGenerado += subtotalVenta;
    }

    String detallesVentasStr = detallesVentas.toString();
    
    ReporteSemanal reporte = new ReporteSemanal();
    reporte.setFecha(new Date());
    reporte.setTotalGenerado(totalGenerado);
    reporte.setDetallesVentas(detallesVentasStr);

    controlPersis.crearReporte(reporte);
    }
    
    public void generarPDF(ReporteSemanal reporte, OutputStream out) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy HH:mm:ss", new Locale("es", "ES"));
            String fechaFormateada = sdf.format(reporte.getFecha());

            document.add(new Paragraph("Reporte Semanal"));
            document.add(new Paragraph("ID: " + reporte.getId()));
            document.add(new Paragraph("Fecha de Generación: " + fechaFormateada));
            document.add(new Paragraph("Detalle de Ventas:"));

 
            String[] ventas = reporte.getDetallesVentas().split("\n\n"); 

            for (String venta : ventas) {

                String[] lineasVenta = venta.split("\n");
                String fechaVenta = lineasVenta[0].replace("Fecha de la Venta: ", "").trim();
                document.add(new Paragraph("Fecha de la Venta: " + fechaVenta));

                PdfPTable table = new PdfPTable(3);
                table.setWidthPercentage(100); 
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f); 

    
                table.addCell("Producto");
                table.addCell("Cantidad");
                table.addCell("Subtotal");

                for (int i = 1; i < lineasVenta.length - 1; i++) {
                    String[] partes = lineasVenta[i].split("-");
                    if (partes.length == 3) {
                        String producto = partes[0].replace("Producto: ", "").trim();
                        String cantidad = partes[1].replace("Cantidad: ", "").trim();
                        String subtotal = partes[2].replace("Subtotal: ", "").trim();

                        table.addCell(producto); 
                        table.addCell(cantidad); 
                        table.addCell(subtotal); 
                    }
                }

                document.add(table);

                String totalVenta = lineasVenta[lineasVenta.length - 1].replace("Total de la venta: ", "").trim();
                document.add(new Paragraph("Total de la Venta: $" + totalVenta));
                document.add(new Paragraph("\n")); // Salto de línea entre ventas
            }

            document.add(new Paragraph("Total Generado: $" + reporte.getTotalGenerado()));

        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
    

