/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.repositorios;

import com.uniontv.cuotas.entidades.Abonado;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author German
 */

@Repository
public interface AbonadoRepositorio extends JpaRepository<Abonado, Integer>{
    
    @Query("SELECT a FROM Abonado a")
    public List<Abonado> listarAbonados();
    
    @Query("SELECT a FROM Abonado a WHERE a.nombre = :nombre")
    public List<Abonado> listarAbonadosPorNombre(@Param("nombre") String nombre);
    
}
