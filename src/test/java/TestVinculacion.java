import Dominio.Vinculador.*;
import entities.*;
import org.junit.Test;
import org.junit.Assert;

import java.net.CacheRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TestVinculacion {
    private LocalDate fechaEmisionTest;
    private List<Articulo> articulosTest;
    private Presupuesto presupuesto1 = new Presupuesto(20000,articulosTest);
    private Presupuesto presupuesto2 = new Presupuesto(30000, articulosTest);
    private Presupuesto presupuesto3 = new Presupuesto(40000,articulosTest);
    private Presupuesto[] presReqTest = {presupuesto1,presupuesto2,presupuesto3};

    OperacionEgreso opEgTestPrincipal = new OperacionEgreso(null,50000,null,articulosTest,null,presReqTest,1,null);
    OperacionEgreso opEgTestPrincipal2 = new OperacionEgreso(null,40000,null,articulosTest,null,presReqTest,1,null);
    OperacionEgreso opEgTestPrincipal3 = new OperacionEgreso(null,10000,null,articulosTest,null,presReqTest,1,null);
    OperacionEgreso opEgTestPrincipal4 = new OperacionEgreso(null,80000,null,articulosTest,null,presReqTest,1,null);
    LocalDate date = LocalDate.parse("2020-08-01");

    @Test
    public void testPeriodoAceptabilidad(){
        OperacionIngreso opInTest = new OperacionIngreso("a",100000,date);
        OperacionIngreso opInTest2 = new OperacionIngreso("a",100000,date);
        List<OperacionEgreso> opTestList = new ArrayList<>();
        opTestList.add(opEgTestPrincipal);
        opTestList.add(opEgTestPrincipal2);
        opTestList.add(opEgTestPrincipal3);

        PeriodoAceptabilidad pa = new PeriodoAceptabilidad();
        List<OperacionEgreso> opTestListResult = pa.filtrarEgresos(opInTest,opTestList);

        Assert.assertEquals(opTestList,opTestListResult);

    }

    @Test
    public void testVincularPorFecha(){
        OperacionIngreso opInTest = new OperacionIngreso("a",100000,date);
        OperacionIngreso opInTest2 = new OperacionIngreso("a",100000,date);
        List<CondicionadorVinculacion> cv = new ArrayList<>();

        List<OperacionEgreso> opTestList = new ArrayList<>();
        opTestList.add(opEgTestPrincipal);
        opTestList.add(opEgTestPrincipal2);
        opTestList.add(opEgTestPrincipal3);
        opTestList.add(opEgTestPrincipal4);

        //System.out.println("Original: "+opTestList);
        List<OperacionIngreso> opInTestList = new ArrayList<>();
        opInTestList.add(opInTest);
        opInTestList.add(opInTest2);

        PeriodoAceptabilidad pa = new PeriodoAceptabilidad();
        cv.add(pa);
        VincularPorFecha vpf = new VincularPorFecha(cv);
        vpf.vincular(opTestList,opInTestList);

        Assert.assertTrue(opInTest.getEgresosVinculados().contains(opEgTestPrincipal));
        Assert.assertTrue(opInTest.getEgresosVinculados().contains(opEgTestPrincipal2));
        Assert.assertTrue(opInTest.getEgresosVinculados().contains(opEgTestPrincipal3));
        Assert.assertTrue(opInTest2.getEgresosVinculados().contains(opEgTestPrincipal4));

        System.out.println("In1: "+opInTest.getEgresosVinculados());
        System.out.println("In2: "+opInTest2.getEgresosVinculados());
        System.out.println("Original: "+opTestList);
    }

    @Test
    public void testVincularOVPE(){
        OperacionIngreso opInTest = new OperacionIngreso("a",100000,date);
        OperacionIngreso opInTest2 = new OperacionIngreso("a",100000,date);
        List<CondicionadorVinculacion> cv = new ArrayList<>();

        List<OperacionEgreso> opTestList = new ArrayList<>();
        opTestList.add(opEgTestPrincipal);
        opTestList.add(opEgTestPrincipal2);
        opTestList.add(opEgTestPrincipal3);
        opTestList.add(opEgTestPrincipal4);
        //System.out.println("Original: "+opTestList);
        List<OperacionIngreso> opInTestList = new ArrayList<>();
        opInTestList.add(opInTest);
        opInTestList.add(opInTest2);

        PeriodoAceptabilidad pa = new PeriodoAceptabilidad();
        cv.add(pa);
        VincularOVPE vpf = new VincularOVPE(cv);
        vpf.vincular(opTestList,opInTestList);

        //System.out.println("In1: "+opInTest.getEgresosVinculados());
        //System.out.println("In2: "+opInTest2.getEgresosVinculados());
        Assert.assertTrue(opInTest.getEgresosVinculados().contains(opEgTestPrincipal));
        Assert.assertTrue(opInTest.getEgresosVinculados().contains(opEgTestPrincipal2));
        Assert.assertTrue(opInTest.getEgresosVinculados().contains(opEgTestPrincipal3));
        Assert.assertTrue(opInTest2.getEgresosVinculados().contains(opEgTestPrincipal4));

        System.out.println("In1: "+opInTest.getEgresosVinculados());
        System.out.println("In2: "+opInTest2.getEgresosVinculados());
        System.out.println("Original: "+opTestList);
    }

    @Test
    public void testVincularOVPI(){
        OperacionIngreso opInTest = new OperacionIngreso("a",100000,date);
        OperacionIngreso opInTest2 = new OperacionIngreso("b",70000,date);
        List<CondicionadorVinculacion> cv = new ArrayList<>();

        List<OperacionEgreso> opTestList = new ArrayList<>();
        opTestList.add(opEgTestPrincipal);
        opTestList.add(opEgTestPrincipal2);
        opTestList.add(opEgTestPrincipal3);
        opTestList.add(opEgTestPrincipal4);
        System.out.println("Original: "+opTestList);
        List<OperacionIngreso> opInTestList = new ArrayList<>();
        opInTestList.add(opInTest);
        opInTestList.add(opInTest2);

        PeriodoAceptabilidad pa = new PeriodoAceptabilidad();
        cv.add(pa);
        VincularOVPI vpf = new VincularOVPI(cv);
        vpf.vincular(opTestList,opInTestList);

        System.out.println("In1: "+opInTest.getEgresosVinculados());
        System.out.println("In2: "+opInTest2.getEgresosVinculados());
        System.out.println("Original: "+opTestList);

    }

    @Test
    public void testVincularMix(){
        OperacionIngreso opInTest = new OperacionIngreso("a",100000,date);
        OperacionIngreso opInTest2 = new OperacionIngreso("b",100000,date);
        List<CondicionadorVinculacion> cv = new ArrayList<>();

        List<OperacionEgreso> opTestList = new ArrayList<>();
        opTestList.add(opEgTestPrincipal);
        opTestList.add(opEgTestPrincipal2);
        opTestList.add(opEgTestPrincipal3);
        opTestList.add(opEgTestPrincipal4);
        System.out.println("Original: "+opTestList);
        List<OperacionIngreso> opInTestList = new ArrayList<>();
        opInTestList.add(opInTest);
        opInTestList.add(opInTest2);

        PeriodoAceptabilidad pa = new PeriodoAceptabilidad();
        cv.add(pa);

        VincularMix vincularMix = new VincularMix(cv);
        List<MetodoDeEjecucion> criteriosMix = new ArrayList<>();
        VincularOVPE vincularOVPE = new VincularOVPE(cv);
        VincularOVPI vincularOVPI = new VincularOVPI(cv);
        VincularPorFecha vincularPorFecha= new VincularPorFecha(cv);
        criteriosMix.add(vincularOVPE);
        criteriosMix.add(vincularOVPI);
        criteriosMix.add(vincularPorFecha);

        vincularMix.selecionarCriterios(criteriosMix);

        vincularMix.vincular(opTestList,opInTestList);


        System.out.println("In1: "+opInTest.getEgresosVinculados());
        System.out.println("In2: "+opInTest2.getEgresosVinculados());
        System.out.println("Original: "+opTestList);

    }


}
