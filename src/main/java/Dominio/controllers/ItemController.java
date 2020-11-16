package Dominio.controllers;

import Dominio.repositories.BusquedaCondicional;
import Dominio.repositories.RepositorioDeEgresos;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import Dominio.repositories.factories.FactoryRepositorioEgresos;
import entities.Articulo;
import entities.OperacionEgreso;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemController {
        DAO<OperacionEgreso> dao;

    public ItemController(){
        this.dao = new DAOHibernate<>(OperacionEgreso.class);
    }

    public ModelAndView inicioAgregarItems(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        OperacionEgreso opEg = dao.buscar(Integer.valueOf(request.params("id")));
        List<Articulo> articulos;
        if (!opEg.getArticulos().isEmpty()){
        articulos = opEg.getArticulos();
        parametros.put("articulos", articulos);
        parametros.put("id",request.params("id"));
        }
        return new ModelAndView(parametros,"agregar_items.hbs");
    }

    public Response agregarItems(Request request, Response response){
        int id = Integer.valueOf(request.params("id"));
        OperacionEgreso opEg = dao.buscar(id);

        String nombre = request.queryParams("nombreProducto");
        String descripcion = request.queryParams("descripcion");
        String cantidad = request.queryParams("cantidad");
        String precio = request.queryParams("precio");

        Articulo articulo = new Articulo();
        articulo.setDescripcion(descripcion);
        articulo.setNombre(nombre);
        articulo.setCantidadArticulos(Integer.parseInt(cantidad));
        articulo.setPrecio(Float.parseFloat(precio));
        opEg.getArticulos().add(articulo);

        System.out.printf(String.valueOf(opEg.getArticulos().size()),"/n");
        System.out.printf(articulo.getDescripcion(),"/n");

        dao.modificar(opEg);

        return response;
    }

}
