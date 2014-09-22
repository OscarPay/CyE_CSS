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
public class Encargado extends Usuario {
    Double sueldo;

    public Encargado(Double sueldo, String nombreUsuario, String telefono, String correo, String clave) {
        super(nombreUsuario, telefono, correo, clave);
        this.sueldo = sueldo;
    }    
    
}
