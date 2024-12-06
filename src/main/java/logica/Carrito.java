/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package logica;

import java.util.HashMap;
import java.util.Map;


public class Carrito {
    private Map<Ropa, Integer> ropas;

    public Carrito() {
        this.ropas = new HashMap<>();
    }

    public boolean agregarProducto(Ropa ropa) {
        int cantidadEnCarrito = ropas.getOrDefault(ropa, 0);
        if (ropa.getStock() > cantidadEnCarrito) {
            ropas.put(ropa, cantidadEnCarrito + 1);
            return true;
        }
        return false;
    }

    public void eliminarProducto(Ropa ropa) {
        if (ropas.containsKey(ropa)) {
            int cantidad = ropas.get(ropa);
            if (cantidad > 1) {
                ropas.put(ropa, cantidad - 1);
            } else {
                ropas.remove(ropa);
            }
        }
    }
    
    public void eliminarCompletamente(Ropa ropa){
        if (ropas.containsKey(ropa)) {
        ropas.remove(ropa); 
        }
    }

    public Map<Ropa, Integer> getRopas() {
        return ropas;
    }

    public int getCantidad(Ropa ropa) {
        return ropas.getOrDefault(ropa, 0);
    }

    public void actualizarCantidad(Ropa ropa, int cantidad) {
        if (ropas.containsKey(ropa)) {
            int stockDisponible = ropa.getStock();
            if (cantidad > stockDisponible) {
                cantidad = stockDisponible;
            }
            ropas.put(ropa, cantidad);
        }
    }
}