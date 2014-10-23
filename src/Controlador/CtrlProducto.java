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
public class CtrlProducto {
    
    GestorBDProducto g_gestorProduc;
    
    public void agregarProducto(Producto produc){
        
        g_gestorProduc=new GestorBDProducto();
        g_gestorProduc.establecerConexion();
       
        try {
            
            g_gestorProduc.agregarProducto(produc);
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    public void editarProducto(Producto produc,String idproduc){
        
        g_gestorProduc = new GestorBDProducto();
        g_gestorProduc.establecerConexion();
        
        try {
             
            g_gestorProduc.modificarProducto(produc,idproduc);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Producto buscarProducto(String idproduc){
        
        g_gestorProduc = new GestorBDProducto();
        g_gestorProduc.establecerConexion();
        
        try {
        
            return   g_gestorProduc.buscarProducto(idproduc);
        
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        }
         
         return null;
    }
    
    public void eliminarProducto(Producto produc){
        
        g_gestorProduc = new GestorBDProducto();
        g_gestorProduc.establecerConexion();
        
         try {
        
             g_gestorProduc.eliminarProducto(produc);
             
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        }
         
    }
    
}
