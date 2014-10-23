/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class AdminComputadoras {
    
    private static final AdminComputadoras INSTANCE = new AdminComputadoras();    
    private ArrayList<Computadora> computadoras = new ArrayList<Computadora>();    
    private int posicionCompuActual = 0;    
    
    public void iniciarComputadora(String tiempoSalida, int numComputadora) {        
        Computadora computadora = new Computadora(tiempoSalida, numComputadora); 
        computadoras.add(computadora); //Agrega un objeto computadora
        //Obtiene la pocision de la computadora dentro del ArrayList
        posicionCompuActual = computadoras.indexOf(computadora);         
        computadora.activarComputadora();        
    }   
    
    public static AdminComputadoras getInstance(){        
        return INSTANCE;        
    }

    public int getPosicionCompuActual() {        
        return posicionCompuActual;        
    }   

    public Computadora getCompu(int idCompu){        
        return (Computadora) computadoras.get(idCompu);        
    }
    
}
