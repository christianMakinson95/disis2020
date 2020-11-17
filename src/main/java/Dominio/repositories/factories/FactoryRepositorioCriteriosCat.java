package Dominio.repositories.factories;

import Dominio.repositories.RepositorioDeCategorias;
import Dominio.repositories.RepositorioDeCriteriosCat;
import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import config.Config;
import entities.CategoriaOperaciones;
import entities.CriterioOperaciones;
import entities.Usuario;

public class FactoryRepositorioCriteriosCat {
    private static RepositorioDeCriteriosCat repo;

    static {
        repo = null;
    }

    public static RepositorioDeCriteriosCat get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<CriterioOperaciones> dao = new DAOHibernate<>(CriterioOperaciones.class);
                repo = new RepositorioDeCriteriosCat(dao);
            }
            else{
                repo = null;
            }
        }
        return repo;
    }
}
