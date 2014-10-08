/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controlador.Observador;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class AdministradorComputadoras {
    
    private static final AdministradorComputadoras INSTANCE = 
                                                new AdministradorComputadoras();
    
    private ArrayList<Computadora> computadoras = new ArrayList<Computadora>(); 
    
    private int posicionCompuActual = 0;
    
    
    public void iniciarComputadora(String tiempoSalida, int numComputadora) {
        
        Computadora computadora = new Computadora(tiempoSalida, numComputadora); 
        this.computadoras.add(computadora); //Agrega un objeto computadora
        //Obtiene la pocision de la computadora dentro del ArrayList
        this.posicionCompuActual = computadoras.indexOf(computadora);         
        computadora.activarComputadora();        
        
    }   
    
    public static AdministradorComputadoras getInstance(){
        
        return INSTANCE;
        
    }

    public int getPosicionCompuActual() {
        
        return posicionCompuActual;
        
    }   

    public Computadora getCompu(int posicion){
        
        return (Computadora) computadoras.get(posicion);
        
    }
    
}
