package ValidadorContrasenia;

import entities.Password;
import exception.VerificadorException;

public abstract class ValidadorContra {


    public void validar(String contra) throws VerificadorException {}
    public void validar(Password password) throws VerificadorException {}
}
