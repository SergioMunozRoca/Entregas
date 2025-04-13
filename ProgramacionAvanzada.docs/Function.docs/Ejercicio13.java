package Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Ejercicio13 {

    public static <T, U> void filtrarLista(List<T> lista, U condicion, BiFunction<T, U, T> operacion) {
        for (T elemento : lista) {
            T resultado = operacion.apply(elemento, condicion);
            if (resultado != null) {
                System.out.println("Cumple la condición: " + resultado);
            } else {
                System.out.println("No cumple la condición: " + elemento);
            }
        }
    }

    public static void main(String[] args) {

        List<String> listaTextos = Arrays.asList("coche", "motocicleta", "avion", "patinete");
        int condicionLongitud = 5;

        BiFunction<String, Integer, String> verificarLongitud = (texto, longitud) -> {
            if (texto.length() > longitud) {
                return texto;
            } else {
                return null;
            }
        };

        System.out.println("Filtrando por longitud mayor a " + condicionLongitud + ":");
        System.out.println("----------------------------------");
        filtrarLista(listaTextos, condicionLongitud, verificarLongitud);
        System.out.println();

        List<String> listaTextosPrefijo = Arrays.asList("coche", "motocicleta", "avion", "moto");
        String condicionPrefijo = "m";

        BiFunction<String, String, String> verificarPrefijo = (texto, prefijo) -> {
            if (texto.startsWith(prefijo)) {
                return texto;
            } else {
                return null;
            }
        };

        System.out.println("Filtrando por prefijo '" + condicionPrefijo + "':");
        System.out.println("----------------------------------");
        filtrarLista(listaTextosPrefijo, condicionPrefijo, verificarPrefijo);
    }
}
