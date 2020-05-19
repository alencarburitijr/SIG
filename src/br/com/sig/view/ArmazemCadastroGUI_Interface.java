/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.view;

import br.com.medicalpharm.model.ArmazemModel;
import br.com.medicalpharm.model.ProdutoModel;
import br.com.medicalpharm.model.UsuarioRequisitanteModel;
import br.com.medicalpharm.model.VeiculoModel;

/**
 *
 * @author ALENCAR
 */
public interface ArmazemCadastroGUI_Interface {
    public void carregaProduto(ProdutoModel produto);
    public void carregaDestino(ArmazemModel armazem);
    public void setStatusTela(boolean status);
    public void carregarUsuarioRequisitante(UsuarioRequisitanteModel requisitante);
    //public void statusTela(boolean status);
    public void carregarVeiculo(VeiculoModel veiculo);
}
