package Dominio.controllers;

import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.factories.FactoryRepositorioUsuarios;
import entities.Mensaje;
import entities.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BandejaDeMensajesController {



   // public BandejaDeMensajesController(){
        //this.repoBandejaDeMensajes = FactoryRepositorio.get(BandejaDeMensajes.class);
        //this.repoMensajes = FactoryRepositorio.get(Mensaje.class);

    //}

    public ModelAndView inicio(Request request, Response response){

        Map<String, Object> parametros = new HashMap<>();
        RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();
        Usuario usuario = repoUsuarios.buscar(request.session().attribute("id"));;
        List<Mensaje> mensajes = usuario.getBandejaDeMensajes().getMensajes();
        parametros.put("mensajes",mensajes);

        return new ModelAndView(parametros,"bandejaMensajes.hbs");
    }
}
