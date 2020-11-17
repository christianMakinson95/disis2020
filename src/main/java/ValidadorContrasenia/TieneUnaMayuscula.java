package ValidadorContrasenia;

import exception.VerificadorException;

public class TieneUnaMayuscula extends ValidadorContra {

    @Override
    public void validar(String contra) throws VerificadorException {
        for(char c : contra.toCharArray()) {
            if(Character.isUpperCase(c)){
                return;
            }
        }throw new VerificadorException("La contrasenia debe tener al menos una mayuscula");
    }
}
