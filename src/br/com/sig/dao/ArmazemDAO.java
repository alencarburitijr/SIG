/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.SaidaArmazemItemModel;
import br.com.medicalpharm.model.SaidaArmazemModel;
import br.com.medicalpharm.model.ArmazemModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.sig.util.Conexao;
import com.mysql.jdbc.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class ArmazemDAO {

    private String consultaArmazem = "SELECT codMovimento, dataMovimento, motivoMovimento, destino.idDestino, "
            + "destino.descDestino, usuario_requisitor.nome,veiculo.descricao FROM saidadestino, destino,usuario_requisitor,veiculo WHERE (destino.descDestino LIKE ?) & "
            + "(destino.idDestino=destino_idDestino) & (saidadestino.idUsuario_requisitor = usuario_requisitor.codigo_requisitor) & (saidadestino.codigo_veiculo = veiculo.codigo)";
    private String consultaArmazemCodigo = "SELECT codMovimento, dataMovimento, motivoMovimento, destino.idDestino, "
            + "destino.descDestino FROM saidadestino, destino WHERE (destino.idDestino = ?) & "
            + "(destino.idDestino=destino_idDestino)";
    private String consultaItem = "SELECT saida_saidadestino,  saidadestinoitem.codProduto, produto.idproduto, produto.descProduto, "
            + "produto.concentracao,  saidadestinoitem.quantidade FROM saidadestinoitem, produto WHERE "
            + "(saida_saidadestino= ?) & ( produto.idproduto = codProduto)";
    private String consultaArmazemProduto = "SELECT produto.idproduto, produto.concentracao, produto.descProduto, "
            + "tbarmazem.quantidade FROM produto, tbarmazem where (codDestino=?) and (codProduto=?) and "
            + "(produto.idproduto=tbarmazem.codProduto) ORDER BY descProduto";
    private String cadastraArmazemItem = "INSERT INTO saidadestinoitem(saidadestinoitem.quantidade, codProduto, saida_saidadestino)VALUES(?,?,?)";
    private String cadastraArmazem = "INSERT INTO saidadestino(dataMovimento,motivoMovimento, destino_idDestino,idUsuario_requisitor,codigo_veiculo)VALUES(?,?,?,?,?)";
    PreparedStatement pstm;

    public List<SaidaArmazemModel> listaArmazem(String destino) {
        List<SaidaArmazemModel> armazens = new ArrayList();
        try {
            ResultSet rs;

            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaArmazem);
            pstm.setString(1, destino);
            rs = pstm.executeQuery();
    //        rs.absolute(1);
            SaidaArmazemModel arm;
            while (rs.next()) {
                arm = new SaidaArmazemModel();
                arm.setDestino(new ArmazemModel(rs.getInt("destino.idDestino"), rs.getString("destino.descDestino")));
                arm.setDataMovimento(rs.getDate("dataMovimento"));
                arm.setMotivo(rs.getString("motivoMovimento"));
                arm.setDescricaoVeiculo(rs.getString("descricao"));
                arm.setNomeRequisitante(rs.getString("nome"));
                arm.setIdArmazem(rs.getInt("codMovimento"));
                armazens.add(arm);
            }
            rs.close();
            pstm.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return armazens;
    }

    public List<SaidaArmazemModel> listaArmazemCodigo(String destino) {
        List<SaidaArmazemModel> armazens = new ArrayList();
        try {
            ResultSet rs;

            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(consultaArmazemCodigo);
            pstm.setString(1, destino);
            rs = pstm.executeQuery();
      //      rs.absolute(1);
            SaidaArmazemModel arm;
            while (rs.next()) {
                arm = new SaidaArmazemModel();
                arm.setDestino(new ArmazemModel(rs.getInt("destino.idDestino"), rs.getString("destino.descDestino")));
                arm.setDataMovimento(rs.getDate("dataMovimento"));
                arm.setMotivo(rs.getString("motivoMovimento"));
                arm.setIdArmazem(rs.getInt("codMovimento"));
                armazens.add(arm);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return armazens;
    }

    public List<SaidaArmazemItemModel> listarItens(Integer idEntrada) {
        List<SaidaArmazemItemModel> itens = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaItem);
            pstm.setInt(1, idEntrada);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            SaidaArmazemItemModel armazemItem;
            while (rs.next()) {
                armazemItem = new SaidaArmazemItemModel();
                armazemItem.setProduto(new ProdutoModel(rs.getInt("produto.idproduto"), rs.getString("produto.descProduto"), rs.getString("produto.concentracao")));
                armazemItem.setQuantidade(rs.getInt("quantidade"));
                itens.add(armazemItem);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itens;
    }

    public List<SaidaArmazemItemModel> listaProdutoArmazem(ArmazemModel destino, ProdutoModel produto) {
        List<SaidaArmazemItemModel> armazens = new ArrayList();
        try {

            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(consultaArmazemProduto);
            pstm.setInt(1, destino.getCod_destino());
            pstm.setInt(2, produto.getCod_produto());
            rs = pstm.executeQuery();
            SaidaArmazemItemModel arm;
            while (rs.next()) {
                arm = new SaidaArmazemItemModel();
                arm.setProduto(new ProdutoModel(rs.getInt("produto.idproduto"), rs.getString("produto.descProduto"), rs.getString("produto.concentracao")));
                arm.setQuantidade(rs.getInt("tbarmazem.quantidade"));
                armazens.add(arm);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return armazens;
    }

    public SaidaArmazemModel cadastraSaida(SaidaArmazemModel armazem) {
        try {
            Date dataSaida = null;
            if (armazem.getDataMovimento() != null) {
                dataSaida = new Date(armazem.getDataMovimento().getTime());
            }

            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(cadastraArmazem);
            pstm.setDate(1, (java.sql.Date) dataSaida);
            pstm.setString(2, armazem.getMotivo());
            pstm.setInt(3, armazem.getDestino().getCod_destino());
            pstm.setInt(4,armazem.getIdrequisitante());
            pstm.setInt(5,armazem.getCodigoVeiculo());
            pstm.executeUpdate();
            pstm.close();
            conexao.desconecta();

            Integer codMax;
            String sql = "SELECT Max(codMovimento) FROM saidadestino"; //,destino_idDestino
            Statement stm = (Statement) conexao.conecta().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = stm.executeQuery(sql);
            res.next();
            codMax = res.getInt("Max(codMovimento)");
            armazem.setIdArmazem(codMax);
            conexao.desconecta();
            res.close();

            return armazem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void armazemItem(List<SaidaArmazemItemModel> itens, SaidaArmazemModel armazem) {

        try {

            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(cadastraArmazemItem);
            for (int i = 0; i < itens.size(); i++) {
                pstm.setInt(1, itens.get(i).getQuantidade());
                pstm.setInt(2, itens.get(i).getProduto().getCod_produto());
                pstm.setInt(3, armazem.getIdArmazem());
                pstm.executeUpdate();

            }
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao retirar os itens");
        }
    }

    public void consultaQuantidade(List<SaidaArmazemItemModel> itens, SaidaArmazemModel armazem) {
        List<SaidaArmazemItemModel> itensArmazem;
        try {
            String consulta = "SELECT tbarmazem.idarmazem, produto.idproduto, produto.concentracao, produto.descProduto, tbarmazem.quantidade "
                    + "FROM produto, tbarmazem where (codDestino=?) and (codProduto=?) and "
                    + "(produto.idproduto=tbarmazem.codProduto) ORDER BY tbarmazem.vencimento ";
            Conexao conexao = new Conexao();
            for (int i = 0; i < itens.size(); i++) {
                ResultSet rs;

                SaidaArmazemItemModel armItem = new SaidaArmazemItemModel();
                armItem.setProduto(itens.get(i).getProduto());
                armItem.setQuantidade(itens.get(i).getQuantidade());

                pstm = conexao.conecta().prepareStatement(consulta);
                pstm.setInt(1, armazem.getDestino().getCod_destino());
                pstm.setInt(2, armItem.getProduto().getCod_produto());
                rs = pstm.executeQuery();

                SaidaArmazemItemModel armazemItemModel;
                itensArmazem = new ArrayList();
                while (rs.next()) {
                    armazemItemModel = new SaidaArmazemItemModel();
                    armazemItemModel.setProduto(new ProdutoModel(rs.getInt("produto.idproduto")));
                    armazemItemModel.setQuantidade(rs.getInt("tbarmazem.quantidade"));
                    armazemItemModel.setIdArmazemItem(rs.getInt("tbarmazem.idarmazem"));
                    itensArmazem.add(armazemItemModel);

                }
                darBaixa(itensArmazem, armItem);
            }
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao retirar os itens");
        }
    }

    public void darBaixa(List<SaidaArmazemItemModel> itensArmazem, SaidaArmazemItemModel armItem) {
        try {

            int i = 0;
            Integer idItem;
            Integer qtd = null;
            Integer qtdLista = null;
            while (armItem.getQuantidade() > 0) {
                qtd = armItem.getQuantidade();
                qtdLista = itensArmazem.get(i).getQuantidade();
                if (qtd > qtdLista) {

                    qtd = qtd - qtdLista;
                    qtdLista = 0;
                    idItem = itensArmazem.get(i).getIdArmazemItem();
                    itensArmazem.get(i).setQuantidade(qtdLista);
                    armItem.setQuantidade(qtd);
                    //JOptionPane.showMessageDialog(null,idVencimento);
                    salvarBaixa1(qtdLista, idItem);

                    i++;
                } else {

                    qtdLista = qtdLista - qtd;
                    qtd = 0;
                    idItem = itensArmazem.get(i).getIdArmazemItem();
                    itensArmazem.get(i).setQuantidade(qtdLista);
                    armItem.setQuantidade(qtd);
                    //JOptionPane.showMessageDialog(null,idVencimento);
                    salvarBaixa1(qtdLista, idItem);
                    i++;

                }
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problema com baixa por armazem");
        }
    }

    public void salvarBaixa1(Integer qtdLista, Integer idItem) {
        try {

            Conexao conexao = new Conexao();
            String baixa = "UPDATE tbarmazem SET tbarmazem.quantidade = ? WHERE idarmazem = ?";
            //JOptionPane.showMessageDialog(null,qtdLista+" "+ idVencimento);

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(baixa);
            pstm.setInt(1, qtdLista);
            pstm.setInt(2, idItem);
            pstm.executeUpdate();
            pstm.close();


        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
            erro.printStackTrace();

        }
    }
}
