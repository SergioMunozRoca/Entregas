import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompraSupermercado {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Double> precios = Map.of(
            "avena", 2.21,
            "garbanzos", 2.39,
            "tomate", 1.59,
            "jengibre", 3.13,
            "quinoa", 4.50,
            "guisantes", 1.60
    );
    private static final Map<String, Producto> compra = new HashMap<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion;

        while (continuar) {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Introduce un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    insertarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    buscarProducto();
                    break;
                case 5:
                    imprimirYGuardarTicket();
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("\n*****************");
        System.out.println("COMPRA SUPERMERCADO");
        System.out.println("*****************");
        System.out.println("0 - Salir");
        System.out.println("1 - Insertar producto");
        System.out.println("2 - Eliminar producto");
        System.out.println("3 - Actualizar producto");
        System.out.println("4 - Buscar producto");
        System.out.println("5 - Imprimir y guardar ticket");
    }

    private static void insertarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine().toLowerCase();

        if (!precios.containsKey(nombre)) {
            System.out.println("Producto no disponible.");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        double precio = precios.get(nombre);
        if (compra.containsKey(nombre)) {
            compra.get(nombre).agregarCantidad(cantidad);
        } else {
            compra.put(nombre, new Producto(nombre, precio, cantidad));
        }

        System.out.println("Producto añadido a la compra.");
    }

    private static void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine().toLowerCase();

        if (compra.remove(nombre) != null) {
            System.out.println("Producto eliminado de la compra.");
        } else {
            System.out.println("El producto no está en la compra.");
        }
    }

    private static void actualizarProducto() {
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = scanner.nextLine().toLowerCase();

        Producto p = compra.get(nombre);
        if (p == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Nueva cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        p.setCantidad(cantidad);
        System.out.println("Cantidad actualizada.");

        System.out.println("Nuevo precio (dejar vacío para no cambiar): ");
        String precioInput = scanner.nextLine();
        if (!precioInput.isBlank()) {
            try {
                double nuevoPrecio = Double.parseDouble(precioInput);
                p.setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado.");
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. No se actualizó el precio.");
            }
        }
    }

    private static void buscarProducto() {
        System.out.print("Nombre del producto a buscar: ");
        String nombre = scanner.nextLine().toLowerCase();

        Producto p = compra.get(nombre);
        if (p != null) {
            System.out.println("Producto: " + p.getNombre());
            System.out.println("Precio: " + df.format(p.getPrecio()));
            System.out.println("Cantidad: " + p.getCantidad());
            System.out.println("Subtotal: " + df.format(p.getSubtotal()));
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void imprimirYGuardarTicket() {
        if (compra.isEmpty()) {
            System.out.println("No hay productos en la compra.");
            return;
        }

        double total = 0.0;
        StringBuilder ticket = new StringBuilder();
        ticket.append("Producto\tPrecio\tCantidad\tSubtotal\n");
        ticket.append("-----------------------------------------------\n");

        for (Producto p : compra.values()) {
            ticket.append(p.getNombre()).append("\t\t")
                    .append(df.format(p.getPrecio())).append("\t\t")
                    .append(p.getCantidad()).append("\t\t")
                    .append(df.format(p.getSubtotal())).append("\n");
            total += p.getSubtotal();
        }

        ticket.append("-----------------------------------------------\n");

        System.out.print("Introduzca código de descuento (INTRO si no tiene ninguno): ");
        String codigo = scanner.nextLine();
        boolean aplicarDescuento = codigo.equalsIgnoreCase("PROMOECO");

        if (aplicarDescuento) {
            double descuento = total * 0.10;
            total -= descuento;
            ticket.append("Descuento:\t\t\t\t\t\t").append(df.format(descuento)).append("\n");
        }

        ticket.append("TOTAL:\t\t\t\t\t\t\t").append(df.format(total)).append("\n");

        System.out.println("\n" + ticket);

        try (FileWriter fw = new FileWriter("C:\\Users\\User\\Desktop\\ejemplo\\ticket.txt")) {
            fw.write(ticket.toString());
            System.out.println("Ticket guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error escribiendo ticket: " + e.getMessage());
        }
    }
}
