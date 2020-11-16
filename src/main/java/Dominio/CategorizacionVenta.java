package Dominio;

import entities.Categoria;
import entities.Empresa;
import exception.CategorizacionException;

public class CategorizacionVenta implements Categorizador{
    @Override
    public Categoria categorizarEmpresa(Empresa empresa, Categoria[] listaCategorias) throws CategorizacionException {

        for(int i=0;i<listaCategorias.length;i++){
            if(empresa.getRubro()==listaCategorias[i].getRubro() && empresa.getVentasTotAnual() > listaCategorias[i].getValorMinLigado() && empresa.getVentasTotAnual() < listaCategorias[i].getValorMaxLigado())
                return listaCategorias[i];

        }
        throw new CategorizacionException("No se encontró nunguna categoria");
    }

}
