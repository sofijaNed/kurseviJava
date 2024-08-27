/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import prop.PropertiesFilee;

/**
 *
 * @author Sofija Nedeljkovic
 */
public class DatabaseFactoryRepository {
    private Connection connection;
    private static DatabaseFactoryRepository instance;
    private String url = null;
    private String username = null;
    private String password = null;
    
    private DatabaseFactoryRepository(){
        
    }
    
    public static DatabaseFactoryRepository getInstance(){
        if(instance==null) instance = new DatabaseFactoryRepository();
        return instance;
    }
    
    public Connection getConnection() throws Exception{
         if (connection == null || connection.isClosed()) {
             
           Properties properties = new Properties();
            properties.load(new FileInputStream("config/dbconfig.properties"));
//             OutputStream output = null;
//             
//             output = new FileOutputStream("config/dbconfig.properties");
//             properties.setProperty("url", "");
//             properties.setProperty("username", "");
//             properties.setProperty("password", "");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
