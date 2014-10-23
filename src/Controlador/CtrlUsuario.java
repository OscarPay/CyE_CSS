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
public class CtrlUsuario {

    GestorBDUsuario g_gestorUsr;

    public void agregarUsuario(Usuario usr) {
        g_gestorUsr = new GestorBDUsuario();
        g_gestorUsr.establecerConexion();

        try {

            g_gestorUsr.agregarUsuario(usr);

        } catch (SQLException ex) {

            ex.printStackTrace();

        }
    }

    public void editarUsuario(Usuario usr, String idusr) {

        g_gestorUsr = new GestorBDUsuario();
        g_gestorUsr.establecerConexion();

        try {

            g_gestorUsr.modificarUsuario(usr, idusr);

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

    }

    public Usuario buscarUsuario(String idusr) {

        g_gestorUsr = new GestorBDUsuario();
        g_gestorUsr.establecerConexion();

        try {

            return g_gestorUsr.buscarUsuario(idusr);

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return null;
    }

    public int determinarPermisoUsuario(Usuario usr) {

        g_gestorUsr = new GestorBDUsuario();
        g_gestorUsr.establecerConexion();

        try {
            
            return g_gestorUsr.obtenerTipoUsuario(usr.getTipoUsuario());
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        }
        return 1;
    }
}
