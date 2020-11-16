package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "entidad_base")
public class EntidadBase extends EntidadPersistente {

    @Column(name = "nombre_ficticio")
    private String nombreFicticio;

    @Column(name = "descripcion")
    private String descripcion;

    //getters y setters

    public String getNombreFicticio() {
        return nombreFicticio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EntidadBase(String nombreFicticio, String descripcion) {
        this.nombreFicticio = nombreFicticio;
        this.descripcion = descripcion;
    }
}