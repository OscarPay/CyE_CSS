/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.LogicaNegocios;

import Modelo.RentaComputadora;
import Modelo.RentaXbox;

/**
 *
 * @author Oscar
 */
public class AdminDatosRenta {

    public static void crearRentaCompu(int id, String tiempoEntrada, String tiempoTranscurrido, String precioTotal) {
        RentaComputadora rentaCompu = new RentaComputadora(id, precioTotal, tiempoEntrada, tiempoTranscurrido);
        System.out.println(rentaCompu.toString());
    }
    
    public static void crearRentaXbox(int id,int numControles, String tiempoEntrada, String tiempoTranscurrido, String precioTotal) {
        RentaXbox rentaXbox = new RentaXbox(id,numControles, precioTotal, tiempoEntrada, tiempoTranscurrido);
        System.out.println(rentaXbox.toString());
    }
    
}
