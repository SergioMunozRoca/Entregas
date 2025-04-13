package Predicate.Ejercicios;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ejercicio8 {
    public static void main(String[] args) {


        List<String> nombres= List.of("coche","moto","avion","bicicleta","camion","barco");

        Predicate<String> checker = a -> a.startsWith("A");

        Predicate<String> checker2 = a -> a.length() == 5;

        Predicate<String> combino = checker.or(checker2);

        Consumer<String> nombre= s -> System.out.println(s);

        nombres.stream()
                .filter(combino)
                .forEach(nombre);
    }
}
