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
    
    public static final AdministradorComputadoras INSTANCE = 
                        new AdministradorComputadoras();   
    public ArrayList computadoras = new ArrayList();  
    
    public int iniciarComputadora(String tiempoSalida, int numComputadora) {
        
        Computadora computadora = new Computadora(tiempoSalida, numComputadora); 
        this.computadoras.add(computadora); //Agrega un objeto computadora
        int numero = computadoras.indexOf(computadora); //Obtiene la pocision de la computadora dentro del ArrayList        
        computadora.activarComputadora();
        return numero;
        
    }   
    
    public static AdministradorComputadoras getInstance(){
        
        return INSTANCE;
        
    }

    public Computadora getCompu(int numero){
        
        return (Computadora) computadoras.get(numero);
        
    }     
    
   
    
}
