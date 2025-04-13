package Predicate.Ejercicios;

import java.util.function.Predicate;

public class Ejercicio4 {
    public static void main(String[] args) {
        Predicate<Integer> checker = i -> i != 100;
        System.out.println(checker.test(100));
        System.out.println(checker.test(50));
    }

}
