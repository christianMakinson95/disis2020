package entities;

import ValidadorTransparencia.ValidadorDeTransparencia;
import exception.ValidadorTransparenciaException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

@Entity
@Table(name = "operacion_egreso")
public class OperacionEgreso extends EntidadPersistente{

    @Column
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "fecha_egreso", columnDefinition = "DATE")
    private LocalDate fechaEgreso;

    @Column(name = "valor_total_operacion")
    private double valorTotalOp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private DocumentoComercial documentoComercial;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Articulo> Articulos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medio_pago_id", referencedColumnName = "id")
    private MedioDePago medioDePago;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "presupuesto_id", referencedColumnName = "id")
    private List<Presupuesto> presupuestosRequeridos;

    @Column(name = "cant_presupuestos_requeridos")
    private int cantPresupuestosRequeridos = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proveedor_id", referencedColumnName = "id")
    private Proveedor proveedor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "revisor_x_operacion",
                joinColumns = { @JoinColumn(name = "operacion_id", referencedColumnName = "id") },
                inverseJoinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") } )
    private List<Usuario> revisores=new ArrayList<>();

    //Condicion para el validador de transparencia
    //@OneToMany(cascade = CascadeType.ALL)
    @Transient
    private ValidadorDeTransparencia[] condiciones;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdIngreso", referencedColumnName = "id")
    private OperacionIngreso operacionIngreso;

    public OperacionEgreso(){};

    public OperacionEgreso(Usuario usuario,
                           double valorTotalOp,
                           DocumentoComercial documentoComercial,
                           List<Articulo> articulos,
                           MedioDePago medioDePago,
                           Presupuesto[] presupuestosRequeridos,
                           int cantPresupuestosRequeridos,
                           ValidadorDeTransparencia[] condiciones) {
        this.usuario = usuario;
        this.fechaEgreso = LocalDate.now();
        this.valorTotalOp = valorTotalOp;
        this.documentoComercial = documentoComercial;
        this.Articulos = articulos;
        this.medioDePago = medioDePago;
        this.presupuestosRequeridos = Arrays.asList(presupuestosRequeridos);
        this.cantPresupuestosRequeridos = cantPresupuestosRequeridos;
        this.condiciones = condiciones;

        /*for (ValidadorDeTransparencia condicion : this.condiciones
             ) {
            condicion.setOperacionEgreso(this);
            Timer timer = new Timer();
            timer.schedule(condicion,condicion.getFechaInicio(),condicion.getPeriodo());
        }*/

    }



    //getters y setters
    public ValidadorDeTransparencia[] getCondiciones(){ return condiciones;}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public double getValorTotalOp() {
        return valorTotalOp;
    }

    public void setValorTotalOp(double valorTotalOp) {
        this.valorTotalOp = valorTotalOp;
    }

    public DocumentoComercial getDocumentoComercial() {
        return documentoComercial;
    }

    public void setDocumentoComercial(DocumentoComercial documentoComercial) {
        this.documentoComercial = documentoComercial;
    }
    public List<Articulo> getArticulos() {
        return Articulos;
    }

    public void setArticulos(List<Articulo> articulos) { Articulos = articulos; }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public List<Presupuesto> getPresupuestosRequeridos() {
        return presupuestosRequeridos;
    }

    public int getCantPresupuestosRequeridos() {
        return cantPresupuestosRequeridos;
    }

    public List<Usuario> getRevisores(){
        return this.revisores;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantPresupuestosRequeridos(int cantPresupuestosRequeridos) {
        this.cantPresupuestosRequeridos = cantPresupuestosRequeridos;
    }

    //comportamiento

    public boolean requierePresupuestos(){
        return this.presupuestosRequeridos.size() == this.getCantPresupuestosRequeridos();
    }

   public void realizarVerificaciones() throws ValidadorTransparenciaException {

        if(requierePresupuestos()){
            ArrayList<Mensaje> mensajes = new ArrayList<>();
            ValidadorDeTransparencia[] condiciones = this.getCondiciones();
            for (int i = 0; i < this.condiciones.length; i++)
                mensajes.add(condiciones[i].verificar(this));
            enviarMensajes(mensajes);
        }else{
            throw new ValidadorTransparenciaException("La cantidad de presupuestos requeridos no es la correcta");
        }
   }
    public void enviarMensajes(List<Mensaje> mensajes){
        List<Usuario> revisores = this.getRevisores();
        for(int i=0;i<revisores.size();i++)
            for(int j=0;j<mensajes.size();j++)
                revisores.get(i).getBandejaDeMensajes().agregarMensaje(mensajes.get(j));
    }
    public void actualizarRevisores(Usuario usuario){
        this.revisores.add(usuario);
    }

}