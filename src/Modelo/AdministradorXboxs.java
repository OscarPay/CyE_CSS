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
public class AdministradorXboxs {
   
   public static final AdministradorXboxs INSTANCE= new AdministradorXboxs();   
    public ArrayList xboxs = new ArrayList();  
    
    public int iniciarXbox(String tiempoSalida, int numXbox) {
        //El numero 1 es el numero de controles
        Xbox xbox = new Xbox(tiempoSalida, 1 , numXbox);       
        this.xboxs.add(xbox); //Agrega un xbox
        int posicion = xboxs.indexOf(xbox); //Obtiene la pocision del xbox dentro del ArrayList        
        xbox.activarXbox();
        return posicion;
    }   
    
    public static AdministradorXboxs getInstance(){
        return INSTANCE;
    }

    public Xbox getXbox(int NumXbox){
        return (Xbox) xboxs.get(NumXbox);
    }   
    
}
