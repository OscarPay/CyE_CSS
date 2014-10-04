/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Modelo.AdminVotos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


 
/**
 *
 * @author A09003539
 */
public class Pastel extends Vista {
    
    AdminVotos adminVotos;
    
    DefaultPieDataset data = new DefaultPieDataset();
    JFreeChart chart = ChartFactory.createPieChart3D("Candidatos", data);
    ChartFrame frame = new ChartFrame("Candidatos", chart);  
    
    public Pastel(AdminVotos adminVotos){
        this.adminVotos = adminVotos;
        adminVotos.agregar(this);
    }

    @Override
    public void Inicializar() {       
        frame.pack();
        frame.setVisible(true);   
    }

    @Override
    public void Activar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Desplegar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Actualizar(int v1, int v2, int v3) {
       data.setValue(adminVotos.getCandidato1().getNombre(), v1);
       data.setValue(adminVotos.getCandidato2().getNombre(), v2);
       data.setValue(adminVotos.getCandidato3().getNombre(), v3);
       Inicializar();
    }
    
    
}
