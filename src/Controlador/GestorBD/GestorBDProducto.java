/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.GestorBD;

import Modelo.Producto;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abner
 */
public class GestorBDProducto extends GestorBD {
    
     public void agregarProducto(Producto producto) throws SQLException{
         int clvtipoproduc=this.obtenerTipoProducto(producto.getTipoProducto());
         
         String consulta="INSERT INTO productos (Nombre_Produc,Id_Produc,"+
                        "PrecioCom_Produc,PrecioVen_Produc,Clv_TipoProduc) VALUES"
                        + " ('"+producto.getNombreProduc()+"','"+producto.getId()+
                        "','"+producto.getPrecioCompra()+"','"+producto.getPrecioVenta()+
                        "','"+clvtipoproduc+"')";
                        
        
        Statement sentencia;
        sentencia = this.conexion.createStatement();         
        sentencia.executeUpdate(consulta);
        
        sentencia.close();
        this.cerrarConexion(this.conexion);
    }
    
    public void modificarProducto(Producto producto,String idproduc ) throws SQLException{
         int clvtipoproduc=this.obtenerTipoProducto(producto.getTipoProducto());
        String consulta="UPDATE productos SET "+
                    "Nombre_Produc='"+producto.getNombreProduc()+"',"+
                    "Id_Produc='"+producto.getId()+"',"+
                    "PrecioCom_Produc='"+producto.getPrecioCompra()+"',"+
                    "PrecioVen_Produc='"+producto.getPrecioVenta()+"',"+
                    "Clv_TipoProduc='"+clvtipoproduc+"'"+
                    "WHERE Id_Produc='"+idproduc+"'";
       
        Statement sentencia;
        sentencia = this.conexion.createStatement();
        sentencia.executeUpdate(consulta);
        
        sentencia.close();
        this.cerrarConexion(this.conexion);
    }
    
    public void eliminarProducto(Producto producto) throws SQLException{
         String consulta = "DELETE FROM productos WHERE Id_Produc='"+
                            producto.getId()+"'";
        Statement sentencia;
        sentencia = this.conexion.createStatement();

        sentencia.executeUpdate(consulta);
        
        sentencia.close();
        this.cerrarConexion(this.conexion);
    }
    
    public Producto buscarProducto(String  condicion) throws SQLException{
         String consulta="SELECT productos.Nombre_Produc, productos.Id_Produc,"+
                            "productos.PrecioVen_Produc, productos.PrecioCom_Produc,"+
                            " tipo_produc.Nombre_TipoProduc\n" +
                            "FROM productos JOIN tipo_produc\n" +
                            "ON productos.Clv_TipoProduc = tipo_produc.Clv_TipoProduc "+
                             "WHERE Id_Produc='"+condicion+"'";
            
        Statement sentencia;
        sentencia = this.conexion.createStatement();    
        ResultSet busqueda=sentencia.executeQuery(consulta);
            
        Producto producto=null;
        while(busqueda.next()){
            String nombre=busqueda.getString("Nombre_Produc");
            String id=busqueda.getString("Id_Produc");
            Double precioven=busqueda.getDouble("PrecioVen_Produc");
            Double preciocom=busqueda.getDouble("PrecioCom_Produc");
            String tipoproduc=busqueda.getString("Nombre_TipoProduc");
           
            producto=new Producto(nombre,id,tipoproduc,preciocom,precioven);
        }
        
        sentencia.close();
        this.cerrarConexion(this.conexion);
        
        return producto;
    }
    
    
    
    public ArrayList <Producto> consultarProductos(String condicion){
    return null;
    }
    
    public int obtenerTipoProducto(String tipoproduc) throws SQLException{
        String consulta="SELECT Clv_TipoProduc FROM tipo_produc "+
                         "WHERE Nombre_TipoProduc='"+tipoproduc+"'";
        
        Statement sentencia = this.conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery (consulta);  
         
        int clvtipoproduc=0;
        while (resultado.next()) { 
             clvtipoproduc=resultado.getInt ("Clv_TipoProduc"); 
        }
                
         return clvtipoproduc;
        
    }
    
    public static void main(String[] args) throws SQLException {
        Producto produc;//=new Producto("010","Carlos V Chocolate 125 gr","Dulceria",4.0,6.0);
        GestorBDProducto gestor=new GestorBDProducto();
        gestor.establecerConexion();
       produc=gestor.buscarProducto("11");
        System.out.println(produc.getNombreProduc()+" "+produc.getId()+" "+produc.getPrecioCompra());
    }
}
