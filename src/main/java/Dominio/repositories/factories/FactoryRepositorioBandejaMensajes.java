package Dominio.repositories.factories;

import Dominio.repositories.RepositorioDeBandejaDeMensajes;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import config.Config;
import entities.BandejaDeMensajes;

public class FactoryRepositorioBandejaMensajes {

    private static RepositorioDeBandejaDeMensajes repo;

    static {
        repo = null;
    }

    public static RepositorioDeBandejaDeMensajes get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<BandejaDeMensajes> dao = new DAOHibernate<>(BandejaDeMensajes.class);
                repo = new RepositorioDeBandejaDeMensajes(dao);
            }
            else{
                repo = null;
            }
        }
        return repo;
    }
}
