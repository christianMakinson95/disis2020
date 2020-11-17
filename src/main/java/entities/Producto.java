package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("producto")
public class Producto extends Articulo {

    @Column(name = "tipo_producto")
    private String tipoProducto;

    public Producto(String nombre, int precio, String descripcion, int cantidadArticulos) {
        super(nombre, precio, descripcion, cantidadArticulos);
    }

    //getter y setter

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Producto(){}
}