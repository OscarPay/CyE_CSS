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
    private Double precio = 0.0;
    private String tiempoEntrada = "";
    private String tiempoSalida = "";

    public RentaComputadora(int idCompu, Double precio, String tiempoEntrada, 
                             String tiempoSalida) {
        this.idCompu = idCompu;
        this.precio = precio;
        this.tiempoEntrada = tiempoEntrada;
        this.tiempoSalida = tiempoSalida;
    }

    public int getIdComp() {
        return idCompu;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getTiempoEntrada() {
        return tiempoEntrada;
    }

    public String getTiempoSalida() {
        return tiempoSalida;
    }
    
}
