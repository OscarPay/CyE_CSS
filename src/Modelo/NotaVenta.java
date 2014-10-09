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

    ArrayList g_productos;
    Date g_fechaDeVenta;
    Double g_precioTotal;
    Double g_dineroEntregado;

    public NotaVenta(ArrayList productos, Date fechaDeVenta, Double precioTotal, Double dineroEntregado) {
        g_productos = productos;
        g_fechaDeVenta = fechaDeVenta;
        g_precioTotal = precioTotal;
        g_dineroEntregado = dineroEntregado;
    }    

    public Double calcular_Cambio(){
        return null;
    }
}
