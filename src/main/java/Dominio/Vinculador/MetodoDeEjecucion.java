package Dominio.Vinculador;
import entities.OperacionEgreso;
import entities.OperacionIngreso;

import java.util.List;

public abstract class MetodoDeEjecucion{
    public List<CondicionadorVinculacion> condicionesDeVinculacion;
    MetodoDeEjecucion(List<CondicionadorVinculacion> cv){
        this.condicionesDeVinculacion = cv;

    }
    public abstract void vincular(List<OperacionEgreso> egresos, List<OperacionIngreso> ingresos);

}