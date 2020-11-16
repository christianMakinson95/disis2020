import Dominio.Vinculador.CondicionadorVinculacion;
import Dominio.Vinculador.PeriodoAceptabilidad;
import Dominio.Vinculador.VinculacionEstablecida;
import Dominio.Vinculador.VincularPorFecha;
import db.EntityManagerHelper;
import entities.*;
import exception.VerificadorException;
import org.hsqldb.Session;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmTest {
    
   /*@Test
    public void persistirVinculacionPorFecha(){


        LocalDate fechaEmisionTest;
        List<Articulo> articulosTest = null;
        Presupuesto presupuesto1 = new Presupuesto(20000,articulosTest);
        Presupuesto presupuesto2 = new Presupuesto(30000, articulosTest);
        Presupuesto presupuesto3 = new Presupuesto(40000,articulosTest);
        Presupuesto[] presReqTest = {presupuesto1,presupuesto2,presupuesto3};

        OperacionEgreso opEgTestPrincipal = new OperacionEgreso(null,50000,null,articulosTest,null,presReqTest,1,null);
        OperacionEgreso opEgTestPrincipal2 = new OperacionEgreso(null,40000,null,articulosTest,null,presReqTest,1,null);
        OperacionEgreso opEgTestPrincipal3 = new OperacionEgreso(null,10000,null,articulosTest,null,presReqTest,1,null);
        OperacionEgreso opEgTestPrincipal4 = new OperacionEgreso(null,80000,null,articulosTest,null,presReqTest,1,null);
        LocalDate date = LocalDate.parse("2020-08-01");
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

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(opInTest);
        EntityManagerHelper.getEntityManager().persist(opInTest2);
        EntityManagerHelper.commit();

    }*/

    @Test

    public void persistirUsuario() throws VerificadorException {
        Usuario max = new Usuario("Max", "Boeing737!");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(max);
        EntityManagerHelper.commit();



    }

}
