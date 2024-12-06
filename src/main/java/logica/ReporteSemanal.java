/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tobar
 */
@Entity
public class ReporteSemanal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    private double totalGenerado;
    private String archivoPath;

    @Lob
    private String detallesVentas; 

    public ReporteSemanal(Long id, Date fecha, double totalGenerado, String archivoPath, String detallesVentas) {
        this.id = id;
        this.fecha = fecha;
        this.totalGenerado = totalGenerado;
        this.archivoPath = archivoPath;
        this.detallesVentas = detallesVentas;
    }

    public ReporteSemanal() {
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotalGenerado() {
        return totalGenerado;
    }

    public String getArchivoPath() {
        return archivoPath;
    }

    public String getDetallesVentas() {
        return detallesVentas;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTotalGenerado(double totalGenerado) {
        this.totalGenerado = totalGenerado;
    }

    public void setArchivoPath(String archivoPath) {
        this.archivoPath = archivoPath;
    }

    public void setDetallesVentas(String detallesVentas) {
        this.detallesVentas = detallesVentas;
    }
}