package Dominio.repositories.factories;

import Dominio.repositories.RepositorioDeIngresos;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import config.Config;
import entities.OperacionIngreso;

public class FactoryRepositorioIngresos {
    private static RepositorioDeIngresos repo;

    static {
        repo = null;
    }

    public static RepositorioDeIngresos get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<OperacionIngreso> dao = new DAOHibernate<>(OperacionIngreso.class);
                repo = new RepositorioDeIngresos(dao);
            }
            else{
                repo = null;
            }
        }
        return repo;
    }
}
