/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.AdminVotos;
import Vista.Barras;
import Vista.Pastel;
import java.util.Scanner;

/**
 *
 * @author A09003539
 */
public class EntradaVotos extends Controlador {

     AdminVotos adminVotos;
        
    public EntradaVotos(){
        this.adminVotos = AdminVotos.getInstance();
        Barras barra = new Barras(adminVotos);
        Pastel pastel = new Pastel(adminVotos);
    }
    
    @Override
    public void Inicializar() {        
      
    }

    
    public void ManejarEvento(String c) {         
      switch (c){
          case "Candidato1":
        	  adminVotos.votoCandidato1(this.getClass().getName());
              //Inicializar();
              break;
          case "Candidato2":
              adminVotos.votoCandidato2(this.getClass().getName());
              //Inicializar();
              break;
          case "Candidato3":
              adminVotos.votoCandidato3(this.getClass().getName());
              //Inicializar();
              break;          
      }         
    }
    
    public String verVotos(){
        return adminVotos.verVotos();
    }    

    @Override
    public void ManejarEvento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Actualizar(int votos1, int votos2, int votos3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
