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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kev' Pacheco
 */
public class ComunicationHandler extends Thread {

    private String IdConexion;
    private Socket cliente;
    private int numCliente;
    private String message;
    private BufferedReader in;
    private PrintWriter out;
    private boolean active = false;

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
                readBuffer();
                processInfo();
            }

        } catch (IOException e) {
            System.out.println("Error en la comunicacion con el cliente");
            this.active = false;
        } finally {

            //Este metodo se cambiara de lugar
            try {
                cliente.close();
                this.active = false;
            } catch (IOException e) {
                System.out.println("No se pudo cerrar el socket ¿Esta en uso?");
            }
        }
    }

    public void processInfo() {
        System.out.println("Se recibio el siguiente mensaje del cliente: " + this.IdConexion + ", " + this.message);
        String infoId = message.substring(0, 2);
        String infoString = message.substring(3);

        switch (infoId) {
            case "ID"://ID del cliente
                this.IdConexion = infoString;
                SendToBuffer("ID-true");
                break;
            case "ET"://End Time, cuando el cliente notifica que se ah acabado el tiempo
                if (infoString.equals("true")) {
                    System.out.println("El tiempo ha llegado correctamente");
                    //Aqui se verificara con la computadora que corresponde
                }
                break;
            case "EF"://Se confirma la detencion del tiempo forzada

                break;
            case "TM"://Se confirma la recepcion del tiempo por parte del cliente
                if (infoString.equals("TimeSet")) {
                    System.out.println("El tiempo esta listo");
                }
                break;
            case "ED"://Fin de la conexion  
            default:
                System.out.println("Se ah pedido que se cierre la conexion o esta inactiva");
                try {
                    cliente.close();
                } catch (IOException ex) {
                    Logger.getLogger(ComunicationHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

        }
    }

    public void readBuffer() {
        try {
            this.message = in.readLine();

        } catch (IOException ex) {
            Logger.getLogger(ComunicationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void SendToBuffer(String input) {
        out.println(input);
    }

    /**
     * @return the IdConexion
     */
    public String getIdConexion() {
        return IdConexion;
    }

    public boolean isActive() {
        return active;
    }

}
