package com.example.demo.Mantenimiento.services;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Mantenimiento.dtos.ReporteMonopatinesDTO;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class MonopatinService {

    @Value("${monopatinURL}")
    private String monopatinURL;

    private final RestTemplate rest;

    public MonopatinService(RestTemplate rest) {
        this.rest = rest;
    }

    public List<ReporteMonopatinesDTO> getReporte(String authorization) {
        String url = monopatinURL + "/reporteMonopatines";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<ReporteMonopatinesDTO>> response = rest.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<ReporteMonopatinesDTO>>() {});

        return response.getBody();
    }

}
