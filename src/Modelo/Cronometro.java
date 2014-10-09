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

    private String g_tiempoTranscurrido = "";
    private String g_tiempoSalida = "";
    private String g_tipoMaquina = "";
    private int g_numMaquina = 0;    
    private boolean g_activo = true; 
    private Observado g_observado;
       

    public Cronometro(String tiempoSalida, int numMaquina, String tipoMaquina) {
        
        g_tiempoSalida = tiempoSalida;
        g_observado = Observado.getINSTANCE();
        g_numMaquina = numMaquina;
        g_tipoMaquina = tipoMaquina;
        
    }
    
    public void comenzarTiempo(){
        
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

                if (g_tiempoTranscurrido.equals(g_tiempoSalida)) {
                    
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
        
        g_activo = false;
        
    }
    
    public boolean isActivo(){
        
        return g_activo;
        
    }

    private void cambioTiempo(String hora, String min, String seg) {        
         
         g_tiempoTranscurrido = hora + ":" + min + ":" + seg;
         g_observado.notificarObservadoresTiempo(g_tiempoTranscurrido, 
                                                 g_numMaquina, g_tipoMaquina);
         
    }

    public Observado getObservado() {
        
        return g_observado;
        
    }

}