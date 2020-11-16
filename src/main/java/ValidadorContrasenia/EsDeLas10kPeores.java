package ValidadorContrasenia;

import exception.VerificadorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EsDeLas10kPeores extends ValidadorContra{

    @Override
    public void validar(String contra) throws VerificadorException {
        try {
            InputStream is = this.getClass().getResourceAsStream("../resources/10k-most-common.txt");

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String str;
            while ((str = br.readLine()) != null) {
                if(str.equals(contra)) {
                    throw new VerificadorException("La contrasenia es demasiado debil, elija otra");
                }
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}
