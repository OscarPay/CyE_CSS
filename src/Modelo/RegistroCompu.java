/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Oscar
 */
public class RegistroCompu {

    private int idCompu = 0;
    private String tiempoSolicitado = "";
    private Date tiempoEntrada = null;
    private Date tiempoSalida = null;
    private Double precio = 0.00;
    private boolean ocupado = false;

    private Temporizador temporizador = null;
    private CalculadoraPrecios calculadoraPrecio = null;

    public RegistroCompu(int idCompu, String tiempoSolicitado, Temporizador temp, CalculadoraPrecios calcu) {
        this.idCompu = idCompu;
        this.tiempoSolicitado = tiempoSolicitado;
        this.tiempoEntrada = new Date();
        this.ocupado = true;
        this.temporizador = temp;                
        this.calculadoraPrecio = calcu;                
    }

    public Temporizador getTemporizador() {
        return temporizador;
    }
    
    public String getTiempoTranscurrido(){
        return temporizador.getTiempoTranscurrido();
    }

    public int getIdCompu() {
        return idCompu;
    }

    public void setIdCompu(int idCompu) {
        this.idCompu = idCompu;
    }

    public String getTiempoSolicitado() {
        return tiempoSolicitado;
    }

    public void setTiempoSolicitado(String tiempoSolicitado) {
        this.tiempoSolicitado = tiempoSolicitado;
    }

    public Date getTiempoEntrada() {
        return tiempoEntrada;
    }

    public String getTiempoEntradaString() {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(tiempoEntrada);
    }

    public void setTiempoEntrada(Date tiempoEntrada) {
        this.tiempoEntrada = tiempoEntrada;
    }

    public Date getTiempoSalida() {
        return tiempoSalida;
    }

    public void setTiempoSalida(Date tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
