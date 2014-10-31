/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.GestorBD;

import Modelo.RegistroCompu;
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
    
    public void modificarComputadora(RegistroCompu computadora,String condicion){
        
    }
    
    public void eliminarComputadora(RegistroCompu computadora){
        
    }
    
    public void buscarComputadora(RegistroCompu computadora){
        
    }
    
    public ArrayList <RegistroCompu> consultarComputadoras(String condicion){
    return null;
    }
    
    public static void main(String[] args) {
        GestorBDRenta gestor=new GestorBDRenta();
        gestor.establecerConexion();
    }
}