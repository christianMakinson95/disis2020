package Dominio.repositories;

import entities.Usuario;
import Dominio.repositories.daos.DAO;
//import sun.reflect.annotation.ExceptionProxy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeUsuarios extends Repositorio<Usuario> {

    public RepositorioDeUsuarios(DAO<Usuario> dao) {
        super(dao);
    }

    public Boolean existe(String nombreDeUsuario){
        return buscarUsuario(nombreDeUsuario) != null;
    }

    public Usuario buscarUsuario(String nombreDeUsuario){
        try {
            return this.dao.buscar(condicionUsuario(nombreDeUsuario));
        }catch (Exception e){
            return null;
        }
    }

    private BusquedaCondicional condicionUsuario(String nombreDeUsuario){
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<Usuario> usuarioQuery = criteriaBuilder.createQuery(Usuario.class);

        Root<Usuario> condicionRaiz = usuarioQuery.from(Usuario.class);

        Predicate condicionNombreDeUsuario = criteriaBuilder.equal(condicionRaiz.get("nombreUsuario"), nombreDeUsuario);

        usuarioQuery.where(condicionNombreDeUsuario);

        return new BusquedaCondicional(null, usuarioQuery);
    }
}
