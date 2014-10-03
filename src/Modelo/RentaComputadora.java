/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;

/**
 *
 * @author Oscar
 */
public class RentaComputadora {
    Date fecha;
    Date horaEntrada;
    Date horaSalida;
    Double ganancia;
    int idComputadora;

    public RentaComputadora(Date fecha, Date horaEntrada, Date horaSalida, Double ganancia, int idComputadora) {
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.ganancia = ganancia;
        this.idComputadora = idComputadora;
    }    
}
