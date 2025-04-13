package Ejercicios;

import java.util.function.BiConsumer;

public class Ejercicio9 {

    public static void calculator(int a, int b, BiConsumer<Integer, Integer> operation) {
        operation.accept(a, b);
    }

    public static void main(String[] args) {

        BiConsumer<Integer, Integer> suma = (x, y) -> System.out.println("Suma: " + (x + y));
        BiConsumer<Integer, Integer> resta = (x, y) -> System.out.println("Resta: " + (x - y));
        BiConsumer<Integer, Integer> multiplicacion = (x, y) -> System.out.println("Multiplicación: " + (x * y));

        calculator(10, 5, suma);
        calculator(10, 5, resta);
        calculator(10, 5, multiplicacion);
    }
}
