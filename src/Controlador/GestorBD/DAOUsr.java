/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.GestorBD;


import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abner
 */
public class DAOUsr extends DAOBD <Usuario>{
    
        private final String Nombre="Nombre_Usr";
        private final String Correo="Correo_Usr";
        private final String Contrasena="Contrasena_Usr";
        private final String Telefono="Telefono_Usr";
        private final String Tipo="Clv_tipoUsr";
    /*
    La funcion recibe un usuario, checa si existe, si existe el Usuario lo 
    modifica con los nuevos datos, si no existe lo agrega. 
    */
     @Override
     public boolean agregarElemento(Usuario usr) throws SQLException{
         boolean usrAgregado=false;
        if(!this.existeElemento(usr.getCorreo())){
        
        String consulta=this.armarConsultaInserta(usr);
        
        Statement sentencia;
        sentencia = this.conexion.createStatement();         
        sentencia.executeUpdate(consulta);        
        sentencia.close();
        
        usrAgregado=true;
        }
       return usrAgregado;
    }
    
     @Override
    public boolean modificarElemento(Usuario usr,String correousr) throws SQLException{
        boolean seModificoUsr=false;
        if(this.existeElemento(usr.getCorreo())){

        String consulta=this.armarConsultaUpdate(usr, correousr);
       
        Statement sentencia;
        sentencia = this.conexion.createStatement();
        sentencia.executeUpdate(consulta);
        sentencia.close();
        
        seModificoUsr=true;
        }
        
        return seModificoUsr;
               
    }
    
     @Override
    public void eliminarElemento(Usuario usuario) throws SQLException{
         
        String consulta = this.armarConsultaDelete(usuario);
        
        Statement sentencia;
        sentencia = this.conexion.createStatement();
        sentencia.executeUpdate(consulta);
        sentencia.close();
        
         
    }
    
     @Override
    public Usuario buscarElemento(String condicion) throws SQLException{
           
        String consulta=this.armarConsultaSelect(condicion);
            
        Statement sentencia;
        sentencia = this.conexion.createStatement();    
        ResultSet busqueda=sentencia.executeQuery(consulta);
            
        Usuario usr=new Usuario();
        while(busqueda.next()){
            String nombre=busqueda.getString("Nombre_Usr");
            String telefono=busqueda.getString("Telefono_Usr");
            String correo=busqueda.getString("Correo_Usr");
            String clave=busqueda.getString("Contrasena_usr");
            String tipousr=busqueda.getString("Nombre_TipoUsr");
           
            usr=new Usuario(nombre,telefono,correo,clave,tipousr);
        }
        sentencia.close();
        
      
        return usr;
    
    }
    
    
    public ArrayList <Usuario> consultarElementos(String condicion) throws SQLException{
        String consulta=this.armarConsultaSelects(condicion);
            
                
        Statement sentencia;
        sentencia = this.conexion.createStatement();    
        ResultSet busqueda=sentencia.executeQuery(consulta);
        
        Usuario usrTemp;
        ArrayList <Usuario> listaUsr=new ArrayList <Usuario>();
        while(busqueda.next()){
            String nombre=busqueda.getString("Nombre_Usr");
            String telefono=busqueda.getString("Telefono_Usr");
            String correo=busqueda.getString("Correo_Usr");
            String clave=busqueda.getString("Contrasena_usr");
            String tipousr=busqueda.getString("Nombre_TipoUsr");
           
            usrTemp=new Usuario(nombre,telefono,correo,clave,tipousr);
            listaUsr.add(usrTemp);
        }
        
         return listaUsr;
    }
    
    public int obtenerTipoUsuario(String tipousuario) throws SQLException{
        
        String consulta="SELECT clv_tipousr FROM tipo_usr "+
                         "WHERE Nombre_tipousr='"+tipousuario+"'";
        
        Statement sentencia = this.conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery (consulta);  
         
        int clavetipousr=0;
        while (resultado.next()) { 
             clavetipousr=resultado.getInt ("Clv_TipoUsr"); 
        }
        
        
        
        return clavetipousr;   
    }
    
    public boolean existeElemento(String condicion) throws SQLException{
        boolean existeUsr=false;
        String consulta="SELECT usuarios.Nombre_Usr, usuarios.Telefono_Usr,"+
                            "usuarios.Correo_Usr, usuarios.Contrasena_Usr,"+
                            " tipo_usr.Nombre_TipoUsr\n" +
                            "FROM usuarios JOIN tipo_usr\n" +
                            "ON usuarios.Clv_TipoUsr = tipo_usr.Clv_TipoUsr "+
                             "WHERE Correo_usr='"+condicion+"'";
            
        Statement sentencia;
        sentencia = this.conexion.createStatement();    
        ResultSet busqueda=sentencia.executeQuery(consulta);
        if(busqueda.next()){
            existeUsr=true;
        }
      return existeUsr;
            
        
          
    }
    
   
    
    protected String armarConsultaUpdate(Usuario elemento,String correousr) throws SQLException{
         String consulta="UPDATE usuarios SET "+
                    "Nombre_Usr='"+elemento.getNombreUsuario()+"',"+
                    "Telefono_Usr='"+elemento.getTelefono()+"',"+
                    "Correo_Usr='"+elemento.getCorreo()+"',"+
                    "Contrasena_Usr='"+elemento.getClave()+"',"+
                    "Clv_TipoUsr='"+this.obtenerTipoUsuario(elemento.getTipoUsuario())+"'"+
                    "WHERE Correo_Usr='"+correousr+"'";
         
         return consulta;
    }
    
    protected String armarConsultaDelete(Usuario usuario){
        String consulta = "DELETE FROM usuarios WHERE Nombre_usr='"+
                            usuario.getNombreUsuario()+"' or Correo_usr='"+
                            usuario.getCorreo()+"'";
        return consulta;
    }
    
    protected String armarConsultaSelect(String condicion){
        String consulta="SELECT usuarios.Nombre_Usr, usuarios.Telefono_Usr,"+
                            "usuarios.Correo_Usr, usuarios.Contrasena_Usr,"+
                            " tipo_usr.Nombre_TipoUsr\n" +
                            "FROM usuarios JOIN tipo_usr\n" +
                            "ON usuarios.Clv_TipoUsr = tipo_usr.Clv_TipoUsr "+
                             "WHERE Correo_usr='"+condicion+"'";
        return consulta;
        
    }
    
    protected String armarConsultaSelects(String condicion){
        String consulta="SELECT * FROM scc.usuarios join tipo_usr ON"
                + " usuarios.Clv_TipoUsr=tipo_usr.Clv_TipoUsr";
        if(condicion!=null)
            consulta+="WHERE"+condicion;
    
    return consulta;
    }
   
    @Override
    protected String armarConsultaInserta(Usuario elemento)throws SQLException  {
        int clvtipousr=this.obtenerTipoUsuario(elemento.getTipoUsuario());
        String consulta="INSERT INTO usuarios (Nombre_Usr,Correo_Usr,"+
                        "Contrasena_Usr,Telefono_Usr,Clv_tipousr) values "+
                        "('"+elemento.getNombreUsuario()+"','"+elemento.getCorreo()+
                        "','"+elemento.getClave()+"','"+elemento.getTelefono()+"','"+clvtipousr+"')";
       
        
        return consulta;
    }

    
    public static void main(String[] args) throws SQLException {
     
           
        
    }
   

   
}

