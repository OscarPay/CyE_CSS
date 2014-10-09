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
 * @author Oscar Cambiar de nombre a la clase
 */
public class RentaComputadora {

    String g_tiempoEntrada = "";
    String g_tiempoSalida = "";
    int g_numComputadora = 0;    
    Double g_precio = 0.0;

    private Cronometro g_cronometro = null;
    private boolean g_encendida = false;
    private AdministradorPreciosMaquina g_adminPrecios = null;

    public RentaComputadora(String tiempoSalida, int numComputadora) {
        
        g_tiempoSalida = tiempoSalida;
        g_numComputadora = numComputadora;
        
        
        g_cronometro = new Cronometro(tiempoSalida,
                                      numComputadora,
                                      "Computadora");
        
        g_adminPrecios = new AdministradorPreciosMaquina(g_cronometro, 
                                                          numComputadora,     
                                                          "Computadora");

    }

    public void activarComputadora() {

        g_cronometro.comenzarTiempo();
        g_adminPrecios.calcularPrecio();

    }

    public Cronometro getCronometro() {

        return g_cronometro;

    }

}
