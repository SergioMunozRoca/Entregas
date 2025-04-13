package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<String> palabras=new ArrayList<>();
        Consumer<String> palabra= word -> System.out.println(word.charAt(word.length()-1));
        System.out.println("------- Lista de palabras -------");
        palabras.add("banco");
        palabras.add("coche");
        palabras.add("persona");
        palabras.add("hielo");
        palabras.add("agua");
        palabras.add("libro");
        palabras.add("película");
        palabras.add("teclado");
        palabras.add("balón");
        palabras.add("patinete");
        palabras.forEach(palabra);
    }
}
