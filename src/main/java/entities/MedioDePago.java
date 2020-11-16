package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medio_de_pago")
public class MedioDePago extends EntidadPersistente{

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "numero")
    private long numero;

    public MedioDePago(String descripcion, long numero) {
        this.descripcion = descripcion;
        this.numero = numero;
    }

    public MedioDePago(){};

    public String getDescripcion() {
        return descripcion;
    }

    public long getNumero() {
        return numero;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
}