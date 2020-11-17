package Dominio.middleware;

import spark.Request;
import spark.Response;

public class AuthMiddleware {

    public Response verificarSesion(Request request, Response response){
        if(!request.session().isNew()){
            response.redirect("/egresos");
        }else {
            response.redirect("/login");
        }

        return response;
    }

    public Response verificarInicioSesion(Request request, Response response){
        if(request.session().isNew()){
            response.redirect("/login");
            request.session().invalidate();
        }

        return response;
    }
}
