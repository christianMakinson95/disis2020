package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proveedor")
public class Proveedor extends EntidadPersistente {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private int DNI;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private DireccionPostal direccionPostal;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Articulo> productos;

    //getters y setters


    public Proveedor(String nombre, String apellido, int DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
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