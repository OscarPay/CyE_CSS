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

    String g_id;
    String g_nombreProduc;
    String g_tipoProducto;
    Double g_precioCompra;
    Double g_precioVenta;    
    
    public Producto(String id, String nombreProduc, String tipoProducto, 
                     Double precioCompra, Double precioVenta) {
        
        g_id = id;
        g_nombreProduc = nombreProduc;
        g_tipoProducto = tipoProducto;
        g_precioCompra = precioCompra;
        g_precioVenta = precioVenta;       
        
    }   

    public String getId() {
        return g_id;
    }

    public void setId(String id) {
        g_id = id;
    }

    public String getNombreProduc() {
        return g_nombreProduc;
    }

    public void setNombreProduc(String nombreProduc) {
        g_nombreProduc = nombreProduc;
    }

    public String getTipoProducto() {
        return g_tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        g_tipoProducto = tipoProducto;
    }

    public Double getPrecioCompra() {
        return g_precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        g_precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return g_precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        g_precioVenta = precioVenta;
    }  

}