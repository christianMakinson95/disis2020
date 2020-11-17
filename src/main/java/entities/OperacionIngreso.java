package entities;


import Dominio.Vinculador.VinculacionEstablecida;
import ValidadorTransparencia.ValidadorDeTransparencia;
import exception.ValidadorTransparenciaException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operacion_ingreso")
public class OperacionIngreso extends EntidadPersistente {

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaIngreso", columnDefinition = "DATE")
    private LocalDate fechaIngreso;

    @Column(name = "monto_total")
    private double montoTotal;

    @OneToMany(cascade = CascadeType.ALL)
    private List <OperacionEgreso> egresosVinculados;

    public OperacionIngreso(String descripcion, double montoTotal, LocalDate fechaIngreso) {
        this.descripcion = descripcion;
        this.montoTotal = montoTotal;
        this.fechaIngreso = fechaIngreso;
    }
    public OperacionIngreso(){};

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaIngreso() {return fechaIngreso;}

    public void setFechaIngreso(LocalDate fechaIngreso){this.fechaIngreso = fechaIngreso;}

    public void setEgresosVinculados(List<OperacionEgreso> opEg){this.egresosVinculados = opEg;}

    public List<OperacionEgreso> getEgresosVinculados(){return egresosVinculados;}

}


