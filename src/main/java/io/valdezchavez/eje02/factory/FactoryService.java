/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.factory;

import io.valdezchavez.eje02.domain.Empleado;
import io.valdezchavez.eje02.util.Constantes;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Christian
 */
public abstract class FactoryService {

    public static FactoryService obtenerClienteDao(int tipo) {
        FactoryService servicio;
        switch (tipo) {
            case Constantes.STM:
                servicio = new ServiceStatement();
                break;
            case Constantes.PST:
                servicio = new ServicePreparedStatement();
                break;
            default:
                servicio = null;
        }
        return servicio;
    }
    
    public abstract int executeQuery(String query, Object[] param) throws SQLException;
    
    public abstract List<Empleado> getEntities(String query, Object[] params) throws SQLException;
}
