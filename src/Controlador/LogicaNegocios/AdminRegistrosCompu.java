/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.LogicaNegocios;

import Modelo.CalculadoraPrecios;
import Modelo.RegistroCompu;
import Modelo.Temporizador;
import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class AdminRegistrosCompu {
    
    private static final AdminRegistrosCompu INSTANCE = new AdminRegistrosCompu();
    private static final String COMPUTADORA = "Computadora";
    private final ArrayList<RegistroCompu> registrosCompu = new ArrayList<>();
    
    
    private AdminRegistrosCompu(){    
    }

    public static AdminRegistrosCompu getINSTANCE() {
        return INSTANCE;
    }    
    
    public void agregarRegistroCompu(int idCompu, String tiempoSolicitado){ 
        RegistroCompu registroCompu = crearRegistroCompu(idCompu, tiempoSolicitado);
        registrosCompu.add(registroCompu);
    }    

    private RegistroCompu crearRegistroCompu(int idCompu, String tiempoSolicitado) {
        Temporizador temp = AdminTiempo.nuevoTemporizador(idCompu, tiempoSolicitado, COMPUTADORA);
        CalculadoraPrecios calcu = AdminPrecios.nuevaCalculadora(temp, idCompu, COMPUTADORA, 1);
        String tiempoEntrada = AdminTiempo.obtenerHoraActual();
        RegistroCompu registroCompu = new RegistroCompu(idCompu, tiempoSolicitado, tiempoEntrada, temp, calcu);
        return registroCompu;
    }

    public void eliminarRegistroCompu(int idCompu) {
        registrosCompu.remove(idCompu);
    }
    
    public RegistroCompu buscarRegistroCompuPorId(int idCompu){  
        RegistroCompu rentaCompu = null;
        
        for(RegistroCompu renta:registrosCompu){
            if(renta.getIdCompu()==idCompu){
                rentaCompu = renta;
            }
        }
        return rentaCompu;
    }
    
    public static void crearRentaCompu(int id){
       AdminRegistrosCompu admin = AdminRegistrosCompu.getINSTANCE();
       String tiempoEntrada = admin.buscarRegistroCompuPorId(id).getTiempoEntrada();
       String precioTotal = admin.buscarRegistroCompuPorId(id).getCalculadoraPrecio().getPrecioTotal();
       String tiempoTranscurrido = admin.buscarRegistroCompuPorId(id).getTemporizador().getTiempoTranscurrido();
       AdminDatosRenta.crearRentaCompu(id, tiempoEntrada, tiempoTranscurrido, precioTotal);
    }
    
}
