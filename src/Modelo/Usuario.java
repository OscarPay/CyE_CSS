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
public abstract class Usuario {
    String nombreUsuario;
    String telefono;
    String correo;
    String clave;

    public Usuario(String nombreUsuario, String telefono, String correo, String clave) {
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }    
    
}