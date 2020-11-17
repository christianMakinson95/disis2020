package Dominio.Vinculador;

import entities.OperacionEgreso;
import entities.OperacionIngreso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VincularMix extends MetodoDeEjecucion{
    public List<MetodoDeEjecucion> criteriosMix;
    public VincularMix(List<CondicionadorVinculacion> cv) { super(cv);}


    public void selecionarCriterios(List<MetodoDeEjecucion> criterios) {
        this.criteriosMix= criterios;
    }

    @Override
    public void vincular(List<OperacionEgreso> egresos, List<OperacionIngreso> ingresos){
        Vinculador vinculador = new Vinculador();

        for(int i= 0 ;i < criteriosMix.size();i++ ){

            criteriosMix.get(i).vincular(egresos,ingresos);

        }

    }
}
