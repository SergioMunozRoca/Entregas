package ABSTRACCION.Ejercicio7;

import ABSTRACCION.Ejercicio6.Rectangulo;

public class Estudiante implements Comparable<Estudiante>{
    protected String nombre;
    protected int edad;
    protected int altura;

    public Estudiante(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public int compareTo(Estudiante e) {
        int resultado = 0;

        if(this.altura < e.getAltura()) {
            resultado = 1;
        }else if(this.altura > e.getAltura()) {
            resultado = -1;
        }else {
            if(this.edad < e.getEdad()) {
                resultado = 1;
            }else if(this.edad > e.getEdad()) {
                resultado = -1;
            }
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }
}
