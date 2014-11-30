/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.GestorBD;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Abner
 */
public abstract class DAOBD <T> {
        String host="localhost";
        String puerto="666";
        String usuario="root";
        String contrasena="renba";
        String nombreBD="scc";
        Connection conexion=null;
        
    public void establecerConexion() {
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            this.conexion =this.obtenerConexion(this.puerto, this.usuario,
                                                this.contrasena);
                            
        } catch (Exception ex) {// handle the error
            
           
            System.out.println("SQLException: " + ex.getMessage());   
            
        }
    
    }
    
    private Connection obtenerConexion(String puerto,String usuario,String contrasena) throws SQLException{  
        
       return DriverManager.getConnection("jdbc:mysql://"+this.host+":"+puerto+"/"+this.nombreBD, 
                                            usuario, contrasena);
       
    }
    
    public void cerrarConexion(Connection con){
        try {
            
            if ( con != null ){               
                if ( !con.isClosed() ){ // Si no esta cerrada, se cierra
                    con.close();                
                }    
            }
            
        } catch (SQLException e) { 
            
            e.printStackTrace(); 
            
          }
    }
    
    
   public abstract boolean agregarElemento(T elemento)throws SQLException;
      
   
   public abstract boolean modificarElemento(T elemento, String condicion)throws SQLException;
 
    
   public abstract void eliminarElemento(T elemento)throws SQLException;
       
   
   public abstract T buscarElemento(String condicion)throws SQLException;
      
   public abstract ArrayList <T> consultarElementos(String condicion)throws SQLException;
   
   public abstract boolean existeElemento(String condicion)throws SQLException;
    
   
       
    protected abstract String armarConsultaInserta(T elemento)throws SQLException ;
 
   
    protected abstract String armarConsultaUpdate(T elemento,String correousr)throws SQLException ;
   
    protected abstract String armarConsultaDelete(T elemento);
   
    protected abstract String armarConsultaSelect(String condicion);
    
    protected abstract String armarConsultaSelects(String condicion);
    
    
}
