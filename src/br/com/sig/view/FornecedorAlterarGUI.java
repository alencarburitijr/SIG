/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FornecedorCadastroGUI.java
 *
 * Created on 26/05/2011, 00:51:40
 */
package br.com.sig.view;

import br.com.sig.dao.FornecedorDAO;
import br.com.medicalpharm.model.FornecedorModel;
import br.com.sig.util.LimitadorTexto;
import br.com.sig.util.UnaccentedDocument;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ALENCAR
 */
public class FornecedorAlterarGUI extends javax.swing.JFrame {

    MaskFormatter formatoCNPJ, formatoCEP, formatoTelefone, formatoinsc_estadual, formatoinsc_municipal, telefoneVendedor;
    public FornecedorGUI janelapai;
    public FornecedorModel objfornecedor;

    /** Creates new form FornecedorCadastroGUI */
    public FornecedorAlterarGUI() {
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

    public FornecedorAlterarGUI(FornecedorModel fornecedor) {
        this.objfornecedor = fornecedor;
        initComponents();
        tf_codigo.setText(String.valueOf(fornecedor.getCod_fornecedor()));
        tf_razaoSocial.setText(fornecedor.getRazao_social());
        tf_nomeFantasia.setText(fornecedor.getNome_fantasia());
        tf_endereco.setText(fornecedor.getEndereço());
        jftf_cnpj.setText(fornecedor.getCNPJ());
        jftf_telefone.setText(fornecedor.getTelefone());
        jftf_fax.setText(fornecedor.getFax());
        tf_cidade.setText(fornecedor.getCidade());
        jftf_cep.setText(fornecedor.getCEP());
        tf_estado.setText(fornecedor.getEstado());
        jftf_insc_municipal.setText(fornecedor.getInsc_municipal());
        jftf_insc_estadual.setText(fornecedor.getInsc_estadual());
        tf_nomeVendedor.setText(fornecedor.getNome_vendedor());
        jftf_tel_vendedor.setText(fornecedor.getTel_vendedor());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        try
        {
            formatoTelefone = new MaskFormatter("(##)####-####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jftf_telefone = new JFormattedTextField(formatoTelefone);
        try
        {
            formatoTelefone = new MaskFormatter("(##)####-####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jftf_fax = new JFormattedTextField(formatoTelefone);
        try  {      
            formatoCNPJ = new MaskFormatter("##.###.###/####.##");  
        } 
        catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        jftf_cnpj = new JFormattedTextField(formatoCNPJ);
        try
        {
            formatoCEP = new MaskFormatter("##.###-###");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar cep");
        }
        jftf_cep = new JFormattedTextField(formatoCEP);
        jLabel1 = new javax.swing.JLabel();
        jftf_insc_municipal = new javax.swing.JFormattedTextField();
        jftf_insc_estadual = new javax.swing.JFormattedTextField();
        try
        {
            formatoTelefone = new MaskFormatter("(##)####-####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jftf_tel_vendedor = new JFormattedTextField(formatoTelefone);
        tf_razaoSocial = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        tf_nomeFantasia = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        tf_endereco = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        tf_estado = new javax.swing.JTextField(new LimitadorTexto(15), "",10);
        tf_cidade = new javax.swing.JTextField(new LimitadorTexto(30), "",10);
        tf_nomeVendedor = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Fornecedor");
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
        getContentPane().add(jb_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 35));

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 35));

        jftf_telefone.setName("jftf_telefone"); // NOI18N
        jftf_telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_telefoneFocusGained(evt);
            }
        });
        getContentPane().add(jftf_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 120, -1));

        jftf_fax.setName("jftf_fax"); // NOI18N
        jftf_fax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_faxFocusGained(evt);
            }
        });
        getContentPane().add(jftf_fax, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 120, -1));

        jftf_cnpj.setName("jftf_cnpj"); // NOI18N
        jftf_cnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_cnpjFocusGained(evt);
            }
        });
        jftf_cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftf_cnpjKeyPressed(evt);
            }
        });
        getContentPane().add(jftf_cnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 160, -1));

        jftf_cep.setName("jftf_cep"); // NOI18N
        jftf_cep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_cepFocusGained(evt);
            }
        });
        getContentPane().add(jftf_cep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 124, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Código");
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        try {
            jftf_insc_municipal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftf_insc_municipal.setName("jftf_insc_municipal"); // NOI18N
        getContentPane().add(jftf_insc_municipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 142, -1));

        try {
            jftf_insc_estadual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftf_insc_estadual.setName("jftf_insc_estadual"); // NOI18N
        getContentPane().add(jftf_insc_estadual, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 150, -1));

        jftf_tel_vendedor.setName("jftf_tel_vendedor"); // NOI18N
        jftf_tel_vendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_tel_vendedorFocusGained(evt);
            }
        });
        getContentPane().add(jftf_tel_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 140, -1));

        tf_razaoSocial.setDocument(new UnaccentedDocument());
        tf_razaoSocial.setName("tf_razaoSocial"); // NOI18N
        tf_razaoSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_razaoSocialFocusGained(evt);
            }
        });
        tf_razaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_razaoSocialKeyPressed(evt);
            }
        });
        getContentPane().add(tf_razaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 450, 20));

        tf_nomeFantasia.setDocument(new UnaccentedDocument());
        tf_nomeFantasia.setName("tf_nomeFantasia"); // NOI18N
        tf_nomeFantasia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_nomeFantasiaFocusGained(evt);
            }
        });
        tf_nomeFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_nomeFantasiaKeyPressed(evt);
            }
        });
        getContentPane().add(tf_nomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 450, -1));

        tf_endereco.setDocument(new UnaccentedDocument());
        tf_endereco.setName("tf_endereco"); // NOI18N
        tf_endereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_enderecoFocusGained(evt);
            }
        });
        tf_endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_enderecoKeyPressed(evt);
            }
        });
        getContentPane().add(tf_endereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 280, -1));

        tf_estado.setDocument(new UnaccentedDocument());
        tf_estado.setName("tf_estado"); // NOI18N
        tf_estado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_estadoFocusGained(evt);
            }
        });
        tf_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_estadoKeyPressed(evt);
            }
        });
        getContentPane().add(tf_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 60, -1));

        tf_cidade.setDocument(new UnaccentedDocument());
        tf_cidade.setName("tf_cidade"); // NOI18N
        tf_cidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_cidadeFocusGained(evt);
            }
        });
        tf_cidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_cidadeKeyPressed(evt);
            }
        });
        getContentPane().add(tf_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 120, -1));

        tf_nomeVendedor.setDocument(new UnaccentedDocument());
        tf_nomeVendedor.setName("tf_nomeVendedor"); // NOI18N
        tf_nomeVendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_nomeVendedorFocusGained(evt);
            }
        });
        tf_nomeVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_nomeVendedorKeyPressed(evt);
            }
        });
        getContentPane().add(tf_nomeVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 300, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel15.setText("Telefone do Vendedor");
        jLabel15.setName("jLabel15"); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel14.setText("Nome Vendedor");
        jLabel14.setName("jLabel14"); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setText("CEP");
        jLabel12.setName("jLabel12"); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Inscrição Municipal");
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setText("Inscrição Estadual");
        jLabel13.setName("jLabel13"); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Cidade");
        jLabel11.setName("jLabel11"); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("Estado");
        jLabel10.setName("jLabel10"); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Fax");
        jLabel9.setName("jLabel9"); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Telefone");
        jLabel8.setName("jLabel8"); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Endereço");
        jLabel6.setName("jLabel6"); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("CNPJ");
        jLabel7.setName("jLabel7"); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Nome Fantasia");
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Razão Social");
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        tf_codigo.setEditable(false);
        tf_codigo.setName("tf_codigo"); // NOI18N
        getContentPane().add(tf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, -1));

        setSize(new java.awt.Dimension(510, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        alteraFornecedor();
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
        janelapai.listarFornecedor();
        setVisible(false);
        // TODO add your handling code here:
}//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
        setVisible(false);
        // TODO add your handling code here:
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tf_razaoSocial.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setEnabled(true);
        janelapai.setVisible(true);
        janelapai.request();
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jftf_cnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftf_cnpjKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!validaCnpj(jftf_cnpj.getText()) || jftf_cnpj.getText().equals("  .   .   /    -  ")) {
                JOptionPane.showMessageDialog(null, "CNPJ Inválido.");
                jftf_cnpj.requestFocus();
            } else {
                jftf_telefone.requestFocus();
            }
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jftf_cnpjKeyPressed

    private void tf_razaoSocialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_razaoSocialFocusGained
        tf_razaoSocial.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (tf_razaoSocial.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe a razão social");
                    tf_razaoSocial.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_razaoSocialFocusGained

    private void tf_nomeFantasiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nomeFantasiaFocusGained
        tf_nomeFantasia.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (tf_nomeFantasia.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o nome fantasia");
                    tf_nomeFantasia.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nomeFantasiaFocusGained

    private void tf_enderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_enderecoFocusGained
        tf_endereco.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (tf_endereco.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o endereço");
                    tf_endereco.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_enderecoFocusGained

    private void jftf_cnpjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_cnpjFocusGained
        jftf_cnpj.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jftf_cnpj.getText().trim().length() < 18) {
                    JOptionPane.showMessageDialog(null, "CNPJ inválido");
                    return false;
                } else if (jftf_cnpj.getText().equals("00.000.000/0000.00")) {
                    JOptionPane.showMessageDialog(null, "CNPJ inválido");
                    return false;
                } else if (jftf_cnpj.getText().equals("  .   .   /    .  ")) {
                    JOptionPane.showMessageDialog(null, "CNPJ inválido");
                    return false;
                } else if (!(validaCnpj(jftf_cnpj.getText().trim()))) {
                    JOptionPane.showMessageDialog(null, "CNPJ inválido");
                    //   jl_cnpj.setForeground(Color.red);
                    //    jl_cnpj.setText("X");
                    jftf_cnpj.grabFocus();
                    return false;
                } else {
//            jl_cnpj.setForeground(Color.GREEN);
                    // jl_cnpj.setText("V");
                    jftf_telefone.grabFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_cnpjFocusGained

    private void jftf_telefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_telefoneFocusGained
        jftf_telefone.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jftf_telefone.getText().equals("(  )    -    ")) {
                    JOptionPane.showMessageDialog(null, "Informe o telefone");
                    jftf_telefone.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_telefoneFocusGained

    private void jftf_faxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_faxFocusGained
        jftf_telefone.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jftf_telefone.getText().equals("(  )    -    ")) {
                    JOptionPane.showMessageDialog(null, "Informe o fax");
                    jftf_telefone.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_faxFocusGained

    private void tf_estadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_estadoFocusGained
        tf_estado.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (tf_estado.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe o estado");
                    tf_estado.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_estadoFocusGained

    private void tf_cidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_cidadeFocusGained
        tf_cidade.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (tf_cidade.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe a cidade");
                    tf_cidade.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cidadeFocusGained

    private void jftf_cepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_cepFocusGained
        jftf_cep.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jftf_cep.getText().equals("  .   -   ")) {
                    JOptionPane.showMessageDialog(null, "Informe o CEP");
                    jftf_cep.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_cepFocusGained

    private void tf_nomeVendedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nomeVendedorFocusGained
        tf_nomeVendedor.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (tf_nomeVendedor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe o CEP");
                    tf_nomeVendedor.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nomeVendedorFocusGained

    private void jftf_tel_vendedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_tel_vendedorFocusGained
        jftf_tel_vendedor.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jftf_tel_vendedor.getText().equals("(  )    -    ")) {
                    JOptionPane.showMessageDialog(null, "Informe o telefone do vendedor");
                    jftf_tel_vendedor.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_tel_vendedorFocusGained

private void tf_razaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_razaoSocialKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tf_nomeFantasia.requestFocus();
        }
    tf_razaoSocial.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = tf_razaoSocial.getText();  
          tf_razaoSocial.setText(s.toUpperCase());  
        }  
      }  
    }); 
    // TODO add your handling code here:
}//GEN-LAST:event_tf_razaoSocialKeyPressed

private void tf_nomeFantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nomeFantasiaKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tf_endereco.requestFocus();
        }
    tf_nomeFantasia.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = tf_nomeFantasia.getText();  
          tf_nomeFantasia.setText(s.toUpperCase());  
        }  
      }  
    });         

    // TODO add your handling code here:
}//GEN-LAST:event_tf_nomeFantasiaKeyPressed

private void tf_enderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_enderecoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jftf_cnpj.requestFocus();
        }
    tf_endereco.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = tf_endereco.getText();  
          tf_endereco.setText(s.toUpperCase());  
        }  
      }  
    }); 
    // TODO add your handling code here:
}//GEN-LAST:event_tf_enderecoKeyPressed

private void tf_estadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_estadoKeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tf_cidade.requestFocus();
        }
    tf_estado.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = tf_estado.getText();  
          tf_estado.setText(s.toUpperCase());  
        }  
      }  
    }); 
    // TODO add your handling code here:
}//GEN-LAST:event_tf_estadoKeyPressed

private void tf_cidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cidadeKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jftf_cep.requestFocus();
        }
    tf_cidade.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = tf_cidade.getText();  
          tf_cidade.setText(s.toUpperCase());  
        }  
      }  
    }); 
    // TODO add your handling code here:
}//GEN-LAST:event_tf_cidadeKeyPressed

private void tf_nomeVendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nomeVendedorKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jftf_tel_vendedor.requestFocus();
        }
    tf_nomeVendedor.addKeyListener(new KeyAdapter() {  
      public void keyReleased(KeyEvent evt) {  
        if (evt.getKeyCode() != KeyEvent.VK_HOME) {  
          String s = tf_nomeVendedor.getText();  
          tf_nomeVendedor.setText(s.toUpperCase());  
        }  
      }  
    }); 
    // TODO add your handling code here:
}//GEN-LAST:event_tf_nomeVendedorKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FornecedorAlterarGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JFormattedTextField jftf_cep;
    private javax.swing.JFormattedTextField jftf_cnpj;
    private javax.swing.JFormattedTextField jftf_fax;
    private javax.swing.JFormattedTextField jftf_insc_estadual;
    private javax.swing.JFormattedTextField jftf_insc_municipal;
    private javax.swing.JFormattedTextField jftf_tel_vendedor;
    private javax.swing.JFormattedTextField jftf_telefone;
    private javax.swing.JTextField tf_cidade;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_endereco;
    private javax.swing.JTextField tf_estado;
    private javax.swing.JTextField tf_nomeFantasia;
    private javax.swing.JTextField tf_nomeVendedor;
    private javax.swing.JTextField tf_razaoSocial;
    // End of variables declaration//GEN-END:variables
    FornecedorModel fornecedor = new FornecedorModel();

    private void alteraFornecedor() {
        if (verificarCampos()) {
            FornecedorDAO controlFornecedor = new FornecedorDAO();
            fornecedor.setRazao_social(tf_razaoSocial.getText().trim());
            fornecedor.setNome_fantasia(tf_nomeFantasia.getText().trim());
            fornecedor.setEndereço(tf_endereco.getText().trim());
            fornecedor.setCNPJ(jftf_cnpj.getText().trim());
            fornecedor.setTelefone(jftf_telefone.getText().trim());
            fornecedor.setFax(jftf_fax.getText().trim());
            fornecedor.setCidade(tf_cidade.getText().trim());
            fornecedor.setCEP(jftf_cep.getText().trim());
            fornecedor.setEstado(tf_estado.getText().trim());
            fornecedor.setInsc_municipal(jftf_insc_municipal.getText().trim());
            fornecedor.setInsc_estadual(jftf_insc_estadual.getText().trim());
            fornecedor.setNome_vendedor(tf_nomeVendedor.getText().trim());
            fornecedor.setTel_vendedor(jftf_tel_vendedor.getText().trim());
            fornecedor.setCod_fornecedor(Integer.parseInt(tf_codigo.getText().trim()));
            controlFornecedor.alteraFornecedor(fornecedor);
        }
    }

    public boolean verificarCampos() {

        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (tf_razaoSocial.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Razão Social\n";
        }
        if (tf_nomeFantasia.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Nome Fantasia\n";
        }
        if (tf_endereco.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Endereço\n";
        }
        if (jftf_cnpj.getText().trim().equals("")) {
            msgERRO = msgERRO + " *CNPJ\n";
        }
        if (jftf_telefone.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Telefone\n";
        }
        if (jftf_fax.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Fax\n";
        }
        if (tf_cidade.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Cidade\n";
        }
        if (jftf_cep.getText().trim().equals("")) {
            msgERRO = msgERRO + " *CEP\n";
        }
        if (tf_estado.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Estado\n";
        }
        if (jftf_insc_municipal.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Inscrição Municipal\n";
        }
        if (tf_nomeFantasia.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Inscrição Estadual\n";
        }
        if (tf_nomeVendedor.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Nome do Vendedor\n";
        }
        if (jftf_tel_vendedor.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Telefone do vendedor";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            tf_razaoSocial.requestFocus();
            return false;
        } else {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            janelapai.request();
            setVisible(false);
            return true;
        }
    }

    public boolean validaCnpj(String str_cnpj) {
        if (!str_cnpj.substring(0, 1).equals("")) {
            try {
                str_cnpj = str_cnpj.replace('.', ' ');
                str_cnpj = str_cnpj.replace('/', ' ');
                str_cnpj = str_cnpj.replace('-', ' ');
                str_cnpj = str_cnpj.replaceAll(" ", "");
                int soma = 0, aux, dig;
                String cnpj_calc = str_cnpj.substring(0, 12);

                if (str_cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = str_cnpj.toCharArray();
                /* Primeira parte */
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11)
                        ? "0" : Integer.toString(dig);
                /* Segunda parte */
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11)
                        ? "0" : Integer.toString(dig);
                return str_cnpj.equals(cnpj_calc);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }

    }
}
