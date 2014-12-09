/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.LogicaNegocios;

import Modelo.CalculadoraPrecios;
import Modelo.RegistroXbox;
import Modelo.Temporizador;
import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class AdminRegistrosXbox {
   
    private static final AdminRegistrosXbox INSTANCE = new AdminRegistrosXbox();
    private static final String XBOX = "Xbox"; 
    private final ArrayList<RegistroXbox> registrosXbox = new ArrayList<>();
    
    private AdminRegistrosXbox(){    
    }

    public static AdminRegistrosXbox getINSTANCE() {
        return INSTANCE;
    }    
    
    public void agregarRegistroXbox(int idXbox, int numControles, String tiempoSolicitado){
        RegistroXbox registroXbox = crearRegistroXbox(idXbox, tiempoSolicitado, numControles);
        registrosXbox.add(registroXbox);
    }    

    private RegistroXbox crearRegistroXbox(int idXbox, String tiempoSolicitado, int numControles) {
        Temporizador temp = AdminTiempo.nuevoTemporizador(idXbox, tiempoSolicitado, XBOX);
        CalculadoraPrecios calcu = AdminPrecios.nuevaCalculadora(temp, idXbox, XBOX, numControles);
        String tiempoEntrada = AdminTiempo.obtenerHoraActual();
        RegistroXbox registroXbox = new RegistroXbox(idXbox, numControles, tiempoSolicitado, tiempoEntrada, temp, calcu);
        return registroXbox;
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
       RegistroXbox registroXbox = admin.buscarRegistroXboxPorId(id);
       int numControles = registroXbox.getNumComtroles();
       String horaEntrada = registroXbox.getHoraEntrada();
       String horaSalida = AdminTiempo.obtenerHoraActual();
       String precioTotal = registroXbox.getCalculadoraPrecio().getPrecioTotal();
       String tiempoTranscurrido = registroXbox.getTemporizador().getTiempoTranscurrido();
       String fecha = AdminTiempo.obtenerFecha();
       AdminDatosRenta.crearRentaXbox(id, numControles, horaEntrada, horaSalida, 
               tiempoTranscurrido, precioTotal, fecha);
    }
      
    
}
