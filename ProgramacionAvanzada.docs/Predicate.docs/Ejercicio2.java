package Predicate.Ejercicios;

import java.util.function.Predicate;

public class Ejercicio2 {
    public static void main(String[] args) {
        Predicate<Integer> checker = i -> i >100 && i <300;
        System.out.println(checker.test(109));
        System.out.println(checker.test(301));
    }
}
