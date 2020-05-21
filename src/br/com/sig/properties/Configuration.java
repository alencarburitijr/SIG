/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sig.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author william
 */
public class Configuration {
    
    public String configuration(String properties){     
        try{ 
            Properties prop = getProp();
            String diretorio = prop.getProperty(properties);
            return diretorio;        
        }catch(Exception ex){
            return null;   
        }
    }
     
    private static Properties getProp() throws IOException {
        File dir1 = new File (".");
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(dir1.getCanonicalPath()+"/properties/configuration.properties");
        props.load(file);
        return props;
    }
    
    private void load(FileInputStream file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}

