package Dominio.controllers;

import Dominio.repositories.Repositorio;
import Dominio.repositories.RepositorioDeCategorias;
import Dominio.repositories.RepositorioDeCriteriosCat;
import Dominio.repositories.factories.FactoryRepositorio;
import Dominio.repositories.factories.FactoryRepositorioCategorias;
import Dominio.repositories.factories.FactoryRepositorioCriteriosCat;
import entities.CategoriaOperaciones;
import entities.CriterioOperaciones;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriaController {
    private RepositorioDeCategorias repoCategorias;
    private RepositorioDeCriteriosCat repoCriterios;

    public CategoriaController(){
        this.repoCategorias = FactoryRepositorioCategorias.get();
        this.repoCriterios = FactoryRepositorioCriteriosCat.get();
    }

    public ModelAndView inicio(Request request, Response response){
        List<CategoriaOperaciones> categorias = this.repoCategorias.buscarTodos();
        List<CriterioOperaciones> criterios = this.repoCriterios.buscarTodos();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("categorias", categorias);
        parametros.put("criterios", criterios);
        return new ModelAndView(parametros, "crear_categoria2.hbs");
    }

    public Response crear(Request request, Response response){
        CategoriaOperaciones categoria = new CategoriaOperaciones();
        categoria.setDescripcion(request.queryParams("descripcion"));
        this.repoCategorias.agregar(categoria);
        response.redirect("/crear_categoria");
        return response;
    }

    public Response eliminar(Request request, Response response){
        CategoriaOperaciones categoria = this.repoCategorias.buscarCategoria(request.params("descripcion"));
        this.repoCategorias.eliminar(categoria);
        return response;
    }

}
