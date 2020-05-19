/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

/**
 *
 * @author Alencar
 */
public class UsuarioModel {

    public UsuarioModel(Integer cod_usuário, String nome_usuario) {
        this.cod_usuário = cod_usuário;
        this.nome_usuario = nome_usuario;
    }
    private Integer cod_usuário;
    private String nome_usuario;
    private String login;
    private String senha;
    private String permissao;

    public UsuarioModel() {
    }

    public void setCod_usuario(Integer cod_usuário) {
        this.cod_usuário = cod_usuário;
    }

    public void setNome_usuário(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;

    }

    public Integer getCod_usuario() {
        return cod_usuário;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    /**
     * @return the permissao
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
