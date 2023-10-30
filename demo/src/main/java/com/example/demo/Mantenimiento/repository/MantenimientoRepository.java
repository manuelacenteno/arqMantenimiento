package com.example.demo.Mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Mantenimiento.model.Mantenimiento;
import com.example.demo.Usuario.model.Usuario;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
    
}
