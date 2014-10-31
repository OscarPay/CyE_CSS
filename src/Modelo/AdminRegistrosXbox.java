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
    
}
