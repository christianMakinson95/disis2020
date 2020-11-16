package entities;

import Dominio.model.Ciudad;
import Dominio.model.Pais;
import Dominio.model.Provincia;
import Dominio.services.ServicioML;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.IOException;
import java.util.List;

@Entity
@Table(name = "direccion_postal")
public class DireccionPostal extends EntidadPersistente {

    @Column(name = "calle")
    private String calle;

    @Column(name = "altura")
    private int altura;

    @Column(name = "piso")
    private int piso;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "pais")
    private String pais;

    public DireccionPostal() {
    }

    public DireccionPostal(String calle, int altura, Integer piso, String ciudad, String provincia, String pais) {
        this.calle = calle;
        this.altura = altura;
        if (piso != null){ this.piso = piso;}
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }

   public Pais getPais() throws IOException {
        ServicioML servicioML = ServicioML.instancia();
        List<Pais> listadoDePaises = servicioML.listadoDePaises();
        Pais paisIndicado = null;
        for (Pais p : listadoDePaises) {
           if (this.pais.equals(p.name)) {
               paisIndicado = p;
           }
       }
        return paisIndicado;
   }

   public String getPais_Id() throws IOException {
        return this.getPais().id;
   }

    public Provincia getProvincia() throws IOException {
        String pais_id = this.getPais_Id();
        List<Provincia> provincias = ServicioML.instancia().pais(pais_id).states;
        for (Provincia pr : provincias){
            if(this.provincia.equals(pr.name)){
                return pr;
            }
        }
        return null;
    }

    public String getProvincia_id() throws IOException {
        return this.getProvincia().id;
    }

    public Ciudad getCiudad() throws IOException {
        String provincia_id = this.getProvincia_id();
        List<Ciudad> ciudades = ServicioML.instancia().provincia(provincia_id).cities;
        for (Ciudad c : ciudades){
            if(this.ciudad.equals(c.name)){
                return c;
            }
        }
        return null;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
