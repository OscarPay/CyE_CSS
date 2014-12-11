/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Oscar
 */
public class RegistroXbox {

    private int idXbox = 0;
    private int numComtroles = 0;
    private String tiempoSolicitado = "";
    private String horaEntrada = null;
    private String horaSalida = null;
    private String precio = "";
    private boolean ocupado = false;

    private Temporizador temporizador = null;
    private CalculadoraPrecios calculadoraPrecio = null;

    public RegistroXbox(int idXbox, int numControles, String tiempoSolicitado,
            String horaEntrada, Temporizador temp, CalculadoraPrecios calcu) {
        this.idXbox = idXbox;
        this.numComtroles = numControles;
        this.tiempoSolicitado = tiempoSolicitado;
        this.horaEntrada = horaEntrada;
        this.ocupado = true;
        this.temporizador = temp;
        this.calculadoraPrecio = calcu;
    }

    public CalculadoraPrecios getCalculadoraPrecio() {
        return calculadoraPrecio;
    }

    public int getNumComtroles() {
        return numComtroles;
    }

    public Temporizador getTemporizador() {
        return temporizador;
    }

    public int getIdXbox() {
        return idXbox;
    }

    public void setIdXbox(int idXbox) {
        this.idXbox = idXbox;
    }

    public String getTiempoSolicitado() {
        return tiempoSolicitado;
    }

    public void setTiempoSolicitado(String tiempoSolicitado) {
        this.tiempoSolicitado = tiempoSolicitado;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }    

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
