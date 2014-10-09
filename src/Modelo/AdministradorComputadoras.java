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
public class AdministradorComputadoras {
    
    private static final AdministradorComputadoras g_INSTANCE = 
                                                new AdministradorComputadoras();
    
    private ArrayList<RentaComputadora> g_computadoras = new ArrayList<RentaComputadora>(); 
    
    private int g_posicionCompuActual = 0;
    
    
    public void iniciarComputadora(String tiempoSalida, int numComputadora) {
        
        RentaComputadora computadora = new RentaComputadora(tiempoSalida, numComputadora); 
        g_computadoras.add(computadora); //Agrega un objeto computadora
        //Obtiene la pocision de la computadora dentro del ArrayList
        g_posicionCompuActual = g_computadoras.indexOf(computadora);         
        computadora.activarComputadora();        
        
    }   
    
    public static AdministradorComputadoras getInstance(){
        
        return g_INSTANCE;
        
    }

    public int getPosicionCompuActual() {
        
        return g_posicionCompuActual;
        
    }   

    public RentaComputadora getCompu(int posicion){
        
        return (RentaComputadora) g_computadoras.get(posicion);
        
    }
    
}
