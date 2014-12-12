/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.GestorBD.DAONotaVentaDia;
import Controlador.GestorBD.DAORentaCompu;
import Controlador.GestorBD.DAORentaXbox;
import Controlador.LogicaNegocios.GeneradorReportes;
import Modelo.GananciaPorServicio;
import Modelo.NotaVentaDia;
import Modelo.RentaComputadora;
import Modelo.RentaXbox;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hyuchiha
 */

public class CtrlReportes {
    DAONotaVentaDia notas;
    DAORentaXbox rentasxbox;
    DAORentaCompu computadoras;
    GeneradorReportes reportes;
    
    public CtrlReportes(){
        notas = new DAONotaVentaDia();
        rentasxbox = new DAORentaXbox();
        computadoras = new DAORentaCompu();
        reportes = new GeneradorReportes();
    }
    
    public int obtenerGananciaProductos(Date fechaEntrada, Date fechaSalida){
        try {
            ArrayList<NotaVentaDia> ventas = notas.obtenerValoresPorFechas(fechaEntrada, fechaSalida);
            
            return reportes.gananciaPorProductos(ventas);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public int obtenerGananciaComputadoras(Date fechaEntrada, Date fechaSalida){
        try {
            ArrayList<RentaComputadora> compus = computadoras.obtenerValoresPorFechas(fechaEntrada, fechaSalida);
            return reportes.gananciaDeTodasLasComputadoras(compus);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int obtenerGananciarXboxs(Date fechaEntrada, Date fechaSalida){
        try {
            ArrayList<RentaXbox> xbox = rentasxbox.obtenerValoresPorFechas(fechaEntrada, fechaSalida);
            return reportes.gananciaDeTodasLosXbox(xbox);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return 0;
    }
    
    public ArrayList<GananciaPorServicio> obtenerGananciaPorCadaProducto(Date fechaEntrada, Date fechaSalida){
        try {
            ArrayList<NotaVentaDia> ventas = notas.obtenerValoresPorFechas(fechaEntrada, fechaSalida);
            
            return reportes.obtenerGananciaDeProductosIndividuales(ventas);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<GananciaPorServicio> obtenerGananciaPorCadaComputadora(Date fechaEntrada, Date fechaSalida){
        try {
            ArrayList<RentaComputadora> compus = computadoras.obtenerValoresPorFechas(fechaEntrada, fechaSalida);
            return reportes.obtenerGananciaPorCadacomputadora(compus);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<GananciaPorServicio> obtenerGananciaPorCadaXbox(Date fechaEntrada, Date fechaSalida){
        try {
            ArrayList<RentaXbox> xbox = rentasxbox.obtenerValoresPorFechas(fechaEntrada, fechaSalida);
            return reportes.obtenerGananciaPorCadaxbox(xbox);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
