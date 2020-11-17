package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "criterio_operaciones")
@Inheritance(strategy = InheritanceType.JOINED)
public class CriterioOperaciones extends EntidadPersistente {

    @Column(name = "criterio")
    private String criterio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaOperaciones categoria;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Criterio> CriterioHijo;

    //getters y setters

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public CategoriaOperaciones getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaOperaciones categoria) {
        this.categoria = categoria;
    }


    public void actualizarListaHijos(){
        //Poner logica de actualizarListaHijos
    }

}
