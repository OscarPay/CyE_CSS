/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public final class Cronometro extends Thread{

    private String tiempoTranscurrido = "";
    private String tiempoSalida = "";
    private String tipoMaquina = "";
    private int numMaquina = 0;    
    private boolean activo = true; 
    private Observado observado;
       

    public Cronometro(String tiempoSalida, int numMaquina, String tipoMaquina) {
        
        this.tiempoSalida = tiempoSalida;
        this.observado = Observado.getINSTANCE();
        this.numMaquina = numMaquina;
        this.tipoMaquina = tipoMaquina;
        
    }
    
    public void comenzarTiepo(){
        
         //la funcion start() de la clase Thread ejecuta a run() como un hilo
         start();
         
    }

    
    public void run()  {
        
        Integer horas = 0, minutos = 0, segundos = 0;
        String hora = "", min = "", seg = "";
            
        try {
            
            while (isActivo()) {
                
                Thread.sleep(1000); //Esperar un segundo
                
                segundos = aumentarSegundos(segundos);               

                //Aumenta el tiempo                
                if (segundos == 60) {
                    
                    segundos = 0;
                    minutos += 1; //Aumenta un minuto

                    if (minutos == 60) {
                        
                        minutos = 0;
                        horas++; //Aumenta una hora
                        
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
         
         this.tiempoTranscurrido = hora + ":" + min + ":" + seg;
         observado.notificarObservadoresTiempo(this.tiempoTranscurrido, 
                                              this.numMaquina, this.tipoMaquina);
         
    }

    public Observado getObservado() {
        
        return observado;
        
    }

}