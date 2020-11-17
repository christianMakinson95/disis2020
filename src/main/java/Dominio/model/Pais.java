package Dominio.model;

import java.util.List;

public class Pais {
    public String id;
    public String name;
    public String locale;
    public String currency_id;

    public List<Provincia> states;

    public Pais() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocale() {
        return locale;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public List<Provincia> getStates() {
        return states;
    }
}
