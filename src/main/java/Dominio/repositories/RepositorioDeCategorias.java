package Dominio.repositories;

import entities.CategoriaOperaciones;
import Dominio.repositories.daos.DAO;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeCategorias extends Repositorio<CategoriaOperaciones> {

    public RepositorioDeCategorias(DAO<CategoriaOperaciones> dao) {
        super(dao);
    }

    public Boolean existe(String descripcion){
        return buscarCategoria(descripcion) != null;
    }

    public CategoriaOperaciones buscarCategoria(String descripcion){
        try {
            return this.dao.buscar(condicionCategoria(descripcion));
        }catch (Exception e){
            return null;
        }
    }

    private BusquedaCondicional condicionCategoria(String descripcion){
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<CategoriaOperaciones> categoriaQuery = criteriaBuilder.createQuery(CategoriaOperaciones.class);

        Root<CategoriaOperaciones> condicionRaiz = categoriaQuery.from(CategoriaOperaciones.class);

        Predicate condicionDescripcion = criteriaBuilder.equal(condicionRaiz.get("descripcion"), descripcion);

        categoriaQuery.where(condicionDescripcion);

        return new BusquedaCondicional(null, categoriaQuery);
    }
}
