/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class RequisicaoQtdDevolvidaGUI extends javax.swing.JFrame {

    /**
     * Creates new form DevolverProduto
     */
    public RequisicaoQtdDevolvidaGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        jButton1.setFocusable(false);
        jButton2.setFocusable(false);
        jTextField2.setFocusable(true);                
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Devolver Produto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Devovler");
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 11, -1, 35));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 11, -1, 35));

        jLabel1.setText("Qtd:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Devolver(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 84, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    RequisicaoDevolverGUI_Interface d;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        carregarDevolucao();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Devolver(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Devolver

      jTextField2.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if(continuar){
                    continuar = false;
                    carregarDevolucao();               
                }
            }
        } 
      });
    }//GEN-LAST:event_Devolver

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    public void setDevolver(RequisicaoDevolverGUI_Interface d){
        this.d = d;
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RequisicaoQtdDevolvidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequisicaoQtdDevolvidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequisicaoQtdDevolvidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequisicaoQtdDevolvidaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequisicaoQtdDevolvidaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
    public String saldo;
    public int index = 0;   
    private boolean continuar = true;
    public void foco(){      
        jButton1.setFocusable(false);
        jButton2.setFocusable(false);
        jTextField2.setFocusable(true);        
    }
    /**
     * Metodo que manda a quantidade escolhida pelo usuario para ser devolvida para tela RequisicaoDevolver
     */
    public void carregarDevolucao(){
        try{
            int s = Integer.parseInt(saldo);
            int q = Integer.parseInt(jTextField2.getText());
            if(verificarQtd(q,s)){                        
                setVisible(false);
                d.pegarQtd(jTextField2.getText(), index);             
            }else{
                this.setLocationRelativeTo(null);
                jButton1.setFocusable(false);
                jButton2.setFocusable(false);
                jTextField2.setFocusable(true);
                JOptionPane.showMessageDialog(null, "Informe uma quantidade valida\n"+
                                                    "*A quantidade não pode ser igual a zero ou maior que o estoque");
                
            }
        }catch(Exception ex){
            System.out.println("Erro no codigo:"+ex);
       }
        
    }
    private boolean verificarQtd(int qtd,int estoque){
        if(qtd > estoque){
            return false;
        }       
        if(qtd <= 0){
            return false;
        }
//        if(estoque == 1){
//            return false;
//        }
        
        return true;
    }

}