/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

import java.util.Date;

/**
 *
 * @author Alencar
 */
public class ProdutoModel {

    private Integer cod_produto;
    private String nome_produto;
    private String concentraçao;
    private Integer estoque_ideal;
    private Integer estoque_minimo;
    private Double ultimo_preco;
    private GrupoModel grupo;
    private UnidadeModel unidade;
    private Integer estoque;
    private Date data;
    private SubGrupoModel subGrupo;

    public ProdutoModel(Integer cod_produto, String nome_produto, String concentraçao) {
        this.cod_produto = cod_produto;
        this.nome_produto = nome_produto;
        this.concentraçao = concentraçao;
    }

    public ProdutoModel(Integer cod_produto) {
        this.cod_produto = cod_produto;
    }

    public ProdutoModel() {
    }

    public Integer getEstoque() {
        return estoque;
    }

    public String getConcentraçao() {
        return concentraçao;
    }

    public void setConcentraçao(String concentraçao) {
        this.concentraçao = concentraçao;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setCod_produto(Integer cod_produto) {
        this.cod_produto = cod_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setEstoque_ideal(Integer estoque_ideal) {
        this.estoque_ideal = estoque_ideal;
    }

    public void setEstoque_minimo(Integer estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public Integer getCod_produto() {
        return cod_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public Integer getEstoque_ideal() {
        return estoque_ideal;
    }

    public Integer getEstoque_minimo() {
        return estoque_minimo;
    }

    public GrupoModel getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoModel grupo) {
        this.grupo = grupo;
    }

    public UnidadeModel getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeModel unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the ultimo_preco
     */
    public Double getUltimo_preco() {
        return ultimo_preco;
    }

    /**
     * @param ultimo_preco the ultimo_preco to set
     */
    public void setUltimo_preco(Double ultimo_preco) {
        this.ultimo_preco = ultimo_preco;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the subGrupo
     */
    public SubGrupoModel getSubGrupo() {
        return subGrupo;
    }

    /**
     * @param subGrupo the subGrupo to set
     */
    public void setSubGrupo(SubGrupoModel subGrupo) {
        this.subGrupo = subGrupo;
    }
}
