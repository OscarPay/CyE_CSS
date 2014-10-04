/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controlador.Observador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 * Cambiar de nombre a la clase
 */
public class Computadora{    
    
    String nombre = "";
    String tiempo = "";
    String tiempoSalida = "";
    public Cronometro cronometro = null;
    boolean encendida = false;
    
    public Computadora(String nombre, String tiempoSalida){        
        this.nombre = nombre;
        this.tiempoSalida = tiempoSalida;
        this.cronometro = new Cronometro(tiempoSalida);         
    }
    
    public void activarComputadora(){
        this.cronometro.start();        
    }
    
      
   
}
