package entities;
/*
Descripcion del funcionamiento de la Categorizacion:
La empresa, tiene un tipo de categorizacion cuya informacion se encuentra en una tabla en base de datos.
El tipo de categorizacion es, por ejemplo, "ventas"(duda, podria haber clase padre e hijos para todas las categorizacion con un State Patron).

 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria extends EntidadPersistente {

    @Column(name = "rubro")
    private String rubro;

    @Column(name = "categoria")
    private String categoria;//nombre(id) "Mediano"/"Pequenio"

    @Column(name = "valor_min_ligado")
    private int valorMinLigado;

    @Column(name = "valor_max_ligado")
    private int valorMaxLigado;

    public Categoria(String rubro, String categoria,int valorMinLigado, int valorMaxLigado){
        this.categoria=categoria;
        this.rubro=rubro;
        this.valorMinLigado=valorMinLigado;
        this.valorMaxLigado=valorMaxLigado;
    }
    //Getters

    public int getValorMaxLigado() {
        return valorMaxLigado;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getRubro() {
        return rubro;
    }

    public int getValorMinLigado() {return valorMinLigado;}
}
