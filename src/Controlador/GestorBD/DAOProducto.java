/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.GestorBD;

import Modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abner
 */
public class DAOProducto extends DAOBD<Producto> {

    private final String Nombre = "Nombre_Produc";
    private final String ID = "Id_Produc";
    private final String PrecioCom = "PrecioCom_Produc";
    private final String PrecioVen = "PrecioVen_Produc";
    private final String Tipo = "Tipo_Produc";
    private final String Cantidad = "Cantidad_Produc";

    public boolean agregarElemento(Producto producto) throws SQLException {
        boolean seagregoProduc = false;

        if (!this.existeElemento(producto.getId())) {
           
            String consulta = this.armarConsultaInserta(producto);

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);

            sentencia.close();

            seagregoProduc = true;
        }
        return seagregoProduc;
    }

    public boolean modificarElemento(Producto producto, String idproduc) throws SQLException {
        boolean seEditoProduc = false;
        if (this.existeElemento(idproduc)) {

          
            String consulta = this.armarConsultaUpdate(producto, idproduc);

            Statement sentencia;
            sentencia = this.conexion.createStatement();
            sentencia.executeUpdate(consulta);

            sentencia.close();
            seEditoProduc = true;
        }

        return seEditoProduc;
    }

    public void eliminarElemento(Producto producto) throws SQLException {
        String consulta = this.armarConsultaDelete(producto);

        Statement sentencia;
        sentencia = this.conexion.createStatement();

        sentencia.executeUpdate(consulta);

        sentencia.close();

    }

    public Producto buscarElemento(String condicion) throws SQLException {
       /* String consulta = "SELECT productos."+this.Nombre+","
                + " productos."+this.ID+","
                + "productos."+this.PrecioVen+","
                + " productos."+this.PrecioCom+","
                + " productos."+this.Cantidad+","
                + " productos."+this.Tipo+"\n"
                + "FROM productos"
                + "WHERE Id_Produc='" + condicion + "'";
*/          String consulta = this.armarConsultaSelect(condicion);
        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet busqueda = sentencia.executeQuery(consulta);

        Producto producto = null;
        while (busqueda.next()) {
            String nombre = busqueda.getString(this.Nombre);
            String id = busqueda.getString(this.ID);
            Double precioven = busqueda.getDouble(this.PrecioVen);
            Double preciocom = busqueda.getDouble(this.PrecioCom);
            String tipoproduc = busqueda.getString(this.Tipo);
            Double cantidad = busqueda.getDouble(this.Cantidad);

            producto = new Producto(id, nombre, tipoproduc, preciocom, precioven, cantidad);
        }

        sentencia.close();

        return producto;
    }

    public ArrayList<Producto> consultarElementos(String condicion) throws SQLException {
        String consulta = this.armarConsultaSelects(condicion);

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        
        ResultSet busqueda = sentencia.executeQuery(consulta);

        Producto producTemp;
        ArrayList<Producto> listaProduc = new ArrayList<Producto>();

        while (busqueda.next()) {
            String nombre = busqueda.getString(this.Nombre);
            String id = busqueda.getString(this.ID);
            Double precioven = busqueda.getDouble(this.PrecioVen);
            Double preciocom = busqueda.getDouble(this.PrecioCom);
            String tipoproduc = busqueda.getString(this.Tipo);
            Double cantidad = busqueda.getDouble(this.Cantidad);
            producTemp = new Producto(id, nombre, tipoproduc, preciocom, precioven, cantidad);
            listaProduc.add(producTemp);
        }

        return listaProduc;
    }

    public boolean existeElemento(String id) throws SQLException {
        boolean existeProduc = false;
        String consulta = this.armarConsultaSelect(contrasena);

        Statement sentencia;
        sentencia = this.conexion.createStatement();
        ResultSet busqueda = sentencia.executeQuery(consulta);

        if (busqueda.next()) {
            existeProduc = true;
        }
        return existeProduc;

    }

    @Override
    protected String armarConsultaInserta(Producto producto) throws SQLException {

        String consulta = "INSERT INTO productos (Nombre_Produc,Id_Produc,"
                + "PrecioCom_Produc,PrecioVen_Produc,Cantidad_Produc,Tipo_Produc) VALUES"
                + " ('" + producto.getNombreProduc() + "','" + producto.getId()
                + "','" + producto.getPrecioCompra() + "','" + producto.getPrecioVenta()
                + "','" + producto.getCantidad()
                + "','" + producto.getTipoProducto() + "')";
        return consulta;
    }

    @Override
    protected String armarConsultaUpdate(Producto producto, String idproduc) throws SQLException {
      
        String consulta = "UPDATE productos SET "
                + ""+this.Nombre+"='" + producto.getNombreProduc() + "',"
                + ""+this.ID+"='" + producto.getId() + "',"
                + ""+this.PrecioCom+"='" + producto.getPrecioCompra() + "',"
                + ""+this.PrecioVen+"='" + producto.getPrecioVenta() + "',"
                + ""+this.Tipo+"='" + producto.getTipoProducto() + "'"
                + ""+this.Cantidad+"='" + producto.getCantidad() + "'"
                + "WHERE Id_Produc='" + idproduc + "'";
        return consulta;
    }

    @Override
    protected String armarConsultaDelete(Producto producto) {
        String consulta = "DELETE FROM productos WHERE "+this.ID+"='"
                + producto.getId() + "'";
        return consulta;
    }

    @Override
    protected String armarConsultaSelect(String condicion) {
        String consulta = "SELECT productos.Nombre_Produc, productos.Id_Produc,"
                + "productos.PrecioVen_Produc, productos.PrecioCom_Produc,"
                + " productos.Tipo_Produc,productos.Cantidad_Produc\n"
                + "FROM productos\n"
           
                + "WHERE Id_Produc='" + condicion + "'";
        return consulta;
    }

    @Override
    protected String armarConsultaSelects(String condicion) {
        String consulta = "SELECT * FROM productos ";
        if (condicion != null) {
            consulta += "WHERE" + condicion;
        }

        return consulta;
    }

    public static void main(String[] args) throws SQLException {
        DAOProducto p=new DAOProducto();
        p.establecerConexion();
        Producto pro=new Producto("02","coca cola light","Dulceria",9.0,30.0,500.0);
        System.out.println(p.buscarElemento("02").getId());
        
        
    }

}
