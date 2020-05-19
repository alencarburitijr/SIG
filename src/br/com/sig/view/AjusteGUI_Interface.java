/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.view;

import br.com.medicalpharm.model.UsuarioModel;

/**
 *
 * @author ALENCAR
 */
public interface AjusteGUI_Interface {
    public void setStatusTela(boolean status);
    public void setDesabilitaTela();
    public void carregaUsuario(UsuarioModel usuario);
}
