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
 *
 * @author Oscar
 */
public class ControladorAdministradores {    
    
    AdministradorComputadoras administradorComputadoras;
    AdministradorXboxs administradorXboxs;
    
    
    public ControladorAdministradores() {
        administradorComputadoras = AdministradorComputadoras.getInstance();
        administradorXboxs = AdministradorXboxs.getInstance();
    }
    
    public int iniciarComputadora(String tiempoSalida, int numComputadora) {
        int posicion = 0;
        posicion = administradorComputadoras.iniciarComputadora(tiempoSalida, numComputadora);
        return posicion;
    }

    public AdministradorComputadoras getAdministradorComputadoras() {
        return administradorComputadoras;
    } 

    public int iniciarXbox(String tiempoSalida, int numXbox) {
        int posicion = 0;
        posicion = administradorXboxs.iniciarXbox(tiempoSalida, numXbox);
        return posicion;
    }

    public AdministradorXboxs getAdministradorXboxs() {
        return administradorXboxs;
    }
    
    
    
}
