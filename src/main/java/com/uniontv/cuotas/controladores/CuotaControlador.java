/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniontv.cuotas.controladores;

import com.uniontv.cuotas.entidades.Abonado;
import com.uniontv.cuotas.entidades.Cuota;
import com.uniontv.cuotas.entidades.Cuotas;
import com.uniontv.cuotas.repositorios.CuotaRepositorio;
import com.uniontv.cuotas.servicios.CuotaServicio;
import com.uniontv.cuotas.servicios.CuotasServicio;
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
@RequestMapping("/cuota")
public class CuotaControlador {

    @Autowired
    private CuotaServicio cuotaServicio;
    
    @Autowired
    private CuotasServicio cuotasServicio;

    @GetMapping("/agregar")
    public String agregar() {

        return "agregar_cuota";

    }

    @PostMapping("/registro")
    public String registrar(@RequestParam String mes, @RequestParam String anio) {

        cuotaServicio.crearCuota(mes, anio);

        return "index";

    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo) {

        Cuotas cuota = cuotasServicio.buscarCuotaPorId(id);
        
        modelo.put("cuota", cuota);
        
        return "modificar_cuota";

    }
    
    @PostMapping("/modificado/{id}")
    public String modificado(@PathVariable String id, String pagado, String observaciones,
            ModelMap modelo){
        
        cuotasServicio.modificarCuota(id, pagado, observaciones);
        
        modelo.put("exito", "Cuota actualizada correctamente");
        
        return "index";
        
    }

}
