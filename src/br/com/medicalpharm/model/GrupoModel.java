/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

/**
 *
 * @author Alencar
 */
public class GrupoModel {

    private Integer cod_grupo;
    private String desc_grupo;
    private Object obj;

    public GrupoModel() {
    }

    public GrupoModel(Integer cod_grupo, String desc_grupo) {
        this.cod_grupo = cod_grupo;
        this.desc_grupo = desc_grupo;
    }
    public GrupoModel(Integer cod_grupo) {
        this.cod_grupo = cod_grupo;
    }
    public void setCod_grupo(Integer cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public void setDesc_grupo(String desc_grupo) {
        this.desc_grupo = desc_grupo;
    }

    public Integer getCod_grupo() {
        return cod_grupo;
    }

    public String getDesc_grupo() {
        return desc_grupo;
    }
}
