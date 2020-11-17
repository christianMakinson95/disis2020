package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_articulo")
@Table(name= "articulo")
public class Articulo extends EntidadPersistente {



    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private float precio;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad_articulos")
    private int cantidadArticulos;

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    //setters

    public Articulo(){};

    public Articulo(String nombre, float precio, String descripcion, int cantidadArticulos) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidadArticulos = cantidadArticulos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}