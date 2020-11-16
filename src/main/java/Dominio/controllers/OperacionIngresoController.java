package Dominio.controllers;

import Dominio.repositories.RepositorioDeIngresos;
import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.factories.FactoryRepositorioIngresos;
import Dominio.repositories.factories.FactoryRepositorioUsuarios;
import entities.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.*;

public class OperacionIngresoController {
    public ModelAndView inicioIngreso(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();
        Usuario usuario = repoUsuarios.buscar(request.session().attribute("id"));
        List<OperacionIngreso> ingresos = usuario.getOperacionIngresos();
        parametros.put("opIn", ingresos);
        return new ModelAndView(parametros, "ingresos.hbs");
    }

    public Response cargarIngreso(Request request, Response response) {
        try {

            RepositorioDeIngresos repoIngresos = FactoryRepositorioIngresos.get();

            RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();

            Usuario usuario = repoUsuarios.buscar(request.session().attribute("id"));

            String nombre = request.queryParams("nombreIngreso");

            LocalDate fecha = LocalDate.parse(request.queryParams("fechaIngreso"));

            Float importeTotal = Float.parseFloat(request.queryParams("importeTotal"));

            OperacionIngreso opIn = new OperacionIngreso();

            opIn.setFechaIngreso(fecha);

            opIn.setMontoTotal(importeTotal);

            opIn.setDescripcion(nombre);

            usuario.getOperacionIngresos().add(opIn);

            repoIngresos.agregar(opIn);

            repoUsuarios.modificar(usuario);

            response.redirect("/ingresos");

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            return response;
        }

    }
}


