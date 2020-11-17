package Dominio.Vinculador;

import entities.OperacionEgreso;
import entities.OperacionIngreso;

import java.time.LocalDate;
import java.util.List;

public abstract class CondicionadorVinculacion{
    public abstract List<OperacionEgreso> filtrarEgresos(OperacionIngreso ingreso, List<OperacionEgreso> egresos);
}
