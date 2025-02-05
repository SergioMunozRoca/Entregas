import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainCompra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int idCompra = validarId("Ingrese ID de compra (positivo): ", scanner);
        LocalDate fCompra = validarFechaCompra(scanner);
        String metodoPago = validarMetodoPago(scanner);
        int idUsuario = validarId("Ingrese ID de usuario (positivo): ", scanner);

        Compra compra = new Compra(idCompra, fCompra, metodoPago, idUsuario);
        System.out.println("Compra creada exitosamente: " + compra);
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
}
