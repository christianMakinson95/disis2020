package ValidadorContrasenia;

import exception.VerificadorException;

public class CumpleLargoMinimo extends ValidadorContra {


    @Override
    public void validar(String contra) throws VerificadorException {
        if(contra.length() < 8){
            throw new VerificadorException
                    ("La contrasenia es demasiado corta, debe tener al menos 8 caracteres de largo");
        }
    }

}
