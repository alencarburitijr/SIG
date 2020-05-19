    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.ArmazemModel;
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
public class DestinoDAO {

    PreparedStatement pstm;
    ResultSet rs;
//comando sql para inserir dados na tabela destino
    private String cadastraDestino = "INSERT INTO destino (descDestino)VALUES(?)";
    //comando sql para consultar pelo nome
    private String consultaDestinoNome = "SELECT iddestino,descDestino FROM destino WHERE descDestino LIKE ? ORDER BY descDestino";
    private String consultaDestinoDescricao = "SELECT iddestino,descDestino FROM destino WHERE descDestino LIKE ? ORDER BY descDestino";
    private String consultaDestinoCodigo = "SELECT iddestino,descDestino FROM destino WHERE (iddestino = ?) ORDER BY descDestino";
    private String consulta = "SELECT iddestino, descDestino FROM destino ORDER BY descDestino";
    // comando sql para alterar dados da tabela aluno
    private String alteraDestino = "UPDATE destino SET descDestino = ? WHERE iddestino = ?";
    private String excluiDestino = "DELETE FROM destino WHERE iddestino = ?";

    public DestinoDAO() {
    }
//metodo para cadastrar destino

    public void cadastraDestino(ArmazemModel destino) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraDestino);
            pstm.setString(1, destino.getDesc_destino());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alteraDestino(ArmazemModel destino) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraDestino);
            pstm.setString(1, destino.getDesc_destino());
            pstm.setInt(2, destino.getCod_destino());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");

        }
    }

    public boolean excluiDestino(ArmazemModel destino) {
        try {

            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiDestino);
            pstm.setInt(1, destino.getCod_destino());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }
    }

    public List<ArmazemModel> listarDestino(String desc_destino) {
        List<ArmazemModel> destino = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaDestinoNome);
            pstm.setString(1, desc_destino);
            rs = pstm.executeQuery();
            ArmazemModel dest;
            while (rs.next()) {
                dest = new ArmazemModel();
                dest.setCod_destino(rs.getInt("idDestino"));
                dest.setDesc_destino(rs.getString("descDestino"));
                destino.add(dest);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destino;
    }

    public List<ArmazemModel> listarDestinoCodigo(String cod_destino) {
        List<ArmazemModel> destino = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaDestinoCodigo);
            pstm.setString(1, cod_destino);
            rs = pstm.executeQuery();
            ArmazemModel dest;
            while (rs.next()) {
                dest = new ArmazemModel();
                dest.setCod_destino(rs.getInt("idDestino"));
                dest.setDesc_destino(rs.getString("descDestino"));
                destino.add(dest);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destino;
    }

    public List<ArmazemModel> listarDestinoDescricao(String desc_destino) {
        List<ArmazemModel> destino = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaDestinoDescricao);
            pstm.setString(1, desc_destino);
            rs = pstm.executeQuery();
            ArmazemModel dest;
            while (rs.next()) {
                dest = new ArmazemModel();
                dest.setCod_destino(rs.getInt("idDestino"));
                dest.setDesc_destino(rs.getString("descDestino"));
                destino.add(dest);

            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destino;
    }

    public List<ArmazemModel> listarDestinos() {
        List<ArmazemModel> destino = new ArrayList();
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            ArmazemModel dest;
            while (rs.next()) {
                dest = new ArmazemModel();
                dest.setCod_destino(rs.getInt("iddestino"));
                dest.setDesc_destino(rs.getString("descDestino"));
                destino.add(dest);
            }
            rs.close();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destino;
    }
}
