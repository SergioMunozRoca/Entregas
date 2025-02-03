package ABSTRACCION.Ejercicio7;

import java.util.Arrays;

public class MainEstudiante {
    public static void main(String[] args) {

        Estudiante[] estudiantes = new Estudiante[5];
        estudiantes[0] = new Estudiante("Sergio",20,178);
        estudiantes[1] = new Estudiante("Alberto",19,178);
        estudiantes[2] = new Estudiante("Adrián",18,169);
        estudiantes[3] = new Estudiante("Manuel",35,180);
        estudiantes[4] = new Estudiante("Daniel",18,172);

        System.out.println("Antes de ordenar: ");
        for(Estudiante estudiante:estudiantes) {
            System.out.println(estudiante);
        }

        System.out.println();

        Arrays.sort(estudiantes);

        System.out.println("Después de ordenar: ");
        for(Estudiante est: estudiantes) {
            System.out.println(est);
        }
    }
}
