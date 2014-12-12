/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Oscar
 */
public class NotaVentaDia {

    private Date fechaDeVenta ;
    private Producto producto ;
    private Double cantidadProducto;
    private Double precioTotal;

    public NotaVentaDia(Date fechaDeVenta, Producto producto, Double cantidadProducto, Double precioTotal) {
        this.fechaDeVenta = fechaDeVenta;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.precioTotal = precioTotal;
    }

   
    
    

    public Date getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(Date fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Double cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    
}
