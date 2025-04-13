package Function;

import java.util.function.Function;

public class Ejercicio3 {
    public static void main(String[] args) {

        Function<String, Integer> extraerlongitud = mensaje -> mensaje.length();
        Integer longitud = extraerlongitud.apply("Programación");
        System.out.println("Longitud: " + longitud);

        Function<Integer,Integer> potencia2= integer -> (int) Math.pow(2,integer);
        Integer valor = potencia2.apply(longitud);
        System.out.println("Valor: " + valor);

    }
}
