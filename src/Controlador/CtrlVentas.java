 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.GestorBD.DAONotaVentaDia;
import Controlador.GestorBD.DAOProducto;
import Controlador.LogicaNegocios.AdminTiempo;
import Modelo.NotaVentaDia;
import Modelo.Producto;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class CtrlVentas {

    DAONotaVentaDia daoNVD;
    CtrlProducto ctrlProduc;
    private DAOProducto daoProducto;

    public void guardarNotaVenta(HashMap<Integer, String[]> tablaProductos) throws SQLException {
       
        this.daoProducto = new DAOProducto();
        this.daoNVD = new DAONotaVentaDia();
        int ID = 0;
        int CANTIDAD = 1;
        int PRECIOTOT = 2;

        for (int indiceTabla = 0; indiceTabla < tablaProductos.size(); indiceTabla++) {

            String[] datosProduc = tablaProductos.get(indiceTabla);
            String idProduc = datosProduc[ID];
            double cantidad = Double.valueOf(datosProduc[CANTIDAD]);
            double precioTotal = Double.valueOf(datosProduc[PRECIOTOT]);
             this.ctrlProduc = new CtrlProducto();
             this.daoProducto.establecerConexion();
            Producto produc = this.daoProducto.buscarElemento(idProduc);

            NotaVentaDia notaVentaD = new NotaVentaDia(this.obtenerFechaActual(), produc, cantidad, precioTotal);
            this.actualizarExistenciaProducto(produc, cantidad);
            this.daoNVD.establecerConexion();
            this.daoNVD.agregarElemento(notaVentaD);
        }

    }

    private Date obtenerFechaActual() {
        Date fecha = new Date(AdminTiempo.obtenerFecha().getTime());

        return fecha;
    }

    private void actualizarExistenciaProducto(Producto producto, double cantidad) throws SQLException {
        if (!producto.getTipoProducto().equals("Servicio Papeleria")) {
            Producto producModificado = producto;
            double cantidadActual = producto.getCantidad() - cantidad;
            producModificado.setCantidad(cantidadActual);
            this.daoProducto.modificarElemento(producModificado, producto.getId());

        }
    }

}
