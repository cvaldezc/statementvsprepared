/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.util;

/**
 *
 * @author Christian
 */
public class Constantes {
    
    public static final String INSERT = "INSERT INTO %s (%s) VALUES(%s)";
    public static final String UPDATE = "UPDATE %s SET %s WHERE id = %s";
    public static final String DELETE = "DELETE FROM %s WHERE id = %s";
    public static final String SELECTONE = "SELECT %s FROM %s WHERE id = %s";
    public static final String SELECTALL = "SELECT %s FROM %s";
    
    public static int FACTORYSERVICE = 1;
    
    public static final int STM = 0;
    public static final int PST = 1;
}
