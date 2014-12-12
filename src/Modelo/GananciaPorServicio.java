/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author hyuchiha
 */
public class GananciaPorServicio {
    private String producto;
    private int ganancia;
    
    public GananciaPorServicio(String producto, int ganancia) {
        this.producto = producto;
        this.ganancia = ganancia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }
    
    
}
