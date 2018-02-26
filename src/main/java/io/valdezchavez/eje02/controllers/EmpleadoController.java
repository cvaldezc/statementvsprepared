/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.controllers;

import io.valdezchavez.eje02.daos.EmpleadoDAOImpl;
import io.valdezchavez.eje02.domain.Empleado;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 *
 * @author Christian
 */
public class EmpleadoController {

    public boolean insert(Empleado entity) throws SQLException {
        return (new EmpleadoDAOImpl().insert(entity) == 1);
    }

    public boolean update(Empleado entity) throws SQLException {
        return (new EmpleadoDAOImpl().update(entity) == 1);
    }

    public boolean delete(Empleado entity) throws SQLException {
        return (new EmpleadoDAOImpl().delete(entity) == 1);
    }

    public Empleado getEntity(int id) throws SQLException {

        return new EmpleadoDAOImpl().getEntity(id);
    }

    public List<Empleado> getEntities() throws SQLException {
        return new EmpleadoDAOImpl().getEntities();
    }

    public Empleado getLastElement() throws SQLException {
        
        return this.getEntities()
            .stream().sorted((o1, o2) -> o1.getEdad() - o2.getEdad()).reduce((first, second) -> second).orElse(new Empleado());
    }

    public boolean todosMayor1850() throws SQLException {
        List<Empleado> list = this.getEntities();
        int filter = (int) list.stream()
                .filter(pr -> pr.getRemuneracion() > 1850)
                .count();
        return (list.size() == filter);
    }

    public List<Empleado> sueldoMayoryEdadMenoryApellidoNOC() throws SQLException {
        return this.getEntities().stream()
                .filter(pr -> pr.getRemuneracion() > 1100)
                .filter(pr -> pr.getEdad() < 38)
                .filter(pr -> !String.valueOf(pr.getApellidos().charAt(0)).equals("C"))
                .collect(Collectors.toList());
    }

    public List<Empleado> sueldoBruto() throws SQLException {
        return this.getEntities().stream()
                .map((Empleado s) -> {
                    return new Empleado(s.getId(), s.getNombres(), s.getApellidos(), s.getRemuneracion(), s.getEdad(), (s.getRemuneracion() * 15));
                })
                .peek(s -> System.out.println(s.toString()))
                .collect(Collectors.toList());
    }

    public double sueldoPromedio() throws SQLException {
        return this.getEntities().stream()
                .filter(pr -> pr.getEdad() > 35)
                .flatMapToDouble(sa -> DoubleStream.of(sa.getRemuneracion()))
                .average()
                .orElse(0);
    }

}
