package Predicate.Ejercicios;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ejercicio7 {
    public static void main(String[] args) {

        Predicate<Integer> checker = i -> i == 22;

        List<Integer> num= List.of(12,22,39,47,52,22,78,86,90,100);

        long cantidad = num.stream().filter(checker).count();
        System.out.println(cantidad);
    }
}
