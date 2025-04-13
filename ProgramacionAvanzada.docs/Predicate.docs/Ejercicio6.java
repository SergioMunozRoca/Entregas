package Predicate.Ejercicios;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ejercicio6 {
    public static void main(String[] args) {

        Predicate<Integer> checker = i -> i > 25;
        Predicate<Integer> checker2 = i -> i < 30;

        Predicate<Integer> combino = checker.and(checker2);

        List<Integer> num= List.of(12,26,39,47,52,61,78,86,90,100);

        Consumer<Integer> numeros=s -> System.out.println(s);

        num.stream()
                .filter(combino)
                .forEach(numeros);

    }
}
