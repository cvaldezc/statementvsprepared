/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.generics;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Christian
 * @param <T>
 */
public interface GenericEntity<T> {
    
    public int insert(T entity) throws SQLException;
    public int update(T entity) throws SQLException;
    public int delete(T entity) throws SQLException;
    public T getEntity(int id) throws SQLException;
    public List<T> getEntities() throws SQLException;
    
}
