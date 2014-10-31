/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public final class Temporizador extends Thread {

    private String tiempoTranscurrido = "";
    private String tiempoParo = "";
    private String tipoMaquina = "";

    private int idMaquina = 0;
    private boolean activo = true;
    private Observado observado = null;

    public Temporizador(String tiempoSalida, int numMaquina, String tipoMaquina) {

        this.tiempoParo = tiempoSalida;
        this.observado = Observado.getINSTANCE();
        this.idMaquina = numMaquina;
        this.tipoMaquina = tipoMaquina;
        start();
    }

    public boolean isActivo() {
        return activo;
    }
    
    public boolean desactivar(){
        return this.activo = false;
    }

    public Observado getObservado() {
        return observado;
    }    
    
    public void run(){
        try {
            comenzarTiempo();
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comenzarTiempo() throws InterruptedException {
        Integer horas = 0, minutos = 0, segundos = 0;
        while (isActivo()) {
            
            segundos = aumentarSegundos(segundos);

            if (segundos == 60) {
                segundos = 0;
                minutos++;
                if (minutos == 60) {
                    minutos = 0;
                    horas++;
                } //fin if
            }//fin if
            
            convertirTiempoString(horas, minutos, segundos);
            verificarTiempo();
        } //fin while        
    }

    private void verificarTiempo(){
        if (tiempoTranscurrido.equals(tiempoParo)) {
            desactivar();
            JOptionPane.showMessageDialog(null, "Se termino el tiempo");
        }
    }

    private Integer aumentarSegundos(Integer segundos) throws InterruptedException {
        Thread.sleep(1000);
        segundos++;
        return segundos;
    }
    
    private void convertirTiempoString(Integer horas, Integer minutos, Integer segundos) {
        String hora = "", min = "", seg = "";
        
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

        actualizarTiempoTranscurrido(hora, min, seg);
    }

    private void actualizarTiempoTranscurrido(String hora, String min, String seg) {
        tiempoTranscurrido = hora+":"+min+":"+seg;
        observado.notificarObservadoresTiempo(tiempoTranscurrido, idMaquina, tipoMaquina);
    }

}
