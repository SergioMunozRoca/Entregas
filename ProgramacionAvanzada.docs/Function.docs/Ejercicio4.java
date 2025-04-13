package Function;

import java.util.*;
import java.util.function.Function;

public class Ejercicio4 {
    public static void main(String[] args) {

        List<String> lista = Arrays.asList("coche", "moto", "barco", "avion");
        Map<String, Integer> mapa = convertirLista(lista, texto -> texto.length());

        System.out.println(mapa);
    }

    public static Map<String, Integer> convertirLista(List<String> lista, Function<String, Integer> funcion) {
        Map<String, Integer> mapa = new HashMap<>();

        lista.forEach(texto -> mapa.put(texto, funcion.apply(texto)));

        return mapa;
    }
}
