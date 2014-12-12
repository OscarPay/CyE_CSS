/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.LogicaNegocios;

import Modelo.GananciaPorServicio;
import Modelo.NotaVentaDia;
import Modelo.Producto;
import Modelo.RentaComputadora;
import Modelo.RentaXbox;
import java.util.ArrayList;

/**
 *
 * @author hyuchiha
 */
public class GeneradorReportes {
    
    public int gananciaDeTodasLasComputadoras(ArrayList<RentaComputadora> computadoras){
        int ganancias =0;
        
        for(RentaComputadora computadora : computadoras){
            ganancias+= Double.parseDouble(computadora.getPrecio());
        }
        
        return ganancias;
    }
    
    public ArrayList<GananciaPorServicio> obtenerGananciaDeProductosIndividuales(
                        ArrayList<NotaVentaDia> productos){
        ArrayList<GananciaPorServicio> ganancias = new ArrayList();
        
        for(NotaVentaDia nota : productos){
            int idProducto = Integer.parseInt(nota.getProducto().getId());
            String nombreProducto = nota.getProducto().getNombreProduc();
            GananciaPorServicio nuevo = new GananciaPorServicio(nombreProducto,
                                            this.gananciaPorIdProducto(productos,idProducto));
            
            ganancias.add(nuevo);
        }
        
        return ganancias;
    }
    
    private int gananciaPorIdProducto(ArrayList<NotaVentaDia> notas, int id){
        int ganancia=0;
        
        for(NotaVentaDia nota:notas){
            ganancia+= nota.getPrecioTotal();
        }
        
        return ganancia;
    }
    
    public ArrayList<GananciaPorServicio> obtenerGananciaPorCadacomputadora(
                        ArrayList<RentaComputadora> computadoras){
        ArrayList<GananciaPorServicio> ganancias = new ArrayList();
        
        for(RentaComputadora computadora : computadoras){
            int idCompu = computadora.getIdComp();
            String nombreProducto = "Computadora";
            GananciaPorServicio nuevo = new GananciaPorServicio(nombreProducto,
                                            gananciasPorIdComputadora(computadoras,idCompu));
            
            ganancias.add(nuevo);
        }
        
        return ganancias;
    }
    
    private int gananciasPorIdComputadora(ArrayList<RentaComputadora> computadoras, int idCompu){
        int ganancia =0;
        
        for(RentaComputadora computadora : computadoras){
            if(computadora.getIdComp() == idCompu){
                ganancia+= Double.parseDouble(computadora.getPrecio());
            }
        }
        
        return ganancia;
    }
    
    public ArrayList<GananciaPorServicio> obtenerGananciaPorCadaxbox(ArrayList<RentaXbox> xboxs){
        ArrayList<GananciaPorServicio> ganancias = new ArrayList();
        
        for(RentaXbox xbox : xboxs){
            int idXbox = xbox.getIdXbox();
            String nombreProducto = "Xbox";
            GananciaPorServicio nuevo = new GananciaPorServicio(nombreProducto,
                                            gananciasPorIdXbox(xboxs,idXbox));
            
            ganancias.add(nuevo);
        }
        
        return ganancias;
    }
    
    public int gananciaDeTodasLosXbox(ArrayList<RentaXbox> xboxs){
        int ganancias =0;
        
        for(RentaXbox xbox : xboxs){
            ganancias+= Double.parseDouble(xbox.getPrecio());
        }
        
        return ganancias;
    }
    
    private int gananciasPorIdXbox(ArrayList<RentaXbox> xboxs, int idXbox){
        int ganancia =0;
        
        for(RentaXbox xbox : xboxs){
            if(xbox.getIdXbox() == idXbox){
                ganancia+= Double.parseDouble(xbox.getPrecio());
            }
        }
        
        return ganancia;
    }
    
    public int gananciaPorProductos(ArrayList<NotaVentaDia> notas){
        int ganancias=0;
        
        for(NotaVentaDia nota : notas){
            ganancias += nota.getPrecioTotal();
        }
        
        return ganancias;
    }
    
    
    
}
