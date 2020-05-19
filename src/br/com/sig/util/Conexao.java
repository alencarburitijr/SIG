/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sig.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author ALENCAR
 */
public class Conexao {

    String driver = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost/medicalpharm";
    String usuario = "root";
    String senha = "";

    Connection conexao;
   //metodo de conexao
   public Conexao(){
       
   }

    public Connection conecta(){

        try {
               Class.forName(driver);
               conexao = DriverManager.getConnection(URL, usuario,senha );
              //JOptionPane.showMessageDialog(null,"conectou");
           }
           catch (ClassNotFoundException ex){
               ex.printStackTrace();
               System.out.println("Nao foi possivel encontrar o driver");
           }
           catch (SQLException ex){
               ex.printStackTrace();
               JOptionPane.showMessageDialog(null,"Nao foi possivel conectar ao banco de dados");
               // System.out.println("Nao foi possivel conectar");
           }
   // System.out.print(conexao);
        return conexao;

    }
    
    public void desconecta(){
        try{
            conexao.close();
         //   JOptionPane.showMessageDialog(null,"banco fechado");
        }
        catch (SQLException fecha){
            JOptionPane.showMessageDialog(null,"nao foi possivel"+
                    "fechar banco de dados "+fecha );
        }
    }
}
