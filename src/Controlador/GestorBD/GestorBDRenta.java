/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.GestorBD;

import Modelo.Computadora;
import Modelo.RentaComputadora;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author x
 */
public class GestorBDRenta extends GestorBD {
    public void agregarComputadora(RentaComputadora renta){
         String consulta="INSERT INTO usuarios  (,,'','','',) VALUES(";
                
    }
    
    public void modificarComputadora(Computadora computadora,String condicion){
        
    }
    
    public void eliminarComputadora(Computadora computadora){
        
    }
    
    public void buscarComputadora(Computadora computadora){
        
    }
    
    public ArrayList <Computadora> consultarComputadoras(String condicion){
    return null;
    }
    
    public static void main(String[] args) {
        GestorBDRenta gestor=new GestorBDRenta();
        gestor.establecerConexion();
    }
}