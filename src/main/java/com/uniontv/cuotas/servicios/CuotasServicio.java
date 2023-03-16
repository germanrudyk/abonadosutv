/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.servicios;

import com.uniontv.cuotas.entidades.Abonado;
import com.uniontv.cuotas.entidades.Cuota;
import com.uniontv.cuotas.entidades.Cuotas;
import com.uniontv.cuotas.repositorios.CuotasRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author German
 */

@Service
public class CuotasServicio {
    
    @Autowired
    private AbonadoServicio abonadoServicio;    
    
    @Autowired
    private CuotasRepositorio cuotasRepositorio;
    
    public void crearCuotas(Cuota cuota){        
        
        List<Abonado> abonados = abonadoServicio.listarAbonados();
        
        for (Abonado abonado : abonados) {
            
            Cuotas cuotas = new Cuotas();
            
            cuotas.setAbonado(abonado);
            cuotas.setCuota(cuota);
            cuotas.setPagado("En Deuda");
            cuotasRepositorio.save(cuotas);
            
        }
        
    }
    
    public void modificarCuota(String id, String pagado, String observaciones){
        
        Cuotas cuota = buscarCuotaPorId(id);
        
        cuota.setPagado(pagado);
        cuota.setObservaciones(observaciones);
        
        cuotasRepositorio.save(cuota);
        
    }
    
    public List<Cuotas> listarCuotasPorIdDeAbonado(Integer id){
        
        List<Cuotas> cuotas = new ArrayList();
        cuotas = cuotasRepositorio.listarCuotasPorIdDeAbonado(id);
        return cuotas;
        
    }
    
    public Cuotas buscarCuotaPorId(String id){
        
        Optional<Cuotas> respuesta = cuotasRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            return respuesta.get();
            
        }
        
        return null;
        
    }
    
}
