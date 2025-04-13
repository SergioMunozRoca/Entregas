package Ejercicios;

import java.util.function.Supplier;

public class Ejercicio5 {
    public static void main(String[] args) {
        Supplier<Double> aleatorio=() -> Math.random();
        System.out.println(aleatorio.get());
    }
}
