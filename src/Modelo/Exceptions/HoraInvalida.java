/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Exceptions;

/**
 *
 * @author Oscar
 */
public class HoraInvalida extends Exception {

    /**
     * Creates a new instance of <code>HoraInvalida</code> without detail
     * message.
     */
    public HoraInvalida() {
        super("Hora Invalida");
    }

    /**
     * Constructs an instance of <code>HoraInvalida</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public HoraInvalida(String msg) {
        super(msg);
    }
}
