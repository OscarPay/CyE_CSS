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
public class Xbox extends Thread {

    String nombre;
    boolean Encendida;
    int Numcontroles;
    Cronometro cronometro;

    public Xbox(String nombre, String tiempodeparo, int Numcontroles) {
        super(nombre);
        this.nombre = nombre;
        this.Numcontroles = Numcontroles;
        this.cronometro = new Cronometro(tiempodeparo);
    }

    public void run() {
        try {
            cronometro.comenzarTiempo();
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
