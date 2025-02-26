package Biblioteca;

import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private String anyo;
    private String genero;
    private String disponibilidad;
    private static ArrayList<Libro> libros = new ArrayList<>();

    public Libro(String titulo, String autor, String anyo, String genero, String disponibilidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnyo() {
        return anyo;
    }

    public String getGenero() {
        return genero;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public static ArrayList<Libro> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        return "título: " + titulo + ", autor: " + autor + ", añoPublicación: " + anyo + ", género: " + genero + ", disponibilidad: " + disponibilidad;
    }
}
