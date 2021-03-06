/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ALENCAR
 */
public class SaidaModel {

    public Integer getIdsaida() {
        return idsaida;
    }

    public void setIdsaida(Integer idsaida) {
        this.idsaida = idsaida;
    }
    private Integer idsaida;
    private ArmazemModel destino;
    private Date dataSaida;
    private List<SaidaItemModel> itensSaida;    
    private Integer idVeiculo;
    private String veiculoDescricao;

    public String getVeiculoDescricao() {
        return veiculoDescricao;
    }

    public void setVeiculoDescricao(String veiculoDescricao) {
        this.veiculoDescricao = veiculoDescricao;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
   
    public List<SaidaItemModel> getItensSaida() {
        return itensSaida;
    }

    public void setItensSaida(List<SaidaItemModel> itensSaida) {
        this.itensSaida = itensSaida;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public ArmazemModel getDestino() {
        return destino;
    }

    public void setDestino(ArmazemModel destino) {
        this.destino = destino;
    }
}
