package CompraGenerarXML;// Autor: Sergio Muñoz Roca

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainCompra {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CompraJuego compraJuego = new CompraJuego();

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion;

        while (continuar) {
            imprimirMenu();
            System.out.println("....................");
            System.out.println("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
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
                    addNewCompra();
                    break;

                case 2:
                    deleteCompra();
                    break;

                case 3:
                    updateCompra();
                    break;

                case 4:
                    searchCompra();
                    break;

                case 5:
                    compraJuego.printCompra();
                    break;

                case 6:
                    mostrarXML();
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    private static void imprimirMenu() {
        System.out.println("*****************");
        System.out.println("COMPRA DE JUEGOS");
        System.out.println("*****************");
        System.out.println("0 - Salir");
        System.out.println("1 - Insertar compra");
        System.out.println("2 - Eliminar compra");
        System.out.println("3 - Actualizar compra");
        System.out.println("4 - Buscar compra");
        System.out.println("5 - Imprimir compras");
        System.out.println("6 - Generar XML");

    }

    private static void addNewCompra() {
        System.out.println("Añadiendo nueva compra...");

        int idCompra = validarId("Ingrese ID de compra (positivo): ");
        LocalDate fCompra = validarFechaCompra();
        String metodoPago = validarMetodoPago();
        int idUsuario = validarId("Ingrese ID de usuario (positivo): ");

        Compra compra = new Compra(idCompra, fCompra, metodoPago, idUsuario);
        if (compraJuego.addNewJuego(compra)) {
            System.out.println("Compra añadida correctamente!");
        } else {
            System.out.println("Error: La compra con ese ID ya existe.");
        }
    }

    private static void deleteCompra() {
        System.out.println("Eliminando compra...");
        int idCompra = validarId("Ingrese ID de la compra a eliminar: ");

        if (compraJuego.removeCompra(idCompra)) {
            System.out.println("Compra eliminada con éxito!!");
        } else {
            System.out.println("Error: No se encontró una compra con ese ID.");
        }
    }

    private static void updateCompra() {
        System.out.println("Actualizando compra...");

        int idCompra = validarId("Ingrese ID de la compra a actualizar: ");
        Compra compraExistente = compraJuego.queryCompra(idCompra);

        if (compraExistente == null) {
            System.out.println("Error: No existe una compra con ese ID.");
            return;
        }

        System.out.println("Introduce los nuevos datos:");

        LocalDate fCompra = validarFechaCompra();
        String metodoPago = validarMetodoPago();
        int idUsuario = validarId("Ingrese nuevo ID de usuario (positivo): ");

        Compra nuevaCompra = new Compra(idCompra, fCompra, metodoPago, idUsuario);

        if (compraJuego.updateCompra(compraExistente, nuevaCompra)) {
            System.out.println("Compra actualizada correctamente!");
        } else {
            System.out.println("Error: No se pudo actualizar la compra.");
        }
    }

    private static void searchCompra() {
        System.out.println("Buscando compra...");
        int idCompra = validarId("Ingrese ID de la compra a buscar: ");
        Compra compra = compraJuego.queryCompra(idCompra);

        if (compra != null) {
            System.out.println("Compra encontrada: " + compra);
        } else {
            System.out.println("No se encontró una compra con ese ID.");
        }
    }

    private static int validarId(String mensaje) {
        int id;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero positivo.");
                System.out.print(mensaje);
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
            if (id <= 0) {
                System.out.println("Error: El ID debe ser un número positivo.");
            }
        } while (id <= 0);
        return id;
    }

    private static LocalDate validarFechaCompra() {
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

    private static String validarMetodoPago() {
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

    private static void mostrarXML() {
        File archivo = new File("C:\\Users\\User\\Desktop\\ejemplo\\compras4.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<Compras>\n");

            for (Compra compra : compraJuego.misJuegos) {
                writer.write("  <Compra>\n");

                
                Field[] campos = Compra.class.getDeclaredFields();

                for (Field campo : campos) {
                    campo.setAccessible(true); 
                    String nombreCampo = campo.getName();
                    Object valorCampo = campo.get(compra); 

                    writer.write("    <" + nombreCampo + ">" + valorCampo + "</" + nombreCampo + ">\n");
                }

                writer.write("  </Compra>\n");
            }

            writer.write("</Compras>\n");

            System.out.println("El archivo XML ha sido generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo XML: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Error al acceder a los campos de la clase Compra: " + e.getMessage());
        }
    }

}
