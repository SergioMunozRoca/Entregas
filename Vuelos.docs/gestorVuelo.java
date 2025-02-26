package Vuelos;

import java.util.ArrayList;

public class gestorVuelo {

    private static ArrayList<Vuelo> vuelos;

    public gestorVuelo() {
        vuelos = new ArrayList<>();
    }

    public static ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    private int findVuelo(String numero){
        int index = 0;
        for(Vuelo vuelo : vuelos){
            if(vuelo.getNumero().equalsIgnoreCase(numero)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean addVuelo(Vuelo vuelo){
        if(findVuelo(vuelo.getNumero()) >= 0){
            System.out.println("Este vuelo ya existe.");
            return false;
        }
        vuelos.add(vuelo);
        return true;
    }

    public static Vuelo queryVuelos(String numero){
        for (Vuelo vuelo: vuelos) {
            if(vuelo.getNumero().equalsIgnoreCase(numero)){
                return vuelo;
            }
        }
        return null;
    }

    public boolean removeVuelo(Vuelo vuelo){
        int index = findVuelo(vuelo.getNumero());

        if(index == -1){
            return false;
        }
        vuelos.remove(index);
        return true;
    }

    public ArrayList<Vuelo> buscarPorClave(String clave, String valor) {
        ArrayList<Vuelo> resultados = new ArrayList<>();

        for (Vuelo v : vuelos) {
            switch (clave) {
                case "numero":
                    if (v.getNumero().equals(valor)){
                        resultados.add(v);
                    }
                    break;
                case "origen":
                    if (v.getOrigen().equalsIgnoreCase(valor)){
                        resultados.add(v);
                    }
                    break;
                case "destino":
                    if (v.getDestino().equalsIgnoreCase(valor)){
                        resultados.add(v);
                    }
                    break;
                case "dia":
                    if (v.getDia().equals(valor)){
                        resultados.add(v);
                    }
                    break;
                case "clase":
                    if (v.getClase().equalsIgnoreCase(valor)){
                        resultados.add(v);
                    }
                    break;
            }
        }

        return resultados;
    }

}
