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
public class Validator {
    
    public static boolean onlyNumber(String number)
    {
        return number.matches("[0-9]{4}");
    }
    
}
