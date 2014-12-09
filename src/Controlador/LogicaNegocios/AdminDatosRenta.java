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

    //Creo que esta clase esta de mas, es una clase inutil
    public static void crearRentaCompu(int id, String horaEntrada,
            String tiempoTranscurrido, String precioTotal, String fecha) {
        RentaComputadora rentaCompu = new RentaComputadora(id, precioTotal,
                horaEntrada, tiempoTranscurrido, fecha);
        System.out.println(rentaCompu.toString());
    }

    public static void crearRentaXbox(int id, int numControles, String horaEntrada,
            String tiempoTranscurrido, String precioTotal, String fecha) {
        RentaXbox rentaXbox = new RentaXbox(id, numControles, horaEntrada,
                tiempoTranscurrido, precioTotal, fecha);
        System.out.println(rentaXbox.toString());
    }

}
