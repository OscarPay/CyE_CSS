/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class AdministradorPrecios extends Thread {
    
    Double precio=0.00;
    Cronometro cronometro = null;
    
    public AdministradorPrecios(Cronometro cronometro){
        this.cronometro = cronometro;
    }
    
    public void run(){
        calcularPrecio();
    }
    
    private void calcularPrecio() {
        try {
            
            while(cronometro.isActivo()){
                Thread.sleep(1000);
                this.precio += .28;
                System.out.println(this.precio);  
            }
            
            
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null,"Error, en calcula precios");
        }
    }
    
    
    
}
