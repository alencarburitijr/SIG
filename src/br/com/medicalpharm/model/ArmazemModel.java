/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

/**
 *
 * @author Alencar
 */
public class ArmazemModel {

    private Integer cod_destino;
    private String desc_destino;

    public ArmazemModel(Integer cod_destino) {
        this.cod_destino = cod_destino;
    }

    public ArmazemModel(Integer cod_destino, String desc_destino) {
        this.cod_destino = cod_destino;
        this.desc_destino = desc_destino;
    }

    public ArmazemModel() {
    }

    public void setCod_destino(Integer cod_destino) {
        this.cod_destino = cod_destino;
    }

    public void setDesc_destino(String desc_destino) {
        this.desc_destino = desc_destino;
    }

    public Integer getCod_destino() {
        return cod_destino;
    }

    public String getDesc_destino() {
        return desc_destino;
    }
}
