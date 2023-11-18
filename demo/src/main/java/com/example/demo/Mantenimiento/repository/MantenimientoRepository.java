package com.example.demo.Mantenimiento.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Mantenimiento.model.Mantenimiento;

@Repository
public interface MantenimientoRepository extends MongoRepository<Mantenimiento, ObjectId> {

}

