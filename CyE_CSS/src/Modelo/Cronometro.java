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
public class Cronometro {

    String tiempo;
    String tiempodeparo;
    boolean activo = true;

    public Cronometro(String tiempodeparo) {
        this.tiempodeparo = tiempodeparo;
    }

    public void comenzarTiempo() throws InterruptedException {
        Integer minutos = 0, segundos = 0, milesimas = 0;
        String min = "", seg = "", mil = "";

        try {
            while (activo) {
                Thread.sleep(100);
                milesimas += 100;

                if (milesimas == 1000) {
                    milesimas = 0;
                    segundos += 1;

                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
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

                if (milesimas < 10) {
                    mil = "00" + milesimas;
                } else {
                    if (milesimas < 100) {
                        mil = "0" + milesimas;
                    } else {
                        mil = milesimas.toString();
                    }
                }
                System.out.println(min + ":" + seg + ":" + mil);
                this.tiempo = min + ":" + seg + ":" + mil;

                if (this.tiempo.equals(this.tiempodeparo)) {
                    pararTiempo();
                    JOptionPane.showMessageDialog(null, "Se termino el tiempo");
                }
            }
        } catch (Exception e) {
        };
    }

    public void pararTiempo() {
        this.activo = false;
    }

}
