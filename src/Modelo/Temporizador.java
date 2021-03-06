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
public final class Temporizador extends Thread {

    private String tiempoTranscurrido = "";
    private String tiempoSolicitado = "";

    private String tipoMaquina = "";
    private int idMaquina = 0;
    private boolean activo = true;
    private Observado observado = null;

    public Temporizador(int numMaquina, String tiempoSolicitado, String tipoMaquina) {
        this.tiempoSolicitado = tiempoSolicitado;
        this.observado = Observado.getINSTANCE();
        this.idMaquina = numMaquina;
        this.tipoMaquina = tipoMaquina;
    }

    public String getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public void agregarTiempoSolicitado(String tiempoSolicitado) {
        this.tiempoSolicitado = tiempoSolicitado;
    }  

    public void setActivo(boolean activo) {
        this.activo = activo;
    }    

    public boolean isActivo() {
        return activo;
    }

    public boolean desactivar() {
        return this.activo = false;
    }

    public Observado getObservado() {
        return observado;
    }

    @Override
    public void run() {
        try {
            avanzarTiempo();
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void avanzarTiempo() throws InterruptedException {
        Integer horas = 0, minutos = 0, segundos = 0;
        while (activo) {

            segundos = aumentarSegundos(segundos);

            if (segundos == 60) {
                segundos = 0;
                minutos++;
            }            
            if (minutos == 60) {
                minutos = 0;
                horas++;
            }

            convertirTiempoString(horas, minutos, segundos);
            verificarTiempo();
        }
    }

    private void verificarTiempo() {
        if (tiempoTranscurrido.equals(tiempoSolicitado)) {
            desactivar();
            
            JOptionPane.showMessageDialog(null, "Se termino el tiempo de: " + tipoMaquina + " " + idMaquina);
        }
    }

    private Integer aumentarSegundos(Integer segundos) throws InterruptedException {
        Thread.sleep(1000);
        segundos++;
        return segundos;
    }

    private void convertirTiempoString(Integer horas, Integer minutos, Integer segundos) {
        String hora, min, seg;

        hora = convertirHorasString(horas);
        min = convertirMinutosString(minutos);
        seg = convertirSegundosString(segundos);

        actualizarTiempoTranscurrido(hora, min, seg);
    }

    private String convertirSegundosString(Integer segundos) {
        String seg;
        if (segundos < 10) {
            seg = "0" + segundos;
        } else {
            seg = segundos.toString();
        }
        return seg;
    }

    private String convertirMinutosString(Integer minutos) {
        String min;
        if (minutos < 10) {
            min = "0" + minutos;
        } else {
            min = minutos.toString();
        }
        return min;
    }

    private String convertirHorasString(Integer horas) {
        String hora;
        if (horas < 10) {
            hora = "0" + horas;
        } else {
            hora = horas.toString();
        }
        return hora;
    }

    private void actualizarTiempoTranscurrido(String hora, String min, String seg) {
        tiempoTranscurrido = hora + ":" + min + ":" + seg;
        observado.notificarObservadoresTiempo(tiempoTranscurrido, idMaquina, tipoMaquina);
    }

}
