/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.RequisicoesModel;
import br.com.medicalpharm.model.RequisicoesProdutoModel;
import br.com.sig.util.Conexao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willi
 */
public class RequisicoesProdutoDAO {
    
    private String buscarProdutoRequisitado = "SELECT * FROM `requisicoes` WHERE codigo_requisicao = ? ";
    private String buscarRequisicaoCodigo = "SELECT `requisicoes`.`tipo`, `requisicoes`.`codigo_requisicao`,`requisicoes`.`id`,`requisicoes`.`produto`, `requisicoes`.`qtd`,`requisicao`.`usuario_requisitor` FROM `requisicoes`,`requisicao` WHERE `requisicoes`.`codigo_requisicao` = ? AND `requisicao`.`codigo_requisicao` = `requisicoes`.`codigo_requisicao`";
    private String buscarRequisicoes = "SELECT * FROM `requisicao` WHERE usuario_requisitor = ?";
    private String novaRequisicao = "INSERT INTO `requisicoes`(`tipo`, `codigo_requisicao`,`produto`, `qtd`, `data`) VALUES (?,?,?,?,?)";
    java.sql.PreparedStatement pstm;
    ResultSet rs;
    
    
   
    public List<RequisicoesProdutoModel> buscarRequisicaoProduto(String nomeUsuario){        
        List<RequisicoesProdutoModel> produtosList = new ArrayList();
        List<RequisicoesModel> requi = buscarRequisicoes(nomeUsuario);
        for (int i = 0; i < requi.size(); i++) {
            saldo = 0;
            devolvido = 0;
            qtd = 0;
            try {
                Conexao conexao = new Conexao();
                pstm = (PreparedStatement) conexao.conecta().prepareStatement(buscarProdutoRequisitado);
                pstm.setString(1,nomeUsuario);//requi.get(i).getCodigo_requisicao()
                rs = pstm.executeQuery();
                
                RequisicoesProdutoModel produtos = null;
                produtos = new RequisicoesProdutoModel();  
                String produto = null;
                while (rs.next()) {                                              
                    verificarStatus(rs.getString("tipo"),rs.getInt("qtd"));                        
                    produto = rs.getString("produto");
                }
                produtos.setCodigoRequisicao(requi.get(i).getCodigo_requisicao());
                produtos.setUsuarioEstoquista(requi.get(i).getUsuario_estoquista());
                produtos.setProduto(produto);//RequisicaoProduto.add(produto);
                produtos.setQtd(qtd);//RequisicaoProduto.add(qtd);
                produtos.setQtdDevolvida(devolvido);//RequisicaoProduto.add(devolvido);
                produtos.setSaldo(saldo);//RequisicaoProduto.add(saldo); 

                produtosList.add(produtos);
                conexao.desconecta();
            } catch (Exception e) {
                e.printStackTrace();                
            }
        }
        return produtosList;
    }
    ArrayList<RequisicoesProdutoModel> itens = new ArrayList();// = new ArrayList();    
    public ArrayList<RequisicoesProdutoModel> buscarRequisicaoPorCodigo(String codigo){
        try {                       
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(buscarRequisicaoCodigo);
            pstm.setString(1, codigo);
            rs = pstm.executeQuery();                    
                while (rs.next()) {                
                    RequisicoesProdutoModel produto  = new RequisicoesProdutoModel();                 
                    if(rs.getString("tipo").equals("E")){
                        produto.setCodigoRequisicao(Integer.parseInt(rs.getString("usuario_requisitor")));
                        produto.setProduto(rs.getString("produto"));
                        produto.setQtd(Integer.parseInt(rs.getString("qtd")));
                        produto.setQtdDevolvida(0);
                        produto.setSaldo(Integer.parseInt(rs.getString("qtd")));
                        produto.setId(rs.getInt("id"));
                        itens.add(produto);
                    }else{
                        int i = 0;
                        while(true){                                     
                            if(rs.getString("produto").equals(itens.get(i).getProduto()) && !rs.getString("id").equals(itens.get(i).getId())){
                                int qtd = Integer.parseInt(itens.get(i).getSaldo().toString());
                                int qtdD = rs.getInt("qtd");                                                                                                                                                                                                
                                itens.get(i).setSaldo(qtd-qtdD);                               
                                itens.get(i).setQtdDevolvida(itens.get(i).getQtdDevolvida()+(qtd-Integer.parseInt(itens.get(i).getSaldo().toString())));                                
                                break;
                            }
                            i++;
                        }
                    }
                }               
            conexao.desconecta();
            return itens;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       
    public List<RequisicoesModel> buscarRequisicoes(String codigoRequisicao){
        List<RequisicoesModel> requisicoes = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(buscarRequisicoes);
            pstm.setString(1, codigoRequisicao);
            rs = pstm.executeQuery();
            RequisicoesModel requi;            
            while (rs.next()) {                
                requi = new RequisicoesModel();
                requi.setCodigo_requisicao(rs.getInt("codigo_requisicao"));
                requi.setUsuario_estoquista(rs.getString("usuario_estoquista"));
                requisicoes.add(requi);
            }
            conexao.desconecta();         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requisicoes;
    }
  
    
    private int saldo = 0;
    private int devolvido = 0;
    private int qtd = 3;
    public void verificarStatus(String tipo,int qtd){
        if(tipo.equals("D")){
            saldo -= qtd;    
            devolvido += qtd; 
        }else if(tipo.equals("E")){
            saldo = qtd;
            this.qtd = qtd;
            
        }
    }
    
    
    public void cadastrarNovaRequisicaoProduto(List<RequisicoesProdutoModel> produto){
        try{
            Conexao conexao = new Conexao();
            for (int i = 0; i < produto.size(); i++) {
                            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(novaRequisicao);
            pstm.setString(1, produto.get(i).getTipo());
            pstm.setInt(2,produto.get(i).getCodigoRequisicao());            
            pstm.setString(3,produto.get(i).getProduto());
            pstm.setInt(4,produto.get(i).getQtd());
            pstm.setDate(5, (Date) produto.get(i).getData_devolucao());
            pstm.executeUpdate();
        }
            conexao.desconecta();                                    
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String verificarStatus(String nome){
        List<RequisicoesProdutoModel> produtos = buscarRequisicaoProduto(nome);
        int status = 0;
        for (int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i).getSaldo() == 0){
                
            }else{
                status++;
            }            
        }
        if(status == 0){
            return "Fechado";
        }
        return "Aberto";
    }
    
    
}
