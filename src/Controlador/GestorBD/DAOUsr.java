/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abner
 */
public class DAOUsr extends DAOBD<Usuario> {

    private final String Nombre = "Nombre_Usr";
    private final String Correo = "Correo_Usr";
    private final String Contrasena = "Contrasena_Usr";
    private final String Telefono = "Telefono_Usr";
    private final String Tipo = "Tipo_Usr";
    /*
     La funcion recibe un usuario, checa si existe, si existe el Usuario lo 
     modifica con los nuevos datos, si no existe lo agrega. 
     */

    @Override
    public boolean agregarElemento(Usuario usr) throws SQLException {
        boolean usrAgregado = false;
        if (!this.existeElemento(usr.getCorreo())) {

            String consulta = this.armarConsultaInserta(usr);

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);
            sentencia.close();

            usrAgregado = true;
        }
        return usrAgregado;
    }

    @Override
    public boolean modificarElemento(Usuario usr, String correousr) throws SQLException {
        boolean seModificoUsr = false;
        if (this.existeElemento(usr.getCorreo())) {

            String consulta = this.armarConsultaUpdate(usr, correousr);

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);
            sentencia.close();

            seModificoUsr = true;
        }

        return seModificoUsr;

    }

    @Override
    public void eliminarElemento(Usuario usuario) throws SQLException {

        String consulta = this.armarConsultaDelete(usuario);

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        sentencia.executeUpdate(consulta);
        sentencia.close();

    }

    @Override
    public Usuario buscarElemento(String condicion) throws SQLException {

        String consulta = this.armarConsultaSelect(condicion);

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet busqueda = sentencia.executeQuery(consulta);

        Usuario usr = new Usuario();
        while (busqueda.next()) {
            String nombre = busqueda.getString(this.Nombre);
            String telefono = busqueda.getString(this.Telefono);
            String correo = busqueda.getString(this.Correo);
            String clave = busqueda.getString(this.Contrasena);
            String tipousr = busqueda.getString(this.Tipo);

            usr = new Usuario(nombre, telefono, correo, clave, tipousr);
        }
        sentencia.close();

        return usr;

    }

    public ArrayList<Usuario> consultarElementos(String condicion) throws SQLException {
        String consulta = this.armarConsultaSelects(condicion);

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet busqueda = sentencia.executeQuery(consulta);

        Usuario usrTemp;
        ArrayList<Usuario> listaUsr = new ArrayList<Usuario>();
        while (busqueda.next()) {
            String nombre = busqueda.getString(this.Nombre);
            String telefono = busqueda.getString(this.Telefono);
            String correo = busqueda.getString(this.Correo);
            String clave = busqueda.getString(this.Contrasena);
            String tipousr = busqueda.getString(this.Tipo);

            usrTemp = new Usuario(nombre, telefono, correo, clave, tipousr);
            listaUsr.add(usrTemp);
        }

        return listaUsr;
    }

    public boolean existeElemento(String condicion) throws SQLException {
        boolean existeUsr = false;
        String consulta = this.armarConsultaSelect(condicion);

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet busqueda = sentencia.executeQuery(consulta);
        if (busqueda.next()) {
            existeUsr = true;
        }
        return existeUsr;

    }

    protected String armarConsultaUpdate(Usuario elemento, String correousr) throws SQLException {
        String consulta = "UPDATE usuarios SET "
                + this.Nombre+"='" + elemento.getNombreUsuario() + "',"
                + this.Telefono+"='" + elemento.getTelefono() + "',"
                + this.Correo+"='" + elemento.getCorreo() + "',"
                + Contrasena+"='" + elemento.getClave() + "',"
                + this.Tipo+"='" + elemento.getTipoUsuario() + "'"
                + "WHERE "+this.Correo+"='" + correousr + "'";

        return consulta;
    }

    protected String armarConsultaDelete(Usuario usuario) {
        String consulta = "DELETE FROM usuarios WHERE "+this.Nombre+"='"
                + usuario.getNombreUsuario() + "' or "+ this.Correo+"='"
                + usuario.getCorreo() + "'";
        return consulta;
    }

    protected String armarConsultaSelect(String condicion) {
        String consulta = "SELECT usuarios."+this.Nombre+", usuarios."+this.Telefono+","
                + "usuarios."+this.Correo+", usuarios."+this.Contrasena+","
                + " usuarios."+this.Tipo+"\n"
                + "FROM usuarios "
                + "WHERE "+this.Correo+"='" 
                + condicion + "'";
        return consulta;

    }

    protected String armarConsultaSelects(String condicion) {
        String consulta = "SELECT * FROM scc.usuarios";

        if (condicion != null) {
            consulta += condicion;
        }

        return consulta;
    }

    @Override
    protected String armarConsultaInserta(Usuario elemento) throws SQLException {

        String consulta = "INSERT INTO usuarios ("+this.Nombre+","
                + ""+this.Correo+","
                + ""+this.Contrasena+","
                + ""+this.Telefono+","
                + ""+this.Tipo+") "
                + "values "
                + "('" + elemento.getNombreUsuario()
                + "','" + elemento.getCorreo()
                + "','" + elemento.getClave() 
                + "','" + elemento.getTelefono()
                + "','" + elemento.getTipoUsuario() + "')";

        return consulta;
    }

   
}
