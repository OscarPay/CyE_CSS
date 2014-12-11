/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import Modelo.RentaComputadora;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author x
 */
public class DAORentaCompu extends DAOBD {

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
    
    public ArrayList<RentaComputadora> obtenerValoresPorFechas(Date fechaInicio,
                                                                Date fechaFinal) throws SQLException{
        ArrayList<RentaComputadora> rentas = new ArrayList();
        
        String consulta = "SELECT * FROM rentas WHERE ( fecha BETWEEN '"+ 
                fechaInicio + "'  AND '"+ fechaFinal + "') AND "+
                "tipo_maquina = 'Computadora'";
        
        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet result = sentencia.executeQuery(consulta);
        
        while(result.next()){
            int id = result.getInt("no_maquina");
            String precio = result.getString("precio");
            String horaEntrada = result.getString("hora_entrada");
            String horaSalida = result.getString("hora_salida");
            String tiempoTranscurrido = result.getString("tiempo_transcurrido");
            Date fecha =result.getDate("fecha");
            
            RentaComputadora renta = new RentaComputadora(id,precio,horaEntrada,
                                            horaSalida,tiempoTranscurrido,fecha);

            rentas.add(renta);
        }
        
        sentencia.close();
        
        return rentas;
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

        DAORentaCompu dao = new DAORentaCompu();
        dao.establecerConexion();
        
        Date fecha = new Date(2014,12,12);
        
        RentaComputadora renta = new RentaComputadora(1, "5.00", "6:17:00", "6:20:00", "00:03:00", fecha);
        System.out.println(renta.toString());
        try {
            dao.agregarRenta(renta);
        } catch (SQLException ex) {
            Logger.getLogger(DAORentaCompu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
