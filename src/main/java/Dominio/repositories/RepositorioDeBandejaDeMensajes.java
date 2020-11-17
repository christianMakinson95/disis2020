package Dominio.repositories;

import Dominio.repositories.daos.DAO;
import entities.BandejaDeMensajes;

public class RepositorioDeBandejaDeMensajes extends Repositorio<BandejaDeMensajes> {
    public RepositorioDeBandejaDeMensajes(DAO<BandejaDeMensajes> dao) {
        super(dao);
    }
}