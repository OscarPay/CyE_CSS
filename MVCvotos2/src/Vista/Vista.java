/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Patrones.Observer;

/**
 *
 * @author A09003539
 */
public abstract class Vista implements Observer{
    
    public abstract void Inicializar();
    public abstract void Activar();
    public abstract void Desplegar();
    public abstract void Actualizar(int v1, int v2, int v3);
    
}
