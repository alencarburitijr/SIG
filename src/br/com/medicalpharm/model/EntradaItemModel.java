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
public class EntradaItemModel {

    private EntradaModel entradaModel;
    private Integer idEntrada;
    private ProdutoModel produto;
    private String lote;
    private Double preco;
    private Integer qnt;
    private Date vencimento;

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    /**
     * @return the idproduto
     */
    /**
     * @return the produto
     */
    public ProdutoModel getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    /**
     * @return the lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the qnt
     */
    public Integer getQnt() {
        return qnt;
    }

    /**
     * @param qnt the qnt to set
     */
    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    /**
     * @return the vencimento
     */
    public Date getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public EntradaModel getEntradaModel() {
        return entradaModel;
    }

    public void setEntradaModel(EntradaModel entradaModel) {
        this.entradaModel = entradaModel;
    }
}
