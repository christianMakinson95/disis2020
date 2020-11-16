package Dominio.controllers;

import Dominio.model.Ciudad;
import Dominio.model.Moneda;
import Dominio.model.Pais;
import Dominio.model.Provincia;
import Dominio.repositories.Repositorio;
import Dominio.repositories.RepositorioDeEgresos;
import Dominio.repositories.RepositorioDeUsuarios;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.factories.FactoryRepositorio;
import Dominio.repositories.factories.FactoryRepositorioEgresos;
import Dominio.repositories.factories.FactoryRepositorioUsuarios;
import Dominio.services.ServicioML;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Or;
import entities.*;
import scala.util.parsing.combinator.testing.Str;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;

//import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class OperacionEgresoController {
    public ModelAndView inicioEgreso(Request request, Response response) throws IOException {

        Map<String, Object> parametros = new HashMap<>();
        RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();



        ServicioML servicioML = ServicioML.instancia();
        List<Moneda> monedas = servicioML.listadoDeMonedas();
        List<Pais> paises = servicioML.listadoDePaises();

        Usuario usuario = repoUsuarios.buscar(request.session().attribute("id"));

        Organizacion organizacion = usuario.getEntidadJuridica().getOrganizacion();

        List<Usuario> usuariosOrg = organizacion.getUsuarios();

        List<OperacionEgreso> egresos = new ArrayList<>();

        for (Usuario u: usuariosOrg){
            egresos.addAll(u.getEgresos());
        }

        parametros.put("opEg", egresos);
        parametros.put("moneda", monedas);
        parametros.put("pais", paises);

        return new ModelAndView(parametros, "egresos.hbs");
    }


    public Response cargarEgreso(Request request, Response response) {
        try {

            RepositorioDeEgresos repoEgresos = FactoryRepositorioEgresos.get();

            RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();

            Usuario usuario = repoUsuarios.buscar(request.session().attribute("id"));

            String nombre = request.queryParams("nombreEgreso");

            String cantPresupuestosRequeridos = request.queryParams("presupuestosRequeridos");

            OperacionEgreso opEg = new OperacionEgreso();

            if(request.queryParams("serRevisor") != null){
                opEg.actualizarRevisores(usuario);
            }

            opEg.setUsuario(usuario);

            opEg.setFechaEgreso(LocalDate.now());

            opEg.setNombre(nombre);

            opEg.setCantPresupuestosRequeridos(Integer.parseInt(cantPresupuestosRequeridos));

            this.agregarItems(request, opEg);

            this.agregarProveedor(request, opEg);

            this.agregarMedioDePago(request, opEg);

            this.agregarDocumentoComercial(request, opEg);

            usuario.getEgresos().add(opEg);

            repoEgresos.agregar(opEg);

            repoUsuarios.modificar(usuario);

            response.redirect("/egresos");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            return response;
        }

    }

    public void agregarItems(Request request, OperacionEgreso opEg) {
        String contador = request.queryParams("contador");
        List<Articulo> articulos = new ArrayList<>();
        double valorTotalOp = 0;

        for (int i = 1; i <= Integer.parseInt(contador); i++) {
            String tipoArticulo = request.queryParams("tipoArticulo");



            String nombreProducto = request.queryParams("nombreProducto" + i);
            String cantidad = request.queryParams("cantidad" + i);
            String precio = request.queryParams("precio" + i);
            String descripcion = request.queryParams("descripcion" + i);
            String moneda = request.queryParams("moneda");

            if(tipoArticulo.equals("Producto")){
                Producto producto = new Producto(nombreProducto,Integer.parseInt(precio),descripcion,Integer.parseInt(cantidad));
                producto.setMoneda(moneda);
                articulos.add(producto);

            }else {
                Servicio servicio = new Servicio(nombreProducto,Integer.parseInt(precio),descripcion,Integer.parseInt(cantidad));
                servicio.setMoneda(moneda);
                articulos.add(servicio);
            }


        }

        for (Articulo a:articulos){
            valorTotalOp += a.getPrecio() * a.getCantidadArticulos();
        }

        opEg.setArticulos(articulos);
        opEg.setValorTotalOp(valorTotalOp);
    }

    public void agregarProveedor(Request request, OperacionEgreso opEg) {
        String nombreProv = request.queryParams("nombreProveedor");

        String apellidoProv = request.queryParams("apellidoProveedor");

        String dni = request.queryParams("dni");

        String pais = request.queryParams("pais");

        String provincia = request.queryParams("provincia");

        String ciudad = request.queryParams("ciudad");

        String altura = request.queryParams("altura");

        String calle = request.queryParams("calle");

        Proveedor proveedor = new Proveedor(nombreProv, apellidoProv, Integer.parseInt(dni));

        DireccionPostal DP = new DireccionPostal();
        DP.setPais(pais);
        DP.setCiudad(ciudad);
        DP.setProvincia(provincia);
        DP.setCalle(calle);
        DP.setAltura(Integer.parseInt(altura));
        if(request.queryParams("piso") != null && !request.queryParams("piso").equals("")){
            String piso = request.queryParams("piso");
            DP.setPiso(Integer.parseInt(piso));
        }

        opEg.setProveedor(proveedor);

    }

    public void agregarMedioDePago(Request request, OperacionEgreso opEg) {
        String medio = request.queryParams("medio");

        String numeroMedioPago = request.queryParams("identificador");

        MedioDePago medioDePago = new MedioDePago();

        medioDePago.setDescripcion(medio);

        if (medio == "Efectivo") {
            medioDePago.setNumero(0);
        } else {
            medioDePago.setNumero(Long.parseLong(numeroMedioPago));
        }

        opEg.setMedioDePago(medioDePago);

    }

    public void agregarDocumentoComercial(Request request, OperacionEgreso opEg) {
        String identificadorDoc = request.queryParams("identificadorDoc");

        String importeDoc = request.queryParams("importeDoc");

        String detalle = request.queryParams("detalle");

        String fechaEmision = request.queryParams("fechaEmision");

        DocumentoComercial documentoComercial = new DocumentoComercial(Integer.valueOf(identificadorDoc), Integer.valueOf(importeDoc), detalle, LocalDate.parse(fechaEmision));

        opEg.setDocumentoComercial(documentoComercial);

    }

    public String filtrarProvincias(Request request, Response response) throws IOException {
        String pais_id = request.params("idpais");
        ServicioML servicioML = ServicioML.instancia();
        List<Provincia> provincias = servicioML.provinciasDeUnPais(pais_id);
        List<String> nombresProvincias = new ArrayList<>();

        for (Provincia p : provincias) {
            nombresProvincias.add(p.name);
        }

        String json = new Gson().toJson(nombresProvincias);
        return json;
    }

    public String filtrarCiudades(Request request, Response response) throws IOException {
        ServicioML servicioML = ServicioML.instancia();

        String provinciaNombre = request.params("provincia");
        String id_pais = request.params("idpais");

        Pais pais = servicioML.pais(id_pais);
        List<Provincia> provincias = pais.getStates();

        String id_provincia = null;
        for (Provincia p : provincias) {
            if (p.name.equals(provinciaNombre)) {
                id_provincia = p.id;
            }
        }

        Provincia provincia = servicioML.provincia(id_provincia);
        List<Ciudad> ciudades = provincia.cities;
        List<String> nombresCiudades = new ArrayList<>();

        for (Ciudad c : ciudades) {
            nombresCiudades.add(c.name);
        }

        String json = new Gson().toJson(nombresCiudades);
        return json;
    }

    public Response agregarDocumentoPdf(Request request, Response response){
        RepositorioDeEgresos repositorioDeEgresos = FactoryRepositorioEgresos.get();

        String nombre = request.queryParams("rutaDoc");
        String id = request.queryParams("idEgreso");

        OperacionEgreso opEg = repositorioDeEgresos.buscar(Integer.parseInt(id));

        DocumentoComercial doc = opEg.getDocumentoComercial();

        String ruta = "resources/uploads/"+nombre;

        doc.setRutaDoc(ruta);

        repositorioDeEgresos.modificar(opEg);

        return response;
    }
}
