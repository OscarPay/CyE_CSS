/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Comunicacion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kev' Pacheco
 */
public class Servidor {
    private ArrayList<ComunicationHandler> conexiones= new ArrayList();
    private static final int HOST = 5000;
    
    public Servidor(){
        
        //Se abre el puerto 5000 para escucha del clientes
        ServerSocket server = null;
        try{
            server = new ServerSocket(HOST);
        }catch(IOException e){
            System.out.println("ERROR al crear Server");
        }
        
        //Se crear una puerta de entrada cliente y se acepta la conexion
        try{
            while(true){
                verifyConections();
                
                ComunicationHandler com =new ComunicationHandler(server.accept());
                com.start();
                
                conexiones.add(com);
            }
        }catch(IOException e){
            
              System.out.println("IOException");  
              
        }
        finally{
            try {
                server.close();
            } catch (IOException ex) {
                System.out.println("Comunicacion cerrada");
            }
        }        
    }
    
    public boolean sendMessageToConexion(String Id, String message){
        
        for(ComunicationHandler com: conexiones){
            if(com.getIdConexion().equals(Id) && com.isActive()){
                com.SendToBuffer(message);
                return true;
            }
        }
        return false;
    }
    
    public void verifyConections(){
        for(ComunicationHandler com: conexiones){
            if(!com.isActive()){
                conexiones.remove(com);
            }
        }
    }
    
    public ArrayList<ComunicationHandler> getConections(){
        return conexiones;
    }
}
