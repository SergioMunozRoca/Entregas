package Ejercicios.Ejercicio12_13_14;

import java.time.LocalDate;
import java.util.function.Supplier;

public class Ejercicio12 {
    public static void main(String[] args) {

        Supplier<Programador> programador=() -> new Programador("Alberto",12.9,LocalDate.of(2025, 4, 7));
        Programador prog = programador.get();
        System.out.println(prog);

    }
}

