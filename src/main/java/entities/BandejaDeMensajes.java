package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "bandeja_de_mensajes")
public class BandejaDeMensajes extends EntidadPersistente {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Mensaje> mensajes = new ArrayList<>();

    public void agregarMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }
    public List<Mensaje> getMensajes(){
        return mensajes;
    }

}
