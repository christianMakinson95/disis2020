package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "criterio")
public class Criterio extends CriterioOperaciones {

    @OneToOne(cascade = CascadeType.ALL)
    private Criterio criterioHijo;

    //getter y setter

    public Criterio getCriterioHijo() {
        return criterioHijo;
    }

    public void setCriterioHijo(Criterio criterioHijo) {
        this.criterioHijo = criterioHijo;
    }


}
