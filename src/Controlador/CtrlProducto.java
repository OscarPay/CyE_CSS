/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Controlador.GestorBD.DAOProduc;
import Modelo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oscar
 */
public class CtrlProducto {
    DAOProduc gestorProduc;
    
    public boolean agregarProducto(String id, String nombreProduc,Double precioCom
            ,Double precioVen,String tipoproduc) throws SQLException{
            gestorProduc=new DAOProduc();
            gestorProduc.establecerConexion();
            Producto produc=new Producto(id,nombreProduc,tipoproduc,precioCom,precioVen);
       
            return gestorProduc.agregarElemento(produc);
    }
    
    public boolean editarProducto(String id, String nombreProduc,Double precioCom
            ,Double precioVen,String tipoproduc) throws SQLException{
        gestorProduc=new DAOProduc();
        gestorProduc.establecerConexion();
        
       Producto produc=new Producto(id,nombreProduc,tipoproduc,precioCom,precioVen);
             
       return gestorProduc.modificarElemento(produc,id);
            
        
    }
    
    public Producto buscarProducto(String idproduc) throws SQLException{
        gestorProduc=new DAOProduc();
        gestorProduc.establecerConexion();
        Producto producBD=null;
       
        
          producBD= gestorProduc.buscarElemento(idproduc);
        
        return producBD;
         
        
    }
    
    public void eliminarProducto(Producto produc){
        gestorProduc=new DAOProduc();
        gestorProduc.establecerConexion();
        
         try {
        
             gestorProduc.eliminarElemento(produc);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Producto> buscarProductos(){
        gestorProduc=new DAOProduc();
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
    
     public void llenarTablaUsr(JTable tableProduc){
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
            String[] datosProduc={idProduc,nombreProduc,tipoProduc,precioVen,precioCom};
            modelo = (DefaultTableModel) tableProduc.getModel();
            modelo.addRow(datosProduc);
        }
        
    }
}
