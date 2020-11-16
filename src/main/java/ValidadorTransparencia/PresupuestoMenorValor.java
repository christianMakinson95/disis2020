package ValidadorTransparencia;

import entities.Mensaje;
import entities.OperacionEgreso;
import entities.Presupuesto;

import java.util.Calendar;
import java.util.List;

public class PresupuestoMenorValor extends ValidadorDeTransparencia {


    public PresupuestoMenorValor(long milis) {
        super(milis);
    }

    @Override
    public Mensaje verificar(OperacionEgreso operacionEgreso) {
        List<Presupuesto> presupuestos = operacionEgreso.getPresupuestosRequeridos();
        Calendar fecha = Calendar.getInstance();
        double min= presupuestos.get(0).getTotalPresupuesto();
        int posicion=0;
        Mensaje m = new Mensaje(operacionEgreso,"",fecha);
        for(int i=0;i<presupuestos.size();i++){
            if(presupuestos.get(i).getTotalPresupuesto()<min){
                min= presupuestos.get(i).getTotalPresupuesto();
                posicion = i;
            }
        }
        if(presupuestos.get(posicion).getTotalPresupuesto() == operacionEgreso.getValorTotalOp()) {
            m = new Mensaje(operacionEgreso, "Validacion correcta, el presupuesto elegido es el del menor valor",fecha);
        }else{
            m = new Mensaje(operacionEgreso,"Validacion incorrecta, el presupuesto elegido no es el del menor valor",fecha);
        }
        return m;
    }

}
