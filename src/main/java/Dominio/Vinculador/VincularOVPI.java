package Dominio.Vinculador;

import entities.OperacionEgreso;
import entities.OperacionIngreso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VincularOVPI extends MetodoDeEjecucion{
    public VincularOVPI(List<CondicionadorVinculacion> cv) { super(cv);}

    @Override
    public void vincular(List<OperacionEgreso> egresos, List<OperacionIngreso> ingresos){
        Vinculador vinculador = new Vinculador();
        Collections.sort(egresos, Comparator.comparing(OperacionEgreso::getValorTotalOp));
        vinculador.ejecutarVinculacion(egresos, ingresos, this.condicionesDeVinculacion);
    }
}
