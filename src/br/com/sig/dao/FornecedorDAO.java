/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.dao;

import br.com.medicalpharm.model.FornecedorModel;
import br.com.sig.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class FornecedorDAO {

    PreparedStatement pstm;
    private String consultaFornecedor = "SELECT * FROM fornecedor WHERE razaoSocial LIKE ?";
    private String consultaFornecedorCodigo = "SELECT * FROM fornecedor WHERE idfornecedor LIKE ?";
    private String consultaFornecedorDescricao = "SELECT * FROM fornecedor WHERE razaoSocial LIKE ?";
    private String consultaFornecedorDescricao1 = "SELECT * FROM fornecedor WHERE (razaoSocial = ?) or (cnpj = ?)";
    private String consulta = "SELECT *FROM fornecedor ORDER BY razaoSocial";
    private String consultacnpj = "SELECT *FROM fornecedor WHERE (cnpj = ?)";
    private String cadastraFornecedor = "INSERT INTO fornecedor(razaoSocial,nomeFantasia,cnpj,telefone,"
            + "fax,endereco,inscricaoEstadual,inscricaoMunicipal,nomeVendedor,telefoneVendedor,cep,estado,"
            + "cidade)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String alteraFornecedor = "UPDATE fornecedor SET razaoSocial = ?, nomeFantasia = ?,cnpj = ?,telefone = ?,"
            + "fax = ?,endereco = ?,inscricaoEstadual = ?,inscricaoMunicipal = ?,nomeVendedor = ?,telefoneVendedor = ?,cep = ?,estado = ?,"
            + "cidade = ? WHERE idfornecedor = ?";
    private String excluiFornecedor = "DELETE FROM fornecedor WHERE idfornecedor = ?";

    public FornecedorDAO() {
    }

    public void cadastraFornecedor(FornecedorModel fornecedor) {
        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(cadastraFornecedor);
            pstm.setString(1, fornecedor.getRazao_social());
            pstm.setString(2, fornecedor.getNome_fantasia());
            pstm.setString(3, fornecedor.getCNPJ());
            pstm.setString(4, fornecedor.getTelefone());
            pstm.setString(5, fornecedor.getFax());
            pstm.setString(6, fornecedor.getEndereço());
            pstm.setString(7, fornecedor.getInsc_estadual());
            pstm.setString(8, fornecedor.getInsc_municipal());
            pstm.setString(9, fornecedor.getNome_vendedor());
            pstm.setString(10, fornecedor.getTel_vendedor());
            pstm.setString(11, fornecedor.getCEP());
            pstm.setString(12, fornecedor.getEstado());
            pstm.setString(13, fornecedor.getCidade());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel gravar");
        }
    }

    public void alteraFornecedor(FornecedorModel fornecedor) {


        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(alteraFornecedor);
            pstm.setString(1, fornecedor.getRazao_social());
            pstm.setString(2, fornecedor.getNome_fantasia());
            pstm.setString(3, fornecedor.getCNPJ());
            pstm.setString(4, fornecedor.getTelefone());
            pstm.setString(5, fornecedor.getFax());
            pstm.setString(6, fornecedor.getEndereço());
            pstm.setString(7, fornecedor.getInsc_estadual());
            pstm.setString(8, fornecedor.getInsc_municipal());
            pstm.setString(9, fornecedor.getNome_vendedor());
            pstm.setString(10, fornecedor.getTel_vendedor());
            pstm.setString(11, fornecedor.getCEP());
            pstm.setString(12, fornecedor.getEstado());
            pstm.setString(13, fornecedor.getCidade());
            pstm.setInt(14, fornecedor.getCod_fornecedor());
            pstm.executeUpdate();
            conexao.desconecta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar");
        }
    }

    public boolean excluiFornecedor(FornecedorModel fornecedor) {


        try {
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(excluiFornecedor);
            pstm.setInt(1, fornecedor.getCod_fornecedor());
            pstm.executeUpdate();
            conexao.desconecta();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        }
    }

    public List<FornecedorModel> listarForncedor(String razao_social) {
        List<FornecedorModel> fornecedor = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedor);
            pstm.setString(1, razao_social);
            rs = pstm.executeQuery();
            FornecedorModel forn;
            while (rs.next()) {
                forn = new FornecedorModel();
                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
                forn.setRazao_social(rs.getString("razaoSocial"));
                forn.setNome_fantasia(rs.getString("nomeFantasia"));
                forn.setCNPJ(rs.getString("cnpj"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setFax(rs.getString("fax"));
                forn.setEndereço(rs.getString("endereco"));
                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
                forn.setNome_vendedor(rs.getString("nomeVendedor"));
                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
                forn.setCEP(rs.getString("cep"));
                forn.setEstado(rs.getString("estado"));
                forn.setCidade(rs.getString("cidade"));
                fornecedor.add(forn);

            }
            conexao.desconecta();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    public List<FornecedorModel> listarForncedorCodigo(String cod_fornecedor) {
        List<FornecedorModel> fornecedor = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedorCodigo);
            pstm.setString(1, cod_fornecedor);
            rs = pstm.executeQuery();
            FornecedorModel forn;
            while (rs.next()) {
                forn = new FornecedorModel();
                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
                forn.setRazao_social(rs.getString("razaoSocial"));
                forn.setNome_fantasia(rs.getString("nomeFantasia"));
                forn.setCNPJ(rs.getString("cnpj"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setFax(rs.getString("fax"));
                forn.setEndereço(rs.getString("endereco"));
                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
                forn.setNome_vendedor(rs.getString("nomeVendedor"));
                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
                forn.setCEP(rs.getString("cep"));
                forn.setEstado(rs.getString("estado"));
                forn.setCidade(rs.getString("cidade"));
                fornecedor.add(forn);

            }
            conexao.desconecta();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    public List<FornecedorModel> listarForncedorDescricao(String razao_social) {
        List<FornecedorModel> fornecedor = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedorDescricao);
            pstm.setString(1, razao_social);
            rs = pstm.executeQuery();
            FornecedorModel forn;
            while (rs.next()) {
                forn = new FornecedorModel();
                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
                forn.setRazao_social(rs.getString("razaoSocial"));
                forn.setNome_fantasia(rs.getString("nomeFantasia"));
                forn.setCNPJ(rs.getString("cnpj"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setFax(rs.getString("fax"));
                forn.setEndereço(rs.getString("endereco"));
                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
                forn.setNome_vendedor(rs.getString("nomeVendedor"));
                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
                forn.setCEP(rs.getString("cep"));
                forn.setEstado(rs.getString("estado"));
                forn.setCidade(rs.getString("cidade"));
                fornecedor.add(forn);

            }
            conexao.desconecta();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    public List<FornecedorModel> listarForncedorDescricao1(String razao_social, String cnpj) {
        List<FornecedorModel> fornecedor = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaFornecedorDescricao1);
            pstm.setString(1, razao_social);
            pstm.setString(2, cnpj);
            rs = pstm.executeQuery();
            FornecedorModel forn;
            while (rs.next()) {
                forn = new FornecedorModel();
                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
                forn.setRazao_social(rs.getString("razaoSocial"));
                forn.setNome_fantasia(rs.getString("nomeFantasia"));
                forn.setCNPJ(rs.getString("cnpj"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setFax(rs.getString("fax"));
                forn.setEndereço(rs.getString("endereco"));
                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
                forn.setNome_vendedor(rs.getString("nomeVendedor"));
                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
                forn.setCEP(rs.getString("cep"));
                forn.setEstado(rs.getString("estado"));
                forn.setCidade(rs.getString("cidade"));
                fornecedor.add(forn);

            }
            conexao.desconecta();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    public List<FornecedorModel> listarForncedores() {
        List<FornecedorModel> fornecedor = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            FornecedorModel forn;
            while (rs.next()) {
                forn = new FornecedorModel();
                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
                forn.setRazao_social(rs.getString("razaoSocial"));
                forn.setNome_fantasia(rs.getString("nomeFantasia"));
                forn.setCNPJ(rs.getString("cnpj"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setFax(rs.getString("fax"));
                forn.setEndereço(rs.getString("endereco"));
                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
                forn.setNome_vendedor(rs.getString("nomeVendedor"));
                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
                forn.setCEP(rs.getString("cep"));
                forn.setEstado(rs.getString("estado"));
                forn.setCidade(rs.getString("cidade"));
                fornecedor.add(forn);

            }
            conexao.desconecta();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    public List<FornecedorModel> consultaCNPJ(String cnpj) {
        List<FornecedorModel> fornecedor = new ArrayList();
        try {
            ResultSet rs;
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultacnpj);
            pstm.setString(1, cnpj);
            rs = pstm.executeQuery();
            FornecedorModel forn;
            while (rs.next()) {
                forn = new FornecedorModel();
                forn.setCod_fornecedor(rs.getInt("idfornecedor"));
                forn.setRazao_social(rs.getString("razaoSocial"));
                forn.setNome_fantasia(rs.getString("nomeFantasia"));
                forn.setCNPJ(rs.getString("cnpj"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setFax(rs.getString("fax"));
                forn.setEndereço(rs.getString("endereco"));
                forn.setInsc_estadual(rs.getString("inscricaoEstadual"));
                forn.setInsc_municipal(rs.getString("inscricaoMunicipal"));
                forn.setNome_vendedor(rs.getString("nomeVendedor"));
                forn.setTel_vendedor(rs.getString("telefoneVendedor"));
                forn.setCEP(rs.getString("cep"));
                forn.setEstado(rs.getString("estado"));
                forn.setCidade(rs.getString("cidade"));
                fornecedor.add(forn);

            }
            conexao.desconecta();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
    }
}
