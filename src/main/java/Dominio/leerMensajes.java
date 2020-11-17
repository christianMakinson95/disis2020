package Dominio;

import entities.BandejaDeMensajes;
import entities.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class leerMensajes implements PermisosBandeja{
    @Override
    public void permisoLecturaBandeja(BandejaDeMensajes bandeja){
        List<Mensaje> mensajes = new ArrayList<>();
        mensajes=bandeja.getMensajes();
        for(int i=0;i<mensajes.size();i++){
            String texto = mensajes.get(i).getMensaje();
            System.out.println(texto);
        }
    }
}
