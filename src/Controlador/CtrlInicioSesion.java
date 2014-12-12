/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.InicioSesion;
import Vista.MenuPrincipal;
import Vista.MenuUsr;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Oscar
 */
public class CtrlInicioSesion {

    CtrlUsuario ctrlUsuario = new CtrlUsuario();   
    
    public void mostrarMenuPrincipal(JFrame ventana) {
        MenuPrincipal.getINSTANCE().setVisible(true);
        ventana.dispose();
    }
    
    public void mostrarVentanaRegistrarse(){
        MenuUsr menuUsr = new MenuUsr();
        menuUsr.setVisible(true);
        desactivarBotonesVentanaRegistrarse();
    }

    public boolean existeUsuario(String usuario, String correo) {
        ArrayList<Usuario> listaUsuarios = ctrlUsuario.buscarUsuarios();
        boolean existe = false;
        for (Usuario usr : listaUsuarios) {
            if (usr.getNombreUsuario().equals(usuario)) {
                if (usr.getCorreo().equals(correo)) {
                    return true;
                }
            }
        }
        return existe;
    }

    public void limpiarCampos() {
        InicioSesion.tfUsuario.setText("");
        InicioSesion.tfCorreo.setText("");
    }

    private void desactivarBotonesVentanaRegistrarse() {
        MenuUsr.btnBuscar.setEnabled(false);
        MenuUsr.btnEditar.setEnabled(false);
        MenuUsr.btnListaUsr.setEnabled(false);
    }

    public void verificarTipoUsuario(String correo) throws SQLException {
        Usuario usuario = ctrlUsuario.buscarUsuario(correo);
        if(usuario.getTipoUsuario().equals("Encargado")){
            desactivarPestañasMenuPrincipal(false); 
        }else{
            desactivarPestañasMenuPrincipal(true);
        }
    }

    private void desactivarPestañasMenuPrincipal(boolean activo) {
        MenuPrincipal.tpPestañas.setEnabledAt(2, activo);
    }

}
