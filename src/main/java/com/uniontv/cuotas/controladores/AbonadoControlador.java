/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.controladores;

import com.uniontv.cuotas.entidades.Abonado;
import com.uniontv.cuotas.entidades.Cuotas;
import com.uniontv.cuotas.servicios.AbonadoServicio;
import com.uniontv.cuotas.servicios.CuotasServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author German
 */
@Controller
@RequestMapping("/abonado")
public class AbonadoControlador {

    @Autowired
    private AbonadoServicio abonadoServicio;
    
    @Autowired
    private CuotasServicio cuotasServicio;
    
    @GetMapping("/lista")
    public String buscar(ModelMap modelo) {

        List<Abonado> abonados = abonadoServicio.listarAbonados();
        
        modelo.put("abonados", abonados);
        
        return "ver_lista_de_busqueda";

    }

    @PostMapping("/buscar/{nombre}")
    public String buscar(@PathVariable String nombre, ModelMap modelo) {

        List<Abonado> abonados = abonadoServicio.listarAbonadosPorNombre(nombre);
        
        modelo.put("abonados", abonados);
        
        return "ver_lista_de_busqueda";

    }

    @GetMapping("/agregar")
    public String agregar() {

        return "agregar_abonado";

    }
    
    @PostMapping("/registro")  
    public String registrar(@RequestParam String nombre, @RequestParam String dni,
            @RequestParam String domicilio){
        
        abonadoServicio.crearAbonado(nombre, dni, domicilio);
        
        return "index";
        
    }
    
  
    
    @GetMapping("/modificar")
    public String modificar() {

        return "modificar_abonado";

    }
    
    @GetMapping("/{id}")
    public String verCuota(@PathVariable Integer id, ModelMap modelo){
        
        Abonado abonado = abonadoServicio.buscarAbonadoPorId(id);
        
        List<Cuotas> cuotas = new ArrayList();
        
        cuotas = cuotasServicio.listarCuotasPorIdDeAbonado(abonado.getId());
        
        modelo.put("cuotas", cuotas);
        
        return "ver_abonado";
        
    }

}
