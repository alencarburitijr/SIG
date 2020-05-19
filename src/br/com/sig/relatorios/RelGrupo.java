/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sig.relatorios;

import br.com.sig.util.Conexao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelGrupo {

PreparedStatement pstm;
ResultSet rs;
    public void setRelatorioGrupo(Integer cod) {
        try{
            String consultaGrupo = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao,"
                    + "produto.quantidade FROM grupo, produto WHERE (grupo_idgrupo = ?) and "
                    + "(grupo.idgrupo = grupo_idgrupo) and (quantidade <>0)";
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo);
            pstm.setInt(1, cod);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport("./jasper/Grupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }
        }
    }



