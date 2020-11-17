package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "documento_comercial")
public class DocumentoComercial extends EntidadPersistente {

    @Column(name = "identificador")
    private int identificadorDoc;

    @Column(name = "importe")
    private int importe;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "fecha_emision", columnDefinition = "DATE")
    private LocalDate fechaEmision;

    @Column
    private String rutaDoc;

    //getters y setters

    public int getIdentificadorDoc() {
        return identificadorDoc;
    }

    public int getImporte() {
        return importe;
    }

    public String getDetalle() {
        return detalle;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public DocumentoComercial(int identificador, int importe, String detalle, LocalDate fechaEmision) {
        this.identificadorDoc = identificadorDoc;
        this.importe = importe;
        this.detalle = detalle;
        this.fechaEmision = fechaEmision;
    }

    public String getRutaDoc() {
        return rutaDoc;
    }

    public void setRutaDoc(String rutaDoc) {
        this.rutaDoc = rutaDoc;
    }

    public DocumentoComercial() {
    }
}