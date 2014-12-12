/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlProducto;
import Controlador.CtrlUsuario;
import Controlador.CtrlVentas;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author a09002968
 */
public class PuntoVenta extends javax.swing.JFrame {

    CtrlVentas ctrlVen;
    CtrlProducto ctrlProduc;
    CtrlUsuario ctrlUsr;
    

    /**
     * Creates new form PuntoVenta
     */
    public PuntoVenta() {
        initComponents();
        this.ctrlVen=new CtrlVentas();
        this.ctrlProduc=new CtrlProducto();
        this.ctrlUsr=new CtrlUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPuntoVenta = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPuntoVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Producto", "Cantidad", "Precio", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(tblPuntoVenta);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        txtCantidad.setText("1");

        jLabel1.setText("ID:");

        jLabel2.setText("Cantidad:");

        jLabel5.setText("Total:");

        txtTotal.setText("0.00");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)))
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btnAgregar)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnBuscar)
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregar)
                        .addGap(39, 39, 39)
                        .addComponent(btnGuardar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnEliminar)))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.reiniciarVista();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            // TODO add your handling code here:
            if (!this.hayNulos()) {
                System.out.println("hola");
                String idProduc = txtID.getText();
                this.agregarProductoaTabla(idProduc, this.ctrlProduc.obtenerProductoasString(idProduc), txtCantidad.getText());
                System.out.println("fuck");
                this.actualizarTotal();

            } else {

                JOptionPane.showMessageDialog(this, "No se permiten espacios vacios en la Cantidad o en el ID");

            }
        } catch (SQLException ex) {
            Logger.getLogger(PuntoVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int indidiceFilaSelecccionada = this.tblPuntoVenta.getSelectedRow();

        if (indidiceFilaSelecccionada >= 0) {
            ((DefaultTableModel) tblPuntoVenta.getModel()).removeRow(indidiceFilaSelecccionada);
        } else {
            int numProductos = ((DefaultTableModel) tblPuntoVenta.getModel()).getRowCount();
            ((DefaultTableModel) tblPuntoVenta.getModel()).removeRow(numProductos - 1);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        HashMap<Integer, String[]> tablaProductos = this.obtetenerInfoTabla();
        if(tablaProductos.size()>0){
        
       
        double total = Double.parseDouble(this.txtTotal.getText());;
            try {
                this.ctrlVen.guardarNotaVenta(tablaProductos);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Error en la Base de Datos");
            }
        }else{
            JOptionPane.showMessageDialog(this,"No hay datos para guardar en la tabla.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
     ListaProductos listaproduc = new ListaProductos();
        listaproduc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PuntoVenta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPuntoVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void checarNulo() {
        throw new UnsupportedOperationException("Not yet implemented");

    }

    private void agregarProductoaTabla(String idProduc, HashMap<String, String> atributos, String cantidad) {
        try {

            atributos = this.ctrlProduc.obtenerProductoasString(idProduc);
            System.out.println("akejflaekjfglkaejfg");
            String nombreProduc = atributos.get("nombreProduc");
            String precioVen = atributos.get("precioVenta");
            double total = Double.parseDouble(cantidad) * Double.parseDouble(precioVen);
            String precioTotal = String.valueOf(total);
            String[] datosProduc = {idProduc, nombreProduc, cantidad, precioVen, precioTotal};
            System.out.println("akejflaekjfglkaejfg");
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) this.tblPuntoVenta.getModel();
            modelo.addRow(datosProduc);

        } catch (SQLException ex) {
            Logger.getLogger(PuntoVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void actualizarTotal() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) this.tblPuntoVenta.getModel();

        double total = 0;
        int numFilas = modelo.getRowCount();
        System.out.println(numFilas);
        for (int filaActual = 0; filaActual < numFilas; filaActual++) {

            String totalxFila = (String) modelo.getValueAt(filaActual,4);
            total += Double.parseDouble(totalxFila);

        }

        this.txtTotal.setText(String.valueOf(total));
    }

    private boolean hayNulos() {
        boolean hayNulo = false;

        if (this.txtID.getText().equals("")) {

            hayNulo = true;
            return hayNulo;

        }
        if (this.txtCantidad.getText().equals("")) {
            hayNulo = true;
            return hayNulo;

        }
        return hayNulo;
    }

    private void reiniciarVista() {

        this.tblPuntoVenta.setModel(new DefaultTableModel(
                new Object[][][][][]{},
                new String[]{"ID", "Nombre Producto", "Cantidad", "Precio", "Precio Total"})
        );
        this.txtID.setText("");
        this.txtCantidad.setText("1");
       
        this.txtTotal.setText("0.0");

    }

    private HashMap<Integer, String[]> obtetenerInfoTabla() {
        int COLUMNAID = 0;
        int COLUMNACANTIDAD = 2;
        int COLUMNAPRECIOTOT = 4;
        HashMap<Integer, String[]> tablaProductos = new HashMap<Integer, String[]>();
        DefaultTableModel modelo = (DefaultTableModel) tblPuntoVenta.getModel();
        
        
        for (int indiceFila = 0; indiceFila < modelo.getRowCount(); indiceFila++) {
            String idProduc = modelo.getValueAt(indiceFila, COLUMNAID).toString();
            String cantidad = modelo.getValueAt(indiceFila, COLUMNACANTIDAD).toString();;
            String precioTotal = modelo.getValueAt(indiceFila, COLUMNAPRECIOTOT).toString();;
            String[] datosFila = {idProduc, cantidad, precioTotal};
            tablaProductos.put(indiceFila, datosFila);
        }

        return tablaProductos;
    }
}
