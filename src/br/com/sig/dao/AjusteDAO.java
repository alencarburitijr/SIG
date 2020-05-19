/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.AjusteEstoqueModel;
import br.com.medicalpharm.model.FornecedorModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.medicalpharm.model.UsuarioModel;
import br.com.sig.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class AjusteDAO {

    PreparedStatement pstm;
    private String validarNOta = "SELECT numNota, serieNota, fornecedor.idfornecedor FROM entrada, fornecedor WHERE"
            + "(numNota = ?) and (serieNota = ? ) and (fornecedor_idfornecedor = ?)";
    private String cadastraAjuste = "INSERT INTO ajusteestoque(dataMovimento ,serieNota ,dataEmissao ,"
            + "fornecedor_idfornecedor ,produto_idproduto ,lote ,preco ,dataVencimento ,quantidade ,"
            + "observacao,numNota,tipoMovimento, idUsuario )VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String entradaAjuste = "UPDATE produto SET produto.quantidade = ? WHERE idproduto = ?";
    private String entradaVencimento = "UPDATE TbVencimento SET quantidade = ? WHERE (lote = ?)"
            + "and (data = ?) and (codProduto = ?)";
    private String consultaLote = "SELECT  codProduto, data, lote, TbVencimento.quantidade, idVencimento FROM TbVencimento, "
            + "produto WHERE (codProduto = ?) and (lote = ?) and (data = ?) and "
            + "(TbVencimento.codProduto = produto.idproduto)";
    private String consultaQuantidade = "SELECT * FROM produto WHERE idproduto = ?";
    private String cadastroQuantidade = "UPDATE produto SET quantidade = ? WHERE idproduto = ?";

    public boolean cadastraAjuste(AjusteEstoqueModel ajuste) {
        try {

            Date emissao = null;
            if (ajuste.getDataEmissao() != null) {
                emissao = new Date(ajuste.getDataEmissao().getTime());
            }
            Date movimento = null;
            if (ajuste.getDataMovimento() != null) {
                movimento = new Date(ajuste.getDataMovimento().getTime());
            }
            Date vencimento = null;
            vencimento = new Date(ajuste.getDataVencimento().getTime());

            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(cadastraAjuste);
            pstm.setDate(1, (java.sql.Date) movimento);
            pstm.setString(2, ajuste.getnSérie());
            pstm.setDate(3, (java.sql.Date) emissao);
            pstm.setInt(4, ajuste.getFornecedor().getCod_fornecedor());
            pstm.setInt(5, ajuste.getProduto().getCod_produto());
            pstm.setString(6, ajuste.getLote());
            pstm.setDouble(7, ajuste.getPreco());
            pstm.setDate(8, (java.sql.Date) vencimento);
            pstm.setInt(9, ajuste.getQuantidade());
            pstm.setString(10, ajuste.getObservacao());
            pstm.setString(11, ajuste.getNotaFiscal());
            pstm.setString(12, ajuste.getTipoMovimento());
            pstm.setInt(13, ajuste.getUsuario().getCod_usuario());
            pstm.executeUpdate();
            pstm.close();
            conexao.desconecta();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar ajuste");
            e.printStackTrace();
            return false;
        }
    }

    public void entradaAjuste(AjusteEstoqueModel ajuste, Integer quantidadeNova) {
        try {
            Date vencimento = null;
            vencimento = new Date(ajuste.getDataVencimento().getTime());

            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(entradaVencimento);
            pstm.setInt(1, quantidadeNova);
            pstm.setString(2, ajuste.getLote());
            pstm.setDate(3, vencimento);
            pstm.setInt(4, ajuste.getProduto().getCod_produto());
            pstm.executeUpdate();
            pstm.close();
            conexao.desconecta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar quantidade");
            e.printStackTrace();

        }
    }

    public void entradaVencimento(AjusteEstoqueModel ajuste) {
        try {
            ResultSet rs;
            Integer quantidadeAtual;
            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(consultaQuantidade);
            pstm.setInt(1, ajuste.getProduto().getCod_produto());
            rs = pstm.executeQuery();
            rs.absolute(1);
            quantidadeAtual = rs.getInt("quantidade");
            Integer quantidadeNova;

            quantidadeNova = quantidadeAtual + ajuste.getQuantidade();
            conexao.desconecta();

            pstm = conexao.conecta().prepareStatement(cadastroQuantidade);
            pstm.setInt(1, quantidadeNova);
            pstm.setInt(2, ajuste.getProduto().getCod_produto());
            pstm.executeUpdate();
            pstm.close();
            conexao.desconecta();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao incrementar quantidade");
        }
    }

    public void saidaVencimento(AjusteEstoqueModel ajuste) {
        try {
            ResultSet rs;
            Integer quantidadeAtual;
            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(consultaQuantidade);
            pstm.setInt(1, ajuste.getProduto().getCod_produto());
            rs = pstm.executeQuery();
            rs.absolute(1);
            quantidadeAtual = rs.getInt("quantidade");
            Integer quantidadeNova;

            quantidadeNova = quantidadeAtual - ajuste.getQuantidade();
            conexao.desconecta();

            pstm = conexao.conecta().prepareStatement(cadastroQuantidade);
            pstm.setInt(1, quantidadeNova);
            pstm.setInt(2, ajuste.getProduto().getCod_produto());
            pstm.executeUpdate();
            pstm.close();
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao incrementar quantidade");
        }
    }

    public List<AjusteEstoqueModel> validarNota(AjusteEstoqueModel ajuste) {
        List<AjusteEstoqueModel> itens = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(validarNOta);
            pstm.setString(1, ajuste.getNotaFiscal());
            pstm.setString(2, ajuste.getnSérie());
            pstm.setInt(3, ajuste.getFornecedor().getCod_fornecedor());
            rs = pstm.executeQuery();
            rs.absolute(1);
            AjusteEstoqueModel ajus;
            while (rs.next()) {
                ajus = new AjusteEstoqueModel();
                ajus.setNotaFiscal(rs.getString("numNota"));
                ajus.setnSérie(rs.getString("serieNota"));
                ajus.setFornecedor(new FornecedorModel(rs.getInt("fornecedor.idfornecedor")));
                itens.add(ajus);
            }
            
            
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itens;
    }

    public List<AjusteEstoqueModel> consultaLote(AjusteEstoqueModel ajusteModel) {
        List<AjusteEstoqueModel> ajustes = new ArrayList();
        try {
            ResultSet rs;

            Date vencimento = null;
            if (ajusteModel.getDataVencimento() != null) {
                vencimento = new Date(ajusteModel.getDataVencimento().getTime());
            }

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaLote);
            pstm.setInt(1, ajusteModel.getProduto().getCod_produto());
            pstm.setString(2, ajusteModel.getLote());
            pstm.setDate(3, (java.sql.Date) vencimento);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            AjusteEstoqueModel ajus;
            while (rs.next()) {
                ajus = new AjusteEstoqueModel();
                ajus.setLote(rs.getString("lote"));
                ajus.setProduto(new ProdutoModel(rs.getInt("codProduto")));
                ajus.setDataVencimento(rs.getDate("data"));
                ajus.setQuantidade(rs.getInt("quantidade"));
                ajustes.add(ajus);
            }

            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ajustes;


    }
    
    private String consultaFornecedor = "SELECT ajusteestoque.idMovimento, ajusteestoque.dataVencimento, ajusteestoque.quantidade, ajusteestoque.preco, ajusteestoque.lote, ajusteestoque.dataMovimento, ajusteestoque.dataEmissao, ajusteestoque.numNota, ajusteestoque.serieNota, "
            + "ajusteestoque.tipoMovimento,fornecedor.idfornecedor, usuario.idusuario, usuario.nomeUsuario, fornecedor.razaoSocial, produto.idproduto, produto.concentracao,"
            + "produto.descProduto FROM usuario, produto, ajusteestoque, fornecedor WHERE (produto.idproduto = produto_idproduto)"
            + " AND(fornecedor.razaoSocial LIKE ?) AND ( fornecedor.idfornecedor = fornecedor_idfornecedor) AND (usuario.idusuario = ajusteestoque.idusuario)";
    
    public List<AjusteEstoqueModel> listarDescricao(String fornecedor) {
        List<AjusteEstoqueModel> ajustes = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedor);
            pstm.setString(1, fornecedor);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            AjusteEstoqueModel ajuste;
            while (rs.next()) {           
            ajuste = new AjusteEstoqueModel();
            ajuste.setIdMovimento(rs.getInt("idMovimento"));
            ajuste.setDataMovimento(rs.getDate("dataMovimento"));
            ajuste.setFornecedor(new FornecedorModel(rs.getInt("fornecedor.idfornecedor"), rs.getString("fornecedor.razaoSocial")));
            ajuste.setNotaFiscal(rs.getString("numNota"));
            ajuste.setnSérie(rs.getString("serieNota"));
            ajuste.setDataEmissao(rs.getDate("dataEmissao"));
            ajuste.setProduto(new ProdutoModel(rs.getInt("produto.idproduto"),rs.getString("produto.descProduto"), rs.getString("produto.concentracao")));
            ajuste.setLote(rs.getString("lote"));
            ajuste.setPreco(rs.getDouble("preco"));
            ajuste.setQuantidade(rs.getInt("ajusteestoque.quantidade"));
            ajuste.setDataVencimento(rs.getDate("dataVencimento"));
            ajuste.setUsuario(new UsuarioModel(rs.getInt("idUsuario"), rs.getString("nomeUsuario")));
            ajuste.setTipoMovimento(rs.getString("tipoMovimento"));
            ajustes.add(ajuste);
            }
            
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro 123");
            e.printStackTrace();
        }
        return ajustes;
    }
    
      
    private String consultaNotas = "SELECT ajusteestoque.idMovimento, ajusteestoque.dataVencimento, ajusteestoque.quantidade, ajusteestoque.preco, ajusteestoque.lote, ajusteestoque.dataMovimento, ajusteestoque.dataEmissao, ajusteestoque.numNota, ajusteestoque.serieNota, "
            + "ajusteestoque.tipoMovimento,fornecedor.idfornecedor, usuario.idusuario, usuario.nomeUsuario, fornecedor.razaoSocial, produto.idproduto, produto.concentracao,"
            + "produto.descProduto FROM usuario, produto, ajusteestoque, fornecedor WHERE (produto.idproduto = produto_idproduto)"
            + " AND(ajusteestoque.numNota = ?) AND ( fornecedor.idfornecedor = fornecedor_idfornecedor) AND (usuario.idusuario = ajusteestoque.idusuario)";
    
    public List<AjusteEstoqueModel> listarDescricao(Integer nota) {
        List<AjusteEstoqueModel> ajustes = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaNotas);
            pstm.setInt(1, nota);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            AjusteEstoqueModel ajuste;
            while (rs.next()) {           
            ajuste = new AjusteEstoqueModel();
            ajuste.setIdMovimento(rs.getInt("idMovimento"));
            ajuste.setDataMovimento(rs.getDate("dataMovimento"));
            ajuste.setFornecedor(new FornecedorModel(rs.getInt("fornecedor.idfornecedor"), rs.getString("fornecedor.razaoSocial")));
            ajuste.setNotaFiscal(rs.getString("numNota"));
            ajuste.setnSérie(rs.getString("serieNota"));
            ajuste.setDataEmissao(rs.getDate("dataEmissao"));
            ajuste.setProduto(new ProdutoModel(rs.getInt("produto.idproduto"),rs.getString("produto.descProduto"), rs.getString("produto.concentracao")));
            ajuste.setLote(rs.getString("lote"));
            ajuste.setPreco(rs.getDouble("preco"));
            ajuste.setQuantidade(rs.getInt("ajusteestoque.quantidade"));
            ajuste.setDataVencimento(rs.getDate("dataVencimento"));
            ajuste.setUsuario(new UsuarioModel(rs.getInt("idUsuario"), rs.getString("nomeUsuario")));
            ajuste.setTipoMovimento(rs.getString("tipoMovimento"));
            ajustes.add(ajuste);
            }
            
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro 123");
            e.printStackTrace();
        }
        return ajustes;
    }
}
