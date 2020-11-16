package ValidadorTransparencia;

import entities.Mensaje;
import entities.OperacionEgreso;

import java.util.Calendar;

//valida si la cantidad de presupuestos cargados es igual a la cantidad de presupuestos esperados
public class ValidadorCantidadPresupuestos extends ValidadorDeTransparencia {


    public ValidadorCantidadPresupuestos(long milis) {
        super(milis);
    }

    @Override
    public Mensaje verificar(OperacionEgreso operacionEgreso) {
        Calendar fecha = Calendar.getInstance();
       Mensaje mensajeValidacionPRCorrecta = new Mensaje(operacionEgreso,"Validacion correcta, la cantidad de presupuestos cargados coinciden con la cantidad de los requeridos",fecha);
       Mensaje mensajeValidacionPRIncorrecta = new Mensaje(operacionEgreso,"Validacion incorrecta, la cantidad de presupuestos cargados no coinciden con la cantidad de los requeridos",fecha);
       int cantidadPresupuestosRequeridos = operacionEgreso.getCantPresupuestosRequeridos();
       int cantidadPresupuestosCargados = operacionEgreso.getPresupuestosRequeridos().size();

       if(cantidadPresupuestosCargados == cantidadPresupuestosRequeridos){
           System.out.printf("Mensaje enviado \n");
           return mensajeValidacionPRCorrecta;}
       else
           return mensajeValidacionPRIncorrecta;
    }


}
