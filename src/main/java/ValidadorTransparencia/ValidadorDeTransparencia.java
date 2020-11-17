package ValidadorTransparencia;

import entities.Mensaje;
import entities.OperacionEgreso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class ValidadorDeTransparencia extends Scheduler {


    public long periodo;
    public LocalDate fechaInicio = LocalDate.now();
    public OperacionEgreso operacionEgreso;

    public ValidadorDeTransparencia(long milis) {
        //CalculadorDeMilisegundos calculador = new CalculadorDeMilisegundos();
        this.periodo = milis;
    }

    //metodo para verificar las validaciones, las clases que implementen esta interfaz  lo van a sobreescribir
    
    public abstract Mensaje verificar(OperacionEgreso operacionEgreso);

    @Override
    public void run() {
        List<OperacionEgreso> egresos = new ArrayList<OperacionEgreso>();
        egresos = operacionEgreso.getUsuario().getEgresosRevisados();
        Calendar fecha = Calendar.getInstance();
        Mensaje m = new Mensaje(this.operacionEgreso,"",fecha);
             m  = this.verificar(this.operacionEgreso);
             this.operacionEgreso.getUsuario().getBandejaDeMensajes().agregarMensaje(m);
             System.out.printf("Mensaje enviado \n");
    }

    public void setOperacionEgreso(OperacionEgreso operacionEgreso) {
        this.operacionEgreso = operacionEgreso;
    }

    public long getPeriodo() {
        return periodo;
    }

    public Date getFechaInicio() {
        return java.sql.Date.valueOf(this.fechaInicio);
    }

}
