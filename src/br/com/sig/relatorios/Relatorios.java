/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sig.relatorios;

import br.com.medicalpharm.model.ArmazemModel;
import br.com.medicalpharm.model.GrupoModel;
import br.com.sig.properties.Configuration;
import br.com.sig.util.Conexao;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ALENCAR
 */
public class Relatorios {
PreparedStatement pstm;
ResultSet rs;
private final String url;
    public Relatorios(){
        
        Configuration config = new Configuration();
        url  = config.configuration("prop.relatorio.url");
        System.out.println("pegando url:    "+url);
    }
//private final String url = "C:/SIG/jasper/";

    public void setRelatorioEstoqueProduto(){
        try{
            String consultaGrupo1 = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao,"
                    + " produto.quantidade FROM grupo, produto WHERE (grupo.idgrupo = grupo_idgrupo)"
                    + "AND (quantidade <>0) ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo1);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ItensEstoqueProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setRelatorioEstoqueProduto1(GrupoModel grupo){
        try{
            String consultaGrupo = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao,"
                    + " produto.quantidade FROM grupo, produto WHERE (grupo_idgrupo = ?) and (grupo.idgrupo = grupo_idgrupo)"
                    + "AND (quantidade <>0)ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ItensEstoqueProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }




         public void setRelatorioEstoqueGrupo(){
        try{
            String consultaGrupo1 = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao,"
                    + " produto.quantidade FROM grupo, produto WHERE (grupo.idgrupo = grupo_idgrupo)"
                    + "AND (quantidade <>0) ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo1);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ItensEstoqueGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setRelatorioEstoqueGrupo1(GrupoModel grupo){
        try{
            String consultaGrupo = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao,"
                    + " produto.quantidade FROM grupo, produto WHERE (grupo_idgrupo = ?) and (grupo.idgrupo = grupo_idgrupo)"
                    + "AND (quantidade <>0)ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ItensEstoqueGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }




        public void setRelatorioProduto(){
        try{
            String consultaGrupo1 = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao, "
                    + "produto.quantidade FROM grupo, produto WHERE (grupo.idgrupo = grupo_idgrupo)  "
                    + "ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo1);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ListagemProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setRelatorioProduto1(GrupoModel grupo){
        try{
            String consultaGrupo1 = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao, "
                    + "produto.quantidade FROM grupo, produto WHERE (grupo_idgrupo = ?) and (grupo.idgrupo = grupo_idgrupo)  "
                    + "ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo1);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ListagemProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }

        public void setRelatorioGrupo(){
        try{
            String consultaGrupo1 = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao, "
                    + "produto.quantidade FROM grupo, produto WHERE (grupo.idgrupo = grupo_idgrupo)  "
                    + "ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo1);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ListagemGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setRelatorioGrupo1(GrupoModel grupo){
        try{
            String consultaGrupo1 = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao, "
                    + "produto.quantidade FROM grupo, produto WHERE (grupo_idgrupo = ?) and (grupo.idgrupo = grupo_idgrupo)  "
                    + "ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo1);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ListagemGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }








    public void setRelatorioGrupo(GrupoModel grupo){
        try{
            String consultaGrupo = "SELECT grupo.descGrupo, grupo.idgrupo, produto.descProduto, produto.concentracao,"
                    + "produto.quantidade FROM grupo, produto WHERE (grupo_idgrupo = ?) and "
                    + "(grupo.idgrupo = grupo_idgrupo) and (quantidade <>0)";
            Conexao conexao = new Conexao();
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consultaGrupo);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"Grupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }
        }


        public void setEstoqueMinimoProduto(){//consultar estoque minimo e ordenar por produto com todos os grupos
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, "
                    + "produto.quantidade, grupo.descGrupo FROM produto, grupo WHERE (estMinimo>quantidade) "
                    + "&& (grupo.idgrupo = grupo_idgrupo) ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueMinimoProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setEstoqueMinimoProduto(GrupoModel grupo){//consultar estoque minimo por produto com grupos mandados por paramentro
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, "
                    + "produto.quantidade, grupo.descGrupo FROM produto, grupo WHERE (grupo_idgrupo = ?) AND "
                    + "(estMinimo>=quantidade) && (grupo.idgrupo = grupo_idgrupo) ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueMinimoProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }


        public void setEstoqueMinimoGrupo(){
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, produto.quantidade, "
                    + "grupo.descGrupo FROM produto, grupo WHERE (estMinimo>=quantidade) && "
                    + "(grupo.idgrupo = grupo_idgrupo) ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueMinimoGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setEstoqueMinimoGrupo(GrupoModel grupo){
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, produto.quantidade, "
                    + "grupo.descGrupo FROM produto, grupo WHERE (grupo_idgrupo = ?) and (estMinimo>=quantidade) && "
                    + "(grupo.idgrupo = grupo_idgrupo) ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueMinimoGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }






        public void setEstoqueIdealProduto(){//consultar estoque minimo e ordenar por produto com todos os grupos
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, produto.quantidade, "
                    + "grupo.descGrupo FROM produto, grupo WHERE (estIdeal>=quantidade) && "
                    + "(grupo.idgrupo = grupo_idgrupo) ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueIdealProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setEstoqueIdealProduto(GrupoModel grupo){//consultar estoque minimo por produto com grupos mandados por paramentro
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, produto.quantidade, "
                    + "grupo.descGrupo FROM produto, grupo WHERE (grupo_idgrupo = ?) and (estIdeal>=quantidade) && "
                    + "(grupo.idgrupo = grupo_idgrupo) ORDER BY produto.descProduto";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueIdealProduto.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }


        public void setEstoqueIdealGrupo(){
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, produto.quantidade, "
                    + "grupo.descGrupo FROM produto, grupo WHERE (estIdeal>=quantidade) && "
                    + "(grupo.idgrupo = grupo_idgrupo) ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueIdealGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
        public void setEstoqueIdealGrupo(GrupoModel grupo){//consulta estoque ideal ordenado por grupo passando um grupo por parametro
        try{
            String consulta = "SELECT idProduto, descProduto,concentracao, estIdeal, estMinimo, produto.quantidade, "
                    + "grupo.descGrupo FROM produto, grupo WHERE (grupo_idgrupo = ?) and (estIdeal>=quantidade) && "
                    + "(grupo.idgrupo = grupo_idgrupo) ORDER BY grupo.descGrupo";
            Conexao conexao = new Conexao();

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setInt(1, grupo.getCod_grupo());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueIdealGrupo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
    public void setMovimentoDestino(java.util.Date data1, java.util.Date data2){
        try{
            String consulta = "SELECT saida.`idsaida` AS saida_idsaida, saida.`dataRetirada` AS saida_dataRetirada,"
                    + " saida.`destino_idDestino` AS saida_destino_idDestino,saidaitem.`idsaidaItem` AS saidaitem_idsaidaItem,"
                    + "saidaitem.`quantidade` AS saidaitem_quantidade, saidaitem.`produto_idproduto` AS saidaitem_produto_idproduto,"
                    + "saidaitem.`saida_idsaida` AS saidaitem_saida_idsaida,destino.`idDestino` AS destino_idDestino,"
                    + "destino.`descDestino` AS destino_descDestino,produto.`idproduto` AS produto_idproduto,produto.`descProduto` AS produto_descProduto,"
                    + "produto.`quantidade` AS produto_quantidade, produto.`concentracao` AS produto_concentracao FROM`saida` saida INNER JOIN `saidaitem` saidaitem ON saida.`idsaida` = saidaitem.`saida_idsaida`"
                    + "INNER JOIN `destino` destino ON saida.`destino_idDestino` = destino.`idDestino`"
                    + "INNER JOIN `produto` produto ON saidaitem.`produto_idproduto` = produto.`idproduto` WHERE (saida.dataRetirada between ? and ?) ORDER BY saida.dataRetirada";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            //pstm.setInt(1, destino.getCod_destino());
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"MovimentoDestino.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }

        public void setMovimentoDestino(ArmazemModel destino, java.util.Date data1, java.util.Date data2){//consulta estoque ideal ordenado por grupo passando um grupo por parametro
        try{
//            String consulta = "SELECT descProduto, concentracao, saida.dataRetirada, saidaitem.quantidade,  "
//                    + "destino.descDestino FROM saida, saidaitem, produto, destino WHERE (destino.iddestino = ?) and (saida.idsaida = "
//                    + "saidaitem.saida_idsaida) AND ( produto_idproduto = produto.idproduto) AND "
//                    + "(destino_idDestino = destino.idDestino)";
            String consulta = "SELECT saida.`idsaida` AS saida_idsaida, saida.`dataRetirada` AS saida_dataRetirada,"
                    + " saida.`destino_idDestino` AS saida_destino_idDestino,saidaitem.`idsaidaItem` AS saidaitem_idsaidaItem,"
                    + "saidaitem.`quantidade` AS saidaitem_quantidade, saidaitem.`produto_idproduto` AS saidaitem_produto_idproduto,"
                    + "saidaitem.`saida_idsaida` AS saidaitem_saida_idsaida,destino.`idDestino` AS destino_idDestino,"
                    + "destino.`descDestino` AS destino_descDestino,produto.`idproduto` AS produto_idproduto,produto.`descProduto` AS produto_descProduto,"
                    + "produto.`quantidade` AS produto_quantidade, produto.`concentracao` AS produto_concentracao FROM`saida` saida INNER JOIN `saidaitem` saidaitem ON saida.`idsaida` = saidaitem.`saida_idsaida`"
                    + "INNER JOIN `destino` destino ON saida.`destino_idDestino` = destino.`idDestino`"
                    + "INNER JOIN `produto` produto ON saidaitem.`produto_idproduto` = produto.`idproduto` WHERE (saida.dataRetirada between ? and ?) and (destino_iddestino = ?) ORDER BY saida.dataRetirada";

            Conexao conexao = new Conexao();

            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            //pstm.setInt(1, destino.getCod_destino());
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            pstm.setInt(3, destino.getCod_destino());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"MovimentoDestino.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }

    public void setVencidos(){
        try{
            String consulta = "SELECT codProduto, data, lote, tbvencimento.quantidade, produto.quantidade, "
                    + "produto.concentracao, produto.descProduto FROM produto, TbVencimento WHERE "
                    + "(TbVencimento.quantidade<>0)and (produto.idproduto = codProduto) and (SELECT CURDATE() > data)"
                    + "ORDER BY data";

            Conexao conexao = new Conexao();


            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"ProdutosVencidos.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }

    public void relatorioSaida(){
        try{
            String consulta = "SELECT relatoriovencimento.cod_produto, produto.descProduto, produto.idproduto, produto.concentracao,                    relatoriovencimento.lote, relatoriovencimento.vencimento,relatoriovencimento.quantidade FROM relatoriovencimento, produto WHERE(produto.idproduto = cod_produto)";

            Conexao conexao = new Conexao();


            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"relatorioSaida.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }

        public void relatorioMédia(java.util.Date data1, java.util.Date data2){
        try{
            String consulta = "SELECT descproduto, `concentracao` , avg( `quantidade` ) FROM `wsaidadestino`"
                    + " WHERE (`dataMovimento` >= ?) AND (`dataMovimento` <= ?)"
                    + " GROUP BY descproduto, `concentracao`";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"Média.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
    public void relatorioMédiaDestino(java.util.Date data1, java.util.Date data2,ArmazemModel destino){
        try{
            String consulta = "SELECT descproduto, `concentracao`,descDestino , avg( `quantidade` )"
                    + "FROM `wsaidadestino`WHERE (`dataMovimento` >= ?)AND "
                    + "(`dataMovimento` <= ?) AND (`destino_idDestino` = ?)"
                    + "GROUP BY descproduto, `concentracao`,descDestino";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            pstm.setInt(3, destino.getCod_destino());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"Média Destino.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }
    public void relatorioConsumo(java.util.Date data1, java.util.Date data2){
        try{
            String consulta = "SELECT *FROM `wsaidadestino`WHERE `dataMovimento` >= ?"
                    + "AND `dataMovimento` <= ? AND `motivoMovimento` = ? ORDER BY dataMovimento";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());
            String motivo = "consumo";
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            pstm.setString(3, motivo);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"RetiradaConsumo.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){

        }
    }

   
     public void relatorioConsumoDestino(java.util.Date data1, java.util.Date data2,ArmazemModel destino){
        try{
           String consulta = "SELECT *FROM `wsaidadestino`WHERE `dataMovimento` >= ?"
                    + "AND `dataMovimento` <= ? AND `motivoMovimento` = ? AND `destino_idDestino` = ? ORDER BY dataMovimento";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());
            String motivo = "consumo";

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            pstm.setString(3, motivo);
            pstm.setInt(4, destino.getCod_destino());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"RetiradaConsumoDestino.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }

       public void relatorioDescarte(java.util.Date data1, java.util.Date data2){
         try{
            String consulta = "SELECT *FROM `wsaidadestino`WHERE `dataMovimento` >= ?"
                    + "AND `dataMovimento` <= ? AND `motivoMovimento` = ? ORDER BY dataMovimento";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());
            String motivo = "descarte";
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            pstm.setString(3, motivo);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"RetiradaDescarte.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){

        }

    }
     public void relatorioDescarteDestino(java.util.Date data1, java.util.Date data2,ArmazemModel destino){
        try{
           String consulta = "SELECT *FROM `wsaidadestino`WHERE `dataMovimento` >= ?"
                    + "AND `dataMovimento` <= ? AND `motivoMovimento` = ? AND `destino_idDestino` = ? ORDER BY dataMovimento";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());
            String motivo = "descarte";

            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            pstm.setString(3, motivo);
            pstm.setInt(4, destino.getCod_destino());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"RetiradaDescarteDestino.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
        }

    }

       public void relatorioAVencer(java.util.Date data1, java.util.Date data2){
         try{
            String consulta = "SELECT *FROM `wvencimento`WHERE (`data` >= ?)AND (`data` < ?)"
                    + "AND (`quantidade` >0) ORDER BY data, descProduto";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"AVencer.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){
            erro.printStackTrace();
                    
            

        }

    }
       
       public void relatorioAVencerArmazem(java.util.Date data1, java.util.Date data2){
         try{
            String consulta = "SELECT *FROM `warmazem`WHERE ( vencimento >= ?)AND "
                    + "(vencimento < ?)AND (quantidade >0) ORDER BY vencimento";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"AVencerArmazem.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){

        }

    }
       
       public void relatorioAVencerArmazem1(java.util.Date data1, java.util.Date data2,ArmazemModel destino){
         try{
            String consulta = "SELECT *FROM `warmazem`WHERE ( vencimento >= ?)AND "
                    + "(vencimento < ?)AND (quantidade >0) AND (idDestino = ?) ORDER BY vencimento";

            Conexao conexao = new Conexao();
            Date dataInicio = null;
            if(data1 != null)
                dataInicio = new Date(data1.getTime());
            Date dataFim = null;
            if(data2 != null)
            dataFim = new Date(data2.getTime());            
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
            pstm.setDate(1, (java.sql.Date) dataInicio);//erro na passagem de parametro
            pstm.setDate(2, (java.sql.Date) dataFim);
            pstm.setInt(3, destino.getCod_destino());
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"AVencerArmazem.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){

        }

    }
       
       
       public void estoqueArmazem(){
         try{
            String consulta = "SELECT descProduto, idproduto, concentracao,descDestino, siglaUnidade, SUM(quantidade) FROM `warmazem` GROUP BY descProduto, concentracao, descDestino";

            Conexao conexao = new Conexao();
          
            pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
          
            rs = pstm.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if(totalRegistro>0){
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(url+"EstoqueArmazem.jasper", new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            }else{
                    JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                }
        }catch (Exception erro){

        }

    }
       
        public void relatorioRequisicoes(){                      
            try {
                String consulta = "SELECT `usuario_requisitor`.`nome`,`usuario`.`nomeUsuario`,`veiculo`.`descricao`,`requisicao`.`data_emissao` FROM `requisicao`,`veiculo`,`usuario_requisitor`,`usuario` WHERE  `requisicao`.`usuario_requisitor` = `usuario_requisitor`.`codigo_requisitor` AND `requisicao`.`usuario_estoquista` = `usuario`.`idusuario` AND `requisicao`.`veiculo` = `veiculo`.`codigo`";
               
                Conexao conexao = new Conexao();

                pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
                rs = pstm.executeQuery();
                rs.afterLast();//mover apos a ultima linha
                rs.previous(); //entao ir para ultima linha
                int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
                rs.beforeFirst();//retornar ao primeiro resultado
                if(totalRegistro>0){
                    JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                    Map parametros = new HashMap();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(url+"relatorio_requisicao.jasper", new HashMap(), jrRS);
                    JasperViewer.viewReport(jasperPrint, false);
                }else{
                        JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                    }
            } catch (SQLException erro) {
                erro.printStackTrace();
            } catch (JRException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void relatorioDevolucaoRequisicao(int idRequisicao,Date data){
            try {
                //String consulta = "SELECT `usuario_requisitor`.`nome`,`usuario`.`nomeUsuario`,`veiculo`.`descricao`,`requisicao`.`data_emissao` FROM `requisicao`,`veiculo`,`usuario_requisitor`,`usuario` WHERE  `requisicao`.`usuario_requisitor` = `usuario_requisitor`.`codigo_requisitor` AND `requisicao`.`usuario_estoquista` = `usuario`.`idusuario` AND `requisicao`.`veiculo` = `veiculo`.`codigo`";
                String consulta = "SELECT `requisicao`.`codigo_requisicao`,\n" +
                                    "		`usuario`.`nomeUsuario`, \n" +
                                    "        `usuario_requisitor`.`nome`,\n" +
                                    "        `veiculo`.`descricao`,\n" +
                                    "        `produto`.`descProduto`,\n" +
                                    "        `requisicoes`.`qtd`,\n" +
                                    "        `requisicoes`.`data`\n" +
                                    "        FROM \n" +
                                    "        `requisicoes`,`requisicao`,`usuario`,`usuario_requisitor`,`produto`,`veiculo` \n" +
                                    "        WHERE \n" +
                                    "		`requisicoes`.`codigo_requisicao` = ? AND \n" +
                                    "        `requisicao`.`codigo_requisicao` = ? AND\n" +
                                    "        `requisicoes`.`tipo` = 'D' AND\n" +
                                    "        `usuario`.`idusuario` = `requisicao`.`usuario_estoquista` AND\n" +
                                    "        `usuario_requisitor`.`codigo_requisitor` = `requisicao`.`usuario_requisitor` AND\n" +
                                    "        `veiculo`.`codigo` = `requisicao`.`veiculo` AND\n" +
                                    "        `produto`.`idproduto` = `requisicoes`.`produto` AND\n" +
                                    "        `requisicoes`.`data` = ?";
                Conexao conexao = new Conexao();

                pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
                pstm.setInt(1, idRequisicao);
                pstm.setInt(2, idRequisicao);
                pstm.setDate(3, (java.sql.Date)data);
                rs = pstm.executeQuery();
                rs.afterLast();//mover apos a ultima linha
                rs.previous(); //entao ir para ultima linha
                int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
                rs.beforeFirst();//retornar ao primeiro resultado
                if(totalRegistro>0){
                    JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                    Map parametros = new HashMap();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(url+"relatorioDevolucaoProduto.jasper", new HashMap(), jrRS);
                    //C:\medicaPharm\Medical Drugs\jasper
                    JasperViewer.viewReport(jasperPrint, false);
                }else{
                        JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                    }
            } catch (SQLException erro) {
                erro.printStackTrace();
            } catch (JRException ex) {
                int selectedOption = JOptionPane.showConfirmDialog(null, "Não foi possivel imprimir relatório\nDeseja imprimir novamente?", "Erro", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    relatorioDevolucaoRequisicao(idRequisicao,data);
                }
            }
        }
        
        public void relatorioNovaRequisicao(int idRequisicao){
             try {
                //String consulta = "SELECT `usuario_requisitor`.`nome`,`usuario`.`nomeUsuario`,`veiculo`.`descricao`,`requisicao`.`data_emissao` FROM `requisicao`,`veiculo`,`usuario_requisitor`,`usuario` WHERE  `requisicao`.`usuario_requisitor` = `usuario_requisitor`.`codigo_requisitor` AND `requisicao`.`usuario_estoquista` = `usuario`.`idusuario` AND `requisicao`.`veiculo` = `veiculo`.`codigo`";
                String consulta = "SELECT `requisicao`.`codigo_requisicao`,\n" +
                                    "		`usuario`.`nomeUsuario`, \n" +
                                    "        `usuario_requisitor`.`nome`,\n" +
                                    "        `veiculo`.`descricao`,\n" +
                                    "        `produto`.`descProduto`,\n" +
                                    "        `requisicoes`.`qtd`\n" +
                                    "        FROM \n" +
                                    "        `requisicoes`,`requisicao`,`usuario`,`usuario_requisitor`,`produto`,`veiculo` \n" +
                                    "        WHERE \n" +
                                    "		`requisicoes`.`codigo_requisicao` = ? AND \n" +
                                    "        `requisicao`.`codigo_requisicao` = ? AND\n" +
                                    "        `requisicoes`.`tipo` = 'E' AND\n" +
                                    "        `usuario`.`idusuario` = `requisicao`.`usuario_estoquista` AND\n" +
                                    "        `usuario_requisitor`.`codigo_requisitor` = `requisicao`.`usuario_requisitor` AND\n" +
                                    "        `veiculo`.`codigo` = `requisicao`.`veiculo` AND\n" +
                                    "        `produto`.`idproduto` = `requisicoes`.`produto`";
                Conexao conexao = new Conexao();
             
               
                pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
                pstm.setInt(1, idRequisicao);
                pstm.setInt(2, idRequisicao);
                rs = pstm.executeQuery();
                rs.afterLast();//mover apos a ultima linha
                rs.previous(); //entao ir para ultima linha
                int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
                rs.beforeFirst();//retornar ao primeiro resultado
                if(totalRegistro>0){
                    JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                    Map parametros = new HashMap();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(url+"relatorioNovaRequisicao.jasper", new HashMap(), jrRS);
                    JasperViewer.viewReport(jasperPrint, false);
                }else{
                        JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                    }
            } catch (SQLException erro) {
                erro.printStackTrace();
            } catch (JRException ex) {
                int selectedOption = JOptionPane.showConfirmDialog(null, "Não foi possivel imprimir relatório\nDeseja imprimir novamente?", "Erro", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    relatorioNovaRequisicao(idRequisicao);
                }
            }
        }
        
        public void relatorioEdicaoRequisicao(int idRequisicao,Date data){
            try {
                //String consulta = "SELECT `usuario_requisitor`.`nome`,`usuario`.`nomeUsuario`,`veiculo`.`descricao`,`requisicao`.`data_emissao` FROM `requisicao`,`veiculo`,`usuario_requisitor`,`usuario` WHERE  `requisicao`.`usuario_requisitor` = `usuario_requisitor`.`codigo_requisitor` AND `requisicao`.`usuario_estoquista` = `usuario`.`idusuario` AND `requisicao`.`veiculo` = `veiculo`.`codigo`";
                String consulta = "SELECT `requisicao`.`codigo_requisicao`,\n" +
                                    "		`usuario`.`nomeUsuario`, \n" +
                                    "        `usuario_requisitor`.`nome`,\n" +
                                    "        `veiculo`.`descricao`,\n" +
                                    "        `produto`.`descProduto`,\n" +
                                    "        `requisicoes`.`qtd`,\n" +
                                    "        `requisicoes`.`data`\n" +
                                    "        FROM \n" +
                                    "        `requisicoes`,`requisicao`,`usuario`,`usuario_requisitor`,`produto`,`veiculo` \n" +
                                    "        WHERE \n" +
                                    "		`requisicoes`.`codigo_requisicao` = ? AND \n" +
                                    "        `requisicao`.`codigo_requisicao` = ? AND\n" +
                                    "        `requisicoes`.`tipo` = 'E' AND\n" +
                                    "        `usuario`.`idusuario` = `requisicao`.`usuario_estoquista` AND\n" +
                                    "        `usuario_requisitor`.`codigo_requisitor` = `requisicao`.`usuario_requisitor` AND\n" +
                                    "        `veiculo`.`codigo` = `requisicao`.`veiculo` AND\n" +
                                    "        `produto`.`idproduto` = `requisicoes`.`produto` AND\n" +
                                    "        `requisicoes`.`data` = ?";
                Conexao conexao = new Conexao();
                
                pstm = (PreparedStatement) conexao.conecta().prepareStatement(consulta);
                pstm.setInt(1, idRequisicao);
                pstm.setInt(2, idRequisicao);
                pstm.setDate(3,(java.sql.Date)data);
                rs = pstm.executeQuery();
                rs.afterLast();//mover apos a ultima linha
                rs.previous(); //entao ir para ultima linha
                int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
                rs.beforeFirst();//retornar ao primeiro resultado
                if(totalRegistro>0){
                    JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                    Map parametros = new HashMap();
                    JasperPrint jasperPrint = JasperFillManager.fillReport(url+"relatorioEditarRequisicao.jasper", new HashMap(), jrRS);
                    JasperViewer.viewReport(jasperPrint, false);
                }else{
                        JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
                    }
            } catch (SQLException erro) {
                //JOptionPane.showMessageDialog(null, "Não foi possivel fazer a impressão no sql");

            } catch (JRException ex) {
                int selectedOption = JOptionPane.showConfirmDialog(null, "Não foi possivel imprimir relatório\nDeseja imprimir novamente?", "Erro", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    relatorioEdicaoRequisicao(idRequisicao,data);
                }
            }
        }



    }

