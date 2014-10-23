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

    }

    public void comenzarTemp() {
        //la funcion start() de la clase Thread ejecuta a run() como un hilo
        start();
    }

    @Override
    public void run() {
        Integer horas = 0, minutos = 0, segundos = 0;
        try {
            while (isActivo()) {

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
                
                convertirTiempoString(horas, minutos, segundos);

                if (tiempoTranscurrido.equals(tiempoParo)) {
                    pararTemp();
                    JOptionPane.showMessageDialog(null, "Se termino el tiempo");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        };
    }

    private Integer aumentarSegundos(Integer segundos) throws InterruptedException {
        Thread.sleep(1000); //Esperar un segundo
        return segundos + 1;
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

        this.actualizarTiempoTranscurrido(hora, min, seg); //Indica al observador que se modifico el tiempo
    }

    private void pararTemp() {
        activo = false;
    }

    public boolean isActivo() {
        return activo;
    }

    private void actualizarTiempoTranscurrido(String hora, String min, String seg) {

        tiempoTranscurrido = hora + ":" + min + ":" + seg;
        observado.notificarObservadoresTiempo(tiempoTranscurrido,
                idMaquina, tipoMaquina);

    }

    public Observado getObservado() {
        return observado;
    }

    public void aumentarTiempoParo(String tiempoParo) {
        this.tiempoParo = tiempoParo;
    }

}
