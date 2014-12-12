/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.LogicaNegocios;

import Controlador.CtrlMenuPrincipal;
import Controlador.CtrlRenta;
import Modelo.CalculadoraPrecios;
import Modelo.RegistroCompu;
import Modelo.RentaComputadora;
import Modelo.Temporizador;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class AdminRegistrosCompu {

    private static final AdminRegistrosCompu INSTANCE = new AdminRegistrosCompu();
    private static final String COMPUTADORA = "Computadora";
    private final ArrayList<RegistroCompu> registrosCompu = new ArrayList<>();
    private final CtrlRenta ctrlRenta = new CtrlRenta();
    private final CtrlMenuPrincipal ctrlMenuPrincipal = new CtrlMenuPrincipal();

    private AdminRegistrosCompu() {
    }

    public static AdminRegistrosCompu getINSTANCE() {
        return INSTANCE;
    }

    public void agregarRegistroCompu(int idCompu, String tiempoSolicitado) {
        RegistroCompu registroCompu = crearRegistroCompu(idCompu, tiempoSolicitado);
        registrosCompu.add(registroCompu);
    }

    private RegistroCompu crearRegistroCompu(int idCompu, String tiempoSolicitado) {
        Temporizador temp = AdminTiempo.nuevoTemporizador(idCompu, tiempoSolicitado, COMPUTADORA);
        CalculadoraPrecios calcu = AdminPrecios.nuevaCalculadora(temp, idCompu, COMPUTADORA, 1);
        String tiempoEntrada = AdminTiempo.obtenerHoraActual();
        RegistroCompu registroCompu = new RegistroCompu(idCompu, tiempoSolicitado, tiempoEntrada, temp, calcu);
        return registroCompu;
    }

    public void eliminarRegistroCompu(int idCompu) {
        registrosCompu.remove(idCompu);
    }

    public RegistroCompu buscarRegistroCompuPorId(int idCompu) {
        RegistroCompu rentaCompu = null;

        for (RegistroCompu renta : registrosCompu) {
            if (renta.getIdCompu() == idCompu) {
                rentaCompu = renta;
            }
        }
        return rentaCompu;
    }

    public void guardarRentaCompu(int id) {
        try {
            RentaComputadora rentaCompu = crearRentaCompu(id);
            ctrlRenta.agregarRentaCompu(rentaCompu);
            ctrlMenuPrincipal.activarBotonComputadora(id, true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage());
        }

    }

    private RentaComputadora crearRentaCompu(int id) {
        AdminRegistrosCompu admin = AdminRegistrosCompu.getINSTANCE();
        RegistroCompu registroCompu = admin.buscarRegistroCompuPorId(id);
        String horaEntrada = registroCompu.getHoraEntrada();
        String horaSalida = AdminTiempo.obtenerHoraActual();
        String precioTotal = registroCompu.getCalculadoraPrecio().getPrecioTotal();
        String tiempoTranscurrido = registroCompu.getTemporizador().getTiempoTranscurrido();
        Date fecha = new Date(AdminTiempo.obtenerFecha().getTime());
        RentaComputadora rentaCompu = new RentaComputadora(id, precioTotal,
                horaEntrada, horaSalida, tiempoTranscurrido, fecha);
        return rentaCompu;
    }

    public void detenerTemporizador(int idCompu) {
        buscarRegistroCompuPorId(idCompu).getTemporizador().setActivo(false);
    }

    public void agregarTiempo(int id, String tiempoAgregado) {
        buscarRegistroCompuPorId(id).setTiempoSolicitado(tiempoAgregado);
        buscarRegistroCompuPorId(id).getTemporizador().agregarTiempoSolicitado(tiempoAgregado);
    }

}
