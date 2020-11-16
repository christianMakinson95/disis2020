package Dominio.controllers;

import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.factories.FactoryRepositorioUsuarios;
import entities.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginController {
    public ModelAndView inicio(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"login.hbs");
    }



    public ModelAndView error(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"login=error.hbs");
    }

    public Response login(Request request, Response response){
        try{
            RepositorioDeUsuarios repo = FactoryRepositorioUsuarios.get();

            String nombreUsuario = request.queryParams("nombreUsuario");
            String pass = request.queryParams("pass");



            if(repo.existe(nombreUsuario) && nombreUsuario != null && pass != null){
                Usuario usuario = repo.buscarUsuario(nombreUsuario);

                if(checkPass(pass, usuario.getContrasenia().getPass())){
                    request.session(true);
                    request.session().attribute("id", usuario.getId());
                    response.redirect("/egresos");

                }else {
                    response.redirect("/login=error");
                }
            }else {
                response.redirect("/login=error");
            }

    }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return response;
        }

    }

    public boolean checkPass(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public Response logout(Request request, Response response){
        request.session().invalidate();
        response.redirect("/login");
        return response;
    }




}
