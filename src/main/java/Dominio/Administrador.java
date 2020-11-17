package Dominio;

import entities.Criterio;
import entities.Usuario;
import exception.VerificadorException;

public class Administrador extends Usuario {


    public Administrador(String nombreUsuario, String pass) throws VerificadorException {
        super(nombreUsuario, pass);
    }

    public void modificarUsuarioEstandar(Usuario usuario) {


    }


    public void jerarquizar(Criterio criterioPadre, Criterio criterioHijo){
        if (criterioPadre.getCriterioHijo() == null){
            criterioPadre.setCriterioHijo(criterioHijo);
        }
        //else
            //throw new exception el criterio padre ya tiene un subcriterio o criterio hijo
            //metodo para quitar criterio hijo?
    }

}