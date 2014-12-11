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
public class GestorBDProducto extends GestorBD {
    
     public boolean agregarProducto(Producto producto) throws SQLException{
         boolean seagregoProduc=false;
                 
         if(!this.existeProduc(producto.getId())){
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
        
        seagregoProduc=true;
         }
         return seagregoProduc;
    }
    
    public boolean modificarProducto(Producto producto,String idproduc ) throws SQLException{
        boolean seEditoProduc=false;
        if(this.existeProduc(idproduc)){
        
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
        seEditoProduc=true;
        }
        
        return seEditoProduc;
    }
    
    public void eliminarProducto(Producto producto) throws SQLException{
         String consulta = "DELETE FROM productos WHERE Id_Produc='"+
                            producto.getId()+"'";
        Statement sentencia;
        sentencia = this.conexion.createStatement();

        sentencia.executeUpdate(consulta);
        
        sentencia.close();
        
    }
    
    public Producto buscarProducto(String condicion) throws SQLException{
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
        
        
        return producto;
    }
    
    
    
    public ArrayList <Producto> consultarProductos(String condicion) throws SQLException{
        String consulta="SELECT * FROM productos JOIN tipo_produc ON "
                        + "productos.Clv_TipoProduc=tipo_produc.Clv_TipoProduc";
        if(condicion!=null)
            consulta+="WHERE"+condicion;
        
        Statement sentencia;
        sentencia = this.conexion.createStatement();    
        ResultSet busqueda=sentencia.executeQuery(consulta);
        
        Producto producTemp;
        ArrayList <Producto> listaProduc=new ArrayList <Producto>();
        
        while(busqueda.next()){
            String nombre=busqueda.getString("Nombre_Produc");
            String id=busqueda.getString("Id_Produc");
            Double precioven=busqueda.getDouble("PrecioVen_Produc");
            Double preciocom=busqueda.getDouble("PrecioCom_Produc");
            String tipoproduc=busqueda.getString("Nombre_TipoProduc");
           
            producTemp=new Producto(id,nombre,tipoproduc,preciocom,precioven);
            listaProduc.add(producTemp);
        }
        
    return listaProduc;
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
    
    public boolean existeProduc(String id) throws SQLException{
        boolean existeProduc=false;
         String consulta="SELECT productos.Nombre_Produc, productos.Id_Produc,"+
                            "productos.PrecioVen_Produc, productos.PrecioCom_Produc,"+
                            " tipo_produc.Nombre_TipoProduc\n" +
                            "FROM productos JOIN tipo_produc\n" +
                            "ON productos.Clv_TipoProduc = tipo_produc.Clv_TipoProduc "+
                             "WHERE Id_Produc='"+id+"'";
            
        Statement sentencia;
        sentencia = this.conexion.createStatement();    
        ResultSet busqueda=sentencia.executeQuery(consulta);
         
        if(busqueda.next()){
            existeProduc=true;
        }
         return existeProduc;
        
    }
  
}
