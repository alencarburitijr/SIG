package br.com.sig.dao;

import br.com.medicalpharm.model.EntradaItemModel;
import br.com.medicalpharm.model.EntradaModel;
import br.com.medicalpharm.model.FornecedorModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.sig.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class EntradaDAO {

    public FornecedorModel fornecedor;
    PreparedStatement pstm;
    //ResultSet rs;
    private String cadastraEntrada = "INSERT INTO entrada(dataLancamento, dataEmissaoNota, numNota, serieNota,"
            + "fornecedor_idfornecedor)VALUES(?,?,?,?,?)";
    private String cadastraItem = "INSERT INTO itemnota(preco ,lote, itemnota.vencimento, produto_idproduto, entrada_identrada, itemnota.quantidade)VALUES(?,?,?,?,?,?)";
    private String entradaVencimento = "INSERT INTO TbVencimento(lote,data,codProduto,quantidade)VALUES(?,?,?,?)";
    private String cadastroQuantidade = "UPDATE produto SET quantidade = ?, ultimoPreço = ? WHERE idproduto = ?";
    private String consultaQuantidade = "SELECT * FROM produto WHERE idproduto = ?";
    private String alteraUnidade = "UPDATE unidademedida SET siglaUnidade = ?, descUnidade = ? WHERE idunidadeMedida = ?";
    private String consultaEntrada = "SELECT identrada, dataLancamento, dataEmissaoNota, numNota, "
            + "fornecedor.idfornecedor,razaoSocial FROM entrada,fornecedor where (fonecedor_idfornecedor LIKE ?)";
    //private String consultaEntradaNota = "SELECT identrada, dataLancamento, dataEmissaoNota, numNota, serieNota, "
    //       + " FROM entrada WHERE (numNota LIKE ?)";
    private String consultaEntradaNota = "SELECT identrada, dataLancamento, dataEmissaoNota, numNota, serieNota, "
            + "fornecedor.idfornecedor, fornecedor.razaoSocial FROM entrada, fornecedor WHERE (numNota = ?) & "
            + "(fornecedor.idfornecedor = fornecedor_idfornecedor )";
    private String consultaFornecedor = "SELECT identrada, dataLancamento, dataEmissaoNota, numNota, serieNota, "
            + "fornecedor.idfornecedor, fornecedor.razaoSocial FROM entrada, fornecedor WHERE (fornecedor.razaoSocial "
            + "LIKE ?) & ( fornecedor.idfornecedor = fornecedor_idfornecedor )";
    private String consultaItem = "SELECT idItem, preco, lote, vencimento, produto.idproduto, produto.descProduto, "
            + "produto.concentracao, entrada_identrada, itemnota.quantidade FROM itemnota, produto WHERE ( entrada_identrada = ?) & "
            + "( produto.idproduto = produto_idproduto ) ORDER BY idItem";
    private String validarNOta = "SELECT numNota, serieNota, fornecedor.idfornecedor FROM entrada, fornecedor WHERE"
            + "(numNota = ?) and (serieNota = ? ) and (fornecedor_idfornecedor = ?)";
    private String consultaLote = "SELECT  codProduto, data, lote, TbVencimento.quantidade, idVencimento FROM TbVencimento, "
            + "produto WHERE (codProduto = ?) and (lote = ?) and (data = ?) and "
            + "(TbVencimento.codProduto = produto.idproduto)";
    private String updateLote = "UPDATE TbVencimento SET quantidade = ? WHERE idVencimento = ?";

    public EntradaModel cadastraEntrada(EntradaModel entrada) {
        try {

            Date emissao = null;
            if (entrada.getEmissao() != null) {
                emissao = new Date(entrada.getEmissao().getTime());
            }
            Date lancamento = null;
            if (entrada.getLancamento() != null) {
                lancamento = new Date(entrada.getLancamento().getTime());
            }


            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(cadastraEntrada);
            pstm.setDate(1, (java.sql.Date) lancamento);
            pstm.setDate(2, (java.sql.Date) emissao);
            pstm.setString(3, entrada.getNotaFiscal());
            pstm.setString(4, entrada.getnSérie());
            pstm.setInt(5, entrada.getFornecedor().getCod_fornecedor());
            pstm.executeUpdate();
            ResultSet res;
            Integer codMax;
            String sql = "SELECT Max(identrada) FROM entrada";
            Statement stm = (Statement) conexao.conecta().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = stm.executeQuery(sql);
            res.next();
            codMax = res.getInt("Max(identrada)");
            entrada.setIdEntrada(codMax);
            conexao.desconecta();
            res.close();
            return entrada;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar nota");
            e.printStackTrace();
            return null;
        }
    }

    public void cadastraItem(List<EntradaItemModel> itens, EntradaModel entrada) {

        try {
            Conexao conexao = new Conexao();
            for (int i = 0; i < itens.size(); i++) {
                pstm = conexao.conecta().prepareStatement(cadastraItem);

                Date vencimento = null;
                if (itens.get(i).getVencimento() != null) {
                    vencimento = new Date(itens.get(i).getVencimento().getTime());
                }

                pstm.setDouble(1, itens.get(i).getPreco());
                pstm.setString(2, itens.get(i).getLote());
                pstm.setDate(3, (java.sql.Date) vencimento);
                pstm.setInt(4, itens.get(i).getProduto().getCod_produto());
                pstm.setInt(5, entrada.getIdEntrada());
                pstm.setInt(6, itens.get(i).getQnt());
                pstm.executeUpdate();


            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao adicionar os itens");
        }
    }

    public void entradaVencimento(List<EntradaItemModel> itens) {

        try {
            Conexao conexao = new Conexao();
            for (int i = 0; i < itens.size(); i++) {
                //ResultSet rs;
                Date vencimento = null;
                if (itens.get(i).getVencimento() != null) {
                    vencimento = new Date(itens.get(i).getVencimento().getTime());
                }

                EntradaItemModel entradaItem = new EntradaItemModel();
                entradaItem.setLote(itens.get(i).getLote());
                entradaItem.setVencimento(vencimento);
                entradaItem.setProduto(new ProdutoModel(itens.get(i).getProduto().getCod_produto()));
                entradaItem.setQnt(itens.get(i).getQnt());

                if (consultaLote(entradaItem)) {
                    pstm = conexao.conecta().prepareStatement(entradaVencimento);
                    pstm.setString(1, itens.get(i).getLote());
                    pstm.setDate(2, (java.sql.Date) vencimento);
                    pstm.setInt(3, itens.get(i).getProduto().getCod_produto());
                    pstm.setInt(4, itens.get(i).getQnt());
                    pstm.executeUpdate();
                } else {
                    updateLote(entradaItem);
                }

            }
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Erro ao adicionar os itens da Tabela Vencimento");
        }
    }

    public void updateLote(EntradaItemModel entradaItem) {
        try {
            ResultSet rs;
            Integer quantidadeAtual;
            Conexao conexao = new Conexao();

            pstm = conexao.conecta().prepareStatement(consultaLote);
            pstm.setInt(1, entradaItem.getProduto().getCod_produto());
            pstm.setString(2, entradaItem.getLote());
            pstm.setDate(3, (java.sql.Date) entradaItem.getVencimento());
            rs = pstm.executeQuery();
            rs.absolute(1);

            quantidadeAtual = rs.getInt("quantidade");

            Integer idVencimento = rs.getInt("idVencimento");
            Integer quantidadeNova;
            quantidadeNova = quantidadeAtual + entradaItem.getQnt();

            conexao.desconecta();


            pstm = conexao.conecta().prepareStatement(updateLote);
            pstm.setInt(1, quantidadeNova);
            pstm.setInt(2, idVencimento);
            pstm.executeUpdate();
            conexao.desconecta();
            rs.close();

        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    public boolean consultaLote(EntradaItemModel entradaItem) {
        List<EntradaItemModel> entradas = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaLote);
            pstm.setInt(1, entradaItem.getProduto().getCod_produto());
            pstm.setString(2, entradaItem.getLote());
            pstm.setDate(3, (java.sql.Date) entradaItem.getVencimento());
            rs = pstm.executeQuery();
            //rs.absolute(1);
            EntradaItemModel ent;
            while (rs.next()) {
                ent = new EntradaItemModel();
                ent.setLote(rs.getString("lote"));
                ent.setProduto(new ProdutoModel(rs.getInt("codProduto")));
                ent.setVencimento(rs.getDate("data"));
                entradas.add(ent);
            }

            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (entradas.size() == 0) {
            return true;
        } else {
            return false;

        }


    }

    public void consultaQuantidade(List<EntradaItemModel> itens, EntradaModel entrada) {

        try {
            Conexao conexao = new Conexao();

            for (int i = 0; i < itens.size(); i++) {
                ResultSet rs;
                Integer quantidadeAtual;

                pstm = conexao.conecta().prepareStatement(consultaQuantidade);
                pstm.setInt(1, itens.get(i).getProduto().getCod_produto());
                rs = pstm.executeQuery();
                rs.absolute(1);
                quantidadeAtual = rs.getInt("quantidade");
                Integer quantidadeNova;

                quantidadeNova = quantidadeAtual + itens.get(i).getQnt();
                conexao.desconecta();

                pstm = conexao.conecta().prepareStatement(cadastroQuantidade);
                pstm.setInt(1, quantidadeNova);
                pstm.setDouble(2, itens.get(i).getPreco());
                pstm.setInt(3, itens.get(i).getProduto().getCod_produto());
                pstm.executeUpdate();
                pstm.close();
                conexao.desconecta();

            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao incrementar quantidade");
        }

    }

    public List<EntradaModel> listaEntradaNota(Integer nota) {
        List<EntradaModel> entradas = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaEntradaNota);
            pstm.setInt(1, nota);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            EntradaModel ent;
            while (rs.next()) {
                ent = new EntradaModel();
                ent.setIdEntrada(rs.getInt("identrada"));
                ent.setLancamento(rs.getDate("dataLancamento"));
                ent.setEmissao(rs.getDate("dataEmissaoNota"));
                ent.setNotaFiscal(rs.getString("numNota"));
                ent.setnSérie(rs.getString("serieNota"));
                ent.setFornecedor(new FornecedorModel(rs.getInt("fornecedor.idfornecedor"), rs.getString("fornecedor.razaoSocial")));
                entradas.add(ent);
            }
            //rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entradas;
    }

    public List<EntradaModel> listarFornecedor(String fornecedor) {
        List<EntradaModel> entradas = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedor);
            pstm.setString(1, fornecedor);
            rs = pstm.executeQuery();
            rs.absolute(1);
            EntradaModel ent;
            while (rs.next()) {
                ent = new EntradaModel();
                ent.setIdEntrada(rs.getInt("identrada"));
                ent.setLancamento(rs.getDate("dataLancamento"));
                ent.setEmissao(rs.getDate("dataEmissaoNota"));
                ent.setNotaFiscal(rs.getString("numNota"));
                ent.setnSérie(rs.getString("serieNota"));
                ent.setFornecedor(new FornecedorModel(rs.getInt("fornecedor.idfornecedor"), rs.getString("fornecedor.razaoSocial")));
                entradas.add(ent);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entradas;
    }

    public List<EntradaModel> listarDescricao(String fornecedor) {
        List<EntradaModel> entradas = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedor);
            pstm.setString(1, fornecedor);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            EntradaModel ent;
            while (rs.next()) {
                ent = new EntradaModel();
                ent.setIdEntrada(rs.getInt("identrada"));
                ent.setLancamento(rs.getDate("dataLancamento"));
                ent.setEmissao(rs.getDate("dataEmissaoNota"));
                ent.setNotaFiscal(rs.getString("numNota"));
                ent.setnSérie(rs.getString("serieNota"));
                ent.setFornecedor(new FornecedorModel(rs.getInt("fornecedor.idfornecedor"), rs.getString("fornecedor.razaoSocial")));
                entradas.add(ent);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entradas;
    }

    public List<EntradaItemModel> listarItens(Integer idEntrada) {
        List<EntradaItemModel> itens = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaItem);
            pstm.setInt(1, idEntrada);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            EntradaItemModel entItem;
            while (rs.next()) {
                entItem = new EntradaItemModel();
                entItem.setIdEntrada(rs.getInt("idItem"));
                entItem.setPreco(rs.getDouble("preco"));
                entItem.setLote(rs.getString("lote"));
                entItem.setVencimento(rs.getDate("vencimento"));
                entItem.setQnt(rs.getInt("itemnota.quantidade"));
                entItem.setProduto(new ProdutoModel(rs.getInt("produto.idproduto"), rs.getString("produto.descproduto"), rs.getString("produto.concentracao")));
                itens.add(entItem);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itens;
    }

    public List<EntradaModel> validarNota(EntradaModel entrada) {
        List<EntradaModel> itens = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(validarNOta);
            pstm.setString(1, entrada.getNotaFiscal());
            pstm.setString(2, entrada.getnSérie());
            pstm.setInt(3, entrada.getFornecedor().getCod_fornecedor());
            rs = pstm.executeQuery();
            //rs.absolute(1);
            EntradaModel entradaModel;
            while (rs.next()) {
                entradaModel = new EntradaModel();
                entradaModel.setNotaFiscal(rs.getString("numNota"));
                entradaModel.setnSérie(rs.getString("serieNota"));
                entradaModel.setFornecedor(new FornecedorModel(rs.getInt("fornecedor.idfornecedor")));
                itens.add(entradaModel);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itens;
    }
}
