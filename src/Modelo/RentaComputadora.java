/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Oscar
 */
public class RentaComputadora {

    private int idCompu = 0;
    private String precio = "";
    private String horaEntrada = "";
    private String horaSalida = "";
    private String tiempoTranscurrido = "";
    private String fecha = "";
    
    public static final String COMPUTADORA = "Computadora";

    public RentaComputadora(int idCompu, String precio, String horaEntrada,
            String horaSalida, String tiempoTranscurrido, String fecha) {
        this.idCompu = idCompu;
        this.precio = precio;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tiempoTranscurrido = tiempoTranscurrido;
        this.fecha = fecha;
    }

    public int getIdComp() {
        return idCompu;
    }

    public String getPrecio() {
        return precio;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }   

    public String getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }    

    public String getFecha() {
        return fecha;
    }    

    @Override
    public String toString() {
        System.out.println("Computadora");
        String datos = "id: " + idCompu + "\n"
                + "precio: " + precio + "\n"
                + "hora entrada: " + horaEntrada + "\n"
                + "hora salida: " + horaSalida + "\n"
                + "tiempo Transcurrido: " + tiempoTranscurrido + "\n"
                + "fecha: " + fecha;
        return datos;
    }

}
