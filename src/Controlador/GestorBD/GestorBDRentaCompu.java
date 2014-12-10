/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import Modelo.RentaComputadora;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author x
 */
public class GestorBDRentaCompu extends GestorBD {

    public boolean agregarRenta(RentaComputadora renta) throws SQLException {
        boolean seAgregoRenta = false;

        if (true) {
            String consulta = "INSERT INTO rentas (no_maquina,tipo_maquina,"
                    + "hora_entrada,hora_salida,tiempo_transcurrido,"
                    + "precio,fecha) VALUES"
                    + " ('" + renta.getIdComp() + "','"                    
                    + RentaComputadora.COMPUTADORA + "','" //tipo maquina
                    + renta.getHoraEntrada() + "','"
                    + renta.getHoraSalida() + "','"
                    + renta.getTiempoTranscurrido() + "','"
                    + renta.getPrecio() + "','"
                    + renta.getFecha() + "')";

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);

            sentencia.close();

            seAgregoRenta = true;
        }
        return seAgregoRenta;
    }

    /*
    public boolean modificarRenta(RentaComputadora renta, int id) throws SQLException {
        boolean seEditoRenta = false;
        if (this.existeRenta(id)) {
            
            String consulta = "UPDATE rentas SET "
                    + "no_maquina='" + renta.getIdComp() + "',"
                    + "no_controles='" + "1" + "',"
                    + "tipo_maquina='" + "Computadora" + "',"
                    + "hora_entrada='" + renta.getHoraEntrada() + "',"
                    + "hora_salida='" + renta.getHoraSalida() + "'"
                    + "tiempo_transcurrido='" + renta.getTiempoTranscurrido() + "'"
                    + "precio='" + renta.getPrecio() + "'"
                    + "fecha='" + renta.getFecha() + "'"
                    + "WHERE Id_Produc='" + id + "'";

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);

            sentencia.close();
            seEditoRenta = true;
        }

        return seEditoRenta;
    }
     */
    public static void main(String[] args) {

        GestorBDRentaCompu dao = new GestorBDRentaCompu();
        dao.establecerConexion();
        RentaComputadora renta = new RentaComputadora(1, "5.00", "6:17:00", "6:20:00", "00:03:00", "10/december/2014");
        System.out.println(renta.toString());
        try {
            dao.agregarRenta(renta);
        } catch (SQLException ex) {
            Logger.getLogger(GestorBDRentaCompu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
