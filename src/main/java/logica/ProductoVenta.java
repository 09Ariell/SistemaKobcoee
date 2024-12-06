/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author tobar
 */
@Entity
public class ProductoVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Ropa producto;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    
    public ProductoVenta(){
        
    }

    public ProductoVenta(Ropa producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Ropa getProducto() {
        return producto;
    }

    public void setProducto(Ropa producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
  
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setVenta(Venta venta){
        this.venta=venta;
    }
    public Venta getVenta(){
        return venta;
    }
}