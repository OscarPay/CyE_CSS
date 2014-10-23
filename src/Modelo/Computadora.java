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
public class Computadora {

    private boolean ocupada = false;
    public int idCompu;

    private Temporizador temporizador = null;
    private CalculadoraPreciosMaquina adminPrecios = null;

    public Computadora(String tiempoSalida, int numComputadora) {
        this.idCompu = numComputadora;
        this.empezarUso(tiempoSalida);
    }

    public void empezarUso(String tiempoSalida) {
        
        temporizador = new Temporizador(tiempoSalida, idCompu, "Computadora");

        adminPrecios = new CalculadoraPreciosMaquina(
                                            temporizador,
                                            idCompu,
                                            "Computadora",
                                             1);

    }

    public void activarComputadora() {

        temporizador.comenzarTemp();
        adminPrecios.calcularPrecio();

    }

    public Temporizador getCronometro() {
        return temporizador;
    }

}
