/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.AdministradorComputadoras;
import java.util.ArrayList;
import java.util.Observer;

/**
 *
 * @author Oscar
 */
public class ControladorAdmiCompu {    
    
    AdministradorComputadoras administradorComputadoras;
    
    
    public ControladorAdmiCompu() {
        administradorComputadoras = AdministradorComputadoras.getInstance();
    }
    
    public void iniciarComputadora(String nombreEquipo, String tiempoSalida, int NumComputadora) {
        administradorComputadoras.iniciarComputadora(nombreEquipo, tiempoSalida, NumComputadora);
    }

    public AdministradorComputadoras getAdministradorComputadoras() {
        return administradorComputadoras;
    } 
    
}
