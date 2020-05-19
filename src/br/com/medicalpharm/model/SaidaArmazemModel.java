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
public class SaidaArmazemModel {

    private Integer idArmazem;
    private Date dataMovimento;
    private String motivo;
    private ArmazemModel destino;

    public Integer getIdrequisitante() {
        return idrequisitante;
    }

    public void setIdrequisitante(Integer idrequisitante) {
        this.idrequisitante = idrequisitante;
    }

    public String getNomeRequisitante() {
        return NomeRequisitante;
    }

    public void setNomeRequisitante(String NomeRequisitante) {
        this.NomeRequisitante = NomeRequisitante;
    }

    public Integer getCodigoVeiculo() {
        return codigoVeiculo;
    }

    public void setCodigoVeiculo(Integer codigoVeiculo) {
        this.codigoVeiculo = codigoVeiculo;
    }

    public String getDescricaoVeiculo() {
        return descricaoVeiculo;
    }

    public void setDescricaoVeiculo(String descricaoVeiculo) {
        this.descricaoVeiculo = descricaoVeiculo;
    }
    
    private Integer idrequisitante;
    private String NomeRequisitante;
    private Integer codigoVeiculo;
    private String descricaoVeiculo;

    /**
     * @return the idArmazem
     */
    public Integer getIdArmazem() {
        return idArmazem;
    }

    /**
     * @param idArmazem the idArmazem to set
     */
    public void setIdArmazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    /**
     * @return the dataMovimento
     */
    public Date getDataMovimento() {
        return dataMovimento;
    }

    /**
     * @param dataMovimento the dataMovimento to set
     */
    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the destino
     */
    public ArmazemModel getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(ArmazemModel destino) {
        this.destino = destino;
    }
}
