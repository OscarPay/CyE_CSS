/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdminRegistroCompu;
import Modelo.AdminRegistrosXbox;
import Modelo.RegistroCompu;
import Modelo.RegistroXbox;

public class CtrlAdministradores {
    
    public void agregarRegComputadora(int idCompu, String tiempoSolicitado) {
        AdminRegistroCompu adminComputadoras = AdminRegistroCompu.getINSTANCE();
        RegistroCompu registroCompu = new RegistroCompu(idCompu,tiempoSolicitado);
        adminComputadoras.agregarRegistroCompu(registroCompu);
    }
    
    public void eliminarRegComputadora(int idCompu){
        AdminRegistroCompu adminRentaCompu = AdminRegistroCompu.getINSTANCE();        
        adminRentaCompu.eliminarRegistroCompu(idCompu);
    }
    
    public RegistroCompu buscarRegCompuPorId(int idCompu){
        AdminRegistroCompu adminRentaCompu = AdminRegistroCompu.getINSTANCE();        
        return adminRentaCompu.buscarRegistroCompuPorId(idCompu);
    }
    
    public void agregarRegXbox(int idXbox, int numControles, String tiempoSolicitado) {
        AdminRegistrosXbox adminRegistrosXbox = AdminRegistrosXbox.getINSTANCE();
        RegistroXbox registroXbox = new RegistroXbox(idXbox, numControles, tiempoSolicitado);
        adminRegistrosXbox.agregarRegistroXbox(registroXbox);
    }
    
    public void eliminarRegistroComputadora(int idXbox){
        AdminRegistrosXbox adminRegistrosXbox = AdminRegistrosXbox.getINSTANCE();        
        adminRegistrosXbox.eliminarRegistroXbox(idXbox);
    }
    
    
    public RegistroXbox buscarRegXboxPorId(int idXbox){
        AdminRegistrosXbox adminRegistrosXbox = AdminRegistrosXbox.getINSTANCE();        
        return adminRegistrosXbox.buscarRegistroXboxPorId(idXbox);
    }    

    public AdminRegistrosXbox getAdminXboxs() {         
        return AdminRegistrosXbox.getINSTANCE();
    }
    
    public AdminRegistroCompu getAdminComputadoras(){
        return AdminRegistroCompu.getINSTANCE();
    }
    
    

}
