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

import com.example.demo.Mantenimiento.dtos.ReporteMonopatinesDTO;
import com.example.demo.Mantenimiento.model.Mantenimiento;
import com.example.demo.Mantenimiento.repository.MantenimientoRepository;
import com.example.demo.Mantenimiento.servicios.MonopatinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public void grabarMantenimiento(@RequestBody String mantenimiento) throws JsonMappingException, JsonProcessingException{
        ObjectMapper prueba = new ObjectMapper();
        Map<String,String> pruebva2 = prueba.readValue(mantenimiento, Map.class);
        String tarea = (String)pruebva2.get("tarea");
        String idMonopatin = (String)pruebva2.get("idMonopatin");
        Integer id = Integer.parseInt(idMonopatin);
        LocalDate fecha = LocalDate.now();
        Date fechaHoy = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
    
        System.out.println(tarea + id+ fechaHoy);
        Mantenimiento m = new Mantenimiento(tarea,id,fechaHoy);
        repo.save(m);
    }

    @GetMapping("/pedirReporteMonopatines")
    public List<ReporteMonopatinesDTO> pedirReporte() {
        List<ReporteMonopatinesDTO> reporte = monopatinService.getReporte();
        return reporte;
    }

}
