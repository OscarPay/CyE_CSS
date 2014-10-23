/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class AdminXboxs {
   
    public static final AdminXboxs INSTANCE = new AdminXboxs();   
    public ArrayList<Xbox> xboxs = new ArrayList<Xbox>();  
    private int posicionActual = 0;
    
    public void iniciarXbox(String tiempoSalida, int numXbox) {        
        //El numero 1 es el numero de controles
        Xbox xbox = new Xbox(tiempoSalida, 1 , numXbox);       
        this.xboxs.add(xbox); //Agrega un xbox
        this.posicionActual = xboxs.indexOf(xbox); //Obtiene la pocision del xbox dentro del ArrayList        
        xbox.activarXbox();        
        
    }   
    
    public static AdminXboxs getInstance(){        
        return INSTANCE;        
    }

    public int getPosicionActual() {
        return posicionActual;
    }    

    public Xbox getXbox(int NumXbox){        
        return xboxs.get(NumXbox);        
    }   
    
}
