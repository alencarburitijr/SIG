/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.view;

import br.com.medicalpharm.model.FornecedorModel;
import br.com.medicalpharm.model.ProdutoModel;

/**
 *
 * @author ALENCAR
 */
public interface AjusteEstoqueGUI_Interface {

    public void carregaProduto(ProdutoModel produto);

    public void carregaFornecedor(FornecedorModel fornecedor);

    public void setStatusTela(boolean status);
}
