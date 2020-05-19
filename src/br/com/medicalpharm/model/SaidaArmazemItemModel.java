/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.medicalpharm.model;

/**
 *
 * @author ALENCAR
 */
public class SaidaArmazemItemModel {

    private SaidaArmazemModel armazemModel;
    private Integer idArmazemItem;
    private ProdutoModel produto;
    private Integer quantidade;

    /**
     * @return the armazemModel
     */
    public SaidaArmazemModel getArmazemModel() {
        return armazemModel;
    }

    /**
     * @param armazemModel the armazemModel to set
     */
    public void setArmazemModel(SaidaArmazemModel armazemModel) {
        this.armazemModel = armazemModel;
    }

    /**
     * @return the idArmazemItem
     */
    public Integer getIdArmazemItem() {
        return idArmazemItem;
    }

    /**
     * @param idArmazemItem the idArmazemItem to set
     */
    public void setIdArmazemItem(Integer idArmazemItem) {
        this.idArmazemItem = idArmazemItem;
    }

    /**
     * @return the produto
     */
    public ProdutoModel getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
