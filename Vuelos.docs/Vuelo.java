package Vuelos;

import java.util.ArrayList;

public class Vuelo {

    private String numero;
    private String origen;
    private String destino;
    private String dia;
    private String clase;
    private static ArrayList<gestorVuelo> vuelos = new ArrayList<>();


    public Vuelo(String numero, String origen, String destino, String dia, String clase) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.clase = clase;
    }

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getDia() {
        return dia;
    }

    public String getClase() {
        return clase;
    }

    public static ArrayList<gestorVuelo> getVuelos() {
        return vuelos;
    }

    @Override
    public String toString() {
        return "número: " + numero + ", origen: " + origen + ", destino: " + destino + ", día: " + dia + ", clase: " + clase;
    }
}
