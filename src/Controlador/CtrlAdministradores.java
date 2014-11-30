/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.LogicaNegocios.AdminPrecios;
import Controlador.LogicaNegocios.AdminRegistrosCompu;
import Controlador.LogicaNegocios.AdminRegistrosXbox;
import Controlador.LogicaNegocios.AdminTemp;
import Modelo.CalculadoraPrecios;
import Modelo.RegistroCompu;
import Modelo.RegistroXbox;
import Modelo.Temporizador;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CtrlAdministradores {
    
    private final AdminRegistrosCompu adminRegistrosCompus = AdminRegistrosCompu.getINSTANCE();
    private final AdminRegistrosXbox adminRegistrosXbox = AdminRegistrosXbox.getINSTANCE();
    
    public void agregarRegComputadora(int idCompu, String tiempoSolicitado) {
        RegistroCompu registroCompu = crearRegistroCompu(idCompu, tiempoSolicitado);
        adminRegistrosCompus.agregarRegistroCompu(registroCompu);
    }

    private RegistroCompu crearRegistroCompu(int idCompu, String tiempoSolicitado) {
        Temporizador temp = AdminTemp.nuevoTemporizador(idCompu, tiempoSolicitado, "Computadora");
        CalculadoraPrecios calcu = AdminPrecios.nuevaCalculadora(temp, idCompu, "Computadora", 1);
        String tiempoEntrada = obtenerTiempoEntrada();
        RegistroCompu registroCompu = new RegistroCompu(idCompu, tiempoSolicitado, tiempoEntrada, temp, calcu);
        return registroCompu;
    }
    
    public void eliminarRegComputadora(int idCompu){                
        adminRegistrosCompus.eliminarRegistroCompu(idCompu);
    }
    
    public RegistroCompu buscarRegCompuPorId(int idCompu){             
        return adminRegistrosCompus.buscarRegistroCompuPorId(idCompu);
    }
    
    public void agregarRegXbox(int idXbox, int numControles, String tiempoSolicitado) {
        RegistroXbox registroXbox = crearRegistroXbox(idXbox, tiempoSolicitado, numControles);
        adminRegistrosXbox.agregarRegistroXbox(registroXbox);
    }

    private RegistroXbox crearRegistroXbox(int idXbox, String tiempoSolicitado, int numControles) {
        Temporizador temp = AdminTemp.nuevoTemporizador(idXbox, tiempoSolicitado, "Xbox");
        CalculadoraPrecios calcu = AdminPrecios.nuevaCalculadora(temp, idXbox, "Xbox", numControles);
        String tiempoEntrada = obtenerTiempoEntrada();
        RegistroXbox registroXbox = new RegistroXbox(idXbox, numControles, tiempoSolicitado, tiempoEntrada, temp, calcu);
        return registroXbox;
    }
    
    public void eliminarRegistroComputadora(int idXbox){                
        adminRegistrosXbox.eliminarRegistroXbox(idXbox);
    }    
    
    public RegistroXbox buscarRegXboxPorId(int idXbox){             
        return adminRegistrosXbox.buscarRegistroXboxPorId(idXbox);
    }    

    public AdminRegistrosXbox getAdminXboxs() {         
        return AdminRegistrosXbox.getINSTANCE();
    }
    
    public AdminRegistrosCompu getAdminComputadoras(){
        return AdminRegistrosCompu.getINSTANCE();
    }   

    private String obtenerTiempoEntrada() {
        Date tiempoEntrada = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(tiempoEntrada);
    }  

}
