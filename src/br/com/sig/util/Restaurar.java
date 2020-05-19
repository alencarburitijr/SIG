/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Restaurar.java
 *
 * Created on 17/07/2011, 15:34:05
 */
package br.com.sig.util;

import java.io.File;
import java.sql.Connection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author michel
 */
public class Restaurar extends javax.swing.JFrame {
//Connection con = null; //variável para usar em conexão de banco de dados.
Process proc;

    /** Creates new form Restaurar */
    public Restaurar() {
        initComponents();
        
        try {
            Conexao conexao = new Conexao();
            conexao.conecta();//Conecta ao banco de dados 
            JFC_Backup.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFC_Backup = new javax.swing.JFileChooser();
        JB_BT_Restaurar_Mysql = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurar Backup");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JB_BT_Restaurar_Mysql.setText("Restaurar Backup");
        JB_BT_Restaurar_Mysql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_BT_Restaurar_MysqlActionPerformed(evt);
            }
        });
        getContentPane().add(JB_BT_Restaurar_Mysql, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        setSize(new java.awt.Dimension(309, 125));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_BT_Restaurar_MysqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_BT_Restaurar_MysqlActionPerformed
        // TODO add your handling code here:
        try {
   JFC_Backup.setVisible(true);  
               String bd = "medicalpharm";
  int result = JFC_Backup.showOpenDialog(null); 
 
  if(result == JFileChooser.OPEN_DIALOG){
  
                File bkp;  
            bkp = JFC_Backup.getSelectedFile();  
           String arq = bkp.getPath();  
           System.out.println("bd "+ bd);
           System.out.println("arq "+ arq); 
           
String[] cmd = new String[3];
               cmd[0] = "cmd.exe" ;
                cmd[1] = "/C" ;
                 cmd[2] = "c:\\wamp\\bin\\mysql\\mysql5.5.8\\bin\\mysql -u root -proot -h localhost "+bd+" < "+arq ;
                 
         Runtime rt = Runtime.getRuntime();
            System.out.println("Execing " + cmd[0] + " " + cmd[1]);
            proc = rt.exec(cmd);
            
                        // any error message?
            StreamGobbler errorGobbler = new 
            StreamGobbler(proc.getErrorStream(), "ERROR");            
            
            // any output?
            StreamGobbler outputGobbler = new 
            StreamGobbler(proc.getInputStream(), "OUTPUT");
                
            // kick them off
            errorGobbler.run();
            outputGobbler.run();
                                    
            // any error???
            int exitVal = proc.waitFor();
      
       
                        if (exitVal == 0){  
                JOptionPane.showMessageDialog(null, "Backup Restaurado com sucesso !");  
            }  
            else{  
                JOptionPane.showMessageDialog(null, "Falha ao restaurar backup. \n Verifique as configurações ou entre em contato com o suporte !");  
            }
}
           
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);            
        }        
    }//GEN-LAST:event_JB_BT_Restaurar_MysqlActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Restaurar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_BT_Restaurar_Mysql;
    private javax.swing.JFileChooser JFC_Backup;
    // End of variables declaration//GEN-END:variables
}
