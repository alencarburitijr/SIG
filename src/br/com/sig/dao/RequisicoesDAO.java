/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.RequisicoesModel;
import br.com.medicalpharm.model.RequisicoesProdutoModel;
import br.com.sig.util.Conexao;
import br.com.sig.util.Data;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class RequisicoesDAO {
    
    java.sql.PreparedStatement pstm;
    ResultSet rs;
    
    private String consultarRequisicao = "SELECT * FROM `requisicao` WHERE ";
    private String cadastrarRequisicao = "INSERT INTO `requisicao`(`veiculo`,`data_emissao`, `usuario_requisitor`, `usuario_estoquista`) VALUES (?,?,?,?)";
    private String buscarUsuarioVeiculo = "SELECT `usuario_requisitor`.`codigo_requisitor`,`usuario_requisitor`.`nome`,`veiculo`.`codigo`,`veiculo`.`descricao` FROM `requisicao`,`usuario_requisitor`,`veiculo` WHERE `requisicao`.`codigo_requisicao` = ? AND `requisicao`.`veiculo` = `veiculo`.`codigo` AND `requisicao`.`usuario_requisitor` = `usuario_requisitor`.`codigo_requisitor`";
    private String pegarUltimoID = "SELECT MAX(codigo_requisicao) FROM requisicao";
    private String status = "SELECT COUNT(*) FROM (\n" +
                            "SELECT EMPRESTIMO.CODIGO_REQUISICAO, EMPRESTIMO.PRODUTO, EMPRESTIMO.QTD - IFNULL(DEVOLUCAO.QTD,0) FROM\n" +
                            "(SELECT CODIGO_REQUISICAO, PRODUTO, SUM(QTD) AS QTD FROM requisicoes AS ITENS WHERE TIPO = 'E' GROUP BY CODIGO_REQUISICAO, PRODUTO) AS EMPRESTIMO LEFT JOIN\n" +
                            "(SELECT CODIGO_REQUISICAO, PRODUTO, SUM(QTD) AS QTD FROM requisicoes AS ITENS WHERE TIPO = 'D' GROUP BY CODIGO_REQUISICAO, PRODUTO) AS DEVOLUCAO ON\n" +
                            "EMPRESTIMO.CODIGO_REQUISICAO = DEVOLUCAO.CODIGO_REQUISICAO\n" +
                            "AND EMPRESTIMO.PRODUTO = DEVOLUCAO.PRODUTO\n" +
                            "WHERE EMPRESTIMO.QTD - IFNULL(DEVOLUCAO.QTD,0) <> 0\n" +
                            "AND EMPRESTIMO.CODIGO_REQUISICAO = ?) AS RET";
    
    Data data = new Data();
    
    public List<RequisicoesModel> listarRequisicoes(String parametro,String opcaoPesquisa){
        List<RequisicoesModel> requisicao = new ArrayList();
        verificarParametroPesquisa(opcaoPesquisa);
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultarRequisicao);
            if(opcaoPesquisa.equals("codigo Requisicao")){
                pstm.setString(1, "%"+parametro+"%");
            }else{
                pstm.setString(1,data.inverterData(parametro,"normal"));
                
            }
            rs = pstm.executeQuery();
            RequisicoesModel requi;
            while (rs.next()) {
                requi = new RequisicoesModel();
                requi.setCodigo_requisicao(rs.getInt("codigo_requisicao"));
                requi.setData_emissao(rs.getDate("data_emissao"));
                requi.setUsuario_requisitor(rs.getString("usuario_requisitor"));
                requi.setUsuario_estoquista(rs.getString("usuario_estoquista"));
                
                
                requisicao.add(requi);

            }
            conexao.desconecta();
        } catch (Exception e) {
            
        }
        return requisicao;
    }
    
    public ArrayList buscarUsuario(String parametro){
        ArrayList retorno = new ArrayList();
        
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(buscarUsuarioVeiculo);
            pstm.setString(1, parametro);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                retorno.add(rs.getString("codigo_requisitor"));
                retorno.add(rs.getString("nome"));
                retorno.add(rs.getString("codigo"));
                retorno.add(rs.getString("descricao"));
            }
            conexao.desconecta();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(retorno.get(0)+" - "+retorno.get(1)+" - "+retorno.get(2)+" - "+retorno.get(3));
        return retorno;
    }
    
    public void verificarParametroPesquisa(String opcaoPesquisa){
        consultarRequisicao = "SELECT * FROM `requisicao` WHERE ";
        if(opcaoPesquisa.equals("codigo Requisicao")){
            consultarRequisicao += "codigo_requisicao LIKE ?";       
        }else if(opcaoPesquisa.equals("data")){
            consultarRequisicao += "data_emissao = ?";
        }
    }
    
    public void cadastrarNovaRequisicao(RequisicoesModel requisicao,List<RequisicoesProdutoModel> produto,boolean update){
        try{
            Conexao conexao = new Conexao();
            if(!update){
                pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastrarRequisicao);            
                pstm.setString(1,requisicao.getCodigo_veiculo());
                pstm.setDate(2, (Date) requisicao.getData_emissao());
                pstm.setString(3, requisicao.getUsuario_requisitor());
                pstm.setString(4,requisicao.getUsuario_estoquista());

                pstm.executeUpdate();
                conexao.desconecta();
            }
            RequisicoesProdutoDAO novaRequisicao = new RequisicoesProdutoDAO();
            novaRequisicao.cadastrarNovaRequisicaoProduto(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int pegarUltimoID(){
        int id = 0;
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(pegarUltimoID);            
            rs = pstm.executeQuery();           
           
            while (rs.next()) {
                
                id = rs.getInt("MAX(codigo_requisicao)");
               
                
                

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
       
    public String statusRequisicao(String codigoRequisicao){
        try{            
            Conexao conexao = new Conexao();
            int linhas = 0;
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(status);
            pstm.setString(1,codigoRequisicao);
            rs = pstm.executeQuery();           
           
            while (rs.next()) {
                int count = Integer.parseInt(rs.getString("COUNT(*)"));
                if(count > 0){
                    return "Aberto";
                }                
            }
            conexao.desconecta();
            return "Fechado";
        }catch(Exception ex){
            System.out.println("linhas>Erradas"+ex);
        }
        return null;   
    }
    
        
}
