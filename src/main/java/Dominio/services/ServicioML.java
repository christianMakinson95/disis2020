package Dominio.services;

import Dominio.model.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ServicioML {
    private static ServicioML instancia = null;
    private Retrofit retrofit;

    public static ServicioML instancia(){
        if(instancia == null){
            instancia = new ServicioML();
        }
        return instancia;
    }

    private ServicioML(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/") // poner la url en un archivo de config
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Pais pais(String country_id) throws IOException {
        MLservices mLservices = this.retrofit.create(MLservices.class);
        Call<Pais> requestPais = mLservices.pais(country_id);
        Response<Pais> responsePais = requestPais.execute();
        return responsePais.body();
    }

    public Provincia provincia(String state_id) throws IOException {
        MLservices mLservices = this.retrofit.create(MLservices.class);
        Call<Provincia> requestProvincia = mLservices.provincia(state_id);
        Response<Provincia> responseProvincia = requestProvincia.execute();
        return responseProvincia.body();
    }
    public Ciudad ciudad(String city_id) throws IOException {
        MLservices mLservices = this.retrofit.create(MLservices.class);
        Call<Ciudad> requestCiudad = mLservices.ciudad(city_id);
        Response<Ciudad> responseCiudad = requestCiudad.execute();
        return responseCiudad.body();
    }

    public List<Moneda> listadoDeMonedas() throws IOException {
        MLservices mLservices = this.retrofit.create(MLservices.class);
        Call<List<Moneda>> requestListadoDeMonedas = mLservices.monedas();
        Response<List<Moneda>> responseListadoDeMonedas = requestListadoDeMonedas.execute();
        return responseListadoDeMonedas.body();
    }

    public List<Pais> listadoDePaises() throws IOException {
        MLservices mLservices = this.retrofit.create(MLservices.class);
        Call<List<Pais>> requestListadoDePaises = mLservices.paises();
        Response<List<Pais>> responseListadoDePaises = requestListadoDePaises.execute();
        return responseListadoDePaises.body();
    }

   public List<Provincia> provinciasDeUnPais(String pais_id) throws IOException {
        Pais pais = this.pais(pais_id);
        List<Provincia> provincias = pais.getStates();
        return provincias;
    }

}
