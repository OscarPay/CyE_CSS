/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Observador;
import Vista.MenuPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public final class Cronometro extends Thread{

    String tiempo = "";
    String tiempoSalida = "";
    boolean activo = true; 
    public ArrayList observadores;
    

    public Cronometro(String tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
        observadores = new ArrayList();
    }
    
    public void run(){
         this.comenzarTiempo();
    }

    public void comenzarTiempo()  {
        Integer horas = 0, minutos = 0, segundos = 0;
        String hora = "", min = "", seg = "";

        try {
            while (activo) {
                Thread.sleep(1000);
                
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
               
                cambioTiempo(hora, min, seg);

                if (this.tiempo.equals(this.tiempoSalida)) {
                    pararTiempo();
                    JOptionPane.showMessageDialog(null, "Se termino el tiempo");
                }
            }
        } catch (Exception e) {
        };
    }
    
    private Integer aumentarSegundos(Integer segundos){
        return segundos + 1;
    }
    
    private void pararTiempo() {
        this.activo = false;
    }

    private void cambioTiempo(String hora, String min, String seg) {
         System.out.println(hora + ":" + min + ":" + seg);
         this.tiempo = hora + ":" + min + ":" + seg;
         notificarObservadores();
    }
    
     public void agregar(Observador obs) {
        System.out.println(obs.toString());
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
            observer.Actualizar(this.tiempo);
        }
    }

}
