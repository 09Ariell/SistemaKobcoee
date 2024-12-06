/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author tobar
 */
@Entity
public class Ropa implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String color;
    private String talla;
    private String imagen;
    private double precio;
    private int stock;
    
    public Ropa(){
    }

    public Ropa(String nombre, String descripcion, String tipo, String color, String talla, String imagen, int id, double precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.color = color;
        this.talla = talla;
        this.imagen = imagen;
        this.id = id;
        this.precio = precio;
        this.stock=stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ropa ropa = (Ropa) obj;
        return id == ropa.id; 
    }


    @Override
    public int hashCode() {
        return Integer.hashCode(id); 
    }
}