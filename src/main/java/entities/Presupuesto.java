package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "presupuesto")
public class Presupuesto extends EntidadPersistente{

    @Column(name = "total_presupuesto")
    private double totalPresupuesto;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Articulo> articulosPresupuesto;

    public Presupuesto(double totalPresupuesto, List<Articulo> articulosPresupuesto){
        this.totalPresupuesto=totalPresupuesto;
        this.articulosPresupuesto=articulosPresupuesto;
    }

    public double getTotalPresupuesto() {
        return totalPresupuesto;
    }

    public void setTotalPresupuesto(double totalPresupuesto) {
        this.totalPresupuesto = totalPresupuesto;
    }

    public List<Articulo> getArticulosPresupuesto() {
        return articulosPresupuesto;
    }

    public void setArticulosPresupuesto(List<Articulo> articulosPresupuesto) {
        this.articulosPresupuesto = articulosPresupuesto;
    }

    public Presupuesto() {
    }
}
