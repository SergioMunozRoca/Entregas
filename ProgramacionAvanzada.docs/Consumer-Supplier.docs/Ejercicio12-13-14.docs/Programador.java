package Ejercicios.Ejercicio12_13_14;

import java.time.LocalDate;

public class Programador {

    private String nombre;
    private double salario;
    private LocalDate fechaInicio;

    public Programador(String nombre, double salario, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    public Programador(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters si quieres manipular los valores luego
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", fechaInicio=" + fechaInicio +
                '}';
    }
}
