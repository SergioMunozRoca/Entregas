package Ejercicios.Ejercicio12_13_14;

import java.time.LocalDate;
import java.util.function.Supplier;

public class Ejercicio14 {
    public static void main(String[] args) {

        Supplier<Programador> simple = () -> new Programador("Laura");

        Supplier<Programador> completo = () -> new Programador("Carlos", 60000, LocalDate.of(2024, 10, 1));

        Programador p1 = fabricaProgramadores(simple);
        Programador p2 = fabricaProgramadores(completo);

        System.out.println(p1);
        System.out.println(p2);
    }

    public static Programador fabricaProgramadores(Supplier<Programador> creador) {
        Programador p = creador.get();

        if (p.getSalario() == 0.0 || p.getFechaInicio() == null) {
            p.setSalario(50000.0);
            p.setFechaInicio(LocalDate.now());
        }

        return p;
    }
}
