/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class RentaXbox{  
    
    private int idXbox = 0;
    private int numControles = 0;
    private String tiempoEntrada = "";
    private String tiempoSalida = "";    
    private String precio = "";    

    public RentaXbox(int id, int numControles, String tiempoEntrada, String tiempoSalida, String precio) {
        this.idXbox=id;
        this.numControles=numControles;
        this.tiempoEntrada=tiempoEntrada;
        this.tiempoSalida=tiempoSalida;
        this.precio=precio;
    }    

    @Override
    public String toString(){
        System.out.println("Xbox");
        String datos = "id: "+idXbox+"\n"+
                "Controles: "+numControles+"\n"+
                "precio: "+precio+"\n"+
                "tiempo entrada: "+tiempoEntrada+"\n"+
                        "tiempo salida: "+tiempoSalida;
        return datos;
    }
    
    
}
