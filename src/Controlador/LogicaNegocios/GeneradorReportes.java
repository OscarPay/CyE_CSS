/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.LogicaNegocios;

import Modelo.Producto;
import Modelo.RentaComputadora;
import Modelo.RentaXbox;
import java.util.ArrayList;

/**
 *
 * @author hyuchiha
 */
public class GeneradorReportes {
    
    private String ObtenerProductoMasVendido(ArrayList<Producto> productos){
        ArrayList<Producto> respaldo = productos;
        
        int contadorDelProductoActual = 0;
        String productoActual = null;
        for(Producto producto: productos){
            
            int contadorProductoAux=0;
            for(Producto productoAux: respaldo){
                if(productoAux.getNombreProduc().equals(producto.getNombreProduc())){
                    contadorProductoAux++;
                }
                
                if(contadorDelProductoActual< contadorProductoAux){
                    contadorDelProductoActual = contadorProductoAux;
                    productoActual = productoAux.getNombreProduc();
                }
            }
        }
        
        
        return productoActual;
    }
    
    public int gananciaDeTodasLasComputadoras(ArrayList<RentaComputadora> computadoras){
        int ganancias =0;
        
        for(RentaComputadora computadora : computadoras){
            ganancias+= Double.parseDouble(computadora.getPrecio());
        }
        
        return ganancias;
    }
    
    public int gananciasPorComputadora(ArrayList<RentaComputadora> computadoras, int idCompu){
        int ganancia =0;
        
        for(RentaComputadora computadora : computadoras){
            if(computadora.getIdComp() == idCompu){
                ganancia+= Double.parseDouble(computadora.getPrecio());
            }
        }
        
        return ganancia;
    }
    
    public int gananciaDeTodasLosXbox(ArrayList<RentaXbox> xboxs){
        int ganancias =0;
        
        for(RentaXbox xbox : xboxs){
            ganancias+= Double.parseDouble(xbox.getPrecio());
        }
        
        return ganancias;
    }
    
    public int gananciasPorXbox(ArrayList<RentaXbox> xboxs, int idXbox){
        int ganancia =0;
        
        for(RentaXbox xbox : xboxs){
            if(xbox.getIdXbox() == idXbox){
                ganancia+= Double.parseDouble(xbox.getPrecio());
            }
        }
        
        return ganancia;
    }
    
    public int gananciaPorProductos(ArrayList<Producto> productos){
        int ganancias=0;
        
        for(Producto producto : productos){
            ganancias += producto.getPrecioVenta();
        }
        
        return ganancias;
    }
    
    
    
}
