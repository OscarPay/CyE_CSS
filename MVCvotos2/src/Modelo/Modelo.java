/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
 
import Patrones.Observer;


/**
 *
 * @author A09003539
 */
public abstract class Modelo{
    
    private int Datos;   
    
    public abstract void agregar(Observer obs);
    public abstract void eliminar(Observer obs);
    public abstract void obtenerDatos();
    public abstract void servicio();
    
    
}
