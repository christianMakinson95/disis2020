package Dominio.Vinculador;

import entities.OperacionEgreso;
import entities.OperacionIngreso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodoAceptabilidad extends CondicionadorVinculacion{

    @Override
    public List<OperacionEgreso> filtrarEgresos(OperacionIngreso ingreso, List<OperacionEgreso> egresos) {

        int rangoFechaValida = 365;// Esta hardcodeado, deberia estar en el archivo de configuracion
        LocalDate fechaDesde = ingreso.getFechaIngreso();
        LocalDate fechaHasta = fechaDesde.plusDays(rangoFechaValida);
        List<OperacionEgreso> retornoEgreso = new ArrayList<>();
        for (OperacionEgreso eg:egresos) {
            LocalDate fechaEgreso = eg.getFechaEgreso();

            if(fechaEgreso.isAfter(fechaDesde) && fechaEgreso.isBefore(fechaHasta))
                retornoEgreso.add(eg);
        }
        return retornoEgreso;
    }



}
