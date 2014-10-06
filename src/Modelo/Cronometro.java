/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Observador;
import Vista.MenuPrincipal;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public final class Cronometro extends Thread{

    int numero = 0;
    String tiempoTranscurrido = "";
    String tiempoSalida = "";
    String maquina = "";
    boolean activo = true; 
    public ArrayList observadores;    

    public Cronometro(String tiempoSalida, int numMaquina, String maquina) {
        
        this.tiempoSalida = tiempoSalida;
        this.observadores = new ArrayList();
        this.numero = numMaquina;
        this.maquina = maquina;
        
    }
    
    public void run(){
        
         this.comenzarTiempo();
         
    }

    
    public void comenzarTiempo()  {
        
        Integer horas = 0, minutos = 0, segundos = 0;
        String hora = "", min = "", seg = "";

        try {
            
            while (isActivo()) {
                
                Thread.sleep(1000); //Pase un segundo
                
                segundos = aumentarSegundos(segundos);               

                //Aumenta el tiempo
                if (segundos == 60) {
                    
                    segundos = 0;
                    minutos += 1;

                    if (minutos == 60) {
                        
                        minutos = 0;
                        horas++;
                        
                    }
                    
                }

                //Lo combierte a tipo String
                if (horas < 10) {
                    
                    hora = "0" + horas;
                    
                } else {
                    
                    hora = horas.toString();
                    
                }

                if (minutos < 10) {
                    
                    min = "0" + minutos;
                    
                } else {
                    
                    min = minutos.toString();
                    
                }

                if (segundos < 10) {
                    
                    seg = "0" + segundos;
                    
                } else {
                    
                    seg = segundos.toString();
                    
                }
               
                this.cambioTiempo(hora, min, seg); //Indica al observador que se modifico el tiempo

                if (this.tiempoTranscurrido.equals(this.tiempoSalida)) {
                    
                    pararTiempo();
                    JOptionPane.showMessageDialog(null, "Se termino el tiempo");
                    
                }
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        };
        
    }
    
    private Integer aumentarSegundos(Integer segundos){
        
        return segundos + 1;
        
    }
    
    private void pararTiempo() {
        
        this.activo = false;
        
    }
    
    public boolean isActivo(){
        
        return this.activo;
        
    }

    private void cambioTiempo(String hora, String min, String seg) {
        
         //System.out.println(hora + ":" + min + ":" + seg);
         this.tiempoTranscurrido = hora + ":" + min + ":" + seg;
         notificarObservadores();
         
    }
    
     public void agregar(Observador obs) { 
         
        observadores.add(obs);
        
    }

    
    public void eliminar(Observador obs) {
        
        int i = observadores.indexOf(obs);
        
        if (i >= 0) {
            
            observadores.remove(i);
            
        }
        
    }
    
    public void notificarObservadores(){
        
        for (int i = 0; i < observadores.size(); i++) {
            
            Observador observer = (Observador) observadores.get(i);
            observer.Actualizar(this.tiempoTranscurrido, this.numero, this.maquina);
            
        }
        
    }

}
