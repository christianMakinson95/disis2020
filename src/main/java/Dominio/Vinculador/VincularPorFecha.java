package Dominio.Vinculador;

//import com.sun.deploy.panel.AbstractRadioPropertyGroup;
import entities.OperacionEgreso;
import entities.OperacionIngreso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VincularPorFecha extends MetodoDeEjecucion {

    public VincularPorFecha(List<CondicionadorVinculacion> cv) {
        super(cv);
    }

    @Override
    public void vincular(List<OperacionEgreso> egresos, List<OperacionIngreso> ingresos){
        //Ordenamos los egresos por fecha
        Vinculador vinculador = new Vinculador();
        Collections.sort(egresos, Comparator.comparing(OperacionEgreso::getFechaEgreso));
        vinculador.ejecutarVinculacion(egresos, ingresos, this.condicionesDeVinculacion);

    }


}