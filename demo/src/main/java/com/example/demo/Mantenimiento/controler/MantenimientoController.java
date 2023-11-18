package com.example.demo.Mantenimiento.controler;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Mantenimiento.dtos.ReporteMonopatinesDTO;
import com.example.demo.Mantenimiento.model.Mantenimiento;
import com.example.demo.Mantenimiento.repository.MantenimientoRepository;
import com.example.demo.Mantenimiento.services.MonopatinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController {

    @Autowired
    private MantenimientoRepository repo;

    @Autowired
    private MonopatinService monopatinService;

    @GetMapping
    public List<Mantenimiento> listarMantenimientos(){
        return repo.findAll();
    }

    @PostMapping
    public void grabarMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        repo.save(mantenimiento);
    }


    @GetMapping("/pedirReporteMonopatines")
    public List<ReporteMonopatinesDTO> pedirReporte(@RequestHeader("Authorization") String authorization) {
        System.out.println(authorization);
        List<ReporteMonopatinesDTO> reporte = monopatinService.getReporte(authorization);
        return reporte;
    }
    
}
