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
public class DAOProduc extends DAOBD <Producto> {
    private final String Nombre="Nombre_Produc";
    private final String ID="Id_Produc";
    private final String PrecioCom="PrecioCom_Produc";
    private final String PrecioVen="PrecioVen_Produc";
    private final String Tipo="Clv_TipoProduc";
    
     public boolean agregarElemento(Producto producto) throws SQLException{
         boolean seagregoProduc=false;
                 
         if(!this.existeElemento(producto.getId())){
        int clvtipoproduc=this.obtenerTipoProducto(producto.getTipoProducto());
         String consulta=this.armarConsultaInserta(producto);
                        
        
        Statement sentencia;
        sentencia = this.conexion.createStatement();         
        sentencia.executeUpdate(consulta);
        
        sentencia.close();  
        
        seagregoProduc=true;
         }
         return seagregoProduc;
    }
    
    public boolean modificarElemento(Producto producto,String idproduc ) throws SQLException{
        boolean seEditoProduc=false;
        if(this.existeElemento(idproduc)){
        
        int clvtipoproduc=this.obtenerTipoProducto(producto.getTipoProducto());
        String consulta=this.armarConsultaUpdate(producto, idproduc);
       
        Statement sentencia;
        sentencia = this.conexion.createStatement();
        sentencia.executeUpdate(consulta);
        
        sentencia.close();
        seEditoProduc=true;
        }
        
        return seEditoProduc;
    }
    
    public void eliminarElemento(Producto producto) throws SQLException{
        String consulta = this.armarConsultaDelete(producto);
         
        Statement sentencia;
        sentencia = this.conexion.createStatement();

        sentencia.executeUpdate(consulta);
        
        sentencia.close();
        
    }
    
    public Producto buscarElemento(String condicion) throws SQLException{
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
    
    
    
    public ArrayList <Producto> consultarElementos(String condicion) throws SQLException{
        String consulta=this.armarConsultaSelects(condicion);
        
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
        String consulta=this.armarConsutaTipoProduc(tipoproduc);
        
        Statement sentencia = this.conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery (consulta);  
         
        int clvtipoproduc=0;
        while (resultado.next()) { 
             clvtipoproduc=resultado.getInt ("Clv_TipoProduc"); 
        }
                
         return clvtipoproduc;
        
    }
    
    public boolean existeElemento(String id) throws SQLException{
        boolean existeProduc=false;
         String consulta=this.armarConsultaSelect(contrasena);
            
        Statement sentencia;
        sentencia = this.conexion.createStatement();    
        ResultSet busqueda=sentencia.executeQuery(consulta);
         
        if(busqueda.next()){
            existeProduc=true;
        }
         return existeProduc;
        
    }

    @Override
    protected String armarConsultaInserta(Producto producto) throws SQLException {
        int clvtipoproduc=this.obtenerTipoProducto(producto.getTipoProducto());
        String consulta="INSERT INTO productos (Nombre_Produc,Id_Produc,"+
                        "PrecioCom_Produc,PrecioVen_Produc,Clv_TipoProduc) VALUES"
                        + " ('"+producto.getNombreProduc()+"','"+producto.getId()+
                        "','"+producto.getPrecioCompra()+"','"+producto.getPrecioVenta()+
                        "','"+clvtipoproduc+"')";
        return consulta;
    }

    @Override
    protected String armarConsultaUpdate(Producto producto, String idproduc) throws SQLException {
        int clvtipoproduc=this.obtenerTipoProducto(producto.getTipoProducto());
        String consulta="UPDATE productos SET "+
                    "Nombre_Produc='"+producto.getNombreProduc()+"',"+
                    "Id_Produc='"+producto.getId()+"',"+
                    "PrecioCom_Produc='"+producto.getPrecioCompra()+"',"+
                    "PrecioVen_Produc='"+producto.getPrecioVenta()+"',"+
                    "Clv_TipoProduc='"+clvtipoproduc+"'"+
                    "WHERE Id_Produc='"+idproduc+"'";
        return consulta;
    }

    @Override
    protected String armarConsultaDelete(Producto producto) {
        String consulta = "DELETE FROM productos WHERE Id_Produc='"+
                            producto.getId()+"'";
        return consulta;
    }

    @Override
    protected String armarConsultaSelect(String condicion) {
         String consulta="SELECT productos.Nombre_Produc, productos.Id_Produc,"+
                            "productos.PrecioVen_Produc, productos.PrecioCom_Produc,"+
                            " tipo_produc.Nombre_TipoProduc\n" +
                            "FROM productos JOIN tipo_produc\n" +
                            "ON productos.Clv_TipoProduc = tipo_produc.Clv_TipoProduc "+
                             "WHERE Id_Produc='"+condicion+"'";
    return consulta;
    }

    @Override
    protected String armarConsultaSelects(String condicion) {
        String consulta="SELECT * FROM productos JOIN tipo_produc ON "
                        + "productos.Clv_TipoProduc=tipo_produc.Clv_TipoProduc";
        if(condicion!=null)
            consulta+="WHERE"+condicion;
    
    return consulta;
    }
  
    private String armarConsutaTipoProduc(String tipoproduc){
        String consulta="SELECT Clv_TipoProduc FROM tipo_produc "+
                         "WHERE Nombre_TipoProduc='"+tipoproduc+"'";
    return consulta;
    }
}
