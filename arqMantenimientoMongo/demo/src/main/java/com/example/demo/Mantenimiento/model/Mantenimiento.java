package com.example.demo.Mantenimiento.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Mantenimiento")
public class Mantenimiento {
     @Id
    private Integer idMantenimiento;
    private String tarea;
    private Integer idMonopatin;

    private Date fecha;

    public Mantenimiento(){
        super();
    
    }

    public Mantenimiento(String tarea, Integer idMonopatin, Date fecha){
        this.tarea = tarea;
        this.idMonopatin = idMonopatin;
        this.fecha = fecha;
    }

     public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Integer getIdMonopatin() {
        return idMonopatin;
    }

    public void setIdMonopatin(Integer idMonopatin) {
        this.idMonopatin = idMonopatin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
