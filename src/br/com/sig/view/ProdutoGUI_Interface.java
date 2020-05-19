/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sig.view;

import br.com.medicalpharm.model.GrupoModel;
import br.com.medicalpharm.model.UnidadeModel;

/**
 *
 * @author ALENCAR
 */
public interface ProdutoGUI_Interface {
    public void carregaGrupo(GrupoModel grupo);
    public void carregaUnidade(UnidadeModel unidade);
    public void setStatusTela(boolean status);
    public void requestGrupo();
    public void requestUnidade();
}
