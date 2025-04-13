package Predicate.Ejercicios;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ejercicio9 {
    public static void main(String[] args) {

        List<String> nombres = List.of("Perro", "Gato", "Pato", "Caballo", "Pez");

        Predicate<String> noEmpiezaPorP = s -> !s.startsWith("P");

        Consumer<String> nombre = s -> System.out.println(s);

        nombres.stream()
                .filter(noEmpiezaPorP)
                .forEach(nombre);
    }
}
