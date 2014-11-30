/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controlador.LogicaNegocios.AdminRegistrosCompu;
import Controlador.LogicaNegocios.AdminRegistrosXbox;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class CalculadoraPrecios extends Thread {    
    
     private int idMaquina = 0;
    private String maquina = "";
    private String precioTotal;
    private double precioBase = 0;

    private Temporizador temporizador = null;
    private Observado observado = null;

    public CalculadoraPrecios(Temporizador temporizador, int idMaquina, String tipoMaquina, int numControles) {
        this.temporizador = temporizador;
        this.idMaquina = idMaquina;
        this.maquina = tipoMaquina;
        this.observado = Observado.getINSTANCE();
        this.precioBase = ListaPrecios.getPrecioBase(tipoMaquina, numControles);
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public void run() {
        //la funcion start() de la clase Thread ejecuta a run() como un hilo
        calcularPrecio();
    }

    public void calcularPrecio() {

        DecimalFormat formatoPrecio = new DecimalFormat();
        Double precioSegundo = 0.00;
        String precioRedondeado = "";

        try {

            while (temporizador.isActivo()) {
                Thread.sleep(1000);
                precioSegundo += precioBase / 3600;
                precioRedondeado = formatoPrecio.format(precioSegundo);
                precioTotal = precioRedondeado;
                cambioPrecio(precioRedondeado);
            }

            notificarAdmin();

        } catch (InterruptedException ex) {

            JOptionPane.showMessageDialog(null, "Error, en calcula precios");

        }
    }

    private void cambioPrecio(String precioRedondeado) {
        observado.notificarObservadoresPrecio(precioRedondeado, idMaquina, maquina);
    }

    private void notificarAdmin() {
        JOptionPane.showMessageDialog(null, "Precio: " + precioTotal + "Tiempo: " + temporizador.getTiempoTranscurrido());
        switch (maquina) {
            case "Computadora":
                AdminRegistrosCompu.crearRentaCompu(idMaquina);
                break;
            case "Xbox":
                AdminRegistrosXbox.crearRentaXbox(idMaquina);
                break;

        }

    }
    
}
