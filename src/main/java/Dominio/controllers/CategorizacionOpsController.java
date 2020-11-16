package Dominio.controllers;

import Dominio.repositories.Repositorio;
import Dominio.repositories.factories.FactoryRepositorio;
import entities.CategoriaOperaciones;
import entities.OperacionEgreso;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CategorizacionOpsController {
    private Repositorio<CategoriaOperaciones> repoCategorias;
    private Repositorio<OperacionEgreso> repoEgresos;

    public CategorizacionOpsController(){
        this. repoCategorias = FactoryRepositorio.get(CategoriaOperaciones.class);
    }

    public ModelAndView inicio(Request request, Response response){
        return new ModelAndView(null, "asociar_a_categoria.hbs");
    }

    public ModelAndView asociar(Request request, Response response){
        return new ModelAndView(null, "asociar_a_catoria.hbs"); // asociacion correcta
    }

}
