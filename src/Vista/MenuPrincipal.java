/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.ControladorAdmiCompu;
import Controlador.Observador;
import Modelo.Cronometro;
import javax.swing.JOptionPane;



/**
 *
 * @author Oscar
 */
public class MenuPrincipal extends javax.swing.JFrame implements Observador {

   
    ControladorAdmiCompu controladorAdmiCompu;
    
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();   
        controladorAdmiCompu = new ControladorAdmiCompu();
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnComputadora1 = new javax.swing.JButton();
        btnXbox1 = new javax.swing.JButton();
        btnComputadora2 = new javax.swing.JButton();
        btnComputadora3 = new javax.swing.JButton();
        btnXbox2 = new javax.swing.JButton();
        btnComputadora4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTiempo1 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnComputadora1.setText("PC 1");
        btnComputadora1.setAutoscrolls(true);
        btnComputadora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputadora1ActionPerformed(evt);
            }
        });

        btnXbox1.setText("Xbox1");
        btnXbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXbox1ActionPerformed(evt);
            }
        });

        btnComputadora2.setText("PC 2");
        btnComputadora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputadora2ActionPerformed(evt);
            }
        });

        btnComputadora3.setText("PC 3");
        btnComputadora3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputadora3ActionPerformed(evt);
            }
        });

        btnXbox2.setText("Xbox2");
        btnXbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXbox2ActionPerformed(evt);
            }
        });

        btnComputadora4.setText("PC 4");
        btnComputadora4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputadora4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Hora:");

        jLabel2.setText("Precio");

        Hora.setText("Hora");

        jLabel4.setText("Precio");

        jLabel6.setText("Hora");

        jLabel7.setText("Precio");

        jLabel8.setText("Hora");

        jLabel9.setText("Precio");

        jLabel10.setText("Hora");

        jLabel11.setText("Precio");

        jLabel12.setText("Hora");

        jLabel13.setText("Precio");

        lblTiempo1.setText("00:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnComputadora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnComputadora3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnComputadora4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXbox2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnComputadora2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel7)
                                        .addGap(30, 30, 30))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTiempo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66)
                        .addComponent(Hora)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXbox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnComputadora2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnComputadora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(Hora)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lblTiempo1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComputadora3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComputadora4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXbox2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComputadora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputadora1ActionPerformed
        String Nombrepc = btnComputadora1.getText();           
        String tiempoSalida = JOptionPane.showInputDialog("Ingrese el tiempo");
        controladorAdmiCompu.iniciarComputadora(Nombrepc, tiempoSalida);
        controladorAdmiCompu.getAdministradorComputadoras().compu.cronometro.agregar(this);
    }//GEN-LAST:event_btnComputadora1ActionPerformed

    private void btnComputadora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputadora2ActionPerformed
        String Nombrepc = btnComputadora2.getText();
        String tiempoSalida = JOptionPane.showInputDialog("Ingrese el tiempo");
        controladorAdmiCompu.iniciarComputadora(Nombrepc, tiempoSalida);
    }//GEN-LAST:event_btnComputadora2ActionPerformed

    private void btnComputadora3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputadora3ActionPerformed
        String Nombrepc = btnComputadora3.getText();
        String tiempoSalida = JOptionPane.showInputDialog("Ingrese el tiempo");
        controladorAdmiCompu.iniciarComputadora(Nombrepc, tiempoSalida);
    }//GEN-LAST:event_btnComputadora3ActionPerformed

    private void btnComputadora4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputadora4ActionPerformed
        String Nombrepc = btnComputadora4.getText();
        String tiempoSalida = JOptionPane.showInputDialog("Ingrese el tiempo");
        controladorAdmiCompu.iniciarComputadora(Nombrepc, tiempoSalida);
    }//GEN-LAST:event_btnComputadora4ActionPerformed

    private void btnXbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXbox1ActionPerformed
        String Nombrexbox = btnXbox1.getText();
        String tiempoSalida = JOptionPane.showInputDialog("Ingrese el tiempo");
        controladorAdmiCompu.iniciarComputadora(Nombrexbox, tiempoSalida);
    }//GEN-LAST:event_btnXbox1ActionPerformed

    private void btnXbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXbox2ActionPerformed
        String Nombrexbox = btnXbox2.getText();
        String tiempoSalida = JOptionPane.showInputDialog("Ingrese el tiempo");
        controladorAdmiCompu.iniciarComputadora(Nombrexbox, tiempoSalida);
    }//GEN-LAST:event_btnXbox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hora;
    private javax.swing.JButton btnComputadora1;
    private javax.swing.JButton btnComputadora2;
    private javax.swing.JButton btnComputadora3;
    private javax.swing.JButton btnComputadora4;
    private javax.swing.JButton btnXbox1;
    private javax.swing.JButton btnXbox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblTiempo1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Actualizar(String tiempo) {
        lblTiempo1.setText(tiempo);
    }
}
