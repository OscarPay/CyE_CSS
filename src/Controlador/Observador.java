/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

/**
 *
 * @author Oscar
 */
public interface Observador {
    
    public abstract void actualizarTiempo(String tiempo, int numLabel, String equipo);
    public abstract void actualizarPrecio(String precio, int numLabel, String equipo);
    
}
