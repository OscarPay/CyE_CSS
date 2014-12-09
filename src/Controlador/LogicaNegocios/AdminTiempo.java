/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.LogicaNegocios;

import Modelo.Temporizador;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Oscar
 */
public class AdminTiempo {
    
    public static Temporizador nuevoTemporizador(int id, String tiempoSolicitado, String tipo){
     Temporizador temp = new Temporizador(id, tiempoSolicitado, tipo);
     iniciarTemporizador(temp);
     return temp;
    }

    private static void iniciarTemporizador(Temporizador temp) {
        temp.start();
    }
    
    public static String obtenerHoraActual() {
        Date horaEntrada = new Date();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        return formatoHora.format(horaEntrada);
    }
    
    public static String obtenerFecha(){
        Date fecha = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/yyyy");
        return formatoFecha.format(fecha);
    }
    
}
