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
public class Usuario {
    
    String nombreUsuario;
    String telefono;
    String correo;
    String clave;
    String tipoUsuario;

    public Usuario(String nombreUsuario, String telefono, 
                    String correo, String clave, String tipo) {
        
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
        tipoUsuario = tipo;
        
    }    

    public Usuario() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipo) {
        tipoUsuario = tipo;
    }  
    
}