/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

/**
 *
 * @author ALENCAR
 */
public class SubGrupoModel {
    private Integer idSubGrupo;
    private String descSubGrupo;
    private GrupoModel grupo;


    
    /**
     * @return the idSubGrupo
     */
    public Integer getIdSubGrupo() {
        return idSubGrupo;
    }
    public SubGrupoModel (){
        
    }
    /**
     * @param idSubGrupo the idSubGrupo to set
     */
    public void setIdSubGrupo(Integer idSubGrupo) {
        this.idSubGrupo = idSubGrupo;
    }
    public SubGrupoModel(Integer idSubGrupo, String descSubGrupo) {
        this.idSubGrupo = idSubGrupo;
        this.descSubGrupo = descSubGrupo;
    }

    /**
     * @return the descSubGrupo
     */
    public String getDescSubGrupo() {
        return descSubGrupo;
    }

    /**
     * @param descSubGrupo the descSubGrupo to set
     */
    public void setDescSubGrupo(String descSubGrupo) {
        this.descSubGrupo = descSubGrupo;
    }

    /**
     * @return the grupo
     */
    public GrupoModel getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(GrupoModel grupo) {
        this.grupo = grupo;
    }
    
}
