/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.GestorBD.GestorBDRentaCompu;
import Controlador.GestorBD.GestorBDRentaXbox;
import Modelo.RentaComputadora;
import Modelo.RentaXbox;
import java.sql.SQLException;

/**
 *
 * @author Oscar
 */
public class CtrlRenta {
    
    GestorBDRentaCompu gestorCompu = new GestorBDRentaCompu();
    GestorBDRentaXbox gestorXbox = new GestorBDRentaXbox();
    
    public boolean agregarRentaCompu(RentaComputadora renta) throws SQLException{            
            gestorCompu.establecerConexion();      
            return gestorCompu.agregarRenta(renta);
    }
    
    public boolean agregarRentaXbox(RentaXbox renta) throws SQLException{            
            gestorXbox.establecerConexion();      
            return gestorXbox.agregarRenta(renta);
    }
    
}
