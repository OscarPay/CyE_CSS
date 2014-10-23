/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Oscar
 */
public class Xbox {
    
    private int id = 0;
    private Temporizador temporizador = null;
    private boolean encendida = false;
    private CalculadoraPreciosMaquina adminPrecios = null;
    private int numComtroles = 0;
    
    public Xbox(String tiempoSalida, int numControles, int numXbox) {
        
        this.id = numXbox;   
        this.numComtroles = numControles;
        temporizador = new Temporizador(tiempoSalida, numXbox, "Xbox"); 
        adminPrecios = new CalculadoraPreciosMaquina(temporizador, 
                                                     numXbox, "Xbox", numControles);
        
    }
    
    public void activarXbox(){        
        temporizador.comenzarTemp();
        adminPrecios.calcularPrecio();        
    } 

    public Temporizador getCronometro() {        
        return temporizador;        
    }  
}
