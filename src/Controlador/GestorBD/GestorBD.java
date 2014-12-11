/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.GestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Abner
 */
public abstract class GestorBD {
        String host="localhost";
        String puerto="666";
        String usuario="root";
        String contrasena="thestrokes";
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
    
    
   
    
}
