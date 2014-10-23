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

    private String id = "";
    private String nombreProduc = "";
    private String tipoProducto = "";
    private Double precioCompra = 0.00;
    private Double precioVenta = 0.00;    
    
    public Producto(String id, String nombreProduc, String tipoProducto, 
                     Double precioCompra, Double precioVenta) {
        
        this.id = id;
        this.nombreProduc = nombreProduc;
        this.tipoProducto = tipoProducto;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;       
        
    } 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProduc() {
        return nombreProduc;
    }

    public void setNombreProduc(String nombreProduc) {
        this.nombreProduc = nombreProduc;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    

}