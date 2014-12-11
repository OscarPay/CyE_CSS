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
public class RentaXbox {

    private int idXbox = 0;
    private int numControles = 0;
    private String horaEntrada = "";
    private String horaSalida = "";
    private String tiempoTranscurrido = "";
    private String precio = "";
    private String fecha = "";
    
    public static final String XBOX = "Xbox";

    public RentaXbox(int id, int numControles, String horaEntrada, String horaSalida, 
            String tiempoTranscurrido, String precio, String fecha) {
        this.idXbox = id;
        this.numControles = numControles;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tiempoTranscurrido = tiempoTranscurrido;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getIdXbox() {
        return idXbox;
    }

    public int getNumControles() {
        return numControles;
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

    public String getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }    

    @Override
    public String toString() {
        System.out.println("Xbox");
        String datos = "id: " + idXbox + "\n"
                + "Controles: " + numControles + "\n"
                + "precio: " + precio + "\n"
                + "hora entrada: " + horaEntrada + "\n"
                + "hora salida: " + horaSalida + "\n"
                + "tiempo Transcurrido: " + tiempoTranscurrido + "\n"
                + "fecha: " + fecha;
        return datos;
    }

}
