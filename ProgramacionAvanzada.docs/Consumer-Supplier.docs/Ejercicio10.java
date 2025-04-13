package Ejercicios;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ejercicio10 {
    public static void main(String[] args) {

        Map<Integer,String> mapa=new LinkedHashMap<>();
        mapa.put(1,"uno");
        mapa.put(2,"dos");
        mapa.put(3,"tres");
        mapa.put(4,"cuatro");
        mapa.put(5,"cinco");

        mapa.forEach((clave, valor) -> System.out.println("Clave: "+clave+", Valor: "+valor));
    }
}
