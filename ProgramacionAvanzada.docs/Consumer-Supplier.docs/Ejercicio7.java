package Ejercicios;

public class Ejercicio7 {

    interface Operar{
        public int calcula(int a, int b);
    }

    public static void main(String[] args) {

        Ejercicio7.Operar mult=(a, b) -> a * b;
        System.out.println(mult.calcula(-9,7));
    }
}
