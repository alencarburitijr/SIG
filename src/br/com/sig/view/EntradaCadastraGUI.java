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

import br.com.sig.dao.EntradaDAO;
import br.com.sig.dao.FornecedorDAO;
import br.com.medicalpharm.model.EntradaItemModel;
import br.com.medicalpharm.model.EntradaModel;
import br.com.medicalpharm.model.FornecedorModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.sig.util.Data;
import br.com.sig.util.ItemDbGrid;
import br.com.sig.util.LimitadorTexto;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
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

public class EntradaCadastraGUI extends javax.swing.JFrame implements EntradaCadastraGUI_InterFace {

    EntradaGUI janelaPaim;
    public FornecedorModel objfornecedor;
    DecimalFormat formatoPreco;
    MaskFormatter formatoData;
    ListSelectionModel lsmItem;
    EntradaModel entradaModel = new EntradaModel();
    String permissao;

    public EntradaCadastraGUI() throws SQLException {
        initComponents();
        Data mostraData = new Data();
        mostraData.le_data();
        jftf_lancamento.setText(mostraData.dia + "/" + mostraData.mes + "/" + mostraData.ano);
        // listarFornecedor();
        //     listarProduto();
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

    public void setJanelapai(EntradaGUI janelaPaim) {
        janelaPaim = janelaPaim;
        permissao = janelaPaim.permissao;
        setTela(permissao);
    }

    public void setTela(String permissao) {

        //JOptionPane.showMessageDialog(null, permissao);
        if (permissao.equals("usuario")) {
            jb_fornecedor.setEnabled(false);
//            jb_produto.setEnabled(false);            
        } else {
            // jb_fornecedor.setEnabled(true);
//            jb_produto.setEnabled(true);            
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jtf_NotaFiscal = new javax.swing.JTextField(new LimitadorTexto(18), "",10);
        jtf_serie = new javax.swing.JTextField(new LimitadorTexto(15), "",10);
        try  {      
            formatoData = new MaskFormatter("##/##/####");  
        } 
        catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        jftf_emissao = new JFormattedTextField(formatoData);
        jtf_fornecedor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jtf_produto = new javax.swing.JTextField();
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
        jtf_quantidade = new javax.swing.JTextField(new LimitadorTexto(11), "",10);
        jb_adicionar = new javax.swing.JButton();
        jb_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jtf_codigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jftf_lancamento = new javax.swing.JFormattedTextField();
        jtf_codigo_forn = new javax.swing.JTextField();
        jb_fornecedor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de produtos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jtf_NotaFiscal.setName("jtf_NotaFiscal"); // NOI18N
        jtf_NotaFiscal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_NotaFiscalFocusGained(evt);
            }
        });
        getContentPane().add(jtf_NotaFiscal);
        jtf_NotaFiscal.setBounds(120, 100, 100, 24);

        jtf_serie.setName("jtf_serie"); // NOI18N
        jtf_serie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_serieFocusGained(evt);
            }
        });
        getContentPane().add(jtf_serie);
        jtf_serie.setBounds(240, 100, 90, 24);

        jftf_emissao.setName("jftf_emissao"); // NOI18N
        jftf_emissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftf_emissaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftf_emissaoFocusLost(evt);
            }
        });
        jftf_emissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftf_emissaoKeyPressed(evt);
            }
        });
        getContentPane().add(jftf_emissao);
        jftf_emissao.setBounds(350, 100, 90, 20);

        jtf_fornecedor.setName("jtf_fornecedor"); // NOI18N
        jtf_fornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_fornecedorFocusLost(evt);
            }
        });
        jtf_fornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_fornecedorKeyPressed(evt);
            }
        });
        getContentPane().add(jtf_fornecedor);
        jtf_fornecedor.setBounds(140, 150, 410, 24);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_produto.setName("jtf_produto"); // NOI18N
        jtf_produto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_produtoFocusGained(evt);
            }
        });
        jtf_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_produtoKeyPressed(evt);
            }
        });
        jPanel2.add(jtf_produto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 410, -1));

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
        jPanel2.add(jtf_preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, -1));

        jtf_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_quantidade.setText(jtf_quantidade.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_quantidade.setName("jtf_quantidade"); // NOI18N
        jtf_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_quantidadeFocusGained(evt);
            }
        });
        jtf_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_quantidadeKeyPressed(evt);
            }
        });
        jPanel2.add(jtf_quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 70, -1));

        jb_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/edit_add.png"))); // NOI18N
        jb_adicionar.setToolTipText("Incluir");
        jb_adicionar.setName("jb_adicionar"); // NOI18N
        jb_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionarActionPerformed(evt);
            }
        });
        jPanel2.add(jb_adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 30, 30));

        jb_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/edit_remove.png"))); // NOI18N
        jb_eliminar.setToolTipText("Excluir");
        jb_eliminar.setName("jb_eliminar"); // NOI18N
        jb_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jb_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 30, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Produto");
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 300, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Preço unitário");
        jLabel5.setName("jLabel5"); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("Quantidade");
        jLabel6.setName("jLabel6"); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Preço", "Qtd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 550, 200));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel14.setText("Código");
        jLabel14.setName("jLabel14"); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtf_codigo.setEditable(false);
        jtf_codigo.setName("jtf_codigo"); // NOI18N
        jPanel2.add(jtf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jButton1.setText("...");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 30, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 190, 590, 350);

        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/gravar_registro.gif"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salvar);
        jb_salvar.setBounds(410, 20, 94, 35);

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_cancelar);
        jb_cancelar.setBounds(510, 20, 107, 35);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Código");
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 130, 40, 16);

        jftf_lancamento.setEditable(false);
        jftf_lancamento.setName("jftf_lancamento"); // NOI18N
        getContentPane().add(jftf_lancamento);
        jftf_lancamento.setBounds(30, 100, 70, 20);

        jtf_codigo_forn.setEditable(false);
        jtf_codigo_forn.setName("jtf_codigo_forn"); // NOI18N
        getContentPane().add(jtf_codigo_forn);
        jtf_codigo_forn.setBounds(30, 150, 88, 24);

        jb_fornecedor.setText("...");
        jb_fornecedor.setName("jb_fornecedor"); // NOI18N
        jb_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_fornecedorActionPerformed(evt);
            }
        });
        getContentPane().add(jb_fornecedor);
        jb_fornecedor.setBounds(560, 150, 30, 32);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("N° Série");
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 80, 50, 16);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Data");
        jLabel9.setName("jLabel9"); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 80, 26, 16);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Nota Fiscal");
        jLabel11.setName("jLabel11"); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(120, 80, 62, 16);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setText("Emissão");
        jLabel12.setName("jLabel12"); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(350, 80, 50, 16);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("Fornecedor");
        jLabel10.setName("jLabel10"); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(140, 130, 63, 16);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/shoppingcart_full.png"))); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 20, 70, 50);

        setSize(new java.awt.Dimension(656, 599));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_NotaFiscal.requestFocus();

    }//GEN-LAST:event_formWindowOpened

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        cadastroNotas();
}//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        jTable1.updateUI();
        this.setVisible(false);
        janelaPaim.setEnabled(true);
        janelaPaim.setVisible(true);
}//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionarActionPerformed
        try {
            alimentarItens();
        } catch (ParseException ex) {
            Logger.getLogger(EntradaCadastraGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_adicionarActionPerformed
    EntradaItemModel entradaItemModel = new EntradaItemModel();

    private void jb_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminarActionPerformed
        excluirProduto();
    }//GEN-LAST:event_jb_eliminarActionPerformed

    private void jtf_precoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_precoFocusLost
        jtf_preco.setText(setPrecoFormat(jtf_preco.getText()));
    }//GEN-LAST:event_jtf_precoFocusLost

    private void jtf_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_quantidadeKeyPressed
    }//GEN-LAST:event_jtf_quantidadeKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased
    ProdutoModel produtoCombo;
    FornecedorModel fornecedorCombo;
    private void jtf_NotaFiscalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_NotaFiscalFocusGained
        jtf_NotaFiscal.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_NotaFiscal.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe o número da nota fiscal");
                    jtf_NotaFiscal.requestFocus();
                    return false;
                } else {
                    jtf_serie.grabFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_NotaFiscalFocusGained

    private void jtf_serieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_serieFocusGained
        jtf_serie.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_serie.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe a série");
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

    private void jtf_precoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_precoFocusGained
        jtf_preco.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_preco.getText().trim().equals("RS")) {
                    JOptionPane.showMessageDialog(null, "Informe o preço");
                    jtf_preco.requestFocus();
                    return false;
                } else {
                    jtf_quantidade.requestFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_precoFocusGained

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
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_quantidadeFocusGained

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        jTable1.updateUI();
        this.setVisible(false);
        janelaPaim.setEnabled(true);
        janelaPaim.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_fornecedorActionPerformed
    FornecedorConsultarGUI forn = new FornecedorConsultarGUI();
    forn.setTelaCadNota(this);;
    forn.janelapai = this;
    forn.listaFornecedor(jtf_fornecedor.getText().trim());
    forn.setVisible(true);
    setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jb_fornecedorActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
    conProduto.setTelaCadNota(this);;
    conProduto.janelapai = this;
    conProduto.listaProduto(jtf_produto.getText().trim());
    conProduto.setVisible(true);
    setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void jtf_produtoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_produtoFocusGained
    jtf_produto.setInputVerifier(new InputVerifier() {

        public boolean verify(JComponent input) {
            if (jtf_produto.getText().trim().equals("")) {


                return false;
            } else {
                return true;
            }
        }
    });

    // TODO add your handling code here:
}//GEN-LAST:event_jtf_produtoFocusGained

private void jtf_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_produtoKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
        conProduto.setTelaCadNota(this);;
        conProduto.janelapai = this;
        conProduto.listaProduto(jtf_produto.getText().trim());
        conProduto.setVisible(true);
        setStatusTela(false);
    }
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        ProdutoConsultarGUI conProduto = new ProdutoConsultarGUI();
        conProduto.setTelaCadNota(this);;
        conProduto.janelapai = this;
        conProduto.listaProduto(jtf_produto.getText().trim());
        conProduto.setVisible(true);
        setStatusTela(false);
    }

    // TODO add your handling code here:
}//GEN-LAST:event_jtf_produtoKeyPressed

    public void consultarForncedor(){
        FornecedorConsultarGUI forn = new FornecedorConsultarGUI();
        forn.setTelaCadNota(this);;
        forn.janelapai = this;
        forn.listaFornecedor(jtf_fornecedor.getText().trim());
        forn.setVisible(true);
        setStatusTela(false);
    }

private void jtf_fornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_fornecedorKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER ||evt.getKeyCode() == KeyEvent.VK_TAB) {
        consultarForncedor();
    }
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        consultarForncedor();
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_fornecedorKeyPressed

private void jftf_emissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftf_emissaoKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        jtf_fornecedor.requestFocus();
    }
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jtf_fornecedor.requestFocus();
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jftf_emissaoKeyPressed

private void jftf_emissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftf_emissaoFocusLost
    jtf_fornecedor.requestFocus();
    // TODO add your handling code here:
}//GEN-LAST:event_jftf_emissaoFocusLost

private void jtf_fornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_fornecedorFocusLost
    //jtf_produto.requestFocus();
    // TODO add your handling code here:
}//GEN-LAST:event_jtf_fornecedorFocusLost
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new EntradaCadastraGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EntradaCadastraGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_adicionar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_eliminar;
    private javax.swing.JButton jb_fornecedor;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JFormattedTextField jftf_emissao;
    private javax.swing.JFormattedTextField jftf_lancamento;
    private javax.swing.JTextField jtf_NotaFiscal;
    private javax.swing.JTextField jtf_codigo;
    private javax.swing.JTextField jtf_codigo_forn;
    private javax.swing.JTextField jtf_fornecedor;
    private javax.swing.JTextField jtf_preco;
    private javax.swing.JTextField jtf_produto;
    private javax.swing.JTextField jtf_quantidade;
    private javax.swing.JTextField jtf_serie;
    // End of variables declaration//GEN-END:variables
    private FornecedorModel fornecedor;

    public void cadastroNotas() {
        if (verificaCampos()) {
            EntradaModel entrada = new EntradaModel();
            List<EntradaItemModel> itens = new ArrayList();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                EntradaItemModel entrItem = new EntradaItemModel();
                entrItem.setProduto(new ProdutoModel((Integer) jTable1.getValueAt(i, 0)));
                entrItem.setLote("0");
                entrItem.setPreco(getPrecoFormato((String) jTable1.getValueAt(i, 2)));
                entrItem.setQnt(Integer.parseInt((String) jTable1.getValueAt(i, 3)));
                try {
                    entrItem.setVencimento(new SimpleDateFormat("dd/MM/yyyy").parse("00/00/0000"));
                    //                ItemDbGrid hashDbGrid1 = (ItemDbGrid) jTable1.getValueAt(i, 0);
                } catch (ParseException ex) {
                    Logger.getLogger(EntradaCadastraGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
//                ItemDbGrid hashDbGrid1 = (ItemDbGrid) jTable1.getValueAt(i, 0);

                itens.add(entrItem);
            }

            EntradaDAO controlEntrada = new EntradaDAO();
            try {
                entrada.setLancamento(new SimpleDateFormat("dd/MM/yyyy").parse(jftf_lancamento.getText()));
                entrada.setEmissao(new SimpleDateFormat("dd/MM/yyyy").parse(jftf_emissao.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(EntradaCadastraGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
//            ItemDbGrid hashDbGrid1 = (ItemDbGrid)jcb_fornecedor.getSelectedItem();
//            fornecedorCombo = (FornecedorModel)hashDbGrid1.getObjeto();

            entrada.setFornecedor(fornecedor);
            entrada.setNotaFiscal(jtf_NotaFiscal.getText().trim());
            entrada.setnSérie(jtf_serie.getText().trim());

            if (validaNota(entrada)) {
                entrada = controlEntrada.cadastraEntrada(entrada);
                if (entrada != null) {
                    controlEntrada.cadastraItem(itens, entrada);
                    controlEntrada.consultaQuantidade(itens, entrada);
                    controlEntrada.entradaVencimento(itens);
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                    janelaPaim.setVisible(true);
                    janelaPaim.setEnabled(true);
                    janelaPaim.listarEntradas();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar a nota fiscal.");
                    //  jcb_fornecedor.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Está nota fiscal já foi cadastrada. Você deve fazer agora um ajuste");
            }
        }
    }

    public boolean validaNota(EntradaModel entrada) {
        List<EntradaModel> entradas = new ArrayList();
        EntradaDAO entr = new EntradaDAO();
        entradas = entr.validarNota(entrada);
        if (entradas.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
//     EntradaCadastraGUI_Interface TelaEntrada;
//
//     public void setTelaEntradaGUI(EntradaCadastraGUI_Interface TelaEntrada){
//        this.TelaEntrada = TelaEntrada;
//    }
    ProdutoModel produto;

    public void limparCampos() {


        jtf_preco.setText("");
        jtf_quantidade.setText("");
        
//        jcb_produto.requestFocus();
    }

    private void excluirProduto() {
        removeProduto(jTable1);
    }

    public void removeProduto(JTable tb) {
        DefaultTableModel row = (DefaultTableModel) jTable1.getModel();
        if (tb.getSelectedRow() != -1) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_NO_OPTION) {
                row.removeRow(tb.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto");
        }
    }

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

        if (jtf_codigo_forn.getText().equals("")) {
            msgERRO = msgERRO + " *Fornecedor\n";
        }
        if (jtf_NotaFiscal.getText().equals("")) {
            msgERRO = msgERRO + " *Nota Fiscal\n";
        }
        if (jtf_serie.getText().equals("")) {
            msgERRO = msgERRO + " *Número de série\n";
        }
        if (jftf_emissao.getText().equals("  /  /    ")) {
            msgERRO = msgERRO + " *Data de emissão\n";
        }
        if (jTable1.getRowCount() == 0) {
            msgERRO = msgERRO + " *Adicione pelo menos 1 Produto\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_NotaFiscal.requestFocus();
            return false;
        } else {
            return true;
        }
    }
    List<ProdutoModel> produtos;
//    public void listarProduto() {
//        ProdutoDAO prod = new ProdutoDAO();
//        produtos = prod.listarProdutos();
//        mostraProdutos(produtos);
//
//    }
//
//    public void mostraProdutos(List<ProdutoModel> produtos){
////       if(jcb_produto.getSelectedIndex()==0){
////           
////       }
//        //jcb_produto.removeAllItems();
//        if (produtos.size() == 0 ){
//           JOptionPane.showMessageDialog(this,"Nenhum produto encontrado");
//
//        } else {
//            for(int i = 0; i<produtos.size(); i++){//ou i<destino.size() para retornar todos
//                ProdutoModel produtoModel = new ProdutoModel();
//                produtoModel.setCod_produto(produtos.get(i).getCod_produto());
//                produtoModel.setNome_produto(produtos.get(i).getNome_produto());
//                produtoModel.setConcentraçao(produtos.get(i).getConcentraçao());
//                produtoModel.setEstoque(produtos.get(i).getEstoque());
//                produtoModel.setEstoque_ideal(produtos.get(i).getEstoque_ideal());
//                produtoModel.setEstoque_minimo(produtos.get(i).getEstoque_minimo());
//                produtoModel.setGrupo(produtos.get(i).getGrupo());;
//                produtoModel.setUnidade(produtos.get(i).getUnidade());
//                produtoModel.setUltimo_preco(produtos.get(i).getUltimo_preco());
//                ItemDbGrid hashDbGrid = new ItemDbGrid(produtoModel, produtoModel.getNome_produto());
//                jcb_produto.addItem(hashDbGrid);
////                S20BinaryLookup  teste = new S20BinaryLookup(jcb_produto);
//                AutoCompletion auto = new AutoCompletion(jcb_produto);
//
//            }
//         }
//     }
    List<FornecedorModel> fornecedores;

    public void listarFornecedor() {
        FornecedorDAO forn = new FornecedorDAO();
        fornecedores = forn.listarForncedores();
        mostraFornecedores(fornecedores);

    }

    public void mostraFornecedores(List<FornecedorModel> fornecedores) {
//        jcb_fornecedor.removeAllItems();
        if (fornecedores.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum fornecedor encontrado");

        } else {
            for (int i = 0; i < fornecedores.size(); i++) {
                FornecedorModel fornecedorModel = new FornecedorModel();
                fornecedorModel.setCod_fornecedor(fornecedores.get(i).getCod_fornecedor());
                fornecedorModel.setRazao_social(fornecedores.get(i).getRazao_social());
                fornecedorModel.setNome_fantasia(fornecedores.get(i).getNome_fantasia());
                fornecedorModel.setEndereço(fornecedores.get(i).getEndereço());
                fornecedorModel.setCNPJ(fornecedores.get(i).getCNPJ());
                fornecedorModel.setTelefone(fornecedores.get(i).getTelefone());
                fornecedorModel.setFax(fornecedores.get(i).getFax());
                fornecedorModel.setCidade(fornecedores.get(i).getCidade());
                fornecedorModel.setCEP(fornecedores.get(i).getCEP());
                fornecedorModel.setEstado(fornecedores.get(i).getEstado());
                fornecedorModel.setInsc_municipal(fornecedores.get(i).getInsc_municipal());
                fornecedorModel.setInsc_estadual(fornecedores.get(i).getInsc_estadual());
                fornecedorModel.setNome_vendedor(fornecedores.get(i).getNome_vendedor());
                fornecedorModel.setTel_vendedor(fornecedores.get(i).getTel_vendedor());

                ItemDbGrid hashDbGrid = new ItemDbGrid(fornecedorModel, fornecedorModel.getRazao_social());
//            jcb_fornecedor.addItem(hashDbGrid);
                //    AutoCompletion auto = new AutoCompletion(jcb_fornecedor);
            }
        }
    }

    public boolean verificarItem() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo.getText().equals("")) {
            msgERRO = msgERRO + " *Produto\n";
        }
       
        if (jtf_preco.getText().equals("R$")) {
            msgERRO = msgERRO + " *Preço\n";
        }
        if (jtf_quantidade.getText().equals("")) {
            msgERRO = msgERRO + " *Quantidade\n";
        }
       

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);           
            return false;
        } else {
            return true;
        }
    }

    public void alimentarItens() throws ParseException {
        if (verificarItem() && (verificaTabela() == true)) {
            entradaItemModel.setEntradaModel(entradaModel);
            entradaItemModel.setLote((""));


            entradaItemModel.setProduto(produto);
            entradaItemModel.setQnt(new Integer(jtf_quantidade.getText()));
            entradaItemModel.setPreco(getPrecoFormato(jtf_preco.getText()));            

            entradaItemModel.setVencimento(null);

            DefaultTableModel row = (DefaultTableModel) jTable1.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(entradaItemModel, entradaItemModel.getProduto().getNome_produto());
            row.addRow(new Object[]{produto.getCod_produto(), hashDbGrid,jtf_preco.getText(), jtf_quantidade.getText()});
            limparItem();
            //jtf_produto.requestFocus();
        } else {
            //JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
        }
    }
    private Date data;

    public boolean verificaTabela() {


        boolean tabela = true;
        if (jTable1.getRowCount() == 0) {
            return true;

        } else if (jTable1.getRowCount() > 0) {
            int linhas = jTable1.getRowCount();

            for (int i = 0; i < linhas; i++) {
                EntradaItemModel ent = new EntradaItemModel();
                ent.setProduto(new ProdutoModel((Integer) jTable1.getValueAt(i, 0)));
               
                String lote = null;
                

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
              
                //String venc = null;
                //venc = (String) jTable1.getValueAt(i, 5);

                /*try {
                    ent.setVencimento(dateFormat.parse(venc));
                } catch (ParseException ex) {
                    Logger.getLogger(EntradaCadastraGUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                /*data = null;
                try {
                    data = (dateFormat.parse(""));
                } catch (ParseException ex) {
                    Logger.getLogger(EntradaCadastraGUI.class.getName()).log(Level.SEVERE, null, ex);
                }*/

                if (ent.getProduto().getCod_produto() == produto.getCod_produto()) {
                    ent.setLote((String) jTable1.getValueAt(i, 2));

                    if (ent.getLote().equals(lote)) {

                        JOptionPane.showMessageDialog(null, "Este lote já foi inserido para este produto");
                        tabela = false;

                    } else if (ent.getVencimento() == data) {
                        JOptionPane.showMessageDialog(null, "Este vencimento já foi inserido para um lote neste produto");
                        tabela = false;

                    } else {
                        tabela = true;
                    }
                }
            }

            return tabela;
        }
        return tabela;
    }
    List<EntradaItemModel> itemModel = new ArrayList<EntradaItemModel>();
//
//    public boolean verificaTabela() {
//        boolean produtoExistente = false;
//
//        if (jTable1.getRowCount() == 0) {
//            produtoExistente = true;
//
//        } else {
//            produtoExistente = false;
//        }
//
//
//
//        if (jTable1.getRowCount() > 0) {
//            for (int i = 0; i < jTable1.getRowCount(); i++) {
//                ItemDbGrid hashDb = (ItemDbGrid) jTable1.getValueAt(i, 0);
//                EntradaItemModel entradaItem = (EntradaItemModel) hashDb.getObjeto();
//                entradaItemModel = entradaItem;
//                if (entradaItemModel.getProduto().getCod_produto() == produtoCombo.getCod_produto()) {
//                    JOptionPane.showMessageDialog(null, "Este produto já foi inserido");
//                    produtoExistente = false;
//                } else {
//                    produtoExistente = true;
//                }
//            }
//            return produtoExistente;
//        }
//        return produtoExistente;
//    }

    public void limparItem() {

       
        jtf_preco.setText("R$");
        jtf_quantidade.setText("");
       
        jtf_codigo.setText("");
        jtf_produto.setText("");
//        jtf_concentracao.setText("");
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregaFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
        jtf_codigo_forn.setText(String.valueOf(fornecedor.getCod_fornecedor()));
        jtf_fornecedor.setText(fornecedor.getRazao_social());
        //jtf_produto.requestFocus();
    }

    public void carregaProduto(ProdutoModel produto) {
        this.produto = produto;
        jtf_produto.setText(produto.getNome_produto());
        jtf_codigo.setText(String.valueOf(produto.getCod_produto()));       
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }

    public void setRequestProd() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRequestForn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
