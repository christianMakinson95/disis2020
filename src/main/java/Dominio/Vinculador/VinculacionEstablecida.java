package Dominio.Vinculador;
import entities.EntidadPersistente;
import entities.OperacionIngreso;
import entities.OperacionEgreso;

import javax.persistence.*;
import java.util.List;

public class VinculacionEstablecida {


    private OperacionIngreso operacionIngreso;

    private List<OperacionEgreso> operacionesEgreso;

    public OperacionIngreso getOperacionIngreso() {
        return operacionIngreso;
    }

    public void setOperacionIngreso(OperacionIngreso operacionIngreso) {
        this.operacionIngreso = operacionIngreso;
    }


    public List<OperacionEgreso> getOperacionesEgreso() {
        return operacionesEgreso;
    }

    public void setOperacionesEgreso(List<OperacionEgreso> operacionesEgreso) {
        this.operacionesEgreso = operacionesEgreso;
    }
}
