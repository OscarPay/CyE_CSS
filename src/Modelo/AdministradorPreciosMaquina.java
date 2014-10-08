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
    
    private Double precioTotal = 0.00;
    private Cronometro cronometro = null;
    private Observado observado = null;
    
    private int numEquipo = 0;
    private String maquina = "";
    
    public AdministradorPreciosMaquina(Cronometro cronometro, int numEquipo, String maquina){
       
        this.cronometro = cronometro;
        this.numEquipo = numEquipo;
        this.maquina = maquina;
        this.observado = Observado.getINSTANCE();
        
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
            
            while(cronometro.isActivo()){
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
        
        observado.notificarObservadoresPrecio(precioRedondeado, this.numEquipo, this.maquina);
        
    }
    
}
