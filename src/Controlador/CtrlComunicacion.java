/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Comunicacion.ComunicationHandler;
import Controlador.Comunicacion.Servidor;
import java.util.ArrayList;

/**
 *
 * @author hyuchiha
 */
public class CtrlComunicacion {
    
    private static final CtrlComunicacion INSTANCE = new CtrlComunicacion();
    private Servidor server = new Servidor();

    private CtrlComunicacion() {
       this.initializeServer();
    }

    public static CtrlComunicacion getINSTANCE() {
        return INSTANCE;
    }       
    
    public void initializeServer(){
        server.start();
    }
    
    public void sendMessage(String Id, String message){
        server.sendMessageToConexion(Id, message);
    }
    
    public ArrayList<ComunicationHandler> getConectionsAvailables(){
        return server.getConections();
    }
    
}
