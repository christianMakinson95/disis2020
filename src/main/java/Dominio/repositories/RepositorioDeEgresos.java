package Dominio.repositories;

import Dominio.repositories.daos.DAO;
import entities.OperacionEgreso;

public class RepositorioDeEgresos extends Repositorio<OperacionEgreso>{

    public RepositorioDeEgresos(DAO<OperacionEgreso> dao) {
        super(dao);
    }
}
