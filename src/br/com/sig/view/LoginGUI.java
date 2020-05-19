/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Log_login.java
 *
 * Created on 07/04/2011, 21:26:40
 */
package br.com.sig.view;

import br.com.sig.dao.UsuarioDAO;
import br.com.medicalpharm.model.UsuarioModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Alencar
 */
public class LoginGUI extends javax.swing.JFrame {

    /** Creates new form Log_login */
    public LoginGUI() {
        initComponents();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setIconFrame();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.smoothmetal.SmoothmetalLookAndAndFeel");
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel(seta_look);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    List<UsuarioModel> usuarios;
    String usuarioNome;
    Integer codUsuário;
    String login;
    String permissao;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_logar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jl_erro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jtf_login = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        jpf_senha = new javax.swing.JPasswordField();
        jb_limpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login"); // NOI18N
        setIconImages(null);
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

        jb_logar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/http___iconesbr.oficinadanet.com_8533_16x16.png"))); // NOI18N
        jb_logar.setText("OK !");
        jb_logar.setName("jb_logar"); // NOI18N
        jb_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_logarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_logar, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 310, 81, 40));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/sair.gif"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 310, 97, -1));

        jl_erro.setText("        ");
        jl_erro.setName("jl_erro"); // NOI18N
        getContentPane().add(jl_erro, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 17, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/SistemaSey.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 500, 217));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label1.setName("label1"); // NOI18N
        label1.setText("Login:");

        jtf_login.setName("jtf_login"); // NOI18N
        jtf_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_loginKeyPressed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label2.setName("label2"); // NOI18N
        label2.setText("Senha:");

        jpf_senha.setName("jpf_senha"); // NOI18N
        jpf_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_senhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jtf_login, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 234, -1, -1));

        jb_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/limpar.png"))); // NOI18N
        jb_limpar.setText("Limpar");
        jb_limpar.setName("jb_limpar"); // NOI18N
        jb_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limparActionPerformed(evt);
            }
        });
        getContentPane().add(jb_limpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        setSize(new java.awt.Dimension(614, 401));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_logarActionPerformed
        entrar();
    }//GEN-LAST:event_jb_logarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        listarUsuário();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jpf_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_senhaKeyPressed
jpf_senha.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = jpf_senha.getText();  
          jpf_senha.setText(s.toUpperCase());  
        }  
      }  
    }); 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_senhaKeyPressed

    private void jtf_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_loginKeyPressed
    jtf_login.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = jtf_login.getText();  
          jtf_login.setText(s.toUpperCase());  
        }  
      }  
    }); 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jpf_senha.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loginKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jb_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limparActionPerformed
        limparCampos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limparActionPerformed
    public void limparCampos() {
        jtf_login.setText("");
        jpf_senha.setText("");
        jtf_login.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_limpar;
    private javax.swing.JButton jb_logar;
    private javax.swing.JLabel jl_erro;
    private javax.swing.JPasswordField jpf_senha;
    private javax.swing.JTextField jtf_login;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables

    private void entrar() {

        if (validaLogin()) {
            if (verificaLogin()) {
                login();
            } else {
                jpf_senha.requestFocus();
                jpf_senha.setText("");
            }
        }
    }

    private boolean validaLogin() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_login.getText().equals("")) {
            msgERRO = msgERRO + " *Login\n";
        }
        if (jpf_senha.getPassword().equals("")) {
            msgERRO = msgERRO + " *Senha\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }


    }
    UsuarioModel usuarioModel;

    public boolean verificaLogin() {
        UsuarioDAO usuarioControl = new UsuarioDAO();
        usuarios = usuarioControl.consultarLogin(jtf_login.getText().trim());

//        usuarioModel.setCod_usuario(usuarios.get(1).getCod_usuario());
//        usuarioModel.setLogin(usuarios.get(1).getLogin());
//        usuarioModel.setNome_usuário(usuarios.get(1).getNome_usuario());
//        usuarioModel.setSenha(usuarios.get(1).getSenha());
//        usuarioModel.setPermissao(usuarios.get(1).getPermissao());
//

        //verifica o login
        if ((usuarios).size() == 0) {
            JOptionPane.showMessageDialog(null, "Login inexistente");
            jtf_login.requestFocus();
            return false;
        }


        //verifica a senha
        char[] senha = jpf_senha.getPassword();
        char[] senhaDoBanco = usuarios.get(0).getSenha().toCharArray();

        // verifica o tamanho da senha
        if (senha.length != senhaDoBanco.length) {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
            return false; // se for diferente, retorna falso
        } else {
            for (int i = 0; i < senha.length; i++) {
                if (senha[i] != senhaDoBanco[i]) {
                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                    return false; // se for diferente, retorna falso
                }
            }
        }

        usuarioNome = (usuarios.get(0).getNome_usuario());
        codUsuário = (usuarios.get(0).getCod_usuario());
        login = (usuarios.get(0).getLogin());
        permissao = (usuarios.get(0).getPermissao());

        return true;
    }
    private TelaPrincipal_Interface telaPrincipal;

    public void login() {

        if (usuarios.get(0).getPermissao().equals("usuario")) {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setJanelaPai(this);
            //tela.setUsuario(usuarioModel);
            tela.show();
            this.dispose();
            tela.permissao();
        } else {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setJanelaPai(this);
            //tela.setUsuario(usuarioModel);
            tela.show();
            this.dispose();

        }

    }
}
