/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.daos;

import io.valdezchavez.eje02.domain.Empleado;
import io.valdezchavez.eje02.factory.FactoryService;
import io.valdezchavez.eje02.generics.EmpleadoDAO;
import io.valdezchavez.eje02.queries.EmpleadoQueries;
import io.valdezchavez.eje02.util.Constantes;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Christian
 */
public class EmpleadoDAOImpl implements EmpleadoDAO<Empleado> {

    @Override
    public int insert(Empleado entity) throws SQLException {
        return FactoryService.obtenerClienteDao(Constantes.FACTORYSERVICE).executeQuery(String.format(EmpleadoQueries.INSERT.getQuery(), "'" + entity.getNombres() + "'", "'" + entity.getApellidos() + "'", "" + entity.getRemuneracion() + "", "" + entity.getEdad() + ""), entity.toParams());
    }

    @Override
    public int update(Empleado entity) throws SQLException {
        return FactoryService.obtenerClienteDao(Constantes.FACTORYSERVICE).executeQuery(String.format(EmpleadoQueries.UPDATE.getQuery(), "'" + entity.getNombres() + "'", "'" + entity.getApellidos() + "'", entity.getRemuneracion(), entity.getEdad(), entity.getId()), new Object[] {entity.getNombres(), entity.getApellidos(), entity.getRemuneracion(), entity.getEdad(), entity.getId()} );
    }

    @Override
    public int delete(Empleado entity) throws SQLException {
        return FactoryService.obtenerClienteDao(Constantes.FACTORYSERVICE).executeQuery(String.format(EmpleadoQueries.DELETE.getQuery(), entity.getId()), new Object[]{ entity.getId() });
    }

    @Override
    public Empleado getEntity(int id) throws SQLException {
        return FactoryService.obtenerClienteDao(Constantes.FACTORYSERVICE).getEntities(String.format(EmpleadoQueries.SELECTONE.getQuery(), id), new Object[]{id}).stream().findFirst().orElse(new Empleado());
    }

    @Override
    public List<Empleado> getEntities() throws SQLException {
        return FactoryService.obtenerClienteDao(Constantes.FACTORYSERVICE).getEntities(String.format(EmpleadoQueries.SELECTALL.getQuery()), new Object[]{});
    }
}
