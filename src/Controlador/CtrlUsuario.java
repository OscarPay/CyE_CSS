/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.GestorBD.DAOUsr;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abner
 */
public class CtrlUsuario {

    DAOUsr gestorUsr;

    public boolean agregarUsuario(String nombreUsuario, String telefono,
            String correo, String clave, String tipoUsuario) throws SQLException {
        
        Usuario usr = new Usuario(nombreUsuario, telefono, correo, clave, tipoUsuario);
        gestorUsr = new DAOUsr();
        gestorUsr.establecerConexion();

        return gestorUsr.agregarElemento(usr);

    }

    public boolean editarUsuario(String nombreUsuario, String telefono,
            String correo, String clave, String tipoUsuario) throws SQLException {
        
        gestorUsr = new DAOUsr();
        gestorUsr.establecerConexion();
        Usuario usr = new Usuario(nombreUsuario, telefono, correo, clave, tipoUsuario);
        
        return gestorUsr.modificarElemento(usr, correo);

    }

    public Usuario buscarUsuario(String correo) throws SQLException {
        gestorUsr = new DAOUsr();
        gestorUsr.establecerConexion();
        Usuario usrBD = null;

        usrBD = gestorUsr.buscarElemento(correo);

        return usrBD;
    }

    

    public ArrayList<Usuario> buscarUsuarios() {
        gestorUsr = new DAOUsr();
        gestorUsr.establecerConexion();

        try {
            return gestorUsr.consultarElementos(null);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void llenarListaUsr(JTable tableUsr) {
        ArrayList<Usuario> listaUsr = new ArrayList<>();
        listaUsr = this.buscarUsuarios();
        DefaultTableModel modelo;
        Usuario usrTemp;

        for (Usuario listaUsr1 : listaUsr) {
            usrTemp = listaUsr1;
            String nombreUsr = usrTemp.getNombreUsuario();
            String tipoUsr = usrTemp.getTipoUsuario();
            String telefonoUsr = usrTemp.getTelefono();
            String correoUsr = usrTemp.getCorreo();
            String[] datosProduc = {nombreUsr,correoUsr,telefonoUsr,tipoUsr };
            modelo = (DefaultTableModel) tableUsr.getModel();
            modelo.addRow(datosProduc);
        }

    }    
}
