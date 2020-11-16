package Dominio.repositories;

import Dominio.repositories.daos.DAO;
import entities.OperacionIngreso;

public class RepositorioDeIngresos extends Repositorio<OperacionIngreso>{

    public RepositorioDeIngresos(DAO<OperacionIngreso> dao) {
        super(dao);
    }
}
