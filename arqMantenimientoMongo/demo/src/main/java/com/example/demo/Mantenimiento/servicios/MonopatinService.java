package com.example.demo.Mantenimiento.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Mantenimiento.dtos.ReporteMonopatinesDTO;

@Service
public class MonopatinService {
    @Value("${monopatinURL}")
    private String monopatinURL;

    private final RestTemplate rest;

    public MonopatinService(RestTemplate rest) {
        this.rest = rest;
    }

    public List<ReporteMonopatinesDTO> getReporte() {
        String url = monopatinURL+"/reporteMonopatines";
        System.out.println(monopatinURL);
        ResponseEntity<List<ReporteMonopatinesDTO>> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ReporteMonopatinesDTO>>() {});
                return response.getBody();
    }

}
