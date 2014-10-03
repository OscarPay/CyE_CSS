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
public class TesPC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Thread compu1 = new Computadora("1.-","01:00:000");
       Thread xbox1 = new Computadora("2.-","00:30:000");
       Thread compu2 = new Computadora("3.-","00:15:000");
       
       
       compu1.start();
       xbox1.start();
       compu2.start();
      // compu3.start();
    }    
}
