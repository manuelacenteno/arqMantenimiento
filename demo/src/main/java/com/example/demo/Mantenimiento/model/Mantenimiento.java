package com.example.demo.Mantenimiento.model;




import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Mantenimiento {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMantenimiento;
    @Column
    private String tarea;
    @Column
    private Integer idMonopatin;
    @Column
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
