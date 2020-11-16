
import entities.Password;
import entities.Usuario;
import ValidadorContrasenia.*;
import exception.VerificadorException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class TestsValidadorContrasenia {

    private Password unaContra;
    private String contraTest;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    // una contra correcta pasa todas las verificaciones, 1 por 1.
    @Test
    public void unaContraEsCorrecta() throws VerificadorException {
        unaContra = new Password("Ads12Eqe");
        EsDeLas10kPeores validoDebilidad = new EsDeLas10kPeores();
        validoDebilidad.validar(unaContra.getPass());
        CumpleLargoMinimo validoLongitud = new CumpleLargoMinimo();
        validoLongitud.validar(unaContra.getPass());
        TieneCaracteresRepetidos validoRepeticion = new TieneCaracteresRepetidos();
        validoRepeticion.validar(unaContra.getPass());
        TieneUnNumero validoUnNumero = new TieneUnNumero();
        validoUnNumero.validar(unaContra.getPass());
        TieneUnaMayuscula validoMayuscula = new TieneUnaMayuscula();
        validoMayuscula.validar(unaContra.getPass());
    }


    // una contra que es correcta pasa las verificaciones y recibe de resultado la misma contra
    @Test
    public void unaContraCorrectaRecibeContra() throws VerificadorException {
        unaContra = new Password("Ads12Eqe");
        contraTest = unaContra.verificarContra(unaContra.getPass());
        Assert.assertEquals(contraTest, unaContra.getPass());
    }


    // una contra es de la 10k peores, comparo con la excepción
    @Test
    public void unaContraEsDeLas10kPeores() throws VerificadorException {
        thrown.expect(VerificadorException.class);
        thrown.expectMessage("La contrasenia es demasiado debil, elija otra");
        unaContra = new Password("zelda");
        unaContra.verificarContra(unaContra.getPass());
    }


    // una contra no tiene mayusculas, comparo con la excepción
    @Test
    public void unaContraNoTieneMayus() throws VerificadorException {
        thrown.expect(VerificadorException.class);
        thrown.expectMessage("La contrasenia debe tener al menos una mayuscula");
        unaContra = new Password("una236ctz");
        unaContra.verificarContra(unaContra.getPass());
    }

    // una contra no tiene numero, comparo con la excepción
    @Test
    public void unaContraNoTieneNumero() throws VerificadorException {
        thrown.expect(VerificadorException.class);
        thrown.expectMessage("La contrasenia debe contener al menos un numero");
        unaContra = new Password("unAsdfctz");
        unaContra.verificarContra(unaContra.getPass());

    }

    // una contra no cumple el largo minimo, comparo con la excepción
    @Test
    public void unaContraNoCumpleLargoMinimo() throws VerificadorException {
        thrown.expect(VerificadorException.class);
        thrown.expectMessage("La contrasenia es demasiado corta, debe tener al menos 8 caracteres de largo");
        unaContra = new Password("uN1Az");
        unaContra.verificarContra(unaContra.getPass());
    }

    // una contra tiene caracteres repetidos (>=3), comparo con la excepción
    @Test
    public void unaContraTieneCaractRepetidos() throws VerificadorException {
        thrown.expect(VerificadorException.class);
        thrown.expectMessage("La contrasenia tiene muchos caracteres repetidos");
        unaContra = new Password("uNNN1aSz");
        unaContra.verificarContra(unaContra.getPass());
    }

            /* VVVV TESTS DE CAMBIAR CONTRASENIA VVVV */

    // un usuario quiere cambiar su contra pero no es correcta. Verifico que tira exception
    @Test(expected = VerificadorException.class)
    public void quiereCambiarxContraIncorrecta() throws VerificadorException {
        Usuario unUser = new Usuario("name", "qwsErt52");
        unUser.cambiarContraseña("23");
    }


    // un usuario quiere cambiar su contra por una correcta
    @Test
    public void quiereCambiarxContraCorrecta() throws VerificadorException {
        Usuario unUser = new Usuario("name", "qwsErt52");
        unUser.cambiarContraseña("cOnr23Ab");
    }


}