/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Controlador.GestorBD.GestorBDProducto;
import Modelo.Producto;
import java.sql.SQLException;

/**
 *
 * @author Oscar
 */
public class ControladorProducto {
    GestorBDProducto gestorProduc;
    
    public void agregarProducto(Producto produc){
        gestorProduc=new GestorBDProducto();
        gestorProduc.establecerConexion();
       
        try {
            
            gestorProduc.agregarProducto(produc);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void editarProducto(Producto produc,String idproduc){
        gestorProduc=new GestorBDProducto();
        gestorProduc.establecerConexion();
        
        try {
             
            gestorProduc.modificarProducto(produc,idproduc);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Producto buscarProducto(String idproduc){
        gestorProduc=new GestorBDProducto();
        gestorProduc.establecerConexion();
        
        try {
        
            return   gestorProduc.buscarProducto(idproduc);
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
         return null;
    }
    
    public void eliminarProducto(Producto produc){
        gestorProduc=new GestorBDProducto();
        gestorProduc.establecerConexion();
        
         try {
        
             gestorProduc.eliminarProducto(produc);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
