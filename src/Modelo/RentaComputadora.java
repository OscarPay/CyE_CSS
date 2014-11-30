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
    private String tiempoEntrada = "";
    private String tiempoSalida = "";

    public RentaComputadora(int idCompu, String precio, String tiempoEntrada, 
                             String tiempoSalida) {
        this.idCompu = idCompu;
        this.precio = precio;
        this.tiempoEntrada = tiempoEntrada;
        this.tiempoSalida = tiempoSalida;
    }

    public int getIdComp() {
        return idCompu;
    }

    public String getPrecio() {
        return precio;
    }

    public String getTiempoEntrada() {
        return tiempoEntrada;
    }

    public String getTiempoSalida() {
        return tiempoSalida;
    }
    
    @Override
    public String toString(){
        System.out.println("Computadora");
        String datos = "id: "+idCompu+"\n"+
                       "precio: "+precio+"\n"+
                        "tiempo entrada: "+tiempoEntrada+"\n"+
                        "tiempo salida: "+tiempoSalida;
        return datos;
    }
    
    
}
