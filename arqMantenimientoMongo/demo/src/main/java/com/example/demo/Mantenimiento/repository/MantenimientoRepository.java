package com.example.demo.Mantenimiento.repository;




import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.Mantenimiento.model.Mantenimiento;




@EnableMongoRepositories
public class MantenimientoRepository extends MongoRepositoryBean<Mantenimiento, ObjectId> {
    
}
