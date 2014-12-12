/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import Modelo.NotaVentaDia;
import Modelo.Producto;
import Modelo.RentaComputadora;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author x
 */
public class DAONotaVentaDia extends DAOBD<NotaVentaDia> {

    private final String CANTIDAD = "cantidad";
    private final String PRECIOTOTAL = "precioTotal";
    private final String IDPRODUC = "id_Produc";
    private final String FECHA = "Fecha";

    @Override
    public boolean agregarElemento(NotaVentaDia elemento) throws SQLException {
        boolean seAgregoVenta = false;
        if (true) {
            String consulta = "INSERT INTO ventas (Fecha,"
                    + "cantidad,precioTotal,id_Produc) VALUES"
                    + " ('" + elemento.getFechaDeVenta() + "','"
                    + elemento.getCantidadProducto() + "','" //tipo maquina
                    + elemento.getPrecioTotal() + "','"                   
                    + elemento.getProducto().getId() + "')";

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);

            sentencia.close();

            seAgregoVenta = true;
        }
        return seAgregoVenta;
    }

    @Override
    public boolean modificarElemento(NotaVentaDia elemento, String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarElemento(NotaVentaDia elemento) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NotaVentaDia buscarElemento(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NotaVentaDia> consultarElementos(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeElemento(String condicion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaInserta(NotaVentaDia elemento) throws SQLException {
        String consulta = "INSERT INTO ventas (Fecha,"
                + "cantidad,precioTotal,id_Produc) VALUES"
                + " ('" + elemento.getFechaDeVenta() + "','"
                + elemento.getCantidadProducto() + "','" //tipo maquina
                + elemento.getPrecioTotal() + "','"
                + elemento.getProducto().getId() + "','"
                + elemento.getProducto().getId() + "')";
        return consulta;
    }

    @Override
    protected String armarConsultaUpdate(NotaVentaDia elemento, String correousr) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String armarConsultaDelete(NotaVentaDia elemento) {
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

    public ArrayList<NotaVentaDia> obtenerValoresPorFechas(Date fechaInicio,
            Date fechaFinal, String tipoProduc) throws SQLException {
        ArrayList<NotaVentaDia> ventas = new ArrayList();

        String consulta = "SELECT * FROM Ventas JOIN WHERE ( Fecha BETWEEN '"
                + fechaInicio + "'  AND '" + fechaFinal + "')  "
                + "tipo_produc = '" + tipoProduc + "'";
        /*
         SELECT scc.ventas.* FROM scc.ventas JOIN productos where scc.ventas.id_Produc=scc.productos.id_produc
         AND (fecha BETWEEN '' AND '') AND tipo_produc='';
         */

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet result = sentencia.executeQuery(consulta);

        while (result.next()) {
            double cantidad = result.getDouble(this.CANTIDAD);
            double precioTotal = result.getDouble(this.PRECIOTOTAL);
            Producto productoVendido = this.obtenerProducto(result.getString(this.IDPRODUC));
            Date fecha = result.getDate(this.FECHA);
            NotaVentaDia venta = new NotaVentaDia(fecha, productoVendido, cantidad, precioTotal);

            ventas.add(venta);
        }

        return ventas;

    }

    private Producto obtenerProducto(String condicion) throws SQLException {
        DAOProducto daoProduc = new DAOProducto();
        return daoProduc.buscarElemento(condicion);
    }
}
