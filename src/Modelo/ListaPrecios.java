/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Oscar
 */
public class ListaPrecios {
    
    private static int precioBase = 10;
    private static String tipoDisp = "";
    
    
    public static int getPrecioBase(String tipoDisp, int numControles){
        
        int precio = 0;
        
        switch(numControles){            
            case 1: 
                precio = precioBase;
                break;
            case 2:
                precio = precioBase+5;
                break;
            case 3:
                precio = precioBase+10;
                break;
            case 4:
                precio = precioBase+15;
                break;                
        }
        
        return precio;
        
    }
    
    
}
