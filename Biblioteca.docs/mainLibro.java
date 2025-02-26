package Biblioteca;

import Biblioteca.gestorLibros;

import java.util.ArrayList;
import java.util.Scanner;

public class mainLibro {

    private static Scanner scanner = new Scanner(System.in);

    private static gestorLibros gestor = new gestorLibros();



    public static void imprimirMenu(){

        System.out.println("BIENVENIDO AL SISTEMA DE BIBLIOTECA");
        System.out.println("1. Añadir Libro");
        System.out.println("2. Buscar Libro");
        System.out.println("3. Eliminar Libro");
        System.out.println("4. Listar Libros");
        System.out.println("5. Salir");
    }

    public static void addLibro(){
        String titulo;
        String autor;
        String anyo;
        String genero;
        String disponibilidad;


        System.out.println("AÑADIR NUEVO LIBRO:");

        do {
            System.out.print("Título del libro: ");
            titulo = scanner.nextLine().trim();

            if (!titulo.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error: solo puedes introducir letras.");
            }
        } while (!titulo.matches("[a-zA-Z\\s]+"));

        do {
            System.out.print("Autor: ");
            autor = scanner.nextLine().trim();

            if (!autor.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error: solo puedes introducir letras.");
            }
        } while (!autor.matches("[a-zA-Z\\s]+"));


        boolean anyoValido;
        do {
            System.out.print("Año de Publicación: ");
            anyo = scanner.nextLine().trim();

            if (!anyo.matches("\\d{4}")) {
                System.out.println("Error: solo puedes introducir 4 dígitos.");
                anyoValido = false;
                continue;
            }

            int anyoInt = Integer.parseInt(anyo);

            if(anyoInt >= 1600 && anyoInt <= 2025){
                anyoValido = true;
            }else{
                System.out.println("Error: el año debe estar entre 1600 y 2025.");
                anyoValido = false;
            }

        } while (!anyoValido);


        do {
            System.out.print("Género: ");
            genero = scanner.nextLine().trim();

            if (!genero.matches("Ficcion|Ciencia|Historia")) {
                System.out.println("Error: solo puedes introducir géneros disponibles.");
            }
        } while (!genero.matches("Ficcion|Ciencia|Historia"));

        do {
            System.out.print("Disponibilidad(si/no): ");
            disponibilidad = scanner.nextLine().trim();

            if (!disponibilidad.matches("si|no")) {
                System.out.println("Error: solo puedes introducir 'si' o 'no'.");
            }
        } while (!disponibilidad.matches("si|no"));

        Libro newLibro = new Libro(titulo,autor,anyo,genero,disponibilidad);

        if(gestor.addLibro(newLibro)){
            System.out.println("Libro añadido al catálogo.");
        }else{
            System.out.println("El libro no se ha podido añadir al catálogo.");
        }
    }

    public static void imprimirLibros(){
        System.out.println("DATOS DE LOS LIBROS:");

        ArrayList<Libro> listaLibros = gestorLibros.getLibros();

        if(listaLibros.isEmpty()){
            System.out.println("No existen libros.");
            return;
        }

        for(Libro libro : listaLibros){
            System.out.println(libro);
        }
    }

    public static void buscarLibro(){

        String tituloLibro;

        System.out.println("BUSCAR LIBRO POR TÍTULO:");

        if(gestorLibros.getLibros().isEmpty()){
            System.out.println("No existen libros.");
            return;
        }

        do {
            System.out.print("Título del libro: ");
            tituloLibro = scanner.nextLine().trim();

            if (!tituloLibro.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error: solo puedes introducir letras.");
            }
        } while (!tituloLibro.matches("[a-zA-Z\\s]+"));

        Libro encontrado = gestorLibros.queryLibros(tituloLibro);

        if(encontrado == null){
            System.out.println("El título del libro no existe.");
        }else{
            System.out.println("Datos del libro: ");
            System.out.println(encontrado);
        }
    }

    public static void removeLibro(){

        String deleteLibro;

        if(gestorLibros.getLibros().isEmpty()){
            System.out.println("No existen libros.");
            return;
        }

        do {
            System.out.print("Título del libro: ");
            deleteLibro = scanner.nextLine().trim();

            if (!deleteLibro.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error: solo puedes introducir letras.");
            }
        } while (!deleteLibro.matches("[a-zA-Z\\s]+"));

        Libro eliminado = gestorLibros.queryLibros(deleteLibro);

        if(eliminado != null){
            gestor.removeLibro(eliminado);
            System.out.println("libro " + deleteLibro + " eliminado.");
        }else{
            System.out.println("El título del libro no existe.");
        }

    }



    public static void main(String[] args) {

        boolean continuar = true;
        int opcion;

        imprimirMenu();

        while (continuar) {
            System.out.println("----------------------------");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, introduce un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    addLibro();
                    break;

                case 2:
                    buscarLibro();
                    break;

                case 3:
                    removeLibro();
                    break;

                case 4:
                    imprimirLibros();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
