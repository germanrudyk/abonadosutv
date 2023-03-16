/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.servicios;

import com.uniontv.cuotas.entidades.Abonado;
import com.uniontv.cuotas.repositorios.AbonadoRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author German
 */

@Service
public class AbonadoServicio {
    
    @Autowired
    private AbonadoRepositorio abonadoRepositorio;
    
    public void crearAbonado(String nombre, String dni, String domicilio){
        
        Abonado abonado = new Abonado();
        
        abonado.setNombre(nombre);
        abonado.setDni(dni);
        abonado.setDomicilio(domicilio);
        abonado.setAlta(new Date());
        
        abonadoRepositorio.save(abonado);
        
    }
    
    public List<Abonado> listarAbonados(){
        
        List<Abonado> abonados = new ArrayList();
        abonados = abonadoRepositorio.findAll();
        return abonados;
        
    }
    
    public List<Abonado> listarAbonadosPorNombre(String nombre){
        
        List<Abonado> abonados = new ArrayList();
        abonados = abonadoRepositorio.listarAbonadosPorNombre(nombre);
        return abonados;
        
    }
    
    public Abonado buscarAbonadoPorId(Integer id){
        
        Optional<Abonado> respuesta = abonadoRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            return respuesta.get();
            
        }
        
        return null;
        
    }
    
}
