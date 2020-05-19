/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

import java.util.Date;

/**
 *
 * @author William
 */
public class RequisicoesModel {
  
    public static String usuarioNome1;
    private Integer codigo_requisicao;
    private Date data_emissao;
    private String usuario_requisitor;
    private String usuario_estoquista;
    private String codigo_veiculo;
//    private String descricao;

    public String getCodigo_veiculo() {
        return codigo_veiculo;
    }

    public void setCodigo_veiculo(String codigo_veiculo) {
        this.codigo_veiculo = codigo_veiculo;
    }

    public Integer getCodigo_requisicao() {
        return codigo_requisicao;
    }

    public void setCodigo_requisicao(Integer codigo_requisicao) {
        this.codigo_requisicao = codigo_requisicao;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getUsuario_requisitor() {
        return usuario_requisitor;
    }

    public void setUsuario_requisitor(String usuario_requisitor) {
        this.usuario_requisitor = usuario_requisitor;
    }

    public String getUsuario_estoquista() {
        return usuario_estoquista;
    }

    public void setUsuario_estoquista(String usuario_estoquista) {
        this.usuario_estoquista = usuario_estoquista;
    }
    
    
}
