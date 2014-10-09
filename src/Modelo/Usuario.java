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
    
    String g_nombreUsuario;
    String g_telefono;
    String g_correo;
    String g_clave;
    String g_tipoUsuario;

    public Usuario(String nombreUsuario, String telefono, 
                    String correo, String clave, String tipo) {
        
        g_nombreUsuario = nombreUsuario;
        g_telefono = telefono;
        g_correo = correo;
        g_clave = clave;
        g_tipoUsuario = tipo;
        
    }    

    public String getNombreUsuario() {
        return g_nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        g_nombreUsuario = nombreUsuario;
    }

    public String getTelefono() {
        return g_telefono;
    }

    public void setTelefono(String telefono) {
        g_telefono = telefono;
    }

    public String getCorreo() {
        return g_correo;
    }

    public void setCorreo(String correo) {
        g_correo = correo;
    }

    public String getClave() {
        return g_clave;
    }

    public void setClave(String clave) {
        g_clave = clave;
    }

    public String getTipoUsuario() {
        return g_tipoUsuario;
    }

    public void setTipoUsuario(String tipo) {
        g_tipoUsuario = tipo;
    }  
    
}