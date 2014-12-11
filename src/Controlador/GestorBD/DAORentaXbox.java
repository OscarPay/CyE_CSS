/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import Modelo.RentaComputadora;
import Modelo.RentaXbox;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class DAORentaXbox extends DAOBD{
    
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
    
    
    public ArrayList<RentaXbox> obtenerValoresPorFechas(Date fechaInicio,
                                                        Date fechaFinal) throws SQLException{
        ArrayList<RentaXbox> rentas = new ArrayList();
        
        String consulta = "SELECT * FROM rentas WHERE ( fecha BETWEEN '"+ 
                fechaInicio + "'  AND '"+ fechaFinal + "') AND "+
                "tipo_maquina = 'Xbox'";
        
        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet result = sentencia.executeQuery(consulta);
        
        while(result.next()){
            int id = result.getInt("no_maquina");
            int noControles = result.getInt("no_controles");
            String horaEntrada = result.getString("hora_entrada");
            String horaSalida = result.getString("hora_salida");
            String tiempoTranscurrido = result.getString("tiempo_transcurrido");
            String precio = result.getString("precio");
            Date fecha =result.getDate("fecha");
            
            RentaXbox renta = new RentaXbox(id,noControles,horaEntrada,
                                            horaSalida,tiempoTranscurrido,precio,fecha);

            rentas.add(renta);
        }
        
        sentencia.close();
        
        return rentas;
    }
}
