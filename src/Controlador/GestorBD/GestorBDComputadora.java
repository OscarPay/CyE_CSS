/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.GestorBD;

import Modelo.Computadora;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author x
 */
public class GestorBDComputadora extends GestorBD {
    public void agregarComputadora(Computadora computadora){
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
        GestorBDComputadora gestor=new GestorBDComputadora();
        gestor.establecerConexion();
    }
}