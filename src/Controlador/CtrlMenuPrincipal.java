/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.LogicaNegocios.AdminRegistrosCompu;
import Controlador.LogicaNegocios.AdminRegistrosXbox;
import Modelo.Observador;
import Modelo.RentaComputadora;
import Modelo.RentaXbox;
import Vista.MenuPrincipal;
import Vista.VtnOpcionesCompu;
import Vista.VtnOpcionesXbox;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class CtrlMenuPrincipal implements Observador {

    private final AdminRegistrosCompu adminRegistrosCompus = AdminRegistrosCompu.getINSTANCE();
    private final AdminRegistrosXbox adminRegistrosXbox = AdminRegistrosXbox.getINSTANCE();
    
    public void crearVentanaOpcionesCompu(int idCompu) {
        VtnOpcionesCompu vtnOpsCompu = new VtnOpcionesCompu(idCompu);
        vtnOpsCompu.setVisible(true);
    }
    
    public void crearVentanaOpcionesXbox(int idXbox) {
        VtnOpcionesXbox vtnOpsXbox = new VtnOpcionesXbox(idXbox);
        vtnOpsXbox.setVisible(true);
    }
    
    /**
     * Me agrega un observador a un cronometro
     *
     * @param obs La ventana MenuPrincipal
     * @param posicion La posicion de la computadora dentro del arreglo
     */
    private void agregarObservadorCompu(int idCompu) {
        adminRegistrosCompus.buscarRegistroCompuPorId(idCompu).getTemporizador()
                .getObservado().agregar(this);
    }

    private void agregarObservadorXbox(int idXbox) {
        adminRegistrosXbox.buscarRegistroXboxPorId(idXbox).getTemporizador()
                .getObservado().agregar(this);
    }

    public void iniciarUsoCompu(int idCompu, String tiempoSolicitado) {
        adminRegistrosCompus.agregarRegistroCompu(idCompu, tiempoSolicitado);
        agregarObservadorCompu(idCompu);
    }

    public void iniciarUsoXbox(int idXbox, int numControles, String tiempoSolicitado) {
        adminRegistrosXbox.agregarRegistroXbox(idXbox, numControles, tiempoSolicitado);
        agregarObservadorXbox(idXbox);
    }
    
    /**
     * Actualizar los datos del observador
     *
     * @param tiempo El tiempo que transcurre
     * @param numero El numero de maquina
     * @param maquina El tipo de maquina (RentaComputadora o RentaXbox)
     */
    @Override
    public void actualizarTiempo(String tiempo, int numero, String maquina) {
        
        switch (maquina) {
            
            case RentaComputadora.COMPUTADORA:
                this.actualizarTiempoComputadora(numero, tiempo);
                break;
            
            case RentaXbox.XBOX:
                this.actualizarTiempoXbox(numero, tiempo);
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Error, Xbox");
        }
        
    }
    
    @Override
    public void actualizarPrecio(String precio, int numero, String maquina) {
        
        switch (maquina) {
            
            case RentaComputadora.COMPUTADORA:
                this.actualizarPrecioComputadora(numero, precio);
                break;
            
            case RentaXbox.XBOX:
                this.actualizarPrecioXbox(numero, precio);
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Error, Xbox");
            
        }
        
    }

    /**
     * Me actualiza el labal de una computadora
     *
     * @param idCompu El numero de la computadora
     * @param tiempo El tiempo que transcurre
     */
    private void actualizarTiempoComputadora(int idCompu, String tiempo) {
        
        switch (idCompu) {
            
            case 1:
                MenuPrincipal.lblTiempoCompu1.setText(tiempo);
                break;
            
            case 2:
                MenuPrincipal.lblTiempoCompu2.setText(tiempo);
                break;
            
            case 3:
                MenuPrincipal.lblTiempoCompu3.setText(tiempo);
                break;
            
            case 4:
                MenuPrincipal.lblTiempoCompu4.setText(tiempo);
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Error, Computadora");
            
        }
        
    }

    /**
     * Me actualiza el labal de un RentaXbox
     *
     * @param idXbox El numero del RentaXbox
     * @param tiempo El tiempo que transcurre
     */
    private void actualizarTiempoXbox(int idXbox, String tiempo) {
        
        switch (idXbox) {
            case 1:
                MenuPrincipal.lblTiempoXbox1.setText(tiempo);
                break;
            case 2:
                MenuPrincipal.lblTiempoXbox2.setText(tiempo);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error, Xbox");
        }
        
    }
    
    private void actualizarPrecioComputadora(int idCompu, String precio) {
        
        switch (idCompu) {
            
            case 1:
                MenuPrincipal.lblPrecioCompu1.setText(precio);
                break;
            
            case 2:
                MenuPrincipal.lblPrecioCompu2.setText(precio);
                break;
            
            case 3:
                MenuPrincipal.lblPrecioCompu3.setText(precio);
                break;
            
            case 4:
                MenuPrincipal.lblPrecioCompu4.setText(precio);
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Error, Computadora");
        }
        
    }
    
    private void actualizarPrecioXbox(int idXbox, String precio) {
        
        switch (idXbox) {
            case 1:
                MenuPrincipal.lblPrecioXbox1.setText(precio);
                break;
            
            case 2:
                MenuPrincipal.lblPrecioXbox2.setText(precio);
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "Error, Xbox");
        }
    }
    
    public void activarBotonComputadora(int id, boolean activo) {
        switch (id) {
            case 1:
                MenuPrincipal.btnComputadora1.setEnabled(activo);                
                break;
            case 2:
                MenuPrincipal.btnComputadora2.setEnabled(activo);
                break;
            case 3:
                MenuPrincipal.btnComputadora3.setEnabled(activo);
                break;
            case 4:
                MenuPrincipal.btnComputadora4.setEnabled(activo);
                break;
        }
        
    }
    
    public void activarBotonXbox(int id, boolean activo) {
        switch (id) {
            case 1:
                MenuPrincipal.btnXbox1.setEnabled(activo);
                break;
            case 2:
                MenuPrincipal.btnXbox2.setEnabled(activo);
                break;
        }
    }
    
       
    
}