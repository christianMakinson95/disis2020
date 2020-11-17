package entities;

import Dominio.leerMensajes;
import exception.VerificadorException;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario extends EntidadPersistente {

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id",referencedColumnName = "id")
    private Password password;

    @ManyToMany(mappedBy = "revisores")
    private List<OperacionEgreso> egresosRevisados;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OperacionEgreso> egresos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OperacionIngreso> operacionIngresos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bandeja_id", referencedColumnName = "id")
    private BandejaDeMensajes bandejaDeMensajes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entidadJuridica_id", referencedColumnName = "id")
    private EntidadJuridica entidadJuridica;


    public void realizarEgreso(OperacionEgreso egreso,boolean esRevisor){
        if(esRevisor)
            egreso.actualizarRevisores(this);
        egresosRevisados.add(egreso);
    }

    public void darAltaIngreso(OperacionIngreso unIngreso){
        operacionIngresos.add(unIngreso);
    }

    public void darBajaIngreso(OperacionIngreso unIngreso){
        operacionIngresos.remove(unIngreso);
    }

    public void modificarIngreso(OperacionIngreso unIngreso, String unaDescripcion, double unMonto){
        int posicion = operacionIngresos.indexOf(unIngreso);
        this.operacionIngresos.get(posicion).setDescripcion(unaDescripcion);
        this.operacionIngresos.get(posicion).setMontoTotal(unMonto);
    }

     /* Aca se deberia pensar la logica para la proxima entrega
    public void cargarPresupuesto() {

    }*/
     public void cambiarContraseña(String pass) throws VerificadorException {
         Password contraNueva = new Password(pass);
         if (pass.equals(contraNueva.verificarContra(pass)))
         this.setContrasenia(contraNueva);
     }
     public void leerMensajes(){
         leerMensajes l=new leerMensajes();
         l.permisoLecturaBandeja(getBandejaDeMensajes());
     }

     public void cargarIngreso(OperacionIngreso operacionIngreso){
         operacionIngresos.add(operacionIngreso);
     }

     public void altaRevisor(OperacionEgreso operacionEgreso){
         operacionEgreso.actualizarRevisores(this);
     }
    //getters y setters

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Password getContrasenia(){
         return password;
    }

    public void setContrasenia(Password password) {
        this.password = password;
    }

    public List<OperacionEgreso> getEgresosRevisados(){return egresosRevisados;}

    public BandejaDeMensajes getBandejaDeMensajes() {
        return bandejaDeMensajes;
    }

    public  List<OperacionIngreso> getOperacionIngresos(){return operacionIngresos;}

    public Usuario(String nombreUsuario, String pass) throws VerificadorException {
        this.nombreUsuario = nombreUsuario;
        Password contra = new Password(pass);
        this.setContrasenia(contra);
        bandejaDeMensajes = new BandejaDeMensajes();
    }

    public List<OperacionEgreso> getEgresos() {
        return egresos;
    }

    public Usuario(){}

    public void setNombreCompleto(String nombreCompleto) {
         this.nombreCompleto = nombreCompleto;
    }

    public void setEntidadJuridica(EntidadJuridica entidadJuridica) {
        this.entidadJuridica = entidadJuridica;
    }

    public EntidadJuridica getEntidadJuridica() {
        return entidadJuridica;
    }

    /*public void vincularEgresosAIngreso(OperacionIngreso ingreso){
         ingreso.vincularEgresos(this.getEgresos());

    }*/


}