/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Controlador.GestorBD.DAOProducto;
import Modelo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oscar
 */
public class CtrlProducto {
    DAOProducto gestorProduc;
    
    public boolean agregarProducto(String id, String nombreProduc,Double precioCom
            ,Double precioVen,String tipoproduc,Double cantidad) throws SQLException{
            gestorProduc=new DAOProducto();
            gestorProduc.establecerConexion();
            Producto produc=new Producto(id,nombreProduc,tipoproduc,precioCom,precioVen,cantidad);
       
            return gestorProduc.agregarElemento(produc);
    }
    
    public boolean editarProducto(String id, String nombreProduc,Double precioCom
            ,Double precioVen,String tipoproduc,Double cantidad) throws SQLException{
        gestorProduc=new DAOProducto();
        gestorProduc.establecerConexion();
        
       Producto produc=new Producto(id,nombreProduc,tipoproduc,precioCom,precioVen,cantidad);
             
       return gestorProduc.modificarElemento(produc,id);
            
        
    }
    
    public Producto buscarProducto(String idproduc) throws SQLException{
        gestorProduc=new DAOProducto();
        gestorProduc.establecerConexion();
        Producto producBD=null;
       
        
          producBD= gestorProduc.buscarElemento(idproduc);
        
        return producBD;
         
        
    }
    
    public void eliminarProducto(Producto produc){
        gestorProduc=new DAOProducto();
        gestorProduc.establecerConexion();
        
         try {
        
             gestorProduc.eliminarElemento(produc);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Producto> buscarProductos(){
        gestorProduc=new DAOProducto();
        gestorProduc.establecerConexion();
        
        try {
        
            return   gestorProduc.consultarElementos(null);
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
         return null;
    }
    
    public boolean existeProduc(Producto produc)throws NullPointerException, SQLException{
        boolean existeProduc=false;
       
        Producto producBuscado=null;
        producBuscado=this.buscarProducto(produc.getId());
        if(producBuscado.getId().equals(produc.getId())){
            
            existeProduc=true;
        }
        
        return existeProduc;
    }
    
     public void llenarListaProduc(JTable tableProduc){
        ArrayList <Producto> listaProduc=new ArrayList<>();
        listaProduc=this.buscarProductos();
        DefaultTableModel modelo;
        Producto producTemp;
       
        for (Producto producto : listaProduc) {
            producTemp = producto;
            String idProduc=producTemp.getId();
            String nombreProduc=producTemp.getNombreProduc();
            String tipoProduc=producTemp.getTipoProducto();
            String precioVen=Double.toString(producTemp.getPrecioVenta());
            String precioCom=Double.toString(producTemp.getPrecioCompra());
            String cantidad=Double.toString(producTemp.getCantidad());
            String[] datosProduc={idProduc,nombreProduc,tipoProduc,precioVen,precioCom,cantidad};
            modelo = (DefaultTableModel) tableProduc.getModel();
            modelo.addRow(datosProduc);
        }
        
    }
     
      public HashMap<String,String> obtenerProductoasString(String id) throws SQLException{
        
        HashMap<String,String> atributosProduc = new HashMap<String,String>();
        Producto producBuscado=this.buscarProducto(id);
          System.out.println("obtenerproductos assitri");
        atributosProduc.put("id",producBuscado.getId());
        atributosProduc.put("nombreProduc",producBuscado.getNombreProduc());
        atributosProduc.put("precioVenta", producBuscado.getPrecioVenta().toString());
        
        return atributosProduc;
        
    }

}
