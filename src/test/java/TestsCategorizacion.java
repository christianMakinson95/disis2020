import Dominio.*;
import entities.Categoria;
import entities.Empresa;
import org.junit.Assert;
import exception.CategorizacionException;
import org.junit.Test;

public class TestsCategorizacion {
     CategorizacionVenta categorizacionInterfaceTest = new CategorizacionVenta();
     Categoria categoriaEspecificaTest = new Categoria("Agropecuaria","Micro",0,12890000);
     Empresa empresaTest = new Empresa("Agropecuaria",1000,10000,15,categorizacionInterfaceTest);
     Categoria[] listaCategoriasTest = {categoriaEspecificaTest};
    @Test
    public void categorizacionCorrecta() throws CategorizacionException {
        empresaTest.setTipoCategorizacion(listaCategoriasTest);
        String c = empresaTest.getNombreCategoria();
        Assert.assertEquals(c,"Micro");
    }
}
