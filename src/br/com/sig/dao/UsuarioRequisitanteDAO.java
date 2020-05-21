/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;


import br.com.medicalpharm.model.UsuarioRequisitanteModel;
import br.com.sig.util.Conexao;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class UsuarioRequisitanteDAO {
    
    java.sql.PreparedStatement pstm;
    ResultSet rs;
    
    private String cadastraUsuario = "INSERT INTO `usuario_requisitor`(`nome`, `cpf`) VALUES (?,?)";
    private String alterarUsuario = "UPDATE `usuario_requisitor` SET `nome`= ?,`cpf`= ? WHERE codigo_requisitor = ?";
    private String buscarNome = "SELECT * FROM `usuario_requisitor` WHERE ";
    private String buscarCpf = "SELECT * FROM `usuario_requisitor` WHERE cpf LIKE";
    private String buscarRequisitante = "SELECT `nome` FROM `usuario_requisitor` WHERE codigo_requisitor = ?";
    private String verificarCpf  = "SELECT  `cpf` FROM `usuario_requisitor` WHERE cpf = ?";

    public boolean cadastraUsuarioRequisitante(UsuarioRequisitanteModel usuario){
        try {
            if(verificarCpf(usuario.getCpf(),false)){
                Conexao conexao = new Conexao();

                pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraUsuario);           
                pstm.setString(1, usuario.getNome_requisitante());
                pstm.setString(2, usuario.getCpf());            
                pstm.executeUpdate();
                conexao.desconecta();  
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel gravar\n"+
                                                    "*Verifique o campo Cpf");
                return false;
            }
            return true;
        }catch (MysqlDataTruncation sqlEx){           
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar\n"+
                                                "*Dados muito longos");
            
            return false; 
        }catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");
            return false;
        }
        
    }
    
    public boolean alterarUsuarioRequisitante(UsuarioRequisitanteModel usuario){
        try {                 
            if(verificarCpf(usuario.getCpf(),false)){
                Conexao conexao = new Conexao();

                pstm = (PreparedStatement) conexao.conecta().prepareStatement(alterarUsuario);            
                pstm.setString(1, usuario.getNome_requisitante());
                pstm.setString(2, usuario.getCpf());            
                pstm.setInt(3, usuario.getCodigo_requisitante());
                pstm.executeUpdate();
                conexao.desconecta();  
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possivel gravar\n"+
                                                    "*Verifique o campo Cpf");
                return false;
            }   
            return true;
        }catch (MysqlDataTruncation sqlEx){           
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar\n"+
                                                "*Dados muito longos");
            
            return false;
        }catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");
            return false;
        }
    }
    
   
    public List<UsuarioRequisitanteModel> listarUsuarios(String parametro,int item){
        List<UsuarioRequisitanteModel> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            switch(item){
                case 0:buscarNome += "codigo_requisitor LIKE ?";break;
                case 1:buscarNome += "nome LIKE ?";break;
                case 2:buscarNome += "cpf LIKE ?";break;
            }
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(buscarNome);
            pstm.setString(1, parametro);
            rs = pstm.executeQuery();
            UsuarioRequisitanteModel requi;
            while (rs.next()) {
                requi = new UsuarioRequisitanteModel();
                requi.setCodigo_requisitante(rs.getInt("codigo_requisitor"));
                requi.setNome_requisitante(rs.getString("nome"));                
                requi.setCpf(rs.getString("cpf"));
                usuario.add(requi);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public String buscarRequisitanteCodigo(int cod) {
        String produto = null;
        try {
            Conexao conexao = new Conexao();
            pstm = (java.sql.PreparedStatement) conexao.conecta().prepareStatement(buscarRequisitante);
            pstm.setInt(1, cod);
            rs = pstm.executeQuery();            
            while (rs.next()) {
                produto = rs.getString("nome");
                
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }
    
    public boolean verificarCpf(String cpf,boolean update){        
        try {
            int i = 0;
            Conexao conexao = new Conexao();
            pstm = (java.sql.PreparedStatement) conexao.conecta().prepareStatement(verificarCpf);
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();            
            while (rs.next()) {
                i++;                
            }
            conexao.desconecta();
            if(i == 0){                
                return true;                
            }else if(i == 1){
                if(update){
                    return true;
                }
            }                        
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }                  
    }
}
