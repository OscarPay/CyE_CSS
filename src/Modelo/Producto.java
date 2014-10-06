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
public class Producto {

    int id;
    String nombreProduc;
    String tipoProducto;
    Double precioCompra;
    Double precioVenta;    

    public Producto(int id, String nombreProduc, String tipoProducto, 
                     Double precioCompra, Double precioVenta) {
        
        this.id = id;
        this.nombreProduc = nombreProduc;
        this.tipoProducto = tipoProducto;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;       
        
    }   

}
