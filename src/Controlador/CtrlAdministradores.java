/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdminComputadoras;
import Modelo.AdminXboxs;

public class CtrlAdministradores {
    
    public void iniciarComputadora(String tiempoSalida, int numComputadora) {
        AdminComputadoras adminComputadoras = AdminComputadoras.getInstance();
        adminComputadoras.iniciarComputadora(tiempoSalida, numComputadora);
    }
    
    public void iniciarXbox(String tiempoSalida, int numXbox) {
        AdminXboxs adminXboxs = AdminXboxs.getInstance();
        adminXboxs.iniciarXbox(tiempoSalida, numXbox);
    }

    public AdminXboxs getAdminXboxs() {         
        return AdminXboxs.getInstance();
    }
    
    public AdminComputadoras getAdminComputadoras(){
        return AdminComputadoras.getInstance();
    }

}
