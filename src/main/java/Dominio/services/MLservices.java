package Dominio.services;

import Dominio.model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MLservices {
    @GET("classified_locations/countries")
    Call<List<Pais>> paises();

    @GET("classified_locations/countries/{Country_id}")
    Call<Pais> pais(@Path("Country_id") String Country_id);

    @GET("classified_locations/states/{State_id}")
    Call<Provincia> provincia(@Path("State_id") String State_id);

    @GET("classified_locations/cities/{City_id}")
    Call<Ciudad> ciudad(@Path("City_id") String City_id);

    @GET("currencies/")
    Call<List<Moneda>> monedas();

}
