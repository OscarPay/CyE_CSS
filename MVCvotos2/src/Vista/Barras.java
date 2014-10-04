/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Modelo.AdminVotos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author A09003539
 */
public class Barras extends Vista{
    
    public AdminVotos adminVotos;
    
     DefaultCategoryDataset data = new DefaultCategoryDataset();        
     JFreeChart chart = ChartFactory.createBarChart(null, null, null, data, PlotOrientation.VERTICAL, true, true, true);
     ChartFrame frame = new ChartFrame("Candidatos", chart);   
   
    
    public Barras(AdminVotos adminVotos){
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
        data.setValue(v1, adminVotos.getCandidato1().getNombre(), "Votos");
        data.setValue(v2, adminVotos.getCandidato2().getNombre(), "Votos");
        data.setValue(v3, adminVotos.getCandidato3().getNombre(), "Votos");
        Inicializar();
    }

   
    
}
