package Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Ejercicio12 {

    public static void main(String[] args) {


        List<String> listaTextos = Arrays.asList("coche", "motocicleta", "avion", "moto");

        String condicion = "m";

        BiFunction<String, String, String> verificarInicio = (texto, prefijo) -> {
            if (texto.startsWith(prefijo)) {
                return texto;
            } else {
                return null;
            }
        };

        for (String texto : listaTextos) {
            String resultado = verificarInicio.apply(texto, condicion);
            if (resultado != null) {
                System.out.println("Texto que empieza con '" + condicion + "': " + resultado);
            } else {
                System.out.println("Texto que no empieza con '" + condicion + "': " + texto);
            }
        }
    }
}
