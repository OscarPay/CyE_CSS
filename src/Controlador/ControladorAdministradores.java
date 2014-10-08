/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.AdministradorComputadoras;
import Modelo.AdministradorXboxs;
import java.util.ArrayList;
import java.util.Observer;

/**
 * Controlador que maneja a los Administradores de Computadoras y Xboxs
 * @author Oscar
 */
public class ControladorAdministradores {  
    
    /**
     * LLama a la funcion iniciarComputadora() de administradorComputadoras
     * @param tiempoSalida El timepo de salida de la computadora
     * @param numComputadora El numero de la computadora
     * @return La posicion de la computadora dentro del ArrayList de administradorComputadoras
     */
    public void iniciarComputadora(String tiempoSalida, int numComputadora) {
        
        AdministradorComputadoras administradorComputadoras = AdministradorComputadoras.getInstance();
        
        administradorComputadoras.iniciarComputadora(tiempoSalida, numComputadora);
        
        
        
    }
    
    /**
     * LLama a la funcion iniciarXbox() de administradorXbox
     * @param tiempoSalida El timepo de salida del Xbox
     * @param numXbox El numero del Xbox
     * @return La posicion del xbox dentro del ArrayList de administradorXbox
     */
    public void iniciarXbox(String tiempoSalida, int numXbox) {
        
        AdministradorXboxs administradorXboxs = AdministradorXboxs.getInstance();
        
        administradorXboxs.iniciarXbox(tiempoSalida, numXbox);      
        
    }

    /**
     * Me devuelve el AdministradosComputadoras
     * @return Una instancia de AdministradorComputadoras
     */
    public AdministradorComputadoras getAdministradorComputadoras() {
        
        AdministradorComputadoras administradorComputadoras = AdministradorComputadoras.getInstance();
        return administradorComputadoras;
        
    }
    
    /**
     * Me devulve el AdministradorXboxs
     * @return Una instancia de AdministradorXboxs
     */
    public AdministradorXboxs getAdministradorXboxs() {
        
        AdministradorXboxs administradorXboxs = AdministradorXboxs.getInstance();
        return administradorXboxs;
        
    }  
    
}
