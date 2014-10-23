/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Oscar
 */
public class NotaVenta {

    private ArrayList productos = null;
    private Date fechaDeVenta = null;
    private Double precioTotal = 0.00;
    private Double dineroEntregado = 0.00;

    public NotaVenta(ArrayList productos, Date fechaDeVenta, Double precioTotal, Double dineroEntregado) {
        this.productos = productos;
        this.fechaDeVenta = fechaDeVenta;
        this.precioTotal = precioTotal;
        this.dineroEntregado = dineroEntregado;
    }    

    public Double calcular_Cambio(){
        return null;
    }
}
