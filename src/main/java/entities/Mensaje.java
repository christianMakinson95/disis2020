package entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "mensaje")
public class Mensaje extends EntidadPersistente {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operacion_id", referencedColumnName = "id")
    private OperacionEgreso compra;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha")
    private Calendar fecha;

    public Mensaje(OperacionEgreso egreso, String mensaje, Calendar fecha){
        this.compra=egreso;
        this.mensaje=mensaje;
        this.fecha = fecha;
    }

    public OperacionEgreso getCompra() {
        return compra;
    }


    public String getMensaje() {
        return mensaje;
    }

    public Calendar getFecha() { return fecha; }
}
