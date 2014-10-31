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
public class CalculadoraPreciosMaquina extends Thread {
    
    private Double precioTotal = 0.00;
    private Temporizador temporizador = null;
    private Observado observado = null;
    
    private int numEquipo = 0;
    private String maquina = "";
    private double precioBase = 0;
    
    
    public CalculadoraPreciosMaquina(Temporizador temporizador, int numEquipo, String tipoMaquina, int numControles){       
        this.temporizador = temporizador;
        this.numEquipo = numEquipo;
        this.maquina = tipoMaquina;
        this.observado = Observado.getINSTANCE();
        this.precioBase = ListaPrecios.getPrecioBase(tipoMaquina, numControles);
        calcularPrecio();
    }
    
    public void calcularPrecio(){        
        //la funcion start() de la clase Thread ejecuta a run() como un hilo
        start();        
    }
    
    public void run(){
        
        DecimalFormat formatoPrecio = new DecimalFormat();
        Double precioSegundo = 0.00; 
        String precioRedondeado = "";
        
        try {
            
            while(temporizador.isActivo()){
                Thread.sleep(1000);
                precioSegundo += precioBase/3600;                
                precioRedondeado = formatoPrecio.format(precioSegundo);
                cambioPrecio(precioRedondeado);
            }
            
            
        } catch (InterruptedException ex) {
            
            JOptionPane.showMessageDialog(null,"Error, en calcula precios");
            
        }
    }
    
    private void cambioPrecio(String precioRedondeado){       
        observado.notificarObservadoresPrecio(precioRedondeado, numEquipo, maquina);        
    }
    
}
