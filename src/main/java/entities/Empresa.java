package entities;

import Dominio.Categorizador;
import exception.CategorizacionException;

import javax.persistence.*;

@Entity
@DiscriminatorValue("empresa")
public class Empresa extends EntidadJuridica {

    @Column(name = "rubro")
    private String rubro;

    @Column(name = "ventas_total_anual")
    private int ventasTotAnual;

    @Column(name = "valor_activos")
    private int valorActivos;

    @Column(name = "cant_empleados")
    private int cantEmpleados;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria tipoCategorizacion;

    @Transient
    private Categorizador categorizador;

    public Empresa(String rubro,int ventasTotAnual,int valorActivos,int cantEmpleados, Categorizador categorizador){
        this.rubro=rubro;
        this.ventasTotAnual=ventasTotAnual;
        this.valorActivos=valorActivos;
        this.cantEmpleados=cantEmpleados;
        this.categorizador=categorizador;
    }

    public Empresa(String rubro, int ventasTotAnual, int cantEmpleados) {
        this.rubro = rubro;
        this.ventasTotAnual = ventasTotAnual;
        this.cantEmpleados = cantEmpleados;
    }

    //getters y setter
    public void setTipoCategorizacion(Categoria[] listaCategorias) throws CategorizacionException {
       this.tipoCategorizacion = categorizador.categorizarEmpresa(this,listaCategorias);
    }
    public String getNombreCategoria(){
        return this.tipoCategorizacion.getCategoria();
    }
    public Categorizador getCategorizador(){
        return categorizador;
    }

    public int getVentasTotAnual() {
        return ventasTotAnual;
    }

    public int getValorActivos() {
        return valorActivos;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public Categoria getTipoCategorizacion() {
        return tipoCategorizacion;
    }

    public String getRubro() {
        return rubro;
    }

    public Empresa() {
    }
}