package Modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Archivo {
//	public static void main(String[] args) {
//		FileWriter fichero = null;
//	    PrintWriter pw = null;
//	    
//	    try
//        {
//            fichero = new FileWriter("c:/prueba/prueba.txt",true);
//            pw = new PrintWriter(fichero);
// 
//            for (int i = 0; i < 10; i++)
//                pw.println("Linea " + i);
// 
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//           try {
//           // Nuevamente aprovechamos el finally para
//           // asegurarnos que se cierra el fichero.
//           if (null != fichero)
//              fichero.close();
//           } catch (Exception e2) {
//              e2.printStackTrace();
//           }
//        }
//	}
	
	
	FileWriter fichero = null;
    PrintWriter pw = null;
    
    private static Archivo INSTANCE = new Archivo();
    
    
    private Archivo() {
    	 
    }
    
    public static Archivo getInstance() {
        return INSTANCE;
    }
    
    public void agregarEntradaEnBitacora(String fechaActual, String clveEvt, String ctrlOrigen,String observadoresDestino){
    	try
        {
            fichero = new FileWriter("c:/prueba/bitacora.txt",true);
            pw = new PrintWriter(fichero);
 
                pw.println(fechaActual+"|"+clveEvt+"|"+ctrlOrigen+"|"+observadoresDestino);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    	
    }
    
    
}
