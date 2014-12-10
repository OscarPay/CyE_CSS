/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import Modelo.RentaXbox;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Oscar
 */
public class GestorBDRentaXbox extends GestorBD{
    
    public boolean agregarRenta(RentaXbox renta) throws SQLException {
        boolean seAgregoRenta = false;

        if (true) {
            String consulta = "INSERT INTO rentas (no_maquina,no_controles,"
                    + "tipo_maquina,hora_entrada,hora_salida,tiempo_transcurrido,"
                    + "precio,fecha) VALUES"
                    + " ('" + renta.getIdXbox() + "','"
                    + renta.getNumControles() + "','" //num controles
                    + RentaXbox.XBOX + "','" //tipo maquina
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
}
