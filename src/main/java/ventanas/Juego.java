package ventanas;


import funciones.BaseDeDatos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Anibal
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Insertar
     */
    public Juego(int id_juego) {
        initComponents();
        initComponents2(id_juego);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textField1 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        textField4 = new java.awt.TextField();
        textArea1 = new java.awt.TextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("     Titulo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 51, 120, 20));

        jLabel2.setText("     Descripcion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 156, 87, -1));

        jLabel3.setText("     Año de lanzamiento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 88, 136, -1));

        jLabel4.setText("     Plataforma(s)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 122, 115, -1));

        textField1.setEditable(false);
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 51, 250, -1));

        textField3.setEditable(false);
        getContentPane().add(textField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 84, 250, -1));

        textField4.setEditable(false);
        getContentPane().add(textField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 118, 250, -1));

        textArea1.setEditable(false);
        getContentPane().add(textArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 110));

        jButton1.setText("Inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initComponents2(int id_juego) {
        try {
            String sql = "SELECT id_juegos, titulo, descripcion, plataforma, lanzamiento FROM juegos WHERE id_juegos = '"+id_juego+"'";
            ResultSet consulta = BaseDeDatos.RealizarConsultaLectura(sql);
            consulta.next();
            textField1.setText(consulta.getString(2));
            textField4.setText(consulta.getString(4));
            int year = consulta.getDate(5).getYear() + 1900;
            textField3.setText(String.valueOf(year));
            textArea1.setText(consulta.getString(3));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            String sql = "CALL juego_cerrado();";
            BaseDeDatos.RealizarConsultaEscritura(sql);
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Inicio().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private java.awt.TextArea textArea1;
    private java.awt.TextField textField1;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    // End of variables declaration//GEN-END:variables
}