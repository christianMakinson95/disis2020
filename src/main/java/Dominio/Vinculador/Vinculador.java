package Dominio.Vinculador;

import entities.OperacionEgreso;
import entities.OperacionIngreso;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vinculador {
    public void ejecutarVinculacion(List<OperacionEgreso> egresos, List<OperacionIngreso> ingresos, List<CondicionadorVinculacion> condicionesDeVinculacion){
        VinculacionEstablecida vinculacionEstablecida = new VinculacionEstablecida();
        //Collections.reverse(egresos);
        for(OperacionIngreso ingreso:ingresos)
        {
            //creamos una copia inicializada al principio
            List<OperacionEgreso> copiaEgresos = egresos;
            double total = 0;
            //Primero filtramos los egresos en una copia para asi no perder datos
            List<CondicionadorVinculacion> condicionesParaFiltrar = condicionesDeVinculacion;
            for (CondicionadorVinculacion condicionParaFiltrar:condicionesParaFiltrar) {
                copiaEgresos = condicionParaFiltrar.filtrarEgresos(ingreso,copiaEgresos);
            }

            //Ahora seguimos con la vinculacion
            for(int i=0; i<copiaEgresos.size();i++)
            {
                OperacionEgreso e = copiaEgresos.get(i);
                if(total + e.getValorTotalOp() > ingreso.getMontoTotal())
                {
                    copiaEgresos.remove(e);
                }
                else{
                    egresos.remove(e);
                    total+=e.getValorTotalOp();
                }
            }
            ingreso.setEgresosVinculados(copiaEgresos);
            //aca los guarda solo habria que pasarlo a tabla
            vinculacionEstablecida.setOperacionesEgreso(copiaEgresos);
            vinculacionEstablecida.setOperacionIngreso(ingreso);
        }

    }
}
