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
    
    AdministradorComputadoras administradorComputadoras;
    AdministradorXboxs administradorXboxs;
    
    /**
     * Constructor de ControladorAdministrador 
     * Aqui se inicializan los atributos
     */
    public ControladorAdministradores() {
        
        administradorComputadoras = AdministradorComputadoras.getInstance();
        administradorXboxs = AdministradorXboxs.getInstance();
        
    }
    
    /**
     * LLama a la funcion iniciarComputadora() de administradorComputadoras
     * @param tiempoSalida El timepo de salida de la computadora
     * @param numComputadora El numero de la computadora
     * @return La posicion de la computadora dentro del ArrayList de administradorComputadoras
     */
    public int iniciarComputadora(String tiempoSalida, int numComputadora) {
        
        int posicion = administradorComputadoras.
                       iniciarComputadora(tiempoSalida, numComputadora);
        
        return posicion;
        
    }
    
    /**
     * LLama a la funcion iniciarXbox() de administradorXbox
     * @param tiempoSalida El timepo de salida del Xbox
     * @param numXbox El numero del Xbox
     * @return La posicion del xbox dentro del ArrayList de administradorXbox
     */
    public int iniciarXbox(String tiempoSalida, int numXbox) {
        
        int posicion = administradorXboxs.iniciarXbox(tiempoSalida, numXbox);
        
        return posicion;
        
    }

    /**
     * Me devuelve el AdministradosComputadoras
     * @return Una instancia de AdministradorComputadoras
     */
    public AdministradorComputadoras getAdministradorComputadoras() {
        
        return administradorComputadoras;
        
    }
    
    /**
     * Me devulve el AdministradorXboxs
     * @return Una instancia de AdministradorXboxs
     */
    public AdministradorXboxs getAdministradorXboxs() {
        
        return administradorXboxs;
        
    }  
    
}
