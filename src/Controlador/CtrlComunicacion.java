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
       this.iniciarServidor();
    }

    public static CtrlComunicacion getINSTANCE() {
        return INSTANCE;
    }       
    
    public void iniciarServidor(){
        server.start();
    }
    
    public void EnviarTiempo(String Id, String mensaje){
        server.sendMessageToConexion(Id, "TM-"+mensaje);
    }
    
    public void AumentarTiempo(String id, String mensaje){
        server.sendMessageToConexion(id, "AT-"+mensaje);       
    }
    
    public void DetenerTiempo(String id){
        server.sendMessageToConexion(id, "EF-True");
    }
    
    public ArrayList<ComunicationHandler> getConexionesDisponibles(){
        return server.getConections();
    }
    
}
