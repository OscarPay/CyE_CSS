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
public class Observado {
    
    public static final Observado g_INSTANCE = new Observado();
    private ArrayList<Observador> g_observadores = new ArrayList<Observador>(); 

    public static Observado getINSTANCE() {
        
        return g_INSTANCE;
        
    }   
    
    public void agregar(Observador obs) { 
         
        g_observadores.add(obs);
        
    }

    
    public void eliminar(Observador obs) {
        
        int i = g_observadores.indexOf(obs);
        
        if (i >= 0) {
            
            g_observadores.remove(i);
            
        }
        
    }
    
    public void notificarObservadoresTiempo(String tiempoTranscurrido, int numero, String maquina){
        
        for (int i = 0; i < g_observadores.size(); i++) {
            
            Observador observer = (Observador) g_observadores.get(i);
            observer.actualizarTiempo(tiempoTranscurrido, numero, maquina);
            
        }
        
    }
    
    public void notificarObservadoresPrecio(String precioTotal, int numero, String maquina){
    for (int i = 0; i < g_observadores.size(); i++) {
            
            Observador observer = (Observador) g_observadores.get(i);
            observer.actualizarPrecio(precioTotal, numero, maquina);
            
        }
    }
    
}
