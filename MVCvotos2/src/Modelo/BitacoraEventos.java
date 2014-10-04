package Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.sun.org.apache.xpath.internal.operations.String;

import Patrones.Observer;

public class BitacoraEventos extends Modelo{
	private static BitacoraEventos INSTANCE = new BitacoraEventos();
	
	public java.lang.String fechaActual;
	public java.lang.String clveEvt;
	public java.lang.String ctrlOrigen;
	public java.lang.String observadoresDestino;
	
	
	
	public Archivo archivo;
	
	
    
    /**
     * Supongo que aqui podriamos inicalizar el archivo bitacora.txt
     */
    private BitacoraEventos() {
    	this.archivo = archivo.getInstance();
        //this.file = new FileIOdfsdfsd();
        
    }

    public static BitacoraEventos getInstance() {
        return INSTANCE;
    }

	@Override
	public void agregar(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenerDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void servicio() {
		// TODO Auto-generated method stub
		
	}

	
	
	public java.lang.String getCtrlOrigen() {
		return ctrlOrigen;
	}

	public void setCtrlOrigen(java.lang.String ctrlOrigen) {
		this.ctrlOrigen = ctrlOrigen;
	}

	public java.lang.String getClveEvt() {
		return clveEvt;
	}

	public void setClveEvt(java.lang.String string) {
		this.clveEvt = string;
	}

	public java.lang.String getObservadoresDestino() {
		return observadoresDestino;
	}

	public void setObservadoresDestino(ArrayList observadores) {
		java.lang.String obs = null;
		
		for (int i = 0; i < observadores.size(); i++) {
			Observer ob;
			ob = (Observer) observadores.get(i);
			obs += ob.getClass().getName()+" ";
		}
		
		
		this.observadoresDestino = obs;
	}

	public java.lang.String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual() {
		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH);
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
		
		this.fechaActual = dia+":"+mes+":"+anio+" "+hora+":"+minuto+":"+segundo;
	}


	
	
	
	/**
	 * Esta funcion agrega al txt llamado bitacora una nueva entrada 
	 * del movimiento de los votos.
	 * @param string
	 */
	public void agregarEntradaEnBitacora(){
		java.lang.String fechaActual = this.fechaActual;
		java.lang.String clveEvt = this.clveEvt;
		java.lang.String ctrlOrigen = this.ctrlOrigen;
		java.lang.String observadoresDestino = this.observadoresDestino;
		this.archivo.agregarEntradaEnBitacora(fechaActual, clveEvt,ctrlOrigen,observadoresDestino);
		
	}
	
}
