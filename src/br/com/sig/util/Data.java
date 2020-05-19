/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sig.util;

//import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alencar
 */
public class Data {
    public String mes, dia, ano, dia_semana,hora;
    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm:ss");

    public void le_hora(){
        Date horaAtual = new Date();
        hora = horaformatada.format(horaAtual);
    }
    public void le_data(){
        Date data = new Date();
        mes = ""+data.getMonth();//0 a 11;
        dia = ""+data.getDate();
        ano = ""+(1900+data.getYear());
        dia_semana = ""+data.getDay();
/*
        switch(data.getMonth()){
            case 0: mes = "Janeiro";break;
            case 1: mes = "Fevereiro";break;
            case 2: mes = "Março";break;
            case 3: mes = "Abril";break;
            case 4: mes = "Maio";break;
            case 5: mes = "Junho";break;
            case 6: mes = "Julho";break;
            case 7: mes = "Agosto";break;
            case 8: mes = "Setembro";break;
            case 9: mes = "Outubro";break;
            case 10: mes = "Novembro";break;
            case 11: mes = "Dezembro";break;
        
    }

 */
    }
    
    /**
     * Esse metodo recebe uma data no formato 0000-00-00 e retorna ela como 00-00-0000 
     * @param data
     * @param tipo
     * @return 
     */
    public String inverterData(String data,String tipo){
        String d = null,r = null;
        if(tipo.equals("sql")){ 
            d = "-";r = "/";
        }else if(tipo.equals("normal")){
            d = "/";r = "-";
        }else{
            return null;
        }
        String[] dividir;
       
            dividir = data.split(d);
            return dividir[2]+r+dividir[1]+r+dividir[0];
       
       //return null;
    }
   


}
