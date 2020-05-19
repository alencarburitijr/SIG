/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.ArmazemModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.medicalpharm.model.SaidaItemModel;
import br.com.medicalpharm.model.SaidaModel;
import br.com.sig.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class SaidaDAO {

    PreparedStatement pstm;
    private String cadastraSaida = "INSERT INTO saida(dataRetirada, destino_iddestino)VALUES(?,?)";
    
    private String cadastraArmazem = "INSERT INTO tbarmazem(codDestino,codProduto,tbarmazem.quantidade,tbarmazem.vencimento)VALUES(?,?,?,?)";
    
    private String cadastraSaidaItem = "INSERT INTO saidaitem(quantidade, produto_idproduto, saida_idsaida)VALUES(?,?,?)";
    //private String consultaEstoque = "SELECT * FROM `estoque` WHERE `produto_idproduto` = 10 AND `quantidade`<> 0 ORDER BY `vencimento`";
    private String consultaQuantidade = "SELECT * FROM produto WHERE idproduto = ?";
    private String cadastroQuantidade = "UPDATE produto SET quantidade = ? WHERE idproduto = ?";
    private String consultaDestino = "SELECT idsaida, dataRetirada, destino.idDestino, destino.descDestino FROM "
            + "saida, destino  WHERE (destino.descDestino LIKE ?) & (destino.idDestino=destino_idDestino) ";
//        private String consultaDestinoDescricao = "SELECT idsaida, dataRetirada, destino.idDestino, destino.descDestino FROM "
//                + "saida, destino WHERE (destino.descDestino LIKE ?) & (destino.idDestino=destino_idDestino)";
    private String consultaDestinoCodigo = "SELECT idsaida, dataRetirada, destino.idDestino, destino.descDestino "
            + "FROM saida, destino WHERE (idsaida = ?) & (destino.idDestino = destino_idDestino)";
    private String consultaItem = "SELECT idsaidaItem,  produto.idproduto, produto.descProduto, produto.concentracao,"
            + " saida_idsaida, saidaitem.quantidade FROM saidaitem, produto WHERE (saida_idsaida = ?) & ( produto.idproduto = produto_idproduto )";

    public SaidaModel cadastraSaida(SaidaModel saida) {
        try {
            Date dataSaida = null;
            if (saida.getDataSaida() != null) {
                dataSaida = new Date(saida.getDataSaida().getTime());
            }

            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(cadastraSaida);
            pstm.setDate(1, (java.sql.Date) dataSaida);
            pstm.setInt(2, saida.getDestino().getCod_destino());           
            pstm.executeUpdate();
            pstm.close();
            conexao.desconecta();

            Integer codMax;
            String sql = "SELECT Max(idsaida) FROM saida"; //,destino_idDestino
            Statement stm = (Statement) conexao.conecta().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = stm.executeQuery(sql);
            res.next();
            codMax = res.getInt("Max(idsaida)");
            saida.setIdsaida(codMax);
            conexao.desconecta();
            res.close();

//            String sql1 ="SELECT destino_idDestino FROM saida WHERE (idsaida = ?)";
//            Conexao conexao1 = new Conexao();
//            pstm = conexao1.conecta().prepareStatement(sql1);
//            pstm.setInt(1, codMax);
//            ResultSet rs = pstm.executeQuery();
//            saida.setDestino(new ArmazemModel(rs.getInt("destino_idDestino")));
//            conexao.desconecta();
//            rs.close();

            return saida;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void baixarEstoque(List<SaidaItemModel> itens) {

        try {

            for (int i = 0; i < itens.size(); i++) {
                Conexao conexao = new Conexao();
                ResultSet rs;
                Integer quantidadeAtual;

                pstm = conexao.conecta().prepareStatement(consultaQuantidade);
                pstm.setInt(1, itens.get(i).getProduto().getCod_produto());
                rs = pstm.executeQuery();
                rs.absolute(1);
                quantidadeAtual = rs.getInt("quantidade");
                Integer quantidadeBaixada;

                quantidadeBaixada = quantidadeAtual - itens.get(i).getQuantidade();

                pstm = conexao.conecta().prepareStatement(cadastroQuantidade);
                pstm.setInt(1, quantidadeBaixada);
                pstm.setInt(2, itens.get(i).getProduto().getCod_produto());
                pstm.executeUpdate();
                pstm.close();
                conexao.desconecta();
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao retirar quantidade do estoque");
        }

    }

    public void saidaItem(List<SaidaItemModel> itens, SaidaModel saida) {

        try {
            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(cadastraSaidaItem);
            for (int i = 0; i < itens.size(); i++) {
                pstm.setInt(1, itens.get(i).getQuantidade());
                pstm.setInt(2, itens.get(i).getProduto().getCod_produto());
                pstm.setInt(3, saida.getIdsaida());
                pstm.executeUpdate();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao retirar os itens");
        }
    }

    public void implementaArmazem(List<SaidaItemModel> itens, SaidaModel saida) {

        try {
            Conexao conexao = new Conexao();
            pstm = conexao.conecta().prepareStatement(cadastraArmazem);
            for (int i = 0; i < itens.size(); i++) {
                pstm.setInt(1, saida.getDestino().getCod_destino());
                pstm.setInt(2, itens.get(i).getProduto().getCod_produto());
                pstm.setInt(3, itens.get(i).getQuantidade());
                pstm.executeUpdate();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inserir itens na tabela Armazem");
        }
    }

    public List<SaidaModel> listarDestinoCodigo(String destino) {
        List<SaidaModel> saidas = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaDestinoCodigo);
            pstm.setString(1, destino);
            rs = pstm.executeQuery();
          //  rs.absolute(1);
            SaidaModel sai;
            while (rs.next()) {
                sai = new SaidaModel();
                sai.setDestino(new ArmazemModel(rs.getInt("destino.idDestino"), rs.getString("destino.descDestino")));
                sai.setDataSaida(rs.getDate("dataRetirada"));
                sai.setIdsaida(rs.getInt("idSaida"));
                saidas.add(sai);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saidas;
    }

    public List<SaidaModel> ListarDestinoDescricao(String destino) {
        List<SaidaModel> saidas = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaDestino);
            pstm.setString(1, destino);
            rs = pstm.executeQuery();
           // rs.absolute(1);
            SaidaModel sai;
            while (rs.next()) {
                sai = new SaidaModel();
                sai.setDestino(new ArmazemModel(rs.getInt("destino.idDestino"), rs.getString("destino.descDestino")));
                sai.setDataSaida(rs.getDate("dataRetirada"));
                sai.setIdsaida(rs.getInt("idSaida"));
                saidas.add(sai);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saidas;
    }

    public List<SaidaModel> listaDestino(String destino) {
        List<SaidaModel> saidas = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaDestino);
            pstm.setString(1, destino);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            SaidaModel sai;
            while (rs.next()) {
                sai = new SaidaModel();
                sai.setDestino(new ArmazemModel(rs.getInt("destino.idDestino"), rs.getString("destino.descDestino")));
                sai.setDataSaida(rs.getDate("dataRetirada"));
                sai.setIdsaida(rs.getInt("idSaida"));                
                saidas.add(sai);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saidas;
    }

    public List<SaidaItemModel> listarItens(Integer idEntrada) {
        List<SaidaItemModel> itens = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaItem);
            pstm.setInt(1, idEntrada);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            SaidaItemModel saidaItem;
            while (rs.next()) {
                saidaItem = new SaidaItemModel();
                saidaItem.setProduto(new ProdutoModel(rs.getInt("produto.idproduto"), rs.getString("produto.descProduto"), rs.getString("produto.concentracao")));
                saidaItem.setQuantidade(rs.getInt("quantidade"));
                itens.add(saidaItem);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itens;
    }

    public void consultaQuantidade(List<SaidaItemModel> itens, SaidaModel destino) {
        List<SaidaItemModel> itensVencimento;
        try {
            String consulta = "SELECT * FROM TbVencimento, produto WHERE (codProduto = ?) and (TbVencimento.codProduto = produto.idproduto) and (TbVencimento.quantidade<>0) ORDER BY data";
            Conexao conexao = new Conexao();
            for (int i = 0; i < itens.size(); i++) {
                SaidaItemModel saida = null;
                ResultSet rs;
                saida = new SaidaItemModel();
                saida.setLote(itens.get(i).getLote());
                saida.setProduto(itens.get(i).getProduto());
                //JOptionPane.showMessageDialog(null, saida.getProduto().getCod_produto()+"  "+i);
                saida.setQuantidade(itens.get(i).getQuantidade());
                saida.setVencimento(itens.get(i).getVencimento());
                if (saida != null) {

                    pstm = conexao.conecta().prepareStatement(consulta);
                    pstm.setInt(1, itens.get(i).getProduto().getCod_produto());
                    rs = pstm.executeQuery();
                    // rs.absolute(1);

                    SaidaItemModel vencimentoModel = null;
                    itensVencimento = new ArrayList<SaidaItemModel>();;

                    while (rs.next()) {
                        vencimentoModel = new SaidaItemModel();
                        vencimentoModel.setLote(rs.getString("lote"));
                        vencimentoModel.setVencimento(rs.getDate("data"));
                        vencimentoModel.setQuantidade(rs.getInt("TbVencimento.quantidade"));
                        vencimentoModel.setProduto(new ProdutoModel(rs.getInt("produto.idproduto")));
                        vencimentoModel.setCodSaida(rs.getInt("idVencimento"));
                        itensVencimento.add(vencimentoModel);
                    }
                    rs.close();

                    // JOptionPane.showMessageDialog(null, "Cod: "+vencimentoModel.getCodSaida());
                    conexao.desconecta();
                    darBaixa(saida, itensVencimento,destino);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao retirar os itens");
        }
    }

    public void darBaixa(SaidaItemModel saida, List<SaidaItemModel> itensVencimento, SaidaModel destino) {
        try {

            int i = 0;
            Integer idVencimento;
            Integer qtd;
            Integer qtdLista;
            while (saida.getQuantidade() > 0) {
                qtd = saida.getQuantidade();
                qtdLista = itensVencimento.get(i).getQuantidade();

                idVencimento = itensVencimento.get(i).getCodSaida();
                if (qtd > qtdLista) {
                    //  JOptionPane.showMessageDialog(null, itensVencimento.get(i).getCodSaida());
                    qtd = qtd - qtdLista;
                    Conexao conexao = new Conexao();
                    pstm = conexao.conecta().prepareStatement(cadastraArmazem);

                    pstm.setInt(1, destino.getDestino().getCod_destino());
                    pstm.setInt(2, saida.getProduto().getCod_produto());
                    pstm.setInt(3, itensVencimento.get(i).getQuantidade());
                    
                    pstm.setDate(4,(java.sql.Date) itensVencimento.get(i).getVencimento());
                    pstm.executeUpdate();
                    
                    qtdLista = 0;
                    //idVencimento = itensVencimento.get(i).getCodSaida();
                    itensVencimento.get(i).setQuantidade(qtdLista);
                    saida.setQuantidade(qtd);

                    
                    
                    salvarBaixa1(qtdLista, idVencimento);

                    i++;
                } else {

                    qtdLista = qtdLista - qtd;
                    Conexao conexao = new Conexao();
                    pstm = conexao.conecta().prepareStatement(cadastraArmazem);

                    pstm.setInt(1, destino.getDestino().getCod_destino());
                    pstm.setInt(2, saida.getProduto().getCod_produto());
                    pstm.setInt(3, qtd);
                    
                    pstm.setDate(4,(java.sql.Date) itensVencimento.get(i).getVencimento());
                    pstm.executeUpdate();
                    
                    qtd = 0;
                    //  JOptionPane.showMessageDialog(null, itensVencimento.get(i).getCodSaida());
                    //idVencimento = itensVencimento.get(i).getCodSaida();
                    itensVencimento.get(i).setQuantidade(qtdLista);
                    saida.setQuantidade(qtd);
                    //JOptionPane.showMessageDialog(null,idVencimento);
                    salvarBaixa1(qtdLista, idVencimento);
                    i++;

                }
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problema com baixa por vencimento");
        }
    }

    public void salvarBaixa1(Integer qtdLista, Integer idVencimento) {
        try {

            Conexao conexao = new Conexao();
            String baixa = "UPDATE TbVencimento SET TbVencimento.quantidade = ? WHERE idVencimento = ?";
            //JOptionPane.showMessageDialog(null,qtdLista+" "+ idVencimento);
            //JOptionPane.showMessageDialog(null, itens.get(i).getProduto().getCod_produto());
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(baixa);
            //JOptionPane.showMessageDialog(null, "Quant: "+ qtdLista+"     Codigo "+idVencimento);
            pstm.setInt(1, qtdLista);
            pstm.setInt(2, idVencimento);
            pstm.executeUpdate();
            conexao.desconecta();


        } catch (Exception erro) {
            erro.printStackTrace();

        }
    }

//    public void limparTabela() {
//        try {
//
//            Conexao conexao = new Conexao();
//            String limpar = "TRUNCATE TABLE relatoriovencimento";
//            //JOptionPane.showMessageDialog(null,qtdLista+" "+ idVencimento);
//
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(limpar);
//            pstm.executeUpdate();
//        } catch (Exception erro) {
//            erro.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Erro ao limpar tabela");
//
//        }
//    }
    private String consultaLote = "SELECT * FROM `tbvencimento` WHERE (codProduto = ?)AND (tbvencimento.quantidade >0) ";
       public List<SaidaItemModel> listarLote(ProdutoModel produto) {
        List<SaidaItemModel> itens = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaLote);
            pstm.setInt(1, produto.getCod_produto());
            rs = pstm.executeQuery();
            //rs.absolute(1);
            SaidaItemModel saidaItem;
            while (rs.next()) {
                saidaItem = new SaidaItemModel();
                saidaItem.setLote(rs.getString("lote"));
                saidaItem.setVencimento(rs.getDate("data"));
                saidaItem.setQuantidade(rs.getInt("quantidade"));
                itens.add(saidaItem);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itens;
    }

}
