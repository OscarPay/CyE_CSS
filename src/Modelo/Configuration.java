/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import org.ini4j.Wini;

/**
 *
 * @author hyuchiha
 */
public class Configuration {

    private static final String CONFIGURATION = "Configuration.ini";
    private static Wini configuration;

    static {

        try {
            File file = new File(CONFIGURATION);

            if (!file.exists()) {
                file.createNewFile();
                
                configuration = new Wini(file);
                
                createData();
            }else{
               configuration = new Wini(file); 
            }
            
        } catch (IOException ex) {
            System.out.println("Error archivo de configuracion no encoentrado");
        }
    }
    
    private static void createData(){
        configuration.put("Servidor", "HOST", 0);
        configuration.put("Servidor", "PORT", 0);
        configuration.put("Servidor", "Usuario", 0);
        configuration.put("Servidor", "Password", 0);
        configuration.put("Servidor", "BD", 0);
    }
    

    public static String getIp() {
        return configuration.get("Servidor", "IP");
    }

    public static String getPort() {
        return configuration.get("Servidor", "PORT");
    }

    public static String getUsuario() {
        return configuration.get("Servidor", "Usuario");
    }

    public static String getContraseña(){
        return configuration.get("Servidor", "Password");
    }
    
    public static String getNombreDB(){
        return configuration.get("Servidor", "BD");
    }

}
