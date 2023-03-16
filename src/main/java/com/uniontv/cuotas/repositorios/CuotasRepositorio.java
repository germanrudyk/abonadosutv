/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.repositorios;

import com.uniontv.cuotas.entidades.Cuotas;
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
public interface CuotasRepositorio extends JpaRepository<Cuotas, String>{
    
    @Query("SELECT c FROM Cuotas c WHERE c.abonado.id = :id")
    public List<Cuotas> listarCuotasPorIdDeAbonado(@Param("id") Integer id);
    
}
