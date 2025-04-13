package Ejercicios;

import java.time.LocalDate;
import java.util.function.Supplier;

public class Ejercicio11 {
    public static void main(String[] args) {

        Supplier<LocalDate> fecha=() -> LocalDate.now();
        LocalDate ahora = fecha.get();
        System.out.println(ahora);
    }
}
