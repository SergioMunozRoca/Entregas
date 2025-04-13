package Ejercicios;

import java.util.function.Consumer;

public class Ejercicio1 {
    public static void main(String[] args) {
        Consumer<String> mostrar = mensaje -> System.out.println(mensaje);

        mostrar.accept("Estoy en clase de programación");
    }
}
