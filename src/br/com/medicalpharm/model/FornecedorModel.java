/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

/**
 *
 * @author Alencar
 */
public class FornecedorModel {

    private Integer cod_fornecedor;
    private String razao_social;

    public FornecedorModel(Integer cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public FornecedorModel(Integer cod_fornecedor, String razao_social) {
        this.cod_fornecedor = cod_fornecedor;
        this.razao_social = razao_social;
    }
    private String nome_fantasia;
    private String endereço;
    private String CEP;
    private String CNPJ;
    private String telefone;
    private String fax;
    private String estado;
    private String cidade;
    private String insc_estadual;
    private String insc_municipal;
    private String tel_vendedor;
    private String nome_vendedor;

    public FornecedorModel() {
    }

    public void setCod_fornecedor(Integer cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setInsc_estadual(String insc_estadual) {
        this.insc_estadual = insc_estadual;
    }

    public void setInsc_municipal(String insc_municipal) {
        this.insc_municipal = insc_municipal;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public void setTel_vendedor(String tel_vendedor) {
        this.tel_vendedor = tel_vendedor;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCod_fornecedor() {
        return cod_fornecedor;

    }

    public String getCEP() {
        return CEP;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereço() {
        return endereço;
    }

    public String getEstado() {
        return estado;
    }

    public String getFax() {
        return fax;
    }

    public String getInsc_estadual() {
        return insc_estadual;
    }

    public String getInsc_municipal() {
        return insc_municipal;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public String getTel_vendedor() {
        return tel_vendedor;
    }

    public String getTelefone() {
        return telefone;
    }
}
