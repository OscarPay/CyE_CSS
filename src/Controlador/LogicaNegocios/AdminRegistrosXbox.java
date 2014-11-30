/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.LogicaNegocios;

import Modelo.RegistroXbox;
import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class AdminRegistrosXbox {
   
    private static final AdminRegistrosXbox INSTANCE = new AdminRegistrosXbox();
    private final ArrayList<RegistroXbox> registrosXbox = new ArrayList<>();
    
    private AdminRegistrosXbox(){    
    }

    public static AdminRegistrosXbox getINSTANCE() {
        return INSTANCE;
    }    
    
    public void agregarRegistroXbox(RegistroXbox registroXbox){
        registrosXbox.add(registroXbox);
    }

    public void eliminarRegistroXbox(int idXbox) {
        registrosXbox.remove(idXbox);
    }
    
    public RegistroXbox buscarRegistroXboxPorId(int idXbox){  
        RegistroXbox registroXbox = null;
        
        for(RegistroXbox registro:registrosXbox){
            if(registro.getIdXbox()==idXbox){
                registroXbox = registro;
            }
        }
        return registroXbox;
    }    
    
    public static void crearRentaXbox(int id){
       AdminRegistrosXbox admin = AdminRegistrosXbox.getINSTANCE();
       int numControles = admin.buscarRegistroXboxPorId(id).getNumComtroles();
       String tiempoEntrada = admin.buscarRegistroXboxPorId(id).getTiempoEntrada();
       String precioTotal = admin.buscarRegistroXboxPorId(id).getCalculadoraPrecio().getPrecioTotal();
       String tiempoTranscurrido = admin.buscarRegistroXboxPorId(id).getTemporizador().getTiempoTranscurrido();
       
       AdminDatosRenta.crearRentaXbox(id,numControles, tiempoEntrada, tiempoTranscurrido, precioTotal);
    }
      
    
}
