package Ejercicios;

public class Ejercicio8 {

    interface Operar{
        public int calcula(int a, int b);
    }

    public static void main(String[] args) {
        Ejercicio8.Operar sum=(a, b) -> a + b;
        System.out.println(sum.calcula(-9,7));

        Ejercicio7.Operar rest=(a, b) -> a - b;
        System.out.println(rest.calcula(-9,7));

        Ejercicio7.Operar div=(a, b) -> a / b;
        System.out.println(div.calcula(-9,7));
    }
}
