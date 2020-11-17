package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("osc")
public class OSC extends EntidadJuridica {

    @Column(name = "sector_asociado")
    private String sectorAsociado;


    //getter y setter
    public String getSectorAsociado() {
        return sectorAsociado;
    }

    public void setSectorAsociado(String sectorAsociado) {
        this.sectorAsociado = sectorAsociado;
    }
}