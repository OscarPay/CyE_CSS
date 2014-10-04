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
    
    public static final AdministradorComputadoras INSTANCE= new AdministradorComputadoras();   
    public ArrayList computadoras = new ArrayList();  
    
    public void iniciarComputadora(String nombreEquipo, String tiempoSalida, int NumComputadora) {
        Computadora computadora = new Computadora(nombreEquipo, tiempoSalida, NumComputadora);
        this.computadoras.add(computadora);
        computadora = (Computadora) computadoras.get(NumComputadora);
        computadora.activarComputadora();
    }   
    
    public static AdministradorComputadoras getInstance(){
        return INSTANCE;
    }

    public Computadora getCompu(int NumComputadora){
        return (Computadora) computadoras.get(NumComputadora);
    }     
    
   
    
}
