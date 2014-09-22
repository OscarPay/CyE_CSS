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
    Double precioCompra;
    Double precioVenta;
    String tipoProducto;

    public Producto(int id, String nombreProduc, Double precioCompra, Double precioVenta, String tipoProducto) {
        this.id = id;
        this.nombreProduc = nombreProduc;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.tipoProducto = tipoProducto;
    }   

}
