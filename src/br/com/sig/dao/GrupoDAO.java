/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.GrupoModel;
import br.com.medicalpharm.model.SubGrupoModel;
import br.com.sig.util.Conexao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class GrupoDAO {

    PreparedStatement pstm;
    ResultSet rs;
//comando sql para inserir dados na tabela destino
    private String cadastraGrupo = "INSERT INTO grupo(descGrupo) VALUES(?)";
//comando sql para consultar pelo nome
    private String consultaGrupo = "SELECT idgrupo,descGrupo FROM grupo WHERE descGrupo LIKE ? ORDER BY descGrupo";
    private String consultaGrupoDescricao = "SELECT idgrupo,descGrupo FROM grupo WHERE descGrupo LIKE ? ORDER BY descGrupo";
    private String consultaGrupoCodigo = "SELECT idgrupo,descGrupo FROM grupo WHERE idgrupo = ? ORDER BY descGrupo";
    private String consulta = "SELECT idgrupo, descgrupo FROM grupo ORDER BY descGrupo";
// comando sql para alterar dados da tabela aluno
    private String alteraGrupo = "UPDATE grupo,subgrupo SET descGrupo = ?, subDescricao = ? WHERE grupo.idgrupo = ? AND subgrupo.idSubGrupo = ?";
    private String excluiGrupo = "DELETE FROM grupo WHERE idgrupo = ?";
    private String excluiSubGrupo = "DELETE FROM subgrupo WHERE idSubGrupo = ?";
    private String cadastraSubGrupo = "INSERT INTO subgrupo (subDescricao, idgrupo) VALUES (?,?)";

    public GrupoDAO() {
    }
//metodo para cadastrar destini

    public GrupoModel cadastraGrupo(GrupoModel grupo) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraGrupo);
            pstm.setString(1, grupo.getDesc_grupo());
            pstm.executeUpdate();
            conexao.desconecta();
            
            ResultSet res;
            Integer codMax;
            String sql = "SELECT Max(idgrupo) FROM grupo";
            Statement stm = (Statement) conexao.conecta().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = stm.executeQuery(sql);
            res.next();
            codMax = res.getInt("Max(idgrupo)");
            grupo.setCod_grupo(codMax);
            conexao.desconecta();
            res.close();            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
        return grupo;
    }
    public void cadastraSubGrupo(List<SubGrupoModel> itens, GrupoModel grupo){

        try {
            Conexao conexao = new Conexao();
            for (int i = 0; i < itens.size(); i++) {
                pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraSubGrupo);

                pstm.setString(1, itens.get(i).getDescSubGrupo());
                pstm.setInt(2, grupo.getCod_grupo());
                pstm.executeUpdate();
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao adicionar os sub grupos");
        }        
    }
    
    public void cadastraSubGrupoItem(SubGrupoModel item, GrupoModel grupo){

        try {
            Conexao conexao = new Conexao();
          
                pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraSubGrupo);

                pstm.setString(1, item.getDescSubGrupo());
                pstm.setInt(2, grupo.getCod_grupo());
                pstm.executeUpdate();
          
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao adicionar os sub grupos");
        }        
    }
    
    private String consultaItem = "SELECT * FROM `subgrupo` WHERE (idgrupo = ?) ORDER BY subDescricao ";
    
    public List<SubGrupoModel> listarItens(Integer idEntrada) {
        List<SubGrupoModel> itens = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaItem);
            pstm.setInt(1, idEntrada);
            rs = pstm.executeQuery();
            //rs.absolute(1);
            SubGrupoModel subGrupo;

            while (rs.next()) {
                subGrupo = new SubGrupoModel();
                subGrupo.setIdSubGrupo(rs.getInt("idSubGrupo"));
                subGrupo.setDescSubGrupo(rs.getString("subDescricao"));
                subGrupo.setGrupo(new GrupoModel(rs.getInt("idgrupo")));
                itens.add(subGrupo);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itens;
    }
    
    
    //metodo para altera grupo

    public void alterarGrupo(GrupoModel grupo,SubGrupoModel sub) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraGrupo);
            pstm.setString(1, grupo.getDesc_grupo());
            pstm.setString(2, sub.getDescSubGrupo());
            pstm.setInt(3, grupo.getCod_grupo());
            pstm.setInt(4, sub.getIdSubGrupo());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar");
        }
    }
    

    public boolean excluirGrupo(GrupoModel grupo) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiGrupo);
            pstm.setInt(1, grupo.getCod_grupo());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }
    }
    public boolean excluirSubGrupo(SubGrupoModel subGrupo) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiSubGrupo);
            pstm.setInt(1, subGrupo.getIdSubGrupo());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }
    }

    public List<GrupoModel> listarGrupo(String desc_grupo) {

        List<GrupoModel> grupo = new ArrayList();

        try {
            //cria acesso ao banco
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo);
            pstm.setString(1, desc_grupo);
            rs = pstm.executeQuery();
            GrupoModel grup;
            while (rs.next()) {
                grup = new GrupoModel();
                grup.setCod_grupo(rs.getInt("idgrupo"));
                grup.setDesc_grupo(rs.getString("descGrupo"));
                grupo.add(grup);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return grupo;
    }

    public List<GrupoModel> listarGrupoCodigo(String cod_grupo) {
        List<GrupoModel> grupo = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupoCodigo);
            pstm.setString(1, cod_grupo);
            rs = pstm.executeQuery();
            GrupoModel grup;
            while (rs.next()) {
                grup = new GrupoModel();
                grup.setCod_grupo(rs.getInt("idgrupo"));
                grup.setDesc_grupo(rs.getString("descGrupo"));
                grupo.add(grup);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupo;
    }

    public List<GrupoModel> listarGrupoCodigo1(Integer cod_grupo) {
        List<GrupoModel> grupo = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupoCodigo);
            pstm.setObject(1, cod_grupo);
            rs = pstm.executeQuery();
            GrupoModel grup;
            while (rs.next()) {
                grup = new GrupoModel();
                grup.setCod_grupo(rs.getInt("idgrupo"));
                grup.setDesc_grupo(rs.getString("descGrupo"));
                grupo.add(grup);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupo;
    }

    public List<GrupoModel> listarGrupoDescricao(String desc_grupo) {
        List<GrupoModel> grupo = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupoDescricao);
            pstm.setString(1, desc_grupo);
            rs = pstm.executeQuery();
            GrupoModel grup;
            while (rs.next()) {
                grup = new GrupoModel();
                grup.setCod_grupo(rs.getInt("idgrupo"));
                grup.setDesc_grupo(rs.getString("descGrupo"));
                grupo.add(grup);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupo;
    }

    public List<GrupoModel> listarGrupos() {
        List<GrupoModel> grupo = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            GrupoModel grup;
            while (rs.next()) {
                grup = new GrupoModel();
                grup.setCod_grupo(rs.getInt("idgrupo"));
                grup.setDesc_grupo(rs.getString("descGrupo"));
                grupo.add(grup);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupo;
    }
}
