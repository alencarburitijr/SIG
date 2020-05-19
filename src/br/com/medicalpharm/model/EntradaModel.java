/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

import java.util.Date;
import java.util.List;

public class EntradaModel {

    private Integer idEntrada;
    private FornecedorModel fornecedor;
    private String notaFiscal;
    private String nSérie;
    private Date emissao;
    private Date lancamento;
    //  private List<EntradaItemModel> itensNotaFiscal;

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    /**
     * @return the fornecedor
     */
    public FornecedorModel getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the notaFiscal
     */
    public String getNotaFiscal() {
        return notaFiscal;
    }

    /**
     * @param notaFiscal the notaFiscal to set
     */
    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    /**
     * @return the nSérie
     */
    public String getnSérie() {
        return nSérie;
    }

    /**
     * @param nSérie the nSérie to set
     */
    public void setnSérie(String nSérie) {
        this.nSérie = nSérie;
    }

    /**
     * @return the emissao
     */
    public Date getEmissao() {
        return emissao;
    }

    /**
     * @param emissao the emissao to set
     */
    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    /**
     * @return the lancamento
     */
    public Date getLancamento() {
        return lancamento;
    }

    /**
     * @param lancamento the lancamento to set
     */
    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }
//    public List<EntradaItemModel> getItensNotaFiscal() {
//        return itensNotaFiscal;
//    }
//
//    public void setItensNotaFiscal(List<EntradaItemModel> itensNotaFiscal) {
//        this.itensNotaFiscal = itensNotaFiscal;
//    }
}
