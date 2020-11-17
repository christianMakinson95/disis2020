package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proveedor")
public class Proveedor extends EntidadPersistente {

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private DireccionPostal direccionPostal;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Articulo> productos;

    //getters y setters


    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DireccionPostal getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(DireccionPostal direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public List<Articulo> getProductos() {
        return productos;
    }

    public void setProductos(List<Articulo> productos) { this.productos = productos; }

    public Proveedor() {
    }
}