/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class PropertiesFilee {
    private static PropertiesFilee instance;
    private static Properties properties;

    private static Properties init() throws IOException {
        if(properties==null){
        
            properties = new Properties();
            try {
                properties.load(new FileInputStream("congif/dbconfig.properties"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PropertiesFilee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return properties;
    }

    public PropertiesFilee() {
        try {
            PropertiesFilee.init();
        } catch (IOException ex) {
            Logger.getLogger(PropertiesFilee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PropertiesFilee getInstance() {
        if(instance==null){
        
            instance= new PropertiesFilee();
        }
        return instance;
    }
    
    public String get(String key){
    
        return properties.getProperty(key);
    }
    
    public void set(String key, String value){
    
        properties.setProperty(key, value);
        try {
            properties.store(new FileOutputStream("config/config.properties"), "Configuration");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesFilee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesFilee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
