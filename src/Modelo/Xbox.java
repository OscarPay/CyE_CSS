/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class Xbox{

    int numero = 0;
    int numControles = 0;
    String tiempoEntrada = "";
    String tiempoSalida = "";    
    Double precio = 0.0;    
    
    Cronometro cronometro = null;
    boolean encendida = false;

    public Xbox(String tiempoSalida, int numControles, int numXbox) {
        
        this.numero = numXbox;     
        this.numControles = numControles;
        this.cronometro = new Cronometro(tiempoSalida, numXbox, "Xbox"); 
        
    }
    
    public void activarXbox(){
        
        cronometro.start();
        
    } 

    public Cronometro getCronometro() {
        
        return cronometro;
        
    }  
    
}
