package com.example.demo.Mantenimiento.controler;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mantenimiento.dtos.ReporteMonopatinesDTO;
import com.example.demo.Mantenimiento.model.Mantenimiento;
import com.example.demo.Mantenimiento.repository.MantenimientoRepository;
import com.example.demo.Mantenimiento.services.MonopatinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;



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
    
    @SuppressWarnings("unchecked")
    @PostMapping
    public void grabarMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        repo.save(mantenimiento);
    }


    @GetMapping("/pedirReporteMonopatines")
    public List<ReporteMonopatinesDTO> pedirReporte() {
        List<ReporteMonopatinesDTO> reporte = monopatinService.getReporte();
        return reporte;
    }
    
}
