package ValidadorTransparencia;

import entities.Mensaje;
import entities.OperacionEgreso;
import entities.Presupuesto;

import java.util.Calendar;
import java.util.List;

public class UsoAlgunPresupuestoRequerido extends ValidadorDeTransparencia {


    public UsoAlgunPresupuestoRequerido(long milis) {
        super(milis);
    }

    @Override
    public Mensaje verificar(OperacionEgreso operacionEgreso) {
        List<Presupuesto> presupuestos = operacionEgreso.getPresupuestosRequeridos();
        Calendar fecha = Calendar.getInstance();
        Mensaje m = new Mensaje(operacionEgreso,"",fecha);
        for(int i = 0;i<presupuestos.size();i++){
            if(presupuestos.get(i).getTotalPresupuesto() == operacionEgreso.getValorTotalOp()){
                m = new Mensaje(operacionEgreso,"Validacion correcta, se eligio el presupuesto" + presupuestos.get(i), fecha);
                break;
            }else{
                m = new Mensaje(operacionEgreso,"Validacion incorrecta, no se uso ningun presupuesto de los requeridos",fecha);
            }
        }
        return m;
    }

}
