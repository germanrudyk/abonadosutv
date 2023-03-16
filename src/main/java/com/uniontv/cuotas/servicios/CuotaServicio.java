/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.servicios;

import com.uniontv.cuotas.entidades.Cuota;
import com.uniontv.cuotas.repositorios.CuotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author German
 */

@Service
public class CuotaServicio {
    
    @Autowired
    private CuotasServicio cuotasServicio;
    
    @Autowired
    private CuotaRepositorio cuotaRepositorio;
    
    public void crearCuota(String mes, String anio){      
        
        Cuota cuota = new Cuota();
        
        cuota.setMes(mes);
        cuota.setAnio(anio);
        
        cuotaRepositorio.save(cuota);
        
        cuotasServicio.crearCuotas(cuota);
        
    }
    
}
