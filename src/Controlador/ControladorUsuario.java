/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Controlador.GestorBD.GestorBDUsuario;
import Modelo.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Abner
 */
public class ControladorUsuario {
    GestorBDUsuario gestorUsr;
    
    public void agregarUsuario(Usuario usr) {
        gestorUsr=new GestorBDUsuario();
        gestorUsr.establecerConexion();
            
        try {
            gestorUsr.agregarUsuario(usr);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void editarUsuario(Usuario usr, String idusr){
        gestorUsr=new GestorBDUsuario();
        gestorUsr.establecerConexion();
            
        try {
            gestorUsr.modificarUsuario(usr, idusr);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public Usuario buscarUsuario(String idusr){
        gestorUsr=new GestorBDUsuario();
        gestorUsr.establecerConexion();
            
        try {
            return gestorUsr.buscarUsuario(idusr);
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public int determinarPermisoUsuario(Usuario usr){
         gestorUsr=new GestorBDUsuario();
            gestorUsr.establecerConexion();
            
            try {
            return gestorUsr.obtenerTipoUsuario(usr.getTipoUsuario());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return 1;
    }
}
