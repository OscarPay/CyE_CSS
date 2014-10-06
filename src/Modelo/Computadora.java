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
    
    int numero = 0;
    String tiempoEntrada = "";
    String tiempoSalida = "";
    Double precio = 0.0;
    public Cronometro cronometro = null;
    boolean encendida = false;
    AdministradorPrecios administradorPrecios = null;
    
    
    public Computadora(String tiempoSalida, int numComputadora){        
        this.numero = numComputadora;
        this.tiempoSalida = tiempoSalida;        
        this.cronometro = new Cronometro(tiempoSalida, numComputadora,"Computadora");
        this.administradorPrecios = new AdministradorPrecios(cronometro);
    }
    
    public void activarComputadora(){
        this.cronometro.start(); 
        this.administradorPrecios.start();
    }

    public Cronometro getCronometro() {
        return cronometro;
    }      
}
