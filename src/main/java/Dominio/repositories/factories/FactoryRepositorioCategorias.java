package Dominio.repositories.factories;

import Dominio.repositories.RepositorioDeCategorias;
import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import config.Config;
import entities.CategoriaOperaciones;
import entities.Usuario;

public class FactoryRepositorioCategorias {
    private static RepositorioDeCategorias repo;

    static {
        repo = null;
    }

    public static RepositorioDeCategorias get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<CategoriaOperaciones> dao = new DAOHibernate<>(CategoriaOperaciones.class);
                repo = new RepositorioDeCategorias(dao);
            }
            else{
                repo = null;
            }
        }
        return repo;
    }
}
