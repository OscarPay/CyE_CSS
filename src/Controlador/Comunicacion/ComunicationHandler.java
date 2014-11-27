package Controlador.Comunicacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Kev' Pacheco
 */
public class ComunicationHandler extends Thread {

    private String IdConexion;
    private Socket cliente;
    private int numCliente;
    private String message;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean active = false;

    public ComunicationHandler(Socket cliente) {
        this.cliente = cliente;
        this.active = true;

        System.out.println("Nuevo arrivo de cliente num" + this.numCliente);
        initializeBuffers();
        
        SendToBuffer("ID");
        
    }

    public void initializeBuffers() {
        try {
            //Se declara un BufferedReader que manejara
            //Las entradas del cliente
            in = new DataInputStream(cliente.getInputStream());

            //El printWriter se encargara de enviar mensajes al cliente
            out = new DataOutputStream(cliente.getOutputStream());
            //out = new PrintWriter(cliente.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error en la comunicacion con el cliente");
            this.active = false;
        }
    }

    public void run() {
        //SendToBuffer("ID");
        
        while (true) {
            readBuffer();
            processInfo();
        }

    }

    public void processInfo() {
        System.out.println("Se recibio el siguiente mensaje del cliente: " + this.IdConexion + ", " + this.message);
        
        if(message == null) return;
        
        System.out.println(message);
        
        String infoId = message.substring(0, 2);
        String infoString = message.substring(3);

        switch (infoId) {
            case "ID"://ID del cliente
                this.IdConexion = infoString;
                
                System.out.println(infoString);
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
            case "AT":

                break;
            case "ED"://Fin de la conexion  
            default:
                System.out.println("Se ah pedido que se cierre la conexion o esta inactiva");
                try {
                    cliente.close();
                    System.out.println("se cerro el socke");
                } catch (IOException ex) {
                    System.out.println("Error cerrando la conexion");
                }
                break;

        }
    }

    public void readBuffer() {
        try {
            
            this.message = in.readUTF();

        } catch (IOException ex) {
            System.out.println("Error leyendo los mensajes");
        }

    }

    public void SendToBuffer(String input) {
        try {
            System.out.println("Se envia el sig mensaje" + input);
            out.writeUTF(input);
        } catch (IOException ex) {
            System.out.println("Error al enviar mensaje");
        }
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
