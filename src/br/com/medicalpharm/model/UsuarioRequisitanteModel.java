package br.com.medicalpharm.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class UsuarioRequisitanteModel {
    
    private Integer codigo_requisitante;
    private String nome_requisitante;
    private String cpf;
    
    public Integer getCodigo_requisitante() {
        return codigo_requisitante;
    }

    public void setCodigo_requisitante(Integer codigo_requisitante) {
        this.codigo_requisitante = codigo_requisitante;
    }

    public String getNome_requisitante() {
        return nome_requisitante;
    }

    public void setNome_requisitante(String nome_requisitante) {
        this.nome_requisitante = nome_requisitante;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
