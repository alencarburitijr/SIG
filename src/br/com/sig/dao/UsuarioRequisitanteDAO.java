/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;


import br.com.medicalpharm.model.UsuarioRequisitanteModel;
import br.com.sig.util.Conexao;
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

    public void cadastraUsuarioRequisitante(UsuarioRequisitanteModel usuario){
        try {

            Conexao conexao = new Conexao();
            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraUsuario);           
            pstm.setString(1, usuario.getNome_requisitante());
            pstm.setString(2, usuario.getCpf());            
            pstm.executeUpdate();
            conexao.desconecta();                        
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
        
    }
    
    public void alterarUsuarioRequisitante(UsuarioRequisitanteModel usuario){
        try {

            Conexao conexao = new Conexao();
            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alterarUsuario);            
            pstm.setString(1, usuario.getNome_requisitante());
            pstm.setString(2, usuario.getCpf());            
            pstm.setInt(3, usuario.getCodigo_requisitante());
            pstm.executeUpdate();
            conexao.desconecta();                        
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar\n"+erro);

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
}
