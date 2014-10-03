/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class Xbox extends Thread {
    
     private String entrada;
    private String total;
    boolean cronometroActivo;    
    
    public Xbox(String msg, String entrada){
        super(msg);
        this.entrada = entrada;        
    }
    
    public void run(){
        Integer minutos=0, segundos=0, milesimas=0;        
        String min="", seg="", mil="";
        inicarCronometro();
        
        try{
            while(cronometroActivo){
                Thread.sleep(100);
                
                milesimas +=100;
                
                if(milesimas == 1000){
                    milesimas=0;
                    segundos += 1;
                    
                    if(segundos == 60){
                        segundos = 0;
                        minutos++;
                    }
                }
                
                if(minutos<10){ 
                    min="0" + minutos;                    
                }else{
                    min = minutos.toString();
                }
                
                if(segundos<10){
                    seg="0" + segundos;
                }else{
                    seg = segundos.toString();
                }
                
                if(milesimas<10){
                    mil = "00" + milesimas;
                }else{
                    if(milesimas<100){
                        mil = "0" + milesimas;
                    }else{
                        mil = milesimas.toString();
                    }
                }
                System.out.println(this.getName()+min+":"+seg+":"+mil);
                this.total = min+":"+seg+":"+mil; 
                
                if(getEntrada().equals(getTotal())){
                    JOptionPane.showMessageDialog(null,"Se termino el tiempo");
                    pararCronometro();
                }
                
            }
        }catch(Exception e){};        
        
    }
    
    private final void inicarCronometro(){
         cronometroActivo = true;        
    }
    
    public void pararCronometro(){
        cronometroActivo = false;
        JOptionPane.showMessageDialog(null, getTotal());
    }

    /**
     * @return the entrada
     */
    public String getEntrada() {
        return entrada;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }    
}
