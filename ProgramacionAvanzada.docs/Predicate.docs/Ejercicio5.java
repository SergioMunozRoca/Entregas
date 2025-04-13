package Predicate.Ejercicios;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Ejercicio5 {
    public static void main(String[] args) {
        BiPredicate<String, String> iguales = (s1,s2) -> s1.equals(s2);

        String a = "hola";
        String b = "hola";
        String c = "adios";

        System.out.println(iguales.test(a,b));
        System.out.println(iguales.test(b,c));
        System.out.println(iguales.test(a,c));
    }
}
