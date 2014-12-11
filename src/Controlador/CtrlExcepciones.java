/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Exceptions.HoraInvalida;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Oscar
 */
public class CtrlExcepciones {
    
    private static final String FORMATO_DATE = "HH:mm:ss";
    private static final String HORA_NULA = "00:00:00";
    private static final String DOS_PUNTOS = ":";    
    
    public void validarFormatoHora(String tiempoSolicitado) throws HoraInvalida {
        try {
            DateFormat formatoHora = new SimpleDateFormat(FORMATO_DATE);
            formatoHora.parse(tiempoSolicitado);

            if (tiempoSolicitado.equals(HORA_NULA)) {
                throw new HoraInvalida();
            }
            
            dividirElementosHora(tiempoSolicitado);
            
        } catch (ParseException ex) {
            throw new HoraInvalida();
        }
    }

    private void dividirElementosHora(String tiempoSolicitado) throws HoraInvalida {
        String[] numeros = tiempoSolicitado.split(DOS_PUNTOS);
        for (String s : numeros) {
            validarNumeros(s);
        }
    }

    private void validarNumeros(String s) throws HoraInvalida {
        try {
            int numero = Integer.parseInt(s);
            if (numero > 59) {
                throw new HoraInvalida();
            }
        } catch (NumberFormatException ex) {
            throw new HoraInvalida();
        }
    }
}
