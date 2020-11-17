import db.EntityManagerHelper;
import entities.*;
import exception.VerificadorException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ObjetosDePersistencia {
    @Test
    public void persistirOrganizaciones() throws VerificadorException {
        Organizacion EAAF = new Organizacion();
        EAAF.setNombre("Equipo Argentino de Antropologia Forense - EEAF");

        Empresa EAAF_BA = new Empresa("Construccion",600000000,150);

        EAAF_BA.setCUIT("30-15269857-2");

        DireccionPostal EAAF_BA_DP = new DireccionPostal("Av. Medrano",951,null,"CABA","Buenos Aires","Argentina");

        EAAF_BA.setDireccionPostal(EAAF_BA_DP);

        EAAF_BA.setRazonSocial("EAAF BA");

        EAAF_BA.setNombreFicticio("Oficina Central Buenos Aires");

        EAAF_BA.setOrganizacion(EAAF);

        Empresa EAAF_NY = new Empresa("Construccion",960000000,580);

        EAAF_NY.setCUIT("30-15789655-7");

        DireccionPostal EAAF_NY_DP = new DireccionPostal("Liberty Ave",720,null,"New York","Brooklyn","EE. UU.");

        EAAF_NY.setDireccionPostal(EAAF_NY_DP);

        EAAF_NY.setRazonSocial("EAAF NY");

        EAAF_NY.setNombreFicticio("Oficina Central Nueva York");

        EAAF_NY.setOrganizacion(EAAF);

        Empresa EAAF_M = new Empresa("Construccion",643710000,240);

        EAAF_M.setCUIT("30-77896583-9");

        DireccionPostal EAAF_M_DP = new DireccionPostal("Roberto Gayol",55,null,null,"Ciudad De Mexico","Mexico");

        EAAF_M.setDireccionPostal(EAAF_M_DP);

        EAAF_M.setRazonSocial("EAAF M");

        EAAF_M.setNombreFicticio("Oficina Central Mexico");

        EAAF_M.setOrganizacion(EAAF);

        List<EntidadJuridica> entidadesJuridicasEAAF = new ArrayList<>();

        entidadesJuridicasEAAF.add(EAAF_BA);

        entidadesJuridicasEAAF.add(EAAF_NY);

        entidadesJuridicasEAAF.add(EAAF_M);

        EAAF.setEntidadesJuridicas(entidadesJuridicasEAAF);

        Usuario aroco = new Usuario("aroco","*_aroco20!-?");

        aroco.setNombreCompleto("Alejandro Roco");

        aroco.setEntidadJuridica(EAAF_BA);

        Usuario rrojas = new Usuario("rrojas","*-_rrojas!?");

        rrojas.setNombreCompleto("Rocio Rojas");

        rrojas.setEntidadJuridica(EAAF_BA);

        EAAF.getUsuarios().add(aroco);

        EAAF.getUsuarios().add(rrojas);

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(EAAF);
        EntityManagerHelper.commit();


    }
}
