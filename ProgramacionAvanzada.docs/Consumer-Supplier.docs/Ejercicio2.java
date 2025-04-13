package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        Consumer<Integer> numero= num -> System.out.println(num);
        System.out.println("------- Lista de enteros -------");
        numbers.add(5);
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(35);
        numbers.add(40);
        numbers.add(45);
        numbers.add(50);
        numbers.forEach(numero);
    }
}
