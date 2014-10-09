/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class AdministradorPreciosMaquina extends Thread {
    
    private Double g_precioTotal = 0.00;
    private Cronometro g_cronometro = null;
    private Observado g_observado = null;
    
    private int g_numEquipo = 0;
    private String g_maquina = "";
    
    public AdministradorPreciosMaquina(Cronometro cronometro, int numEquipo, String maquina){
       
        g_cronometro = cronometro;
        g_numEquipo = numEquipo;
        g_maquina = maquina;
        g_observado = Observado.getINSTANCE();
        
    }
    
    public void calcularPrecio(){
        
        //la funcion start() de la clase Thread ejecuta a run() como un hilo
        start();
        
    }
    
    public void run() {
        
        DecimalFormat formatoPrecio = new DecimalFormat();
        Double precio = 0.00; 
        String precioRedondeado = "";
        
        try {
            
            while(g_cronometro.isActivo()){
                Thread.sleep(1000);
                precio += .0028;                
                precioRedondeado = formatoPrecio.format(precio);
                cambioPrecio(precioRedondeado);
            }
            
            
        } catch (InterruptedException ex) {
            
            JOptionPane.showMessageDialog(null,"Error, en calcula precios");
            
        }
    }
    
    private void cambioPrecio(String precioRedondeado){        
        
        g_observado.notificarObservadoresPrecio(precioRedondeado, g_numEquipo, g_maquina);
        
    }
    
}
