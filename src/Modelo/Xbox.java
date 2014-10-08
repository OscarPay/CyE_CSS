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

    int numXbox = 0;
    int numControles = 0;
    String tiempoEntrada = "";
    String tiempoSalida = "";    
    Double precio = 0.0;    
    
    private Cronometro cronometro = null;
    private boolean encendida = false;
    private AdministradorPreciosMaquina adminPrecios = null;

    public Xbox(String tiempoSalida, int numControles, int numXbox) {
        
        this.numXbox = numXbox;     
        this.numControles = numControles;
        this.cronometro = new Cronometro(tiempoSalida, numXbox, "Xbox"); 
        this.adminPrecios = new AdministradorPreciosMaquina(this.cronometro, 
                                                            numXbox, "Xbox");
        
    }
    
    public void activarXbox(){
        
        this.cronometro.comenzarTiepo();
        this.adminPrecios.calcularPrecio();
        
    } 

    public Cronometro getCronometro() {
        
        return cronometro;
        
    }  
    
}
