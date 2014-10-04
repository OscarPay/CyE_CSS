/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Patrones.Observer;
import java.util.ArrayList;

/**
 *
 * @author A09003539
 */
public class AdminVotos extends Modelo {

    private static AdminVotos INSTANCE = new AdminVotos();
    
    public ArrayList observadores;

    private Candidato candidato1;
    private Candidato candidato2;
    private Candidato candidato3;
    
    private BitacoraEventos bitacoraEventos;

    private AdminVotos() {
        observadores = new ArrayList();
        this.candidato1 = new Candidato("Enrique");
        this.candidato2 = new Candidato("Felipe");
        this.candidato3 = new Candidato("Vicente");
        //Es como tener en el controlador un admin votos
        this.bitacoraEventos = BitacoraEventos.getInstance();
    }

    public static AdminVotos getInstance() {
        return INSTANCE;
    }
    
	public Candidato getCandidato1() {
        return candidato1;
    }

    public void setCandidato1(Candidato candidato1) {
        this.candidato1 = candidato1;
    }

    public Candidato getCandidato2() {
        return candidato2;
    }

    public void setCandidato2(Candidato candidato2) {
        this.candidato2 = candidato2;
    }

    public Candidato getCandidato3() {
        return candidato3;
    }

    public void setCandidato3(Candidato candidato3) {
        this.candidato3 = candidato3;
    }



    @Override
    public void agregar(Observer obs) {
        observadores.add(obs);
    }
    
    public ArrayList getObservadores(){
    	ArrayList observadoresDestino;
    	
    	observadoresDestino = this.observadores;
    	
    	return observadoresDestino;
    }

    @Override
    public void eliminar(Observer obs) {
        int i = observadores.indexOf(obs);
        if (i >= 0) {
            observadores.remove(i);
        }
    }
    //Este es un evento
    public void votoCandidato1(String nombreClase) {
        this.candidato1.votos += 1;
        
        bitacoraEventos.setFechaActual();
        bitacoraEventos.setClveEvt("Ev_01");
        bitacoraEventos.setCtrlOrigen(nombreClase);
        ArrayList observadoresDestino = this.getObservadores();
        bitacoraEventos.setObservadoresDestino(observadores);
        
        this.bitacoraEventos.agregarEntradaEnBitacora();
        
        cambioVotos();
    }

    public void votoCandidato2(String nombreClase) {
        this.candidato2.votos += 1;
        
        bitacoraEventos.setFechaActual();
        bitacoraEventos.setClveEvt("Ev_02");
        bitacoraEventos.setCtrlOrigen(nombreClase);
        ArrayList observadoresDestino = this.getObservadores();
        bitacoraEventos.setObservadoresDestino(observadores);
        
        this.bitacoraEventos.agregarEntradaEnBitacora();
        
        cambioVotos();
    }

    public void votoCandidato3(String nombreClase) {
        this.candidato3.votos += 1;
        
        bitacoraEventos.setFechaActual();
        bitacoraEventos.setClveEvt("Ev_03");
        bitacoraEventos.setCtrlOrigen(nombreClase);
        ArrayList observadoresDestino = this.getObservadores();
        bitacoraEventos.setObservadoresDestino(observadores);
        
        this.bitacoraEventos.agregarEntradaEnBitacora();
        
        cambioVotos();
    }

    public String verVotos() {
        String votos = candidato1.getNombre() + " : " + candidato1.getVotos() + "\n"
                + candidato2.getNombre() + " : " + candidato2.getVotos() + "\n"
                + candidato3.getNombre() + " : " + candidato3.getVotos() + "\n";
        return votos;
    }

    public void cambioVotos() {
        servicio();
    }

    @Override
    public void obtenerDatos() {

    }

    @Override
    public void servicio() {
        for (int i = 0; i < observadores.size(); i++) {
            Observer observer = (Observer) observadores.get(i);
            observer.Actualizar(candidato1.getVotos(), candidato2.getVotos(), candidato3.getVotos());
        }
    }

}
