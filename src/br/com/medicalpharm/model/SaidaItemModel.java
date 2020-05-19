/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

import java.util.Date;

/**
 *
 * @author ALENCAR
 */
public class SaidaItemModel {

    public Integer getCodSaida() {
        return codSaida;
    }

    public void setCodSaida(Integer codSaida) {
        this.codSaida = codSaida;
    }
    private Integer codSaida;
    private ProdutoModel produto;
    private Integer quantidade;
    private String lote;
    private Date vencimento;

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public SaidaModel getSaidaModel() {
        return saidaModel;
    }

    public void setSaidaModel(SaidaModel saidaModel) {
        this.saidaModel = saidaModel;
    }
    private SaidaModel saidaModel;

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
