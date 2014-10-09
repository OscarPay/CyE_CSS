/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abner
 */
public abstract class GestorBD {

    private final String g_host = "localhost";
    private final String g_puerto = "666";
    private final String g_usuario = "root";
    private final String g_contrasena = "renba";
    private final String g_nombreBD = "scc";
    Connection g_conexion = null;

    public void establecerConexion() {

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            g_conexion = this.obtenerConexion(g_puerto, g_usuario,
                    g_contrasena);

        } catch (Exception ex) {// handle the error

            System.out.println("SQLException: " + ex.getMessage());

        }

    }

    private Connection obtenerConexion(String puerto, String usuario, String contrasena) throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://" + g_host + ":" + puerto + "/" + g_nombreBD,
                usuario, contrasena);

    }

    public void cerrarConexion(Connection con) {
        try {

            if (con != null) {
                if (!con.isClosed()) { // Si no esta cerrada, se cierra
                    con.close();
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

}
