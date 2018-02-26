/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class ConnectDB {
    
    private final String database;

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.2.116:3306/" + database,
                    "root", "qwerty");
        } catch (SQLException 
                | ClassNotFoundException 
                | InstantiationException 
                | IllegalAccessException e) {
            e.printStackTrace();
        }

        return cn;
    }

    public ConnectDB() {
        this.database = "bdPlanilla"; 
    }

    public ConnectDB(String database) {
        this.database = database;
    }
}
