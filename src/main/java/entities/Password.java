package entities;

import ValidadorContrasenia.*;
import exception.VerificadorException;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "password")
public class Password extends EntidadPersistente {

    @Column(name = "pass")
    private String pass;

    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDate fecha;


    public String verificarContra(String password) throws VerificadorException {
        /*EsDeLas10kPeores validoDebilidad = new EsDeLas10kPeores();
            validoDebilidad.validar(password);*/
        CumpleLargoMinimo validoLongitud = new CumpleLargoMinimo();
            validoLongitud.validar(password);
        TieneCaracteresRepetidos validoRepeticion = new TieneCaracteresRepetidos();
            validoRepeticion.validar(password);
        /*TieneUnNumero validoUnNumero = new TieneUnNumero();
            validoUnNumero.validar(password);*/
        return pass;
    }

    public String getPass() {
        return pass;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Password(String pass) throws VerificadorException {
        this.verificarContra(pass);
        String passHasheada = hashPassword(pass);
        this.pass = passHasheada;
        this.fecha = LocalDate.now();
    }

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }


    public Password(){}
}
