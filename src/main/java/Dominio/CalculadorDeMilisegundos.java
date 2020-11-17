package Dominio;

public class CalculadorDeMilisegundos {
    public long DiasAMilis(int dias){
        long milis = dias * 24 * 60 * 60 * 1000;
        return milis;
    }
}
