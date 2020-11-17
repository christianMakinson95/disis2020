package ValidadorContrasenia;

import exception.VerificadorException;

public class TieneCaracteresRepetidos extends ValidadorContra {


    @Override
    public void validar(String contra) throws VerificadorException {
        //considero que hay caracteres repetidos si el mismo caracter se repite 3 veces
        for (int i=0; i < (contra.length( ) - 2); i++)
            if(contra.charAt(i) == contra.charAt(i+1) && contra.charAt(i) == contra.charAt(i+2)){
                throw new VerificadorException("La contrasenia tiene muchos caracteres repetidos");
            }
    }

}
