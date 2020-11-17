import Dominio.services.ServicioML;
import entities.DireccionPostal;
import Dominio.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestML {
    private DireccionPostal DP = new DireccionPostal("Boedo", 846, 2, "Capital Federal", "Capital Federal", "Argentina");
    private Pais pais;
    private Provincia provincia;
    private Ciudad ciudad;

    @Test
    public void TestPaisCorrecto() throws IOException {
        try {
            pais = DP.getPais();
            Assert.assertEquals("Argentina", pais.name);
        } catch (Exception e) {
            System.out.println("El pais ingresado no esta en la lista");
        }

    }

    @Test
    public void TestProvinciaCorrecta() throws IOException {
        try {
            provincia = DP.getProvincia();
            Assert.assertEquals("Capital Federal", provincia.name);
        } catch (Exception e) {
            System.out.println("La provincia ingresada no esta en la lista");
        }

    }

    @Test
    public void TestCiudadCorrecta() throws IOException {
        try {
            ciudad = DP.getCiudad();
            Assert.assertEquals("Capital Federal", ciudad.name);
        } catch (Exception e) {
            System.out.println("La ciudad ingresada no esta en la lista");
        }
    }

    @Test
    public void TestCurrencyCorrecta() throws IOException {
        try {
            pais = DP.getPais();
            String curr_id = pais.currency_id;
            Assert.assertEquals("ARS", curr_id);
        } catch (Exception e) {
            System.out.println("La moneda no existe");
        }
    }

    @Test
    public void TestSalidaListas() throws IOException {
        ServicioML servicioML = ServicioML.instancia();

        List<Pais> paises = servicioML.listadoDePaises();
        Pais pais = null;
        for (Pais p : paises) {
                System.out.printf(p.name);
                System.out.printf("\n");

        }
    }
}
