import ValidadorTransparencia.PresupuestoMenorValor;
import ValidadorTransparencia.UsoAlgunPresupuestoRequerido;
import ValidadorTransparencia.ValidadorCantidadPresupuestos;
import ValidadorTransparencia.ValidadorDeTransparencia;
import entities.*;
import exception.ValidadorTransparenciaException;
import exception.VerificadorEgresoException;
import exception.VerificadorException;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.List;

public class TestsOperacionEgreso {
    private Usuario usuarioTest = new Usuario("Christian","Ads12Eqe");
    private Usuario usuarioTest2 = new Usuario("Larry", "Ads12Eqe");
    private MedioDePago mdpTest= new MedioDePago("Tarjeta de credito", 1566546);
    private LocalDate fechaEmisionTest;
    private DocumentoComercial docComTest1 = new DocumentoComercial(1,1000,"test",fechaEmisionTest);
    private DocumentoComercial docComTest2 = new DocumentoComercial(2,1000,"test",fechaEmisionTest);
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
    private OperacionEgreso opEgTestPrincipal = new OperacionEgreso(usuarioTest,20000,docComTest1,articulosTest,mdpTest,presReqTest,1,condicionesTestTodas);
    private BandejaDeMensajes bdm = new BandejaDeMensajes();


    public TestsOperacionEgreso() throws VerificadorException {
    }

    @Test
    public void realizarEgreso() throws VerificadorEgresoException, InterruptedException {
        usuarioTest.realizarEgreso(opEgTestPrincipal,true);
       Assert.assertTrue(usuarioTest.getEgresosRevisados().contains(opEgTestPrincipal));
       Thread.sleep(15000);
    }

    @Test
    public void realizarVerificaciones() throws ValidadorTransparenciaException {
        opEgTestPrincipal.realizarVerificaciones();
    }

    @Test
    public void leerMensajes() throws ValidadorTransparenciaException {
        usuarioTest.realizarEgreso(opEgTestPrincipal,true);
        opEgTestPrincipal.realizarVerificaciones();
        usuarioTest.leerMensajes();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


}
