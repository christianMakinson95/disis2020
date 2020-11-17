import ValidadorTransparencia.PresupuestoMenorValor;
import ValidadorTransparencia.UsoAlgunPresupuestoRequerido;
import ValidadorTransparencia.ValidadorCantidadPresupuestos;
import ValidadorTransparencia.ValidadorDeTransparencia;
import entities.*;
import exception.ValidadorTransparenciaException;
import exception.VerificadorException;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class TestValidadorCantidadPresupuestos {
    private Usuario usuarioTest = new Usuario("Larry", "Ads12Eqe");
    private MedioDePago mdpTest= new MedioDePago("Tarjeta de credito", 1566546);
    private LocalDate fechaEmisionTest;
    private DocumentoComercial docComTest = new DocumentoComercial(1,1000,"test",fechaEmisionTest);
    private List<Articulo> articulosTest;
    private Presupuesto presupuesto1 = new Presupuesto(20000,articulosTest);
    private Presupuesto presupuesto2 = new Presupuesto(30000, articulosTest);
    private Presupuesto presupuesto3 = new Presupuesto(40000,articulosTest);
    private Presupuesto[] presReqTest = {presupuesto1,presupuesto2,presupuesto3};
    private ValidadorDeTransparencia condicionUsoPresupRequerido = new UsoAlgunPresupuestoRequerido(5000);
    private ValidadorDeTransparencia condicionValidadorCantidadPresupuesto = new ValidadorCantidadPresupuestos(5000);
    private ValidadorDeTransparencia condicionPresupuestoMenorValor = new PresupuestoMenorValor(5000);
    private ValidadorDeTransparencia[] condicionesTest1={condicionUsoPresupRequerido};
    private ValidadorDeTransparencia[] condicionesTest2 = {condicionValidadorCantidadPresupuesto};
    private ValidadorDeTransparencia[] condicionesTest3 = {condicionPresupuestoMenorValor};
    private ValidadorDeTransparencia[] condicionesTestTodas = {condicionUsoPresupRequerido,condicionValidadorCantidadPresupuesto,condicionPresupuestoMenorValor};
    private OperacionEgreso opEgTest = new OperacionEgreso(usuarioTest,40000,docComTest,articulosTest,mdpTest,presReqTest,1,condicionesTest2);
    private BandejaDeMensajes bdm = new BandejaDeMensajes();

    public TestValidadorCantidadPresupuestos() throws VerificadorException {
    }

    @Test
    public  void realizarVerificacionCantidadPresupuestos() throws ValidadorTransparenciaException {
        opEgTest.realizarVerificaciones();
    }

    @Test
    public void leerMensajes() throws ValidadorTransparenciaException {
        usuarioTest.realizarEgreso(opEgTest,true);
        opEgTest.realizarVerificaciones();
        usuarioTest.leerMensajes();
    }
}
