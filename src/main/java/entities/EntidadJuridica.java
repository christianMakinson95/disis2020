package entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_entidad")
@Table(name = "entidad_juridica")
public class EntidadJuridica extends EntidadPersistente {

    @Column(name = "nombre_ficticio")
    private String nombreFicticio;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "cuit")
    private String CUIT;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private DireccionPostal direccionPostal;

    @Column(name = "codigo_inscripcion")
    private int codigoInscripcion;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<EntidadBase> entidadesBase;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id",referencedColumnName = "id")
    private Organizacion organizacion;

    public EntidadJuridica() {
    }

    public void añadirEntidadBase(String nombreFicticio,String descripcion){
        EntidadBase entidad = new EntidadBase(nombreFicticio, descripcion);
        this.entidadesBase.add(entidad);

    }

    //getters y setters
    public String getNombreFicticio() {
        return nombreFicticio;
    }

    public void setNombreFicticio(String nombreFicticio) {
        this.nombreFicticio = nombreFicticio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public DireccionPostal getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(DireccionPostal direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public int getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public void setCodigoInscripcion(int codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }

    public List<EntidadBase> getEntidadesBase() {
        return entidadesBase;
    }

    public void setEntidadesBase(EntidadBase[] entidadesBase) {
        this.entidadesBase = Arrays.asList(entidadesBase);
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}