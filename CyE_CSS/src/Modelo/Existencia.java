/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Oscar
 */
public class Existencia {
    String tipoAlmacenamiento;
    Producto producto;
    int cantidad;

    public Existencia(String tipoAlmacenamiento, Producto producto, int cantidad) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
        this.producto = producto;
        this.cantidad = cantidad;
    }    
}
