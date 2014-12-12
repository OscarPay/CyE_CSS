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
public class DAORentaXbox extends DAOBD<RentaXbox> {
      private final String NO_MAQUINA = "no_maquina";
    private final String NO_CONTROLES = "no_controles";
    private final String TIPO_MAQUINA = "tipo_maquina";
    private final String HORA_ENTRADA = "hora_entrada";
    private final String HORA_SALIDA = "hora_salida";
    private final String TIEMPO_TRANSCURRIDO = "tiempo_transcurrido";
    private final String PRECIO = "precio";
    private final String FECHA = "fecha";
    

    public boolean agregarRenta(RentaXbox renta) throws SQLException {
        boolean seAgregoRenta = false;

        if (true) {
            String consulta = this.armarConsultaInserta(renta);

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);

            sentencia.close();

            seAgregoRenta = true;
        }
        return seAgregoRenta;
    }

    public ArrayList<RentaXbox> obtenerValoresPorFechas(Date fechaInicio,
            Date fechaFinal) throws SQLException {
        ArrayList<RentaXbox> rentas = new ArrayList();

        String consulta = "SELECT * FROM rentas WHERE ( fecha BETWEEN '"
                + fechaInicio + "'  AND '" + fechaFinal + "') AND "
                + "tipo_maquina = 'Xbox'";

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet result = sentencia.executeQuery(consulta);

        while (result.next()) {
            int id = result.getInt(this.NO_MAQUINA);
            int noControles = result.getInt(this.NO_CONTROLES);
            String horaEntrada = result.getString(this.HORA_ENTRADA);
            String horaSalida = result.getString(this.HORA_SALIDA);
            String tiempoTranscurrido = result.getString(this.TIEMPO_TRANSCURRIDO);
            String precio = result.getString(this.PRECIO);
            Date fecha = result.getDate(this.FECHA);

            RentaXbox renta = new RentaXbox(id, noControles, horaEntrada,
                    horaSalida, tiempoTranscurrido, precio, fecha);

            rentas.add(renta);
        }

        sentencia.close();

        return rentas;
    }

    @Override
    public boolean agregarElemento(RentaXbox elemento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarElemento(RentaXbox elemento, String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarElemento(RentaXbox elemento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RentaXbox buscarElemento(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RentaXbox> consultarElementos(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeElemento(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaInserta(RentaXbox elemento) throws SQLException {
        String consulta = "INSERT INTO rentas (no_maquina,no_controles,"
                + "tipo_maquina,hora_entrada,hora_salida,tiempo_transcurrido,"
                + "precio,fecha) VALUES"
                + " ('" + elemento.getIdXbox() + "','"
                + elemento.getNumControles() + "','" //num controles
                + RentaXbox.XBOX + "','" //tipo maquina
                + elemento.getHoraEntrada() + "','"
                + elemento.getHoraSalida() + "','"
                + elemento.getTiempoTranscurrido() + "','"
                + elemento.getPrecio() + "','"
                + elemento.getFecha() + "')";

        return consulta;
    }

    @Override
    protected String armarConsultaUpdate(RentaXbox elemento, String correousr) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaDelete(RentaXbox elemento) {
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
