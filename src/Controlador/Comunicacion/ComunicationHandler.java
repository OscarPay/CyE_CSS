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

    private Socket cliente;
    private int numCliente;
    private String message;
    public ComunicationHandler(Socket cliente) {
        this.cliente = cliente;
        System.out.println("Nuevo arrivo de cliente num" + this.numCliente);
    }

    public void run() {
        try {

            //Se declara un BufferedReader que manejara
            //Las entradas del cliente
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));

            //El printWriter se encargara de enviar mensajes al cliente
            PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

            //Este loop infinito se encarga de leer y verificar
            //que la conexion sea permanente y tratar las entradas
            while (true) {
                String input = in.readLine();
                if (input == null || input.equals("END")) {
                    break;
                }else{
                    //Aqui se manejara las entradas para responder al cliente
                    message = processInfo(input);
                }
                out.println(input.toUpperCase());
            }

        } catch (IOException e) {
            System.out.println("Error en la comunicacion con el cliente");
        }finally{
            try{
                cliente.close();
            }catch(IOException e){
                System.out.println("No se pudo cerra el socket ¿Esta en uso?");
            }
        }
    }
    
    public String processInfo(String input){
        String infoOut = null;
        
        
        
        
        
        
        return infoOut;
    }

}
