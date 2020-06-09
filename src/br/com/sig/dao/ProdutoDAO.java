/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.ArmazemModel;
import br.com.medicalpharm.model.GrupoModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.medicalpharm.model.SubGrupoModel;
import br.com.medicalpharm.model.UnidadeModel;
import br.com.sig.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    public GrupoModel grupo;
    public UnidadeModel unidade;
    java.sql.PreparedStatement pstm;
    ResultSet rs;
    private String cadastraProduto = "INSERT INTO produto (descProduto, concentracao, estMinimo,estIdeal,"
            + "unidadeMedida_idunidadeMedida,grupo_idgrupo,quantidade,id_SubGrupo,locacao)VALUES(?,?,?,?,?,?,?,?,?)";
    
    private String estoqueIdeal = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo,"
            + " produto.quantidade, grupo.descGrupo FROM produto, grupo WHERE (estIdeal>quantidade) && "
            + "(grupo.idgrupo = grupo_idgrupo) ORDER BY produto.descProduto";
    private String estoqueMínimo = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo,"
            + " produto.quantidade, grupo.descGrupo FROM produto, grupo WHERE (estminimo>quantidade) && "
            + "(grupo.idgrupo = grupo_idgrupo) ORDER BY produto.descProduto";
    private String consulta = "SELECT idproduto,  ultimoPreço, concentracao, descProduto, estminimo, estideal, produto.quantidade,"
            + "grupo.idgrupo, grupo.descGrupo, unidademedida.idunidademedida, unidademedida.siglaunidade, "
            + "unidademedida.descunidade  FROM PRODUTO,grupo,unidademedida where "
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida) ORDER BY descProduto";
    private String consultaArmazem = "SELECT idproduto, produto.concentracao, produto.descProduto, tbarmazem.quantidade "
            + "FROM produto, tbarmazem where(produto.idproduto=tbarmazem.codProduto) and (codDestino=?) ORDER BY descProduto";
    private String consultaProduto1 = "SELECT idproduto, concentracao, descProduto,  estminimo, estideal,quantidade, "
            + "grupo.idgrupo, grupo.descGrupo, unidademedida.idunidademedida,  unidademedida.siglaunidade,"
            + "unidademedida.descunidade, ultimoPreço, subgrupo.idSubGrupo, subgrupo.subDescricao,locacao  FROM PRODUTO,grupo,unidademedida, subgrupo where (descProduto LIKE ?)  & "
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida) & (subgrupo.idSubGrupo=id_SubGrupo) ORDER BY descProduto";
    private String consultaProdutoComercial = "SELECT idproduto, concentracao, descProduto,  estminimo, estideal,quantidade, "
            + "grupo.idgrupo, grupo.descGrupo, unidademedida.idunidademedida,  unidademedida.siglaunidade,"
            + "unidademedida.descunidade, ultimoPreço, subgrupo.idSubGrupo, subgrupo.subDescricao,locacao  FROM PRODUTO,grupo,unidademedida, subgrupo where (concentracao LIKE ?) & "
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida) & (subgrupo.idSubGrupo=id_SubGrupo) ORDER BY descProduto";
    
    private String consultaProd = "SELECT idproduto, concentracao, descProduto,  estminimo, estideal,quantidade, grupo.idgrupo, "
            + "grupo.descGrupo, unidademedida.idunidademedida,  unidademedida.siglaunidade, unidademedida.descunidade  "
            + "FROM produto,grupo,unidademedida where (descProduto LIKE ?) & "
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida) ORDER BY descProduto";
    private String consultaProd1 = "SELECT idproduto, concentracao, descProduto,  estminimo, estideal,quantidade, grupo.idgrupo, "
            + "grupo.descGrupo, unidademedida.idunidademedida,  unidademedida.siglaunidade, unidademedida.descunidade  "
            + "FROM produto,grupo,unidademedida where (concentracao LIKE ?) & "
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida) ORDER BY descProduto";
    
    
    private String listar = "SELECT descProduto, idproduto, concentracao, siglaUnidade, SUM(quantidade) FROM `warmazem` WHERE (idDestino = ?) GROUP BY descProduto, concentracao";
    
    private String consultaProduto = "SELECT idproduto, concentracao, descProduto,  estminimo, estideal,quantidade, "
            + "grupo.idgrupo, grupo.descGrupo, unidademedida.idunidademedida,  unidademedida.siglaunidade,"
            + "unidademedida.descunidade  FROM PRODUTO,grupo,unidademedida where (descProduto = ?) OR (concentracao = ?) &"
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida)";
    private String consultaProduto2 = "SELECT idproduto, concentracao, descProduto,  estminimo, estideal,quantidade, "
            + "grupo.idgrupo, grupo.descGrupo, unidademedida.idunidademedida,  unidademedida.siglaunidade,"
            + "unidademedida.descunidade, ultimoPreço,  subgrupo.idSubGrupo, subgrupo.subDescricao FROM PRODUTO,grupo,unidademedida, subgrupo where (descProduto LIKE ?) OR (concentracao = ?) & "
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida) & (subgrupo.idSubGrupo=id_SubGrupo) ";
    //private String consultaProdutoDescricao = "SELECT * FROM produto WHERE descProduto LIKE ?";
    private String consultaProdutoCodigo = "SELECT idproduto,  concentracao, descProduto, estminimo, estideal, quantidade,"
            + "grupo.idgrupo, grupo.descGrupo, unidademedida.idunidademedida, unidademedida.siglaunidade, "
            + "unidademedida.descunidade, ultimoPreço,  subgrupo.idSubGrupo, subgrupo.subDescricao   FROM PRODUTO,grupo,unidademedida,subgrupo where (idproduto=?) & "
            + "(grupo.idgrupo=grupo_idgrupo) & (unidademedida.idunidademedida=unidademedida_idunidademedida) & (subgrupo.idSubGrupo=id_SubGrupo) ";
    private String alteraProduto = "UPDATE produto SET descProduto = ?, concentracao = ?, estMinimo = ?, estIdeal = ?, grupo_idgrupo = ?, unidadeMedida_idunidadeMedida = ?, id_SubGrupo = ? WHERE idproduto = ?";
    private String excluiProduto = "DELETE FROM produto WHERE idproduto = ?";
    
    private String updateQuantidade = "UPDATE `produto` SET `quantidade`=`quantidade`? ? WHERE idproduto = ?";

    public void cadastraProduto(ProdutoModel produto) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraProduto);
            pstm.setString(1, produto.getNome_produto());
            pstm.setString(2, produto.getConcentraçao());
            pstm.setInt(3, produto.getEstoque_minimo());
            pstm.setInt(4, produto.getEstoque_ideal());
            pstm.setInt(5, produto.getUnidade().getCod_unidade());
            pstm.setInt(6, produto.getGrupo().getCod_grupo());
            pstm.setInt(7, (0));
            pstm.setInt(8, produto.getSubGrupo().getIdSubGrupo());
            pstm.setString(9,produto.getLocacao());

            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");
        }
    }

    public void alterarProduto(ProdutoModel produto) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraProduto);
            pstm.setString(1, produto.getNome_produto());
            pstm.setString(2, produto.getConcentraçao());
            pstm.setInt(3, produto.getEstoque_minimo());
            pstm.setInt(4, produto.getEstoque_ideal());
            pstm.setInt(5, produto.getGrupo().getCod_grupo());
            pstm.setInt(6, produto.getUnidade().getCod_unidade());
            pstm.setInt(7, produto.getSubGrupo().getIdSubGrupo());
            pstm.setInt(8, produto.getCod_produto());
            
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            //JOptionPane.showMessageDialog(null,"Não foi possivel alterar\nERRO: "+erro.getMessage());
            erro.printStackTrace();
        }
    }

    public boolean excluirProduto(ProdutoModel produto) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiProduto);
            pstm.setInt(1, produto.getCod_produto());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }
    }

    public List<ProdutoModel> listarProduto(String nome_produto) {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaProduto1);
            pstm.setString(1, nome_produto);
            //pstm.setString(2, nome_produto);

            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setEstoque_ideal(rs.getInt("estIdeal"));
                prod.setEstoque_minimo(rs.getInt("estMinimo"));
                prod.setUltimo_preco(rs.getDouble("ultimoPreço"));
                prod.setEstoque(rs.getInt("quantidade")); 
                prod.setSubGrupo(new SubGrupoModel(rs.getInt("subgrupo.idSubGrupo"),rs.getString("subgrupo.subDescricao")));
                prod.setNome_produto(rs.getString("descProduto"));
                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                prod.setLocacao(rs.getString("locacao"));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
public List<ProdutoModel> listarProdutoComercial(String nome_produto) {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaProdutoComercial);
            pstm.setString(1, nome_produto);


            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setEstoque_ideal(rs.getInt("estIdeal"));
                prod.setEstoque_minimo(rs.getInt("estMinimo"));
                prod.setUltimo_preco(rs.getDouble("ultimoPreço"));
                prod.setEstoque(rs.getInt("quantidade")); 
                prod.setSubGrupo(new SubGrupoModel(rs.getInt("subgrupo.idSubGrupo"),rs.getString("subgrupo.subDescricao")));
                prod.setNome_produto(rs.getString("descProduto"));
                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                prod.setLocacao(rs.getString("locacao"));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
    public List<ProdutoModel> listarProd(String nome_produto) {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaProd);
            pstm.setString(1, nome_produto);
//            pstm.setString(2,nome_produto);

            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setEstoque_ideal(rs.getInt("estIdeal"));
                prod.setEstoque_minimo(rs.getInt("estMinimo"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setNome_produto(rs.getString("descProduto"));
                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
    
    public List<ProdutoModel> listarProd1(String nome_produto) {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaProd1);
            pstm.setString(1, nome_produto);
//            pstm.setString(2,nome_produto);

            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setEstoque_ideal(rs.getInt("estIdeal"));
                prod.setEstoque_minimo(rs.getInt("estMinimo"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setNome_produto(rs.getString("descProduto"));
                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
//
//    public List<ProdutoModel> listarProdutoCodigo(String cod_produto) {
//        List<ProdutoModel> produto = new ArrayList();
//        try {
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaProdutoCodigo);
//            pstm.setString(1, cod_produto);
//            rs = pstm.executeQuery();
//            ProdutoModel prod;
//            while (rs.next()) {
//                prod = new ProdutoModel();
//                prod.setCod_produto(rs.getInt("idproduto"));
//                prod.setConcentraçao(rs.getString("concentracao"));
//                prod.setEstoque(rs.getInt("quantidade"));
//                prod.setEstoque_ideal(rs.getInt("estIdeal"));
//                prod.setEstoque_minimo(rs.getInt("estMinimo"));
//                prod.setSubGrupo(new SubGrupoModel(rs.getInt("subgrupo.idSubGrupo"),rs.getString("subgrupo.subDescricao")));
//                prod.setUltimo_preco(rs.getDouble("ultimoPreço"));
//                prod.setNome_produto(rs.getString("descProduto"));
//                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
//                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
//                produto.add(prod);
//            }
//            conexao.desconecta();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return produto;
//    }
//
//    public List<ProdutoModel> listarProdutoDescricao(String nome_produto, String concentracao) {
//        List<ProdutoModel> produto = new ArrayList();
//        try {
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaProduto);
//            pstm.setString(1, nome_produto);
//            pstm.setString(2, concentracao);
//            rs = pstm.executeQuery();
//            ProdutoModel prod;
//            while (rs.next()) {
//                prod = new ProdutoModel();
//                prod.setCod_produto(rs.getInt("idproduto"));
//                prod.setConcentraçao(rs.getString("concentracao"));
//                prod.setEstoque(rs.getInt("quantidade"));
//                prod.setEstoque_ideal(rs.getInt("estIdeal"));
//                prod.setEstoque_minimo(rs.getInt("estMinimo"));
//                prod.setNome_produto(rs.getString("descProduto"));
//                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
//                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
//                produto.add(prod);
//            }
//            conexao.desconecta();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return produto;
//    }
//
//    public List<ProdutoModel> listarProdutoDescricao1(String nome_produto) {
//        List<ProdutoModel> produto = new ArrayList();
//        try {
//            Conexao conexao = new Conexao();
//            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaProduto2);
//            pstm.setString(1, nome_produto);
//
//            rs = pstm.executeQuery();
//            ProdutoModel prod;
//            while (rs.next()) {
//                prod = new ProdutoModel();
//                prod.setCod_produto(rs.getInt("idproduto"));
//                prod.setConcentraçao(rs.getString("concentracao"));
//                prod.setEstoque(rs.getInt("quantidade"));
//                prod.setEstoque_ideal(rs.getInt("estIdeal"));
//                prod.setSubGrupo(new SubGrupoModel(rs.getInt("subgrupo.idSubGrupo"),rs.getString("subgrupo.subDescricao")));
//                prod.setEstoque_minimo(rs.getInt("estMinimo"));
//                prod.setUltimo_preco(rs.getDouble("ultimoPreço"));
//
//                prod.setNome_produto(rs.getString("descProduto"));
//                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
//                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
//                produto.add(prod);
//            }
//            conexao.desconecta();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return produto;
//    }

    public List<ProdutoModel> listarProdutos() {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setEstoque_ideal(rs.getInt("estIdeal"));
                prod.setEstoque_minimo(rs.getInt("estMinimo"));
                prod.setUltimo_preco(rs.getDouble("ultimoPreço"));
                prod.setNome_produto(rs.getString("descProduto"));
                prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
                prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<ProdutoModel> listaProdutoArmazem(ArmazemModel destino) {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaArmazem);
            pstm.setInt(1, destino.getCod_destino());
            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("produto.idproduto"));
                prod.setConcentraçao(rs.getString("produto.concentracao"));
                prod.setEstoque(rs.getInt("tbarmazem.quantidade"));
                prod.setNome_produto(rs.getString("produto.descProduto"));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<ProdutoModel> listarIdeal() {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(estoqueIdeal);
            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setEstoque_ideal(rs.getInt("estIdeal"));
//            prod.setEstoque_minimo(rs.getInt("estMinimo"));
                prod.setNome_produto(rs.getString("descProduto"));
//            prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
//            prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<ProdutoModel> listarMinimo() {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(estoqueMínimo);
            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("quantidade"));
                prod.setEstoque_minimo(rs.getInt("estMinimo"));
//            prod.setEstoque_minimo(rs.getInt("estMinimo"));
                prod.setNome_produto(rs.getString("descProduto"));
//            prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
//            prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
    String consultaVenc = "SELECT codProduto, data, lote, tbvencimento.quantidade, produto.quantidade, "
            + "produto.concentracao, produto.descProduto FROM produto, TbVencimento WHERE "
            + "(TbVencimento.quantidade<>0)and (produto.idproduto = codProduto) and (SELECT CURDATE() > data)"
            + "ORDER BY data";

    public List<ProdutoModel> listarProdutoVencidos() {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaVenc);

            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("tbvencimento.codProduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("tbvencimento.quantidade"));
                prod.setData(rs.getDate("data"));
//            prod.setEstoque_ideal(rs.getInt("estIdeal"));
//            prod.setEstoque_minimo(rs.getInt("estMinimo"));            
                prod.setNome_produto(rs.getString("produto.descProduto"));
//            prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
                //  prod.setUnidade(new UnidadeModel(rs.getInt("unidademedida.idunidademedida"), rs.getString("unidademedida.siglaunidade"), rs.getString("unidademedida.descunidade")));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<ProdutoModel> lista(String nome_produto) {
        List<ProdutoModel> produto = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(listar);
            pstm.setString(1, nome_produto);
            //pstm.setString(2,nome_produto);

            rs = pstm.executeQuery();
            ProdutoModel prod;
            while (rs.next()) {
                prod = new ProdutoModel();
                prod.setCod_produto(rs.getInt("idproduto"));
                prod.setConcentraçao(rs.getString("concentracao"));
                prod.setEstoque(rs.getInt("SUM(quantidade)"));

                //   prod.setEstoque_ideal(rs.getInt("estIdeal"));
                //  prod.setEstoque_minimo(rs.getInt("estMinimo"));
                //  prod.setEstoque(rs.getInt("quantidade"));
                prod.setNome_produto(rs.getString("descProduto"));
                //   prod.setGrupo(new GrupoModel(rs.getInt("grupo.idgrupo"), rs.getString("grupo.descGrupo")));
                prod.setUnidade(new UnidadeModel(rs.getString("siglaunidade")));
                produto.add(prod);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
    
    public void updateQuatidade(int qtd,int id,String operacao){
        try{
            if(operacao.equals("+")){
                updateQuantidade = "UPDATE `produto` SET `quantidade`=`quantidade`+? WHERE idproduto = ?";
            }else if (operacao.equals("-")){                
                updateQuantidade = "UPDATE `produto` SET `quantidade`=`quantidade`-? WHERE idproduto = ?";
            }
            
            Conexao conexao = new Conexao();
            pstm = (com.mysql.jdbc.PreparedStatement) conexao.conecta().prepareStatement(updateQuantidade);           
            pstm.setInt(1,qtd);          
            pstm.setInt(2, id);
           
            
            pstm.executeUpdate();
            conexao.desconecta();
        }catch(Exception ex){
            System.out.println("Erro:"+ex);
        }
    }
    
    
     public String listarProdutoCodigo(String cod_produto) {
        String produto = null;
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement("SELECT `descProduto` FROM `produto` WHERE idproduto = ?");
            pstm.setString(1, cod_produto);
            rs = pstm.executeQuery();            
            while (rs.next()) {
                produto = rs.getString("descProduto");               
                
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
     
    public String listarProdutoDesc(String descricao) {
        String produto = null;
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement("SELECT `idproduto` FROM `produto` WHERE `descProduto` = ?");
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();            
            while (rs.next()) {
                produto = rs.getString("idproduto");               
                
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    } 
}
