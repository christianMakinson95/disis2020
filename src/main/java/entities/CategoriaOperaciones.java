package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_operaciones")
public class CategoriaOperaciones extends EntidadPersistente{

    @Column(name = "descripcion")
    private String descripcion;

    //getters y setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
