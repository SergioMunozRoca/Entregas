package Compra;

import Ejercicio1.Colores;
import Ejercicio1.Contacto;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainCompra {

    public static void imprimirMenu() {
        System.out.println("*****************");
        System.out.println("COMPRA DE JUEGOS");
        System.out.println("*****************");
        System.out.println("0 - Salir");
        System.out.println("1 - Insertar juego");
        System.out.println("2 - Eliminar juego");
        System.out.println("3 - Actualizar juego");
        System.out.println("4 - Buscar juego");
        System.out.println("5 - Imprimir juego");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int idCompra = validarId("Ingrese ID de compra (positivo): ", scanner);
        LocalDate fCompra = validarFechaCompra(scanner);
        String metodoPago = validarMetodoPago(scanner);
        int idUsuario = validarId("Ingrese ID de usuario (positivo): ", scanner);

        Compra compra = new Compra(idCompra, fCompra, metodoPago, idUsuario);
        System.out.println("Compra creada exitosamente: " + compra);

        boolean continuar = true;
        int opcion;

        imprimirMenu();

        while (continuar) {
            System.out.println("..................");
            System.out.print("Elige una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;

                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    private static int validarId(String mensaje, Scanner scanner) {
        int id;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero positivo.");
                System.out.print(mensaje);
                scanner.next();
            }
            id = scanner.nextInt();
            if (id <= 0) {
                System.out.println("Error: El ID debe ser un número positivo.");
            }
        } while (id <= 0);
        return id;
    }

    private static LocalDate validarFechaCompra(Scanner scanner) {
        LocalDate fecha = null;
        do {
            System.out.print("Ingrese fecha de compra (YYYY-MM-DD): ");
            String fechaStr = scanner.next();
            try {
                fecha = LocalDate.parse(fechaStr);
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha inválido. Use YYYY-MM-DD.");
            }
        } while (fecha == null);
        return fecha;
    }

    private static String validarMetodoPago(Scanner scanner) {
        String metodoPago;
        do {
            System.out.print("Ingrese método de pago (máximo 16 caracteres): ");
            metodoPago = scanner.next().trim();
            if (metodoPago.isEmpty() || metodoPago.length() > 16) {
                System.out.println("Error: El método de pago no puede estar vacío y debe tener máximo 16 caracteres.");
            }
        } while (metodoPago.isEmpty() || metodoPago.length() > 16);
        return metodoPago;
    }

    private static void addNewCompra() {
        int idCompra;
        LocalDate fCompra;
        String metodoPago;
        int idUsuario;

        do{
            System.out.print("· Introduce el nombre del contacto: ");
            nombre = scanner.nextLine();

            if(!nombre.matches("[a-zA-Z]*")) {
                System.out.println("Error: solo puedes introducir letras en el nombre.");
            }

        }while (!nombre.matches("[a-zA-Z]*"));

        do{
            System.out.print("· Introduce el número (máximo 9 dígitos): ");
            numero = scanner.nextLine();

            if(!numero.matches("[0-9]{1,9}")) {
                System.out.println("Error: solo puedes introducir máximo 9 números.");
            }

        }while(!numero.matches("[0-9]{1,9}"));


        Contacto newContact = Contacto.createContact(nombre, numero);

        if (telefonoMovil.addNewContact(newContact)) {
            System.out.println("Contacto añadido correctamente!!");
        } else {
            System.out.println("Error: El contacto ya existe.");
        }
    }
}
