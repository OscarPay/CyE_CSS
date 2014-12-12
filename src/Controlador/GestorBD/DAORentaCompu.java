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
public class DAORentaCompu extends DAOBD<RentaComputadora> {

    private final String NO_MAQUINA = "no_maquina";
    private final String NO_CONTROLES = "no_controles";
    private final String TIPO_MAQUINA = "tipo_maquina";
    private final String HORA_ENTRADA = "hora_entrada";
    private final String HORA_SALIDA = "hora_salida";
    private final String TIEMPO_TRANSCURRIDO = "tiempo_transcurrido";
    private final String PRECIO = "precio";
    private final String FECHA = "fecha";

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
            Date fechaFinal) throws SQLException {
        ArrayList<RentaComputadora> rentas = new ArrayList();

        String consulta = "SELECT * FROM rentas WHERE ( fecha BETWEEN '"
                + fechaInicio + "'  AND '" + fechaFinal + "') AND "
                + "tipo_maquina = 'Computadora'";

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet result = sentencia.executeQuery(consulta);

        while (result.next()) {
            int id = result.getInt(this.NO_MAQUINA);      
            String horaEntrada = result.getString(this.HORA_ENTRADA);
            String horaSalida = result.getString(this.HORA_SALIDA);
            String tiempoTranscurrido = result.getString(this.TIEMPO_TRANSCURRIDO);
             String precio = result.getString(this.PRECIO);
            Date fecha = result.getDate(this.FECHA);

            RentaComputadora renta = new RentaComputadora(id, precio, horaEntrada,
                    horaSalida, tiempoTranscurrido, fecha);

            rentas.add(renta);
        }

        sentencia.close();

        return rentas;
    }

   


    @Override
    public boolean agregarElemento(RentaComputadora elemento) throws SQLException {
        boolean seAgregoRenta = false;

        if (true) {
            String consulta = this.armarConsultaInserta(elemento);

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);

            sentencia.close();

            seAgregoRenta = true;
        }
        return seAgregoRenta;
    }

    @Override
    public boolean modificarElemento(RentaComputadora elemento, String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarElemento(RentaComputadora elemento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RentaComputadora buscarElemento(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RentaComputadora> consultarElementos(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeElemento(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaInserta(RentaComputadora elemento) throws SQLException {
        String consulta = "INSERT INTO rentas (no_maquina,tipo_maquina,"
                + "hora_entrada,hora_salida,tiempo_transcurrido,"
                + "precio,fecha) VALUES"
                + " ('" + elemento.getIdComp() + "','"
                + RentaComputadora.COMPUTADORA + "','" //tipo maquina
                + elemento.getHoraEntrada() + "','"
                + elemento.getHoraSalida() + "','"
                + elemento.getTiempoTranscurrido() + "','"
                + elemento.getPrecio() + "','"
                + elemento.getFecha() + "')";
        return consulta;
    }

    @Override
    protected String armarConsultaUpdate(RentaComputadora elemento, String correousr) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaDelete(RentaComputadora elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaSelect(String condicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaSelects(String condicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
