/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.VeiculoModel;
import br.com.sig.util.Conexao;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class VeiculoDAO {
     
    java.sql.PreparedStatement pstm;
    ResultSet rs;
    
    private String cadastrarVeiculo = "INSERT INTO `veiculo`(`descricao`, `chassi`, `placa`) VALUES (?,?,?)";
    private String editarVeiculo = "UPDATE `veiculo` SET `descricao`= ?,`chassi`=?,`placa`= ? WHERE codigo = ?";
    private String listaVeiculos = "SELECT * FROM `veiculo` WHERE ";
    private String buscarChassiPlaca = "SELECT `chassi`, `placa` FROM `veiculo` WHERE chassi = ?";
    
    public List<VeiculoModel> listarVeiculos(String nomePesquisa,int parametro){
        List<VeiculoModel> veiculo = new ArrayList();
        
        try{                       
            Conexao conexao = new Conexao();
            switch(parametro){
                case 0:listaVeiculos += "codigo LIKE ?";break;
                case 1:listaVeiculos += "descricao LIKE ?";break;
                case 2:listaVeiculos += "chassi LIKE ?";break;    
                case 3:listaVeiculos += "placa LIKE ?";break;
            }
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(listaVeiculos);
            pstm.setString(1,"%"+nomePesquisa+"%");
            rs = pstm.executeQuery();
            VeiculoModel vei;
            while(rs.next()){
                vei = new VeiculoModel();
                vei.setCodigo(rs.getInt("codigo"));
                vei.setDescricao(rs.getString("descricao"));
                vei.setChassi(rs.getString("chassi"));
                vei.setPlaca(rs.getString("placa"));                
                veiculo.add(vei);
            }
            conexao.desconecta();
        }catch(Exception ex){
             //JOptionPane.showMessageDialog(null, "Não foi possivel listar os veiculos:"+ex);
        }
        return veiculo;
    }
    
    public boolean cadastarVeiculo(VeiculoModel veiculo,boolean editar){
        if(editar){
            cadastrarVeiculo = editarVeiculo;
        }
        try{
            Conexao conexao = new Conexao();
            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastrarVeiculo);
            pstm.setString(1, veiculo.getDescricao());
            pstm.setString(2, veiculo.getChassi());
            pstm.setString(3, veiculo.getPlaca());
            if(editar){
                pstm.setInt(4, veiculo.getCodigo());
            }
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        }catch(MysqlDataTruncation sqlEx){           
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar novo veiculo.\n"+
                                                "*Dados muito longos");
            
            return false;
        }catch(Exception ex){
            System.err.println("Ocorreu um erro.");
            return false;
        }                                        
    }
    
    private void burcarChassi(){
        
    }           
    
    public boolean verificarVeiculo(String chassi){               
        try{                                   
            Conexao conexao = new Conexao();         
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(buscarChassiPlaca);
            pstm.setString(1,chassi);         
            rs = pstm.executeQuery();            
            int i = 0;
            while(rs.next()){
               i++;
            }
            if(i > 0){
                JOptionPane.showMessageDialog(null, "Chassi invalido");
                return false;                                
            }else if(i == 0){
                return true;                
            }
            conexao.desconecta();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os veiculos:"+ex);
        }
        return false;
    }
}
