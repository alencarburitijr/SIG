/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

import java.util.Date;

/**
 *
 * @author willi
 */
public class RequisicoesProdutoModel {
    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String tipo;
    private Integer codigoRequisicao;
    private String produto;
    private Integer qtd;    
    private Date data_devolucao;
    private Date data_emissao;
    private Integer saldo;
           
    private Integer qtdDevolvida;
    private String usuarioEstoquista;

    public String getUsuarioEstoquista() {
        return usuarioEstoquista;
    }

    public void setUsuarioEstoquista(String usuarioEstoquista) {
        this.usuarioEstoquista = usuarioEstoquista;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
    
    public Integer getQtdDevolvida() {
        return qtdDevolvida;
    }

    public void setQtdDevolvida(Integer qtdDevolvida) {
        this.qtdDevolvida = qtdDevolvida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCodigoRequisicao() {
        return codigoRequisicao;
    }

    public void setCodigoRequisicao(Integer codigoRequisicao) {
        this.codigoRequisicao = codigoRequisicao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }
    
    
    
}
