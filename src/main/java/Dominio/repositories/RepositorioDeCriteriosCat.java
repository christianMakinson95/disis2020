package Dominio.repositories;

import Dominio.repositories.daos.DAO;
import entities.Criterio;
import entities.CriterioOperaciones;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeCriteriosCat extends Repositorio<CriterioOperaciones> {

    public RepositorioDeCriteriosCat(DAO<CriterioOperaciones> dao) {
        super(dao);
    }

    public Boolean existe(String criterio){
        return buscarCriterio(criterio) != null;
    }

    public CriterioOperaciones buscarCriterio(String criterio){
        try {
            return this.dao.buscar(condicionCriterio(criterio));
        }catch (Exception e){
            return null;
        }
    }

    private BusquedaCondicional condicionCriterio(String criterio){
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<CriterioOperaciones> criterioQuery = criteriaBuilder.createQuery(CriterioOperaciones.class);

        Root<CriterioOperaciones> condicionRaiz = criterioQuery.from(CriterioOperaciones.class);

        Predicate condicionDescripcion = criteriaBuilder.equal(condicionRaiz.get("criterio"), criterio);

        criterioQuery.where(condicionDescripcion);

        return new BusquedaCondicional(null, criterioQuery);
    }
}