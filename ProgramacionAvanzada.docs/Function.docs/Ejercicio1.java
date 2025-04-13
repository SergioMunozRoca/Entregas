package Function;

import java.util.function.Function;

public class Ejercicio1 {
    public static void main(String[] args) {

        Function<String, Integer> extraerlongitud = mensaje -> mensaje.length();
        Integer longitud = extraerlongitud.apply("Genaro");
        System.out.println("Longitud: " + longitud);
    }
}
