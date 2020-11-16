package Dominio.repositories.factories;

import config.Config;
import entities.Usuario;
import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import Dominio.repositories.daos.DAOMemoria;

public class FactoryRepositorioUsuarios {
    private static RepositorioDeUsuarios repo;

    static {
        repo = null;
    }

    public static RepositorioDeUsuarios get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<Usuario> dao = new DAOHibernate<>(Usuario.class);
                repo = new RepositorioDeUsuarios(dao);
            }
            else{
                repo = null;
            }
        }
        return repo;
    }
}
