package Ejercicio9;
import java.io.Serializable;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dni;
    private String nombre;
    private int edad;
    private double sueldo;

    public Empleado(String dni, String nombre, int edad, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad + ", Sueldo: " + sueldo;
    }
}
