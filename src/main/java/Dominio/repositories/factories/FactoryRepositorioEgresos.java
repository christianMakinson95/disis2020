package Dominio.repositories.factories;

import Dominio.repositories.RepositorioDeEgresos;
import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import config.Config;
import entities.OperacionEgreso;
import entities.Usuario;

public class FactoryRepositorioEgresos {
    private static RepositorioDeEgresos repo;

    static {
        repo = null;
    }

    public static RepositorioDeEgresos get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<OperacionEgreso> dao = new DAOHibernate<>(OperacionEgreso.class);
                repo = new RepositorioDeEgresos(dao);
            }
            else{
                repo = null;
            }
        }
        return repo;
    }
}
