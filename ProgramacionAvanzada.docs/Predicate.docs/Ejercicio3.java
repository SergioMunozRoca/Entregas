package Predicate.Ejercicios;

import java.util.function.Predicate;

public class Ejercicio3 {
    public static void main(String[] args) {
        Predicate<Integer> checker = i -> i > 100 || i < 50;
        System.out.println(checker.test(10));
        System.out.println(checker.test(101));
        System.out.println(checker.test(51));
    }
}
