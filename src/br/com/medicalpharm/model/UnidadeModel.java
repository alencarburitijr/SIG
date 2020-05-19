/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

/**
 *
 * @author Alencar
 */
public class UnidadeModel {

    private Integer cod_unidade;
    private String sigla_unidade;
    private String desc_unidade;

    public UnidadeModel() {
    }

    public UnidadeModel(String sigla) {
        this.sigla_unidade = sigla;
    }

    public UnidadeModel(Integer cod_unidade, String sigla_unidade, String desc_unidade) {
        this.cod_unidade = cod_unidade;
        this.sigla_unidade = sigla_unidade;
        this.desc_unidade = desc_unidade;
    }

    public void setCod_unidade(Integer cod_unidade) {
        this.cod_unidade = cod_unidade;
    }

    public void setSigla_unidade(String sigla_unidade) {
        this.sigla_unidade = sigla_unidade;
    }

    public void setDesc_unidade(String desc_unidade) {
        this.desc_unidade = desc_unidade;
    }

    public Integer getCod_unidade() {
        return cod_unidade;
    }

    public String getSigla_unidade() {
        return sigla_unidade;
    }

    public String getDesc_unidade() {
        return desc_unidade;
    }
}
