/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DestinoCadastroGUI.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.sig.view;

import br.com.sig.dao.DestinoDAO;
import br.com.medicalpharm.model.ArmazemModel;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.sig.util.LimitadorTexto;
import br.com.sig.util.UnaccentedDocument;
import java.awt.event.KeyAdapter;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author ALENCAR
 */
public class DestinoAlterarGUI extends javax.swing.JFrame {

    private ArmazemModel objdestino;
    public DestinoGUI janelapai;

    /** Creates new form DestinoCadastroGUI */
    public DestinoAlterarGUI() {
        initComponents();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.smoothmetal.SmoothmetalLookAndAndFeel");
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel(seta_look);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public DestinoAlterarGUI(ArmazemModel destino) {
        this.objdestino = destino;
        initComponents();

        jtf_codigo.setText(String.valueOf(destino.getCod_destino()));
        jtf_descricao.setText(destino.getDesc_destino());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jtf_codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_descricao = new javax.swing.JTextField (new LimitadorTexto(45), "",10);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Armazém");
        setBackground(new java.awt.Color(255, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/gravar_registro.gif"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 35));

        jtf_codigo.setEditable(false);
        jtf_codigo.setName("jtf_codigo"); // NOI18N
        getContentPane().add(jtf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Descrição");
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Código");
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_descricao.setDocument(new UnaccentedDocument());
        jtf_descricao.setName("jtf_descricao"); // NOI18N
        jtf_descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_descricaoFocusGained(evt);
            }
        });
        jtf_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricaoKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 370, -1));

        setSize(new java.awt.Dimension(434, 177));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        alteraDestino();
        janelapai.listarDestino();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_descricao.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_descricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricaoKeyPressed
    jtf_descricao.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = jtf_descricao.getText();  
          jtf_descricao.setText(s.toUpperCase());  
        }  
      }  
    }); 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alteraDestino();
            janelapai.listarDestino();
        }
    }//GEN-LAST:event_jtf_descricaoKeyPressed

    private void jtf_descricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricaoFocusGained
        jtf_descricao.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_descricao.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe a descrição");
                    jtf_descricao.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricaoFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DestinoAlterarGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JTextField jtf_codigo;
    private javax.swing.JTextField jtf_descricao;
    // End of variables declaration//GEN-END:variables
    ArmazemModel destino = new ArmazemModel();

    public void alimentaCampos(List<DestinoGUI> destinos) {
    }

    private void alteraDestino() {
        if (verificarCampos()) {
            DestinoDAO destinoControl = new DestinoDAO();
            destino.setCod_destino(Integer.parseInt(jtf_codigo.getText().trim()));
            destino.setDesc_destino(jtf_descricao.getText().trim());
            destinoControl.alteraDestino(destino);
            JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
            retornaJanelaPai();
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public void retornaJanelaPai() {
        setVisible(false);
        janelapai.listarDestino();
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
    }
}
