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
 * @author Oscar Cambiar de nombre a la clase
 */
public class Computadora {

    String tiempoEntrada = "";
    String tiempoSalida = "";
    int numComputadora = 0;    
    Double precio = 0.0;

    private Cronometro cronometro = null;
    private boolean encendida = false;
    private AdministradorPreciosMaquina adminPrecios = null;

    public Computadora(String tiempoSalida, int numComputadora) {
        
        this.tiempoSalida = tiempoSalida;
        this.numComputadora = numComputadora;
        
        
        this.cronometro = new Cronometro(tiempoSalida,
                                        numComputadora,
                                        "Computadora");
        
        this.adminPrecios = new AdministradorPreciosMaquina(cronometro, 
                                                            numComputadora,     
                                                            "Computadora");

    }

    public void activarComputadora() {

        this.cronometro.comenzarTiepo();
        this.adminPrecios.calcularPrecio();

    }

    public Cronometro getCronometro() {

        return cronometro;

    }

}
