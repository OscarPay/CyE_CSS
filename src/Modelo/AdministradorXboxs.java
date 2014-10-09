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
   
    public static final AdministradorXboxs g_INSTANCE = new AdministradorXboxs();   
    public ArrayList<RentaXbox> g_xboxs = new ArrayList<RentaXbox>();  
    private int g_posicionActual = 0;
    
    public void iniciarXbox(String tiempoSalida, int numXbox) {
        
        //El numero 1 es el numero de controles
        RentaXbox xbox = new RentaXbox(tiempoSalida, 1 , numXbox);       
        this.g_xboxs.add(xbox); //Agrega un xbox
        this.g_posicionActual = g_xboxs.indexOf(xbox); //Obtiene la pocision del xbox dentro del ArrayList        
        xbox.activarXbox();        
        
    }   
    
    public static AdministradorXboxs getInstance(){
        
        return g_INSTANCE;
        
    }

    public int getPosicionActual() {
        return g_posicionActual;
    }    

    public RentaXbox getXbox(int NumXbox){
        
        return g_xboxs.get(NumXbox);
        
    }   
    
}
