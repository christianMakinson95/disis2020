package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("servicio")
public class Servicio extends Articulo {
    @Column(name = "duracion")
    private int duracion;

    public Servicio(String nombre, int precio, String descripcion, int cantidadArticulos) {
        super(nombre, precio, descripcion, cantidadArticulos);
    }

    //getter y setter

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}