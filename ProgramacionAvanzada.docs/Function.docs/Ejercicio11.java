package Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ejercicio11 {

    public static void main(String[] args) {

        List<String> listaTextos = Arrays.asList("coche", "motocicleta", "avion", "patinete");

        int condicion = 5;

        Function<String, String> verificarLongitud = texto -> {
            if (texto.length() > condicion) {
                return texto;
            } else {
                return null;
            }
        };

        for (String texto : listaTextos) {
            String resultado = verificarLongitud.apply(texto);
            if (resultado != null) {
                System.out.println("Texto con longitud mayor a " + condicion + ": " + resultado);
            } else {
                System.out.println("Texto con longitud menor o igual a " + condicion + ": " + texto);
            }
        }
    }
}
