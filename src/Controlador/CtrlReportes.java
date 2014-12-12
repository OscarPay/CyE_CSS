/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.MenuPrincipal;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author hyuchiha
 */

public class CtrlReportes {
    
    public void obtenerDatosParaRegistro(String tipo, Date fechaEntrada, Date fechaSalida){
        
    }
    
    public void inicializaComboMeses() {
        DefaultComboBoxModel modeloCombo1 = new DefaultComboBoxModel();
        DefaultComboBoxModel modeloCombo2 = new DefaultComboBoxModel();
        
        for(int i=1;i<12;i++){
            modeloCombo1.addElement(1);
            modeloCombo2.addElement(2);
        }
        
        MenuPrincipal.comboMesEntrada.setModel(modeloCombo1);
        MenuPrincipal.comboMesSalida.setModel(modeloCombo2);
    }
    
    public void inicializaAños(){
        DefaultComboBoxModel modeloCombo1 = new DefaultComboBoxModel();
        DefaultComboBoxModel modeloCombo2 = new DefaultComboBoxModel();
        
        modeloCombo1.addElement("2012");
        modeloCombo2.addElement("2012");
        modeloCombo1.addElement("2013");
        modeloCombo2.addElement("2013");
        modeloCombo1.addElement("2014");
        modeloCombo2.addElement("2014");
        java.util.Date date = new java.util.Date();
        int año = date.getYear();
        int ultimoAño = Integer.parseInt("2014");
        if(ultimoAño < año){
            ultimoAño++;
            modeloCombo1.addElement(ultimoAño);
            modeloCombo2.addElement(ultimoAño);
        }
        
        MenuPrincipal.comboAñoEntrada.setModel(modeloCombo1);
        MenuPrincipal.comboAñoSalida.setModel(modeloCombo2);
    }
    
    public void inicializaDias(){
        DefaultComboBoxModel modeloCombo1 = new DefaultComboBoxModel();
        DefaultComboBoxModel modeloCombo2 = new DefaultComboBoxModel();
        
        for(int i=1; i<=31 ;i++){
            modeloCombo1.addElement(i);
            modeloCombo2.addElement(i);
        }
        
        MenuPrincipal.comboDiaEntrada.setModel(modeloCombo1);
        MenuPrincipal.comboDiaSalida.setModel(modeloCombo2);
    }
    
    public void generarReporte() throws NumberFormatException {
        // TODO add your handling code here:
        int diaentrada = Integer.parseInt(MenuPrincipal.comboDiaEntrada.getSelectedItem().toString());
        int diaSalida = Integer.parseInt(MenuPrincipal.comboDiaSalida.getSelectedItem().toString());
        int mesEntrada = Integer.parseInt(MenuPrincipal.comboMesEntrada.getSelectedItem().toString());
        int mesSalida = Integer.parseInt(MenuPrincipal.comboMesSalida.getSelectedItem().toString());
        int AñoEntrada = Integer.parseInt(MenuPrincipal.comboAñoEntrada.getSelectedItem().toString());
        int AñoSalida = Integer.parseInt(MenuPrincipal.comboAñoSalida.getSelectedItem().toString());
        
        java.sql.Date fechaAntes = new java.sql.Date(diaentrada,mesEntrada,AñoEntrada);
        java.sql.Date fechaDespues = new java.sql.Date(diaSalida,mesSalida,AñoSalida);
    }
    
}
