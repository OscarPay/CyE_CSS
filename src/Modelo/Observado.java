/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class Observado {

    private static final Observado INSTANCE = new Observado();
    private final ArrayList<Observador> observadores = new ArrayList<>();

    public static Observado getINSTANCE() {
        return INSTANCE;
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

    public void notificarObservadoresTiempo(String tiempoTranscurrido, int numero, String maquina) {
        for (Observador obs : observadores) {
            Observador observer = (Observador) obs;
            observer.actualizarTiempo(tiempoTranscurrido, numero, maquina);
        }
    }

    public void notificarObservadoresPrecio(String precioTotal, int numero, String maquina) {       
        for (Observador obs : observadores) {
            Observador observer = (Observador) obs;
            observer.actualizarPrecio(precioTotal, numero, maquina);
        }
    }

}
