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
 * Cambiar de nombre a la clase
 */
public class Computadora extends Thread{
    
    String nombre = "";
    Cronometro cronometro = null;
    boolean encendida = false;
    
    public Computadora(String nombre, String tiempodeparo){
        super(nombre);
        this.nombre = nombre;
        this.cronometro = new Cronometro(tiempodeparo);
    }
    
   public void run(){
        try {
            cronometro.comenzarTiempo();
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
   }    
   
}
