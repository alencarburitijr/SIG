/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Mov_Entrada.java
 *
 * Created on 07/04/2011, 20:47:58
 */
package br.com.sig.view;

import br.com.sig.dao.AjusteDAO;
import br.com.medicalpharm.model.AjusteEstoqueModel;
import br.com.medicalpharm.model.EntradaItemModel;
import br.com.medicalpharm.model.FornecedorModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.medicalpharm.model.UsuarioModel;
import br.com.sig.util.Data;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class AjusteEstoqueGUI extends javax.swing.JFrame implements AjusteEstoqueGUI_Interface {

    public EntradaGUI janelaPaim;
    public FornecedorModel objfornecedor;
    DecimalFormat formatoPreco;
    MaskFormatter formatoData;
    private FornecedorModel fornecedor;
    private ProdutoModel produto;
    AjusteGUI janelaPai2;
    LoginGUI janelaLoguin;
    String nomeUsuario;
    Integer codUsuario;

    public AjusteEstoqueGUI() throws SQLException {
        initComponents();
        Data mostraData = new Data();
        mostraData.le_data();
        jftf_movimento.setText(mostraData.dia + "/" + mostraData.mes + "/" + mostraData.ano);
//        listarFornecedor();
//        listarProduto();

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
    private AjusteEstoqueGUI_Interface telaPrincipal;//Recebendo tela como parametro para atualização apos pesquisa

    public void setTelaPrincipal(AjusteEstoqueGUI_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    public void setUsuario(AjusteGUI janelaPai2) {
        this.janelaPai2 = janelaPai2;
        jtf_usuário.setText(janelaPai2.nomeUsuario);
        nomeUsuario = janelaPai2.nomeUsuario;
        codUsuario = janelaPai2.codUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jrb_entrada = new javax.swing.JRadioButton();
        jrb_saida = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_lote = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtf_estoque = new javax.swing.JTextField();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_preco = new javax.swing.JTextField();
        try  {      
            formatoData = new MaskFormatter("##/##/####");  
        } 
        catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        jftf_vencimento = new JFormattedTextField(formatoData);
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_observacao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtf_usuário = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtf_quantidade = new javax.swing.JTextField();
        jftf_movimento = new javax.swing.JFormattedTextField();
        jtf_serie = new javax.swing.JTextField();
        jtf_NotaFiscal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        try  {      
            formatoData = new MaskFormatter("##/##/####");  
        } 
        catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        jftf_emissao = new JFormattedTextField(formatoData);
        jtf_produto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jtf_codigo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtf_fornecedor = new javax.swing.JTextField();
        jtf_cod_forn = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajuste de Estoque");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/gravar_registro.gif"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar);
        jb_salvar.setBounds(180, 20, 100, 40);

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar);
        jb_cancelar.setBounds(290, 20, 120, 33);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Movimento"));
        jPanel3.setName("jPanel3"); // NOI18N

        buttonGroup1.add(jrb_entrada);
        jrb_entrada.setSelected(true);
        jrb_entrada.setText("Entrada");
        jrb_entrada.setName("jrb_entrada"); // NOI18N

        buttonGroup1.add(jrb_saida);
        jrb_saida.setText("Saída");
        jrb_saida.setName("jrb_saida"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrb_entrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrb_saida)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_entrada)
                    .addComponent(jrb_saida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(260, 70, 150, 0);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Código");
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 190, 60, 16);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Lote");
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 290, 24, 16);

        jtf_lote.setName("jtf_lote"); // NOI18N
        jtf_lote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_loteFocusGained(evt);
            }
        });
        getContentPane().add(jtf_lote);
        jtf_lote.setBounds(130, 310, 80, 24);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Preço unitário");
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 290, 76, 16);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Estoque");
        jLabel6.setName("jLabel6"); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 290, 46, 16);

        jtf_estoque.setEnabled(false);
        jtf_estoque.setName("jtf_estoque"); // NOI18N
        getContentPane().add(jtf_estoque);
        jtf_estoque.setBounds(20, 310, 90, 24);

        jtf_preco.setText("R$");
        jtf_preco.setName("jtf_preco"); // NOI18N
        jtf_preco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_precoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_precoFocusLost(evt);
            }
        });
        getContentPane().add(jtf_preco);
        jtf_preco.setBounds(230, 310, 80, 24);

        jftf_vencimento.setName("jftf_vencimento"); // NOI18N
        jftf_vencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_vencimentoFocusGained(evt);
            }
        });
        jftf_vencimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftf_vencimentoKeyPressed(evt);
            }
        });
        getContentPane().add(jftf_vencimento);
        jftf_vencimento.setBounds(330, 310, 80, 20);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setText("Vencimento");
        jLabel13.setName("jLabel13"); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(330, 290, 65, 16);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jta_observacao.setColumns(20);
        jta_observacao.setRows(5);
        jta_observacao.setName("jta_observacao"); // NOI18N
        jScrollPane1.setViewportView(jta_observacao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 410, 390, 83);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Quantidade");
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 340, 64, 16);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Observação");
        jLabel7.setName("jLabel7"); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 390, 66, 16);

        jtf_usuário.setEnabled(false);
        jtf_usuário.setName("jtf_usuário"); // NOI18N
        getContentPane().add(jtf_usuário);
        jtf_usuário.setBounds(100, 360, 120, 24);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel14.setText("Usuário");
        jLabel14.setName("jLabel14"); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(100, 340, 44, 16);

        jtf_quantidade.setName("jtf_quantidade"); // NOI18N
        jtf_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_quantidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_quantidadeFocusLost(evt);
            }
        });
        getContentPane().add(jtf_quantidade);
        jtf_quantidade.setBounds(20, 360, 60, 24);

        jftf_movimento.setEditable(false);
        jftf_movimento.setName("jftf_movimento"); // NOI18N
        getContentPane().add(jftf_movimento);
        jftf_movimento.setBounds(20, 160, 63, 20);

        jtf_serie.setName("jtf_serie"); // NOI18N
        jtf_serie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_serieFocusGained(evt);
            }
        });
        getContentPane().add(jtf_serie);
        jtf_serie.setBounds(210, 160, 110, 24);

        jtf_NotaFiscal.setName("jtf_NotaFiscal"); // NOI18N
        jtf_NotaFiscal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_NotaFiscalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_NotaFiscalFocusLost(evt);
            }
        });
        getContentPane().add(jtf_NotaFiscal);
        jtf_NotaFiscal.setBounds(100, 160, 90, 24);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("N° Série");
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 140, 46, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Data");
        jLabel9.setName("jLabel9"); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 140, 26, 16);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("Fornecedor");
        jLabel10.setName("jLabel10"); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(110, 190, 63, 16);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Nota Fiscal");
        jLabel11.setName("jLabel11"); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(100, 140, 70, 16);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setText("Emissão");
        jLabel12.setName("jLabel12"); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(340, 140, 50, 16);

        jftf_emissao.setName("jftf_emissao"); // NOI18N
        jftf_emissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_emissaoFocusGained(evt);
            }
        });
        getContentPane().add(jftf_emissao);
        jftf_emissao.setBounds(340, 160, 70, 20);

        jtf_produto.setName("jtf_produto"); // NOI18N
        jtf_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_produtoActionPerformed(evt);
            }
        });
        jtf_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_produtoKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_produto);
        jtf_produto.setBounds(110, 260, 250, 24);

        jButton1.setText("...");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 260, 40, 32);

        jtf_codigo.setEditable(false);
        jtf_codigo.setName("jtf_codigo"); // NOI18N
        jtf_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_codigoActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_codigo);
        jtf_codigo.setBounds(20, 260, 70, 24);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel15.setText("Produto / Apresentação");
        jLabel15.setName("jLabel15"); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(110, 240, 140, 16);

        jtf_fornecedor.setName("jtf_fornecedor"); // NOI18N
        jtf_fornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_fornecedorKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_fornecedor);
        jtf_fornecedor.setBounds(110, 210, 250, 24);

        jtf_cod_forn.setEditable(false);
        jtf_cod_forn.setName("jtf_cod_forn"); // NOI18N
        getContentPane().add(jtf_cod_forn);
        jtf_cod_forn.setBounds(20, 210, 70, 24);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel16.setText("Código");
        jLabel16.setName("jLabel16"); // NOI18N
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 240, 60, 16);

        jButton2.setText("...");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 210, 40, 32);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/registry.png"))); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N
        getContentPane().add(jLabel17);
        jLabel17.setBounds(20, 10, 80, 60);

        setSize(new java.awt.Dimension(459, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_NotaFiscal.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        if (verificaCampos()) {
            try {
                popular();
            } catch (ParseException ex) {
                Logger.getLogger(AjusteEstoqueGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

}//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        telaPrincipal.setStatusTela(true);
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void jtf_precoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_precoFocusLost
        jtf_preco.setText(setPrecoFormat(jtf_preco.getText()));
    }//GEN-LAST:event_jtf_precoFocusLost
    public boolean validadorData() {
        try {
            if (!validaData(jftf_emissao.getText())) {
                JOptionPane.showMessageDialog(null, "Data de emissão inválida");
                //jftf_emissao.requestFocus();
                return false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(AjusteEstoqueGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    private void jftf_vencimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftf_vencimentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if (jftf_vencimento.getText().equals("  /  /    ")) {
                    JOptionPane.showMessageDialog(null, "Informe a data");
                    jftf_vencimento.requestFocus();
                } else if (validaDataVencimento(jftf_vencimento.getText())) {
                    jtf_quantidade.requestFocus();
                } else {
                    jftf_vencimento.requestFocus();
                }
            } catch (ParseException ex) {
                Logger.getLogger(EntradaCadastraGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_vencimentoKeyPressed
    ProdutoModel produtoCombo;
    private void jtf_NotaFiscalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_NotaFiscalFocusLost
    }//GEN-LAST:event_jtf_NotaFiscalFocusLost

    private void jtf_NotaFiscalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_NotaFiscalFocusGained
        jtf_NotaFiscal.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_NotaFiscal.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe uma nota fiscal");
                    jtf_NotaFiscal.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_NotaFiscalFocusGained

    private void jtf_serieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_serieFocusGained
        jtf_serie.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_serie.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o número de série");
                    jtf_serie.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_serieFocusGained

    private void jftf_emissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_emissaoFocusGained
        jftf_emissao.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jftf_emissao.getText().trim().length() < 10) {
                    JOptionPane.showMessageDialog(null, "Data de emissão inválida");
                    return false;
                } else if (jftf_emissao.getText().equals("  /  /    ")) {
                    JOptionPane.showMessageDialog(null, "Informe a data de emissão");
                    jftf_emissao.requestFocus();
                    return false;
                } else {
                    try {
                        if (!validaData(jftf_emissao.getText())) {
                            JOptionPane.showMessageDialog(null, "Data de emissão inválida");
                            return false;
                        } else {
                            jtf_fornecedor.requestFocus();
                            return true;
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(AjusteEstoqueGUI.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_emissaoFocusGained

    private void jtf_loteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_loteFocusGained
        jtf_lote.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_lote.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Informe o lote");
                    jtf_lote.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_loteFocusGained

    private void jtf_precoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_precoFocusGained
        jtf_preco.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_preco.getText().trim().equals("RS")) {
                    JOptionPane.showMessageDialog(null, "Informe o preço");
                    jtf_preco.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_precoFocusGained

    private void jftf_vencimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_vencimentoFocusGained
        jftf_vencimento.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jftf_vencimento.getText().trim().length() < 10) {
                    JOptionPane.showMessageDialog(null, "Data de emissão inválida");
                    return false;
                } else if (jftf_vencimento.getText().equals("  /  /    ")) {
                    JOptionPane.showMessageDialog(null, "Informe a data de vencimento");

                    return false;
                } else {
                    try {
                        if (!validaDataVencimento(jftf_vencimento.getText())) {
                            JOptionPane.showMessageDialog(null, "Data de vencimento inválida");
                            return false;
                        } else {
                            return true;
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(AjusteEstoqueGUI.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jftf_vencimentoFocusGained

    private void jtf_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_quantidadeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_quantidadeFocusLost

    private void jtf_quantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_quantidadeFocusGained
        jtf_quantidade.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_quantidade.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade");
                    jtf_quantidade.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        });
        AjusteEstoqueModel ajuste = new AjusteEstoqueModel();
        ajuste.setLote(jtf_lote.getText());
        ajuste.setProduto(new ProdutoModel(produto.getCod_produto()));
        try {
            ajuste.setDataVencimento(new SimpleDateFormat("dd/MM/yyyy").parse(jftf_vencimento.getText()));
            // TODO add your handling code here:
        } catch (ParseException ex) {
            Logger.getLogger(AjusteEstoqueGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        consultaProduto(ajuste);

    }//GEN-LAST:event_jtf_quantidadeFocusGained

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        telaPrincipal.setStatusTela(true);
        //janelaPai2.estoqueIdeal();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
    conProduto.setTelaAjusteEstoque(this);;
    conProduto.janelapai3 = this;
    conProduto.listaProduto(jtf_produto.getText().trim());
    conProduto.setVisible(true);
    setStatusTela(false);

    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void jtf_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_codigoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jtf_codigoActionPerformed

private void jtf_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_produtoActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_produtoActionPerformed

private void jtf_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_produtoKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
        conProduto.setTelaAjusteEstoque(this);;
        conProduto.janelapai3 = this;
        conProduto.listaProduto(jtf_produto.getText().trim());
        conProduto.setVisible(true);
        setStatusTela(false);
    }
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
        conProduto.setTelaAjusteEstoque(this);;
        conProduto.janelapai3 = this;
        conProduto.listaProduto(jtf_produto.getText().trim());
        conProduto.setVisible(true);
        setStatusTela(false);
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_produtoKeyPressed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    FornecedorConsultarGUI forn = new FornecedorConsultarGUI();
    forn.setTelaAjusteEstoque(this);;
    forn.janelapai3 = this;
    forn.setCadastro();
    forn.listaFornecedor(jtf_fornecedor.getText().trim());
    forn.setVisible(true);
    setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

private void jtf_fornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_fornecedorKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        FornecedorConsultarGUI forn = new FornecedorConsultarGUI();
        forn.setTelaAjusteEstoque(this);;
        forn.janelapai3 = this;
        forn.setCadastro();
        forn.listaFornecedor(jtf_fornecedor.getText().trim());
        forn.setVisible(true);
        setStatusTela(false);
    }
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        FornecedorConsultarGUI forn = new FornecedorConsultarGUI();
        forn.setTelaAjusteEstoque(this);;
        forn.janelapai3 = this;
        forn.setCadastro();
        forn.listaFornecedor(jtf_fornecedor.getText().trim());
        forn.setVisible(true);
        setStatusTela(false);
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_fornecedorKeyPressed

    public void consultaProduto(AjusteEstoqueModel ajuste) {
        List<AjusteEstoqueModel> ajustes = new ArrayList();
        AjusteDAO ajusteDao = new AjusteDAO();
        ajustes = ajusteDao.consultaLote(ajuste);
        if (ajustes.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não contém registro com o parâmetro passado");
        } else {
            jtf_estoque.setText(String.valueOf(ajustes.get(0).getQuantidade()));
        }

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new AjusteEstoqueGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AjusteEstoqueGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JFormattedTextField jftf_emissao;
    private javax.swing.JFormattedTextField jftf_movimento;
    private javax.swing.JFormattedTextField jftf_vencimento;
    private javax.swing.JRadioButton jrb_entrada;
    private javax.swing.JRadioButton jrb_saida;
    private javax.swing.JTextArea jta_observacao;
    private javax.swing.JTextField jtf_NotaFiscal;
    private javax.swing.JTextField jtf_cod_forn;
    private javax.swing.JTextField jtf_codigo;
    private javax.swing.JTextField jtf_estoque;
    private javax.swing.JTextField jtf_fornecedor;
    private javax.swing.JTextField jtf_lote;
    private javax.swing.JTextField jtf_preco;
    private javax.swing.JTextField jtf_produto;
    private javax.swing.JTextField jtf_quantidade;
    private javax.swing.JTextField jtf_serie;
    private javax.swing.JTextField jtf_usuário;
    // End of variables declaration//GEN-END:variables

    public void popular() throws ParseException {
        if (validaDataVencimento(jftf_vencimento.getText()) && validaData(jftf_emissao.getText())) {
            AjusteEstoqueModel ajuste = new AjusteEstoqueModel();
            ajuste.setDataMovimento(new SimpleDateFormat("dd/MM/yyyy").parse(jftf_movimento.getText()));
            ajuste.setDataEmissao(new SimpleDateFormat("dd/MM/yyyy").parse(jftf_emissao.getText()));
            ajuste.setNotaFiscal(jtf_NotaFiscal.getText());
            ajuste.setnSérie(jtf_serie.getText());

//        ItemDbGrid hashDbGrid = (ItemDbGrid)jcb_fornecedor.getSelectedItem();
//        FornecedorModel fornecedorModel = (FornecedorModel)hashDbGrid.getObjeto();

            ajuste.setFornecedor(fornecedor);
            ajuste.setProduto(produto);
            ajuste.setQuantidade(Integer.parseInt(jtf_quantidade.getText()));
            ajuste.setLote(jtf_lote.getText());
            ajuste.setPreco(getPrecoFormato(jtf_preco.getText()));
            ajuste.setUsuario(new UsuarioModel(codUsuario, nomeUsuario));
            ajuste.setDataVencimento(new SimpleDateFormat("dd/MM/yyyy").parse(jftf_vencimento.getText()));

            if (validaNota(ajuste)) {
                if (cadastrar(ajuste) == true) {
                    setVisible(false);
                    telaPrincipal.setStatusTela(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Está nota fiscal não está cadastrada");
            }
        }

    }

    public boolean validaNota(AjusteEstoqueModel ajuste) {
        List<AjusteEstoqueModel> ajustes = new ArrayList();
        AjusteDAO ajus = new AjusteDAO();
        ajustes = ajus.validarNota(ajuste);
        if (ajustes.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastrar(AjusteEstoqueModel ajuste) {

        if (jrb_entrada.isSelected() == true) {
            AjusteDAO controlAjuste = new AjusteDAO();
            if (ajuste.getQuantidade() < 0) {
                JOptionPane.showMessageDialog(null, "Quantidade menor que zero");
                jtf_quantidade.requestFocus();
                return false;
            } else {
                ajuste.setTipoMovimento("Entrada");
                controlAjuste.cadastraAjuste(ajuste);



                if (controlAjuste.cadastraAjuste(ajuste)) {
                    Integer quantidadeAtual;
                    quantidadeAtual = Integer.parseInt(jtf_estoque.getText());
                    Integer quantidadeNova;
                    quantidadeNova = quantidadeAtual + ajuste.getQuantidade();

                    controlAjuste.entradaVencimento(ajuste);
                    controlAjuste.entradaAjuste(ajuste, quantidadeNova);
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                    return true;
                }
                return false;
            }
        } else if (jrb_saida.isSelected() == true) {
            AjusteDAO controlAjuste = new AjusteDAO();
            if (ajuste.getQuantidade() < 0) {
                JOptionPane.showMessageDialog(null, "Quantidade menor que zero");
                jtf_quantidade.requestFocus();
                return false;
            } else if (Integer.parseInt(jtf_estoque.getText()) < ajuste.getQuantidade()) {
                JOptionPane.showMessageDialog(null, "Quantidade maior que o estoque para o produto do lote");
                jtf_quantidade.requestFocus();
                return false;
            } else {
                Integer quantidadeAtual;
                quantidadeAtual = Integer.parseInt(jtf_estoque.getText());
                Integer quantidadeNova;
                quantidadeNova = quantidadeAtual - ajuste.getQuantidade();
                ajuste.setTipoMovimento("Saída");
                controlAjuste.cadastraAjuste(ajuste);
                if (controlAjuste.cadastraAjuste(ajuste)) {

                    controlAjuste.saidaVencimento(ajuste);
                    controlAjuste.entradaAjuste(ajuste, quantidadeNova);
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                    return true;
                }
                return false;
            }
        } else {
            return true;
        }
    }
    UsuarioModel usuario;

    public void carregaFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
        jtf_cod_forn.setText(String.valueOf(fornecedor.getCod_fornecedor()));
        jtf_fornecedor.setText(fornecedor.getRazao_social());
        jtf_produto.requestFocus();
    }

    public void carregaProduto(ProdutoModel produto) {
        this.produto = produto;
        jtf_codigo.setText(String.valueOf(produto.getCod_produto()));
        jtf_produto.setText(produto.getNome_produto());
        //jtf_estoque.setText(String.valueOf(produto.getEstoque()));
        jtf_lote.requestFocus();
    }
    List<EntradaItemModel> entradas = new ArrayList();

    public Double getPrecoFormato(String preco) {
        Double precoFormatado = 0.0;
        try {
            preco = preco.replace("R", "");
            preco = preco.replace("$", "");
            preco = preco.replace(",", ".");
            preco = preco.replace(" ", "");
            precoFormatado = Double.parseDouble(preco.trim());

            //this.objFuncionario.setSalario(getSalarioFormat(jTSalario.getText())); pegar valor em double

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor Informado Incorreto!\nInforme um valor com o seguinte formato:\nEx: 100,00");
        }
        return precoFormatado;
    }

    public String setPrecoFormat(String preco) {
        DecimalFormat dFormat = new DecimalFormat();
        dFormat.applyPattern("R$ #0.00");
        return dFormat.format(getPrecoFormato(preco));
    }

    public boolean verificaCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_NotaFiscal.getText().equals("")) {
            msgERRO = msgERRO + " *Nota Fiscal\n";
        }
        if (jtf_serie.getText().equals("")) {
            msgERRO = msgERRO + " *Série\n";
        }
        if (jftf_emissao.getText().equals("  /  /    ")) {
            msgERRO = msgERRO + " *Data de emissão\n";
        }
        if (jtf_cod_forn.getText().equals("")) {
            msgERRO = msgERRO + " *Fornecedor\n";
        }
        if (jtf_codigo.getText().equals("")) {
            msgERRO = msgERRO + " *Produto\n";
        }

        if (jtf_lote.getText().equals("")) {
            msgERRO = msgERRO + " *Lote\n";
        }

        if (jtf_preco.getText().equals("R$")) {
            msgERRO = msgERRO + " *Preço\n";
        }

        if (jftf_vencimento.getText().equals("  /  /    ")) {
            msgERRO = msgERRO + " *Data de vencimento\n";
        }

        if (jtf_quantidade.getText().equals("")) {
            msgERRO = msgERRO + " *Quantidade\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_NotaFiscal.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void carregaUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
        jtf_usuário.setText(usuario.getNome_usuario());
    }

    public boolean validaDataVencimento(String dataString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = new GregorianCalendar();
        Date dataDigitada = new Date(df.parse(dataString).getTime());
        Date dataAtual = new Date(System.currentTimeMillis());

        // gerando o calendar
        cal.setTime(df.parse(dataString));

        // separando os dados da string para comparacao e validacao
        String[] data = dataString.split("/");
        String dia = data[0];
        String mes = data[1];
        String ano = data[2];
        // testando se hah discrepancia entre a data que foi
        // inserida no caledar e a data que foi passada como
        // string. se houver diferenca, a data passada era
        // invalida
        if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
            // dia nao caso
            return false;
        } else if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
            // mes nao casou
            return false;
        } else if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
            // ano nao casou
            return false;
        } else if (dataAtual.after(dataDigitada)) {
            // data maior que atual
            return false;
        }
        return true;
    }

    public static boolean validaData(String dataString) throws java.text.ParseException {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = new GregorianCalendar();
        Date dataDigitada = new Date(df.parse(dataString).getTime());
        Date dataAtual = new Date(System.currentTimeMillis());

        // gerando o calendar
        cal.setTime(df.parse(dataString));

        // separando os dados da string para comparacao e validacao
        String[] data = dataString.split("/");
        String dia = data[0];
        String mes = data[1];
        String ano = data[2];



        // testando se hah discrepancia entre a data que foi
        // inserida no caledar e a data que foi passada como
        // string. se houver diferenca, a data passada era
        // invalida
        if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
            // dia nao casou                 
            return (false);
        }
        if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
            // mes nao casou

            return (false);
        }
        if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
            // ano nao casou

            return (false);
        }
        if (dataDigitada.after(dataAtual)) {
            // data maior que atual
            return (false);
        }
        return (true);
    }
    List<FornecedorModel> fornecedores;

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }
}
