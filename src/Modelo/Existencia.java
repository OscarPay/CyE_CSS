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
    
    String g_tipoAlmacenamiento;
    Producto g_producto;
    int g_cantidad;

    public Existencia(String tipoAlmacenamiento, Producto producto, int cantidad) {
        
        g_tipoAlmacenamiento = tipoAlmacenamiento;
        g_producto = producto;
        g_cantidad = cantidad;
        
    } 
    
}
