/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Patrones.Observer;

/**
 *
 * @author A09003539
 */
public abstract class Controlador implements Observer{
    
    public abstract void Inicializar();       
    public abstract void ManejarEvento();    
    public abstract void Actualizar(int v1, int v2, int v3);
    
    
}
