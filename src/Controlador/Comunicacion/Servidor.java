package Controlador.Comunicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class Servidor extends Thread{

    private ArrayList<ComunicationHandler> conexiones = new ArrayList();
    private static final int HOST = 5000;
    private ServerSocket server = null;

    public Servidor() {
        //Se abre el puerto 5000 para escucha del clientes
        try {
            server = new ServerSocket(HOST);
        } catch (IOException e) {
            System.out.println("ERROR al crear Server");
        }
    }

    @Override
    public void run() {
        //Se crear una puerta de entrada cliente y se acepta la conexion
        try {
            while (true) {
                verifyConections();
                ComunicationHandler com = new ComunicationHandler(server.accept());
                com.start();
                
                conexiones.add(com);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public boolean sendMessageToConexion(String Id, String message) {
        
        if(conexiones.isEmpty()) return false;
        
        for (ComunicationHandler com : conexiones) {
            if (com.getIdConexion().equals(Id) && com.isActive()) {
                com.SendToBuffer(message);
                return true;
            }
        }
        
        System.out.println("no hay conexione a ese");
        
        return false;
    }

    public void verifyConections() {
        if(conexiones.isEmpty()) return;
        
        for (ComunicationHandler com : conexiones) {
            if (!com.isActive()) {
                conexiones.remove(com);
            }
        }
    }
    
    public ArrayList<ComunicationHandler> getConections() {
        return conexiones;
    }
}
