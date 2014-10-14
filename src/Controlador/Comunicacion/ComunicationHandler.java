/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Comunicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Kev' Pacheco
 */
public class ComunicationHandler extends Thread{

    private String IdConexion;
    private Socket cliente;
    private int numCliente;
    private String message;
    private BufferedReader in;
    private PrintWriter out;
    private boolean active= false;
    
    public ComunicationHandler(Socket cliente) {
        this.cliente = cliente;
        this.active = true;
        System.out.println("Nuevo arrivo de cliente num" + this.numCliente);
    }

    public void run() {
        try {

            //Se declara un BufferedReader que manejara
            //Las entradas del cliente
             in = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            //El printWriter se encargara de enviar mensajes al cliente
             out = new PrintWriter(cliente.getOutputStream(), true);

            //Este loop infinito se encarga de leer y verificar
            //que la conexion sea permanente y tratar las entradas
            out.println("ID");
            while (true) {
                String input = in.readLine();
                if (input == null || input.equals("END")) {
                    break;
                }else{
                    //Aqui se manejara las entradas para responder al cliente
                    processInfoIn(input);
                }
                out.println(input.toUpperCase());
            }

        } catch (IOException e) {
            System.out.println("Error en la comunicacion con el cliente");
            this.active= false;
        }finally{
            try{
                cliente.close();
                this.active= false;
            }catch(IOException e){
                System.out.println("No se pudo cerrar el socket ¿Esta en uso?");
            }
        }
    }
    
    public void processInfoIn(String input){
        String infoOut = null;
        
        if((input.charAt(0)) == 'I'){
            int lengh=input.length();
            for(int i=3; i<lengh;i++){
                infoOut+= input.charAt(i);
            }
            
           this.IdConexion= infoOut;
           return;
        }
        
        //Este if recibira informacion de 
        //Cuando se termina un tiempo especifico
        //Y notificara que cierta computadora ya termino
        if((input.charAt(0)) == 'T'){
            int lengh=input.length();
            
            for(int i=2; i<lengh;i++){
                infoOut+= input.charAt(i);
            }   
            
            //Aqui se notificara al Administrador  de las compus
            //que se acabo el tiempo de una maquina******
            
            
        }

    }

    public void SendToBuffer(String input){
        out.println(input);
    }
    
    /**
     * @return the IdConexion
     */
    public String getIdConexion() {
        return IdConexion;
    }
    
    public boolean isActive(){
        return active;
    }

}
