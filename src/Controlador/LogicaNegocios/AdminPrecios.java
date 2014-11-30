/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.LogicaNegocios;

import Modelo.CalculadoraPrecios;
import Modelo.Temporizador;

/**
 *
 * @author Oscar
 */
public class AdminPrecios {
    
    public static CalculadoraPrecios nuevaCalculadora(Temporizador temp, int id, String tipo, int numControles){
     CalculadoraPrecios calcu = new CalculadoraPrecios(temp, id, tipo, numControles);
     iniciarCalculadora(calcu);
     return calcu;
    }

    private static void iniciarCalculadora(CalculadoraPrecios calcu) {
        calcu.start();
    }
    
}
