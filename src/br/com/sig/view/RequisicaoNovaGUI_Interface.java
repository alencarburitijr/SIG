/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.view;

import br.com.medicalpharm.model.ProdutoModel;
import br.com.medicalpharm.model.UsuarioRequisitanteModel;
import br.com.medicalpharm.model.VeiculoModel;

/**
 *
 * @author willi
 */
public interface RequisicaoNovaGUI_Interface {
    public void carregaProduto(ProdutoModel produto);
    public void carregarUsuario(UsuarioRequisitanteModel requisitante);
    public void carregarVeiculo(VeiculoModel veiculo);
    public void listarRequisicoesAction();
}
