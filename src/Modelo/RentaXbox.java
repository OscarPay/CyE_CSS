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
public class RentaXbox{

    int g_numXbox = 0;
    int g_numControles = 0;
    String g_tiempoEntrada = "";
    String g_tiempoSalida = "";    
    Double g_precio = 0.0;    
    
    private Cronometro g_cronometro = null;
    private boolean g_encendida = false;
    private AdministradorPreciosMaquina g_adminPrecios = null;

    public RentaXbox(String tiempoSalida, int numControles, int numXbox) {
        
        g_numXbox = numXbox;     
        g_numControles = numControles;
        g_cronometro = new Cronometro(tiempoSalida, numXbox, "Xbox"); 
        g_adminPrecios = new AdministradorPreciosMaquina(g_cronometro, 
                                                            numXbox, "Xbox");
        
    }
    
    public void activarXbox(){
        
        g_cronometro.comenzarTiempo();
        g_adminPrecios.calcularPrecio();
        
    } 

    public Cronometro getCronometro() {
        
        return g_cronometro;
        
    }  
    
}
