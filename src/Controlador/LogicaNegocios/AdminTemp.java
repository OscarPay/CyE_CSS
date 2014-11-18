/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.LogicaNegocios;

import Modelo.Temporizador;

/**
 *
 * @author Oscar
 */
public class AdminTemp {
    
    public static Temporizador nuevoTemporizador(int id, String tiempoSolicitado, String tipo){
     Temporizador temp = new Temporizador(id, tiempoSolicitado, tipo);
     iniciarTemporizador(temp);
     return temp;
    }

    private static void iniciarTemporizador(Temporizador temp) {
        temp.start();
    }
    
}
