package Biblioteca;

import java.util.ArrayList;

public class gestorLibros {

    private static ArrayList<Libro> libros;

    public gestorLibros(){
        libros = new ArrayList<>();
    }

    public static ArrayList<Libro> getLibros() {
        return libros;
    }

    private int findLibros(String titulo){
        int index = 0;

        for(Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean addLibro(Libro libro){
        if(findLibros(libro.getTitulo()) >= 0){
            System.out.println("Este libro ya existe.");
            return false;
        }
        libros.add(libro);
        return true;
    }

    public static Libro queryLibros(String titulo){
        for(Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                return libro;
            }
        }
        return null;
    }

    public boolean removeLibro(Libro libro){
        int index = findLibros(libro.getTitulo());

        if(index == -1){
            return false;
        }

        libros.remove(index);
        return true;
    }
}
