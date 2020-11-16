package Dominio;

import entities.Categoria;
import entities.Empresa;
import exception.CategorizacionException;

public interface Categorizador{
    public Categoria categorizarEmpresa(Empresa empresa, Categoria[] listaCategorias) throws CategorizacionException;
}
