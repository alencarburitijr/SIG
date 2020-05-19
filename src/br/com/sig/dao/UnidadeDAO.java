/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.UnidadeModel;
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
public class UnidadeDAO {

    private String cadastraUnidade = "INSERT INTO unidademedida (siglaUnidade, descUnidade) VALUES(?,?)";
    private String consultaUnidade = "SELECT idunidadeMedida, siglaUnidade,descUnidade FROM unidademedida WHERE descUnidade LIKE ? ORDER BY descUnidade";
    private String consultaUnidadeDescricao = "SELECT idunidadeMedida, siglaUnidade,descUnidade FROM unidademedida WHERE descUnidade LIKE ? ORDER BY descUnidade";
    private String consultaUnidadeDescricao1 = "SELECT * FROM unidademedida WHERE (descUnidade = ?) OR (siglaUnidade = ?) ORDER BY descUnidade";
    private String consultaUnidadeCodigo = "SELECT idunidadeMedida, siglaUnidade,descUnidade FROM unidademedida WHERE idunidadeMedida = ? ORDER BY descUnidade";
    private String consulta = "SELECT idunidadeMedida, siglaUnidade, descUnidade FROM unidademedida ORDER BY descUnidade";
    private String alteraUnidade = "UPDATE unidademedida SET siglaUnidade = ?, descUnidade = ? WHERE idunidadeMedida = ?";
    private String excluiUnidade = "DELETE FROM unidademedida WHERE idunidadeMedida = ?";
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastraUnidade(UnidadeModel unidade) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraUnidade);
            pstm.setString(1, unidade.getSigla_unidade());
            pstm.setString(2, unidade.getDesc_unidade());

            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");
        }
    }

    public void alteraUnidade(UnidadeModel unidade) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraUnidade);
            pstm.setString(1, unidade.getSigla_unidade());
            pstm.setString(2, unidade.getDesc_unidade());
            pstm.setInt(3, unidade.getCod_unidade());

            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar");
        }
    }

    public boolean excluirUnidade(UnidadeModel unidade) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiUnidade);
            pstm.setInt(1, unidade.getCod_unidade());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }
    }

    public List<UnidadeModel> listarUnidade(String desc_unidade) {
        List<UnidadeModel> unidade = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUnidade);
            pstm.setString(1, desc_unidade);
            rs = pstm.executeQuery();
            UnidadeModel unid;
            while (rs.next()) {
                unid = new UnidadeModel();
                unid.setCod_unidade(rs.getInt("idunidadeMedida"));
                unid.setDesc_unidade(rs.getString("descUnidade"));
                unid.setSigla_unidade(rs.getString("siglaUnidade"));
                unidade.add(unid);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidade;
    }

    public List<UnidadeModel> listarUnidadeCodigo(String cod_unidade) {
        List<UnidadeModel> unidade = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUnidadeCodigo);
            pstm.setString(1, cod_unidade);
            rs = pstm.executeQuery();
            UnidadeModel unid;
            while (rs.next()) {
                unid = new UnidadeModel();
                unid.setCod_unidade(rs.getInt("idunidadeMedida"));
                unid.setDesc_unidade(rs.getString("descUnidade"));
                unid.setSigla_unidade(rs.getString("siglaUnidade"));
                unidade.add(unid);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidade;
    }

    public List<UnidadeModel> listarUnidadeDescricao(String desc_unidade) {
        List<UnidadeModel> unidade = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUnidadeDescricao);
            pstm.setString(1, desc_unidade);
            rs = pstm.executeQuery();
            UnidadeModel unid;
            while (rs.next()) {
                unid = new UnidadeModel();
                unid.setCod_unidade(rs.getInt("idunidadeMedida"));
                unid.setDesc_unidade(rs.getString("descUnidade"));
                unid.setSigla_unidade(rs.getString("siglaUnidade"));
                unidade.add(unid);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidade;
    }

    public List<UnidadeModel> listarUnidadeDescricao1(String desc_unidade, String sigla) {
        List<UnidadeModel> unidade = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaUnidadeDescricao1);
            pstm.setString(1, desc_unidade);
            pstm.setString(2, sigla);
            rs = pstm.executeQuery();
            UnidadeModel unid;
            while (rs.next()) {
                unid = new UnidadeModel();
                unid.setCod_unidade(rs.getInt("idunidadeMedida"));
                unid.setDesc_unidade(rs.getString("descUnidade"));
                unid.setSigla_unidade(rs.getString("siglaUnidade"));
                unidade.add(unid);

            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidade;
    }

    public List<UnidadeModel> listarUnidades() {
        List<UnidadeModel> unidade = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            UnidadeModel unid;
            while (rs.next()) {
                unid = new UnidadeModel();
                unid.setCod_unidade(rs.getInt("idunidadeMedida"));
                unid.setDesc_unidade(rs.getString("descUnidade"));
                unid.setSigla_unidade(rs.getString("siglaUnidade"));
                unidade.add(unid);
            }
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidade;
    }
}
