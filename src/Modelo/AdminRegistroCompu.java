/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class AdminRegistroCompu {
    
    private static final AdminRegistroCompu INSTANCE = new AdminRegistroCompu();
    private final ArrayList<RegistroCompu> registrosCompu = new ArrayList<>();
    
    private AdminRegistroCompu(){    
    }

    public static AdminRegistroCompu getINSTANCE() {
        return INSTANCE;
    }    
    
    public void agregarRegistroCompu(RegistroCompu rentaCompuTemp){
        registrosCompu.add(rentaCompuTemp);
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
    
}
