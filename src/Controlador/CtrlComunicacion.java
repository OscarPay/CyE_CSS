/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Comunicacion.Servidor;

/**
 *
 * @author hyuchiha
 */
public class CtrlComunicacion {
    private Servidor server = new Servidor();
    
    public void sendMessage(String Id, String message){
        server.sendMessageToConexion(Id, message);
    }
    
}
