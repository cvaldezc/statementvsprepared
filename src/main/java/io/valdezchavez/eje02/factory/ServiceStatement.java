/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.factory;

import io.valdezchavez.eje02.domain.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ServiceStatement extends FactoryService {

    private ConnectDB db;

    public ServiceStatement() {
        db = new ConnectDB();
    }

    @Override
    public int executeQuery(String query, Object[] param) throws SQLException {
        int status = 0;
        try (
                Connection cn = db.getConnection();
                Statement ps = cn.createStatement()) {
            status = ps.executeUpdate(query);
        }
        return status;
    }

    @Override
    public List<Empleado> getEntities(String query, Object[] param) throws SQLException {
        List<Empleado> listemp = new ArrayList<>();
        try (Connection cn = db.getConnection();
                Statement ps = cn.createStatement();) {
            ResultSet rs = ps.executeQuery(query);
            Empleado emp;
            while (rs.next()) {
                emp = new Empleado();
                emp.setId(rs.getInt("id"));
                emp.setNombres(rs.getString("nombres"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setRemuneracion(rs.getDouble("remuneracion"));
                emp.setEdad(rs.getInt("edad"));
                listemp.add(emp);
            }
        }
        return listemp;
    }
}


