package ValidadorContrasenia;

import exception.VerificadorException;

public class TieneUnNumero extends ValidadorContra{

    @Override
    public void validar(String contra) throws VerificadorException {
        char[] caracteres = contra.toCharArray();
        for(char c : caracteres){
            if (Character.isDigit(c)) {
                return;
            }
        }throw new VerificadorException("La contrasenia debe contener al menos un numero");
    }

}
