/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntradaGUI.java
 *
 * Created on 27/05/2011, 15:13:50
 */
package br.com.sig.view;

import br.com.sig.dao.SaidaDAO;
import br.com.medicalpharm.model.SaidaItemModel;
import br.com.medicalpharm.model.SaidaModel;
import br.com.sig.util.ItemDbGrid;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class SaidaGUI extends javax.swing.JFrame {

    public SaidaGUI() {
        initComponents();
        listaDestino();
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
    String permissao;
    List<SaidaModel> saidas;
    List<SaidaItemModel> saidaItens;
    TelaPrincipal janelapaiM;

    public void setJanelaPai(TelaPrincipal janelapai) {

        janelapaiM = janelapai;
        permissao = janelapai.permissao;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_detalhado = new javax.swing.JRadioButton();
        jrb_descricao = new javax.swing.JRadioButton();
        jl_pesquisar_destino = new javax.swing.JLabel();
        jb_buscar = new javax.swing.JButton();
        jtf_pesquisar = new javax.swing.JTextField();
        jrb_consumo = new javax.swing.JRadioButton();
        jb_sair = new javax.swing.JButton();
        jb_novo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de saidas do estoque principal");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jrb_codigo);
        jrb_codigo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_codigo.setSelected(true);
        jrb_codigo.setText("Código");
        jrb_codigo.setName("jrb_codigo"); // NOI18N
        jPanel1.add(jrb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, -1, -1));

        buttonGroup1.add(jrb_detalhado);
        jrb_detalhado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_detalhado.setText("Específica");
        jrb_detalhado.setName("jrb_detalhado"); // NOI18N
        jPanel1.add(jrb_detalhado, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 27, -1, -1));

        buttonGroup1.add(jrb_descricao);
        jrb_descricao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jrb_descricao.setText("Descrição");
        jrb_descricao.setName("jrb_descricao"); // NOI18N
        jPanel1.add(jrb_descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 27, -1, -1));

        jl_pesquisar_destino.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jl_pesquisar_destino.setText("Parâmetro");
        jl_pesquisar_destino.setName("jl_pesquisar_destino"); // NOI18N
        jPanel1.add(jl_pesquisar_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 62, -1, -1));

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/ok.png"))); // NOI18N
        jb_buscar.setText("Ir");
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jtf_pesquisar.setName("jtf_pesquisar"); // NOI18N
        jPanel1.add(jtf_pesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 300, 20));

        buttonGroup1.add(jrb_consumo);
        jrb_consumo.setText("Consumo");
        jrb_consumo.setName("jrb_consumo"); // NOI18N
        jPanel1.add(jrb_consumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 27, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 466, 120));

        jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/exit.png"))); // NOI18N
        jb_sair.setText("Sair");
        jb_sair.setName("jb_sair"); // NOI18N
        jb_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sairActionPerformed(evt);
            }
        });
        getContentPane().add(jb_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 33));

        jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/medicalpharm/image/novo_registro.gif"))); // NOI18N
        jb_novo.setText("Novo");
        jb_novo.setName("jb_novo"); // NOI18N
        jb_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novoActionPerformed(evt);
            }
        });
        getContentPane().add(jb_novo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Nome comercial", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setName("jTable1"); // NOI18N
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 466, 120));

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTable2.setUpdateSelectionOnSort(false);
        jTable2.setVerifyInputWhenFocusTarget(false);
        jTable2.setDefaultEditor(Object.class, null);
        jTable2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 1){
                    listarItem();
                }}});
                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Código", "Destino", "Data"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.Object.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jTable2.setColumnSelectionAllowed(true);
                jTable2.setName("jTable2"); // NOI18N
                jTable2.getTableHeader().setReorderingAllowed(false);
                jScrollPane3.setViewportView(jTable2);
                jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                if (jTable2.getColumnModel().getColumnCount() > 0) {
                    jTable2.getColumnModel().getColumn(0).setPreferredWidth(40);
                    jTable2.getColumnModel().getColumn(1).setPreferredWidth(180);
                    jTable2.getColumnModel().getColumn(2).setPreferredWidth(50);
                }

                getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 466, 128));

                setSize(new java.awt.Dimension(526, 526));
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
       
        
        if (jrb_codigo.isSelected() == true ) {
            listarDestinoCodigo();
        } else if (jrb_descricao.isSelected() == true) {
            ListarDestinoDescricao();
        } else if (jrb_detalhado.isSelected() == true) {
            listaDestino();
        }else if(jrb_consumo.isSelected() == true){
            listaConsumo(1);
        }else {
            listaDestino();
        }
}//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        SaidaEstoqueGUI saida;
        saida = new SaidaEstoqueGUI();
        saida.janelapai = this;
        saida.setVisible(true);
        saida.setJanelapai(this);
        this.setEnabled(false);
}//GEN-LAST:event_jb_novoActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
        //telaPrincipal.setStatusTela(true);

}//GEN-LAST:event_jb_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
//        telaPrincipal.setStatusTela(true);

    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaidaGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_pesquisar_destino;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_consumo;
    private javax.swing.JRadioButton jrb_descricao;
    private javax.swing.JRadioButton jrb_detalhado;
    private javax.swing.JTextField jtf_pesquisar;
    // End of variables declaration//GEN-END:variables
    private TelaPrincipal_Interface telaPrincipal;//Recebendo tela como parametro para atualização apos pesquisa

    public void setTelaPrincipal(TelaPrincipal_Interface telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    void request() {
        jtf_pesquisar.requestFocus();
    }
    
    private void listarDestinoCodigo() {
        if (jtf_pesquisar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um código");
        } else {
            SaidaDAO controlSaida = new SaidaDAO();
            saidas = controlSaida.listarDestinoCodigo(jtf_pesquisar.getText().trim());
            mostrarDestino(saidas);
        }
    }

    private void ListarDestinoDescricao() {
        SaidaDAO controlSaida = new SaidaDAO();
        saidas = controlSaida.ListarDestinoDescricao(jtf_pesquisar.getText().trim() + "%");
        mostrarDestino(saidas);
    }

    public void listaDestino() {
        SaidaDAO controlSaida = new SaidaDAO();
        saidas = controlSaida.listaDestino("%" + jtf_pesquisar.getText().trim() + "%");        
        mostrarDestino(saidas);

    }
    public void listaConsumo(int i){
        SaidaDAO controlSaida = new SaidaDAO();        
        saidas = controlSaida.listaConsumo("0");                   
        mostrarDestino(saidas);
    }
    public void mostrarDestino(List<SaidaModel> saidas) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setNumRows(0);

        if (saidas.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma saida encontrada");

        } else {
            for (int i = 0; i < saidas.size(); i++) {
                try {
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");


                    String dataSaida = out.format(in.parse(saidas.get(i).getDataSaida().toString()));

                    SaidaModel saida = new SaidaModel();
                    saida.setIdsaida(saidas.get(i).getIdsaida());
                    saida.setDestino(saidas.get(i).getDestino());
                    saida.setDataSaida(saidas.get(i).getDataSaida());                    

                    DefaultTableModel row = (DefaultTableModel) jTable2.getModel();
                    ItemDbGrid hashDbGrid = new ItemDbGrid(saida, saida.getDestino().getDesc_destino());
                    row.addRow(new Object[]{saida.getIdsaida(), hashDbGrid, dataSaida});
                } catch (ParseException ex) {
                    Logger.getLogger(SaidaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void listarItem() {
        SaidaModel saida = tbSaidaSelecionada(jTable2);
        if (saida != null) {
            SaidaDAO controlSaida = new SaidaDAO();
            Integer idSaida;
            idSaida = saida.getIdsaida();
            // controlSaida.listarItens(saida.getIdsaida());
            saidaItens = controlSaida.listarItens(idSaida);
            mostrarItens(saidaItens);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma nota");
            jtf_pesquisar.requestFocus();
        }
    }

    public SaidaModel tbSaidaSelecionada(JTable tb) {
        SaidaModel saida = null;
        if (tb.getSelectedRow() != -1) {
            saida = new SaidaModel();
            saida.setIdsaida(saidas.get(tb.getSelectedRow()).getIdsaida());
        }
        return saida;

    }

    public void mostrarItens(List<SaidaItemModel> saidaItens) {
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        jTable1.updateUI();

        if (saidaItens.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum item encontrado");

        } else {
            for (int i = 0; i < saidaItens.size(); i++) {//ou i<destino.size() para retornar todos
                SaidaItemModel saidaItemModel = new SaidaItemModel();
                saidaItemModel.setProduto(saidaItens.get(i).getProduto());
                saidaItemModel.setQuantidade(saidaItens.get(i).getQuantidade());

                DefaultTableModel row = (DefaultTableModel) jTable1.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(saidaItemModel, saidaItemModel.getProduto().getNome_produto());
                row.addRow(new Object[]{hashDbGrid, saidaItemModel.getProduto().getConcentraçao(), saidaItemModel.getQuantidade()});


            }
        }

    }
}
