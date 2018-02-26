/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.factory;

import io.valdezchavez.eje02.domain.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class ServicePreparedStatement extends FactoryService {

    private ConnectDB db;

    public ServicePreparedStatement() {
        db = new ConnectDB();
    }

    @Override
    public int executeQuery(String query, Object[] param) throws SQLException {
        System.out.println("QUERY EXECUTE " + query);
        int status = 0;
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query)) {
            for (int i = 0; i < param.length; i++) {
                Object object = param[i];
                System.out.println(" " + i + " " + object);
                ps.setObject(i + 1, object);
            }
            status = ps.executeUpdate();
        }
        return status;
    }

    @Override
    public List<Empleado> getEntities(String query, Object[] params) throws SQLException {
        System.out.println("QUERY EXECUTE " + query);
        List<Empleado> listemp = new ArrayList<>();
        try(
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query);
                ) {
            for (int i = 0; i < params.length; i++) {
                Object object = params[i];
                System.out.println(" " + i + " " + object);
                ps.setObject(i + 1, object);
            }
            ResultSet rs = ps.executeQuery();
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
