package Ejercicios.Ejercicio12_13_14;

import java.util.function.Supplier;

public class Ejercicio13 {
    public static void main(String[] args) {

        Supplier<Programador> programador = () -> new Programador("Alberto");

        Programador prog = programador.get();

        System.out.println(prog);
    }
}
