package Ejercicios;
import java.util.function.Supplier;

public class Ejercicio4 {
    public static void main(String[] args) {
        Supplier<String> mensaje=() -> "Java es un lenguaje de programación";
        System.out.println(mensaje.get());
    }
}
