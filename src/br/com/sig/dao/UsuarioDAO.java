/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.UsuarioModel;
import br.com.sig.util.Conexao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class UsuarioDAO {

    java.sql.PreparedStatement pstm;
    ResultSet rs;
    
//comando sql para inserir dados na tabela destino
    private String cadastraUsuario = "INSERT INTO usuario (nomeUsuario, login, senha,tipoUsuário)VALUES(?,?,?,?)";
//comando sql para consultar pelo nome
    private String consultaUsuarioNome = "SELECT * FROM usuario WHERE nomeUsuario LIKE ? ORDER BY nomeUsuario";
    private String consultaUsuarioDescricao = "SELECT * FROM usuario WHERE (nomeUsuario = ?) ORDER BY nomeUsuario";
    private String consultaUsuarioDescricao1 = "SELECT * FROM usuario WHERE (nomeUsuario = ?) OR (login = ?) ORDER BY nomeUsuario";
    private String consultaUsuarioCodigo = "SELECT * FROM usuario WHERE idusuario = ? ORDER BY nomeUsuario";
    private String consultaUsuarioLogin = "SELECT * FROM usuario WHERE login = ?";
// comando sql para alterar dados da tabela aluno
    private String alteraUsuario = "UPDATE usuario SET nomeUsuario = ?,login = ?,senha = ?, tipoUsuário=? WHERE idusuario = ?";
    private String excluiUsuario = "DELETE FROM usuario WHERE idusuario = ?";

    public void cadastraUsuario(UsuarioModel usuario) {
        try {

            Conexao conexao = new Conexao();
            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraUsuario);
            pstm.setString(1, usuario.getNome_usuario());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, usuario.getPermissao());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
    }

    public void alteraUsuario(UsuarioModel usuario) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraUsuario);
            pstm.setString(1, usuario.getNome_usuario());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, usuario.getPermissao());
            pstm.setInt(5, usuario.getCod_usuario());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
    }

    public boolean excluiUsuario(UsuarioModel usuario) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiUsuario);
            pstm.setInt(1, usuario.getCod_usuario());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;

        }
    }

    public List<UsuarioModel> listarUsuario(String nome_usuario) {
        List<UsuarioModel> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioNome);
            pstm.setString(1, nome_usuario);
            rs = pstm.executeQuery();
            UsuarioModel usua;
            while (rs.next()) {
                usua = new UsuarioModel();
                usua.setCod_usuario(rs.getInt("idusuario"));
                usua.setNome_usuário(rs.getString("nomeUsuario"));
                usua.setLogin(rs.getString("login"));
                usua.setSenha(rs.getString("senha"));
                usua.setPermissao(rs.getString("tipoUsuário"));
                usuario.add(usua);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<UsuarioModel> listarUsuarioCodigo(String cod_usuário) {
        List<UsuarioModel> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioCodigo);
            pstm.setString(1, cod_usuário);
            rs = pstm.executeQuery();
            UsuarioModel usua;
            while (rs.next()) {
                usua = new UsuarioModel();
                usua.setCod_usuario(rs.getInt("idusuario"));
                usua.setNome_usuário(rs.getString("nomeUsuario"));
                usua.setLogin(rs.getString("login"));
                usua.setSenha(rs.getString("senha"));
                usuario.add(usua);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<UsuarioModel> listarUsuarioDescrição(String nome_usuario) {
        List<UsuarioModel> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioDescricao);
            pstm.setString(1, nome_usuario);
            rs = pstm.executeQuery();
            UsuarioModel usua;
            while (rs.next()) {
                usua = new UsuarioModel();
                usua.setCod_usuario(rs.getInt("idusuario"));
                usua.setNome_usuário(rs.getString("nomeUsuario"));
                usua.setLogin(rs.getString("login"));
                usua.setSenha(rs.getString("senha"));
                usua.setPermissao(rs.getString("tipoUsuário "));
                usuario.add(usua);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<UsuarioModel> listarUsuarioDescrição1(String nome_usuario, String login) {
        List<UsuarioModel> usuario = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioDescricao1);
            pstm.setString(1, nome_usuario);
            pstm.setString(2, login);
            rs = pstm.executeQuery();
            UsuarioModel usua;
            while (rs.next()) {
                usua = new UsuarioModel();
                usua.setCod_usuario(rs.getInt("idusuario"));
                usua.setNome_usuário(rs.getString("nomeUsuario"));
                usua.setLogin(rs.getString("login"));
                usua.setSenha(rs.getString("senha"));
                usua.setPermissao(rs.getString("tipoUsuário"));
                usuario.add(usua);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public List<UsuarioModel> consultarLogin(String login) {
        List<UsuarioModel> usuario = new ArrayList();

        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUsuarioLogin);
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            UsuarioModel usua;
            while (rs.next()) {
                usua = new UsuarioModel();
                usua.setCod_usuario(rs.getInt("idusuario"));
                usua.setNome_usuário(rs.getString("nomeUsuario"));
                usua.setLogin(rs.getString("login"));
                usua.setSenha(rs.getString("senha"));
                usua.setPermissao(rs.getString("tipoUsuário"));
                usuario.add(usua);

            }
            pstm.close();
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
