/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Comunicacion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kev' Pacheco
 */
public class Servidor {
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
                new ComunicationHandler(server.accept()).start();
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
}
