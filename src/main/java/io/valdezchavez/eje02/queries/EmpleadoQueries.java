/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.queries;

import io.valdezchavez.eje02.domain.Empleado;
import io.valdezchavez.eje02.util.Constantes;

/**
 *
 * @author Christian
 */
public enum EmpleadoQueries {
    
    INSERT(String.format(Constantes.INSERT, Empleado.class.getSimpleName(), "nombres,apellidos,remuneracion,edad", "%s,%s,%s,%s"), String.format(Constantes.INSERT, Empleado.class.getSimpleName(), "nombres,apellidos,remuneracion,edad", "?,?,?,?")),
    UPDATE(String.format(Constantes.UPDATE, Empleado.class.getSimpleName(), "nombres = %s,apellidos = %s, remuneracion = %f , edad = %d ", "%d"), String.format(Constantes.UPDATE, Empleado.class.getSimpleName(), "nombres = ?,apellidos = ?, remuneracion = ? , edad = ? ", "?")),
    DELETE(String.format(Constantes.DELETE, Empleado.class.getSimpleName(), "%d"), String.format(Constantes.DELETE, Empleado.class.getSimpleName(), "?")),
    SELECTONE(String.format(Constantes.SELECTONE, "id,nombres,apellidos,remuneracion,edad", Empleado.class.getSimpleName(), "%d"), String.format(Constantes.SELECTONE, "id,nombres, apellidos, remuneracion, edad", Empleado.class.getSimpleName(), "?")),
    SELECTALL(String.format(Constantes.SELECTALL, "id,nombres,apellidos,remuneracion,edad", Empleado.class.getSimpleName()), String.format(Constantes.SELECTALL, "id,nombres, apellidos ,remuneracion, edad", Empleado.class.getSimpleName()));
    
    private final String statement;
    private final String preparedStatement;
    
    EmpleadoQueries(String statement, String preparedStatement)
    {
        this.statement = statement;
        this.preparedStatement = preparedStatement;
    }
    
    public String getQuery(){
        if (Constantes.FACTORYSERVICE == Constantes.STM)
            return this.statement;
        else
            return this.preparedStatement;
    }
    
}
