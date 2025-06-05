package ejEduardo.pooAlmacenSupremo;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class SupermercadoApp {

    static Map<String, Producto> almacen = new LinkedHashMap<>(); // LinkedHashMap para mantener orden
    static List<Compra> carrito = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static final String ARCHIVO_PRODUCTOS = "productos.txt";

    public static void main(String[] args) {
        // Cargar productos desde archivo o inicializar vacío si no existe
        almacen = cargarProductosDesdeArchivo(ARCHIVO_PRODUCTOS);
        menuPrincipal();




        System.out.println("Directorio actual: " + new File(".").getAbsolutePath());

        Map<String, Producto> prueba = cargarProductosDesdeArchivo(ARCHIVO_PRODUCTOS);
        System.out.println("Productos cargados: " + prueba.size());
        for (String key : prueba.keySet()) {
            System.out.println(key + " - " + prueba.get(key).getPrecio());
        }

    }

    // MENÚ PRINCIPAL
    private static void menuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n==== MENÚ PRINCIPAL ====");
            System.out.println("1. Gestionar almacén");
            System.out.println("2. Realizar compra");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            int opcion = leerEntero();
            switch (opcion) {
                case 1 -> menuAlmacen();
                case 2 -> realizarCompra();
                case 0 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
        System.out.println("¡Gracias por usar el sistema!");
    }

    // MENÚ ALMACÉN
    private static void menuAlmacen() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n== GESTIÓN DE ALMACÉN ==");
            mostrarProductosConNumeros();
            System.out.println("\nOpciones:");
            System.out.println("1. Añadir producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Cambiar nombre");
            System.out.println("4. Cambiar precio");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            int opcion = leerEntero();
            switch (opcion) {
                case 1 -> anadirProducto();
                case 2 -> eliminarProducto();
                case 3 -> cambiarNombre();
                case 4 -> cambiarPrecio();
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    // MÉTODOS DE GESTIÓN DE ALMACÉN

    private static void anadirProducto() {
        System.out.print("Nombre del nuevo producto: ");
        String nombre = scanner.nextLine().trim().toLowerCase();
        if (nombre.isEmpty()) {
            System.out.println("Nombre inválido.");
            return;
        }
        if (almacen.containsKey(nombre)) {
            System.out.println("El producto ya existe.");
            return;
        }
        System.out.print("Precio del producto: ");
        double precio = leerDoublePositivo();
        almacen.put(nombre, new Producto(nombre, precio));
        guardarProductosEnArchivo(ARCHIVO_PRODUCTOS);
        System.out.println("Producto añadido correctamente.");
    }

    private static void eliminarProducto() {
        if (almacen.isEmpty()) {
            System.out.println("El almacén está vacío.");
            return;
        }
        System.out.print("Introduce el número del producto a eliminar: ");
        int num = leerEntero();
        String clave = obtenerClavePorNumero(num);
        if (clave == null) {
            System.out.println("Número no válido.");
            return;
        }
        System.out.print("¿Seguro que quieres eliminar " + clave + "? (s/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("s")) {
            almacen.remove(clave);
            guardarProductosEnArchivo(ARCHIVO_PRODUCTOS);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    private static void cambiarNombre() {
        if (almacen.isEmpty()) {
            System.out.println("El almacén está vacío.");
            return;
        }
        System.out.print("Introduce el número del producto a renombrar: ");
        int num = leerEntero();
        String claveVieja = obtenerClavePorNumero(num);
        if (claveVieja == null) {
            System.out.println("Número no válido.");
            return;
        }
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine().trim().toLowerCase();
        if (nuevoNombre.isEmpty() || almacen.containsKey(nuevoNombre)) {
            System.out.println("Nombre inválido o ya existe.");
            return;
        }
        Producto p = almacen.get(claveVieja);
        p.setNombre(nuevoNombre);
        almacen.remove(claveVieja);
        almacen.put(nuevoNombre, p);
        guardarProductosEnArchivo(ARCHIVO_PRODUCTOS);
        System.out.println("Nombre actualizado.");
    }

    private static void cambiarPrecio() {
        if (almacen.isEmpty()) {
            System.out.println("El almacén está vacío.");
            return;
        }
        System.out.print("Introduce el número del producto para cambiar precio: ");
        int num = leerEntero();
        String clave = obtenerClavePorNumero(num);
        if (clave == null) {
            System.out.println("Número no válido.");
            return;
        }
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = leerDoublePositivo();
        Producto p = almacen.get(clave);
        p.setPrecio(nuevoPrecio);
        guardarProductosEnArchivo(ARCHIVO_PRODUCTOS);
        System.out.println("Precio actualizado.");
    }

    // REALIZAR COMPRA
    private static void realizarCompra() {
        if (almacen.isEmpty()) {
            System.out.println("No hay productos en el almacén para comprar.");
            return;
        }
        carrito.clear();
        System.out.print("Nombre del cliente: ");
        String cliente = scanner.nextLine().trim();

        System.out.println("\nProductos disponibles:");
        mostrarProductosConNumeros();

        while (true) {
            System.out.print("Introduce el número del producto a comprar (0 para terminar): ");
            int num = leerEntero();
            if (num == 0) break;
            String clave = obtenerClavePorNumero(num);
            if (clave == null) {
                System.out.println("Número inválido, inténtalo de nuevo.");
                continue;
            }
            Producto producto = almacen.get(clave);
            System.out.print("Cantidad: ");
            int cantidad = leerEnteroPositivo();
            agregarAlCarrito(producto, cantidad);
            System.out.println("Producto añadido al carrito.");
        }

        if (carrito.isEmpty()) {
            System.out.println("No se han comprado productos.");
            return;
        }

        System.out.print("Introduce descuento en porcentaje (0 si ninguno): ");
        double descuentoPct = leerDoubleNoNegativo();

        System.out.print("Introduce descuento fijo en euros (0 si ninguno): ");
        double descuentoEuros = leerDoubleNoNegativo();

        generarTicket(cliente, descuentoPct, descuentoEuros);
    }

    private static void agregarAlCarrito(Producto producto, int cantidad) {
        for (Compra compra : carrito) {
            if (compra.getProducto().getNombre().equalsIgnoreCase(producto.getNombre())) {
                compra.aumentarCantidad(cantidad);
                return;
            }
        }
        carrito.add(new Compra(producto, cantidad));
    }

    // GENERAR TICKET Y EXPORTAR
    private static void generarTicket(String cliente, double descuentoPct, double descuentoEuros) {
        double total = 0;
        System.out.println("\n===== TICKET DE COMPRA =====");
        System.out.println("Cliente: " + cliente);
        System.out.println("Fecha: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("-------------------------------------------");
        System.out.println("Producto\tPrecio\tCantidad\tSubtotal");
        System.out.println("-------------------------------------------");

        for (Compra compra : carrito) {
            double subtotal = compra.getSubtotal();
            total += subtotal;
            System.out.printf("%-12s\t%.2f\t%d\t\t%.2f\n",
                    compra.getProducto().getNombre(),
                    compra.getProducto().getPrecio(),
                    compra.getCantidad(),
                    subtotal);
        }

        System.out.println("-------------------------------------------");
        double descuentoTotal = total * (descuentoPct / 100.0) + descuentoEuros;
        if (descuentoTotal > total) descuentoTotal = total; // no descuento negativo

        double totalFinal = total - descuentoTotal;
        System.out.printf("TOTAL: %.2f\n", total);
        System.out.printf("Descuento aplicado: %.2f (%.2f%% + %.2f€)\n", descuentoTotal, descuentoPct, descuentoEuros);
        System.out.printf("TOTAL FINAL: %.2f\n", totalFinal);

        exportarTicket(cliente, total, descuentoPct, descuentoEuros, descuentoTotal, totalFinal);
    }

    private static void exportarTicket(String cliente, double total, double descPct, double descEuros, double descuentoTotal, double totalFinal) {
        String nombreArchivo = "ticket_" + cliente.replaceAll("\\s+", "_") + "_" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("===== TICKET DE COMPRA =====");
            writer.println("Cliente: " + cliente);
            writer.println("Fecha: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            writer.println("-------------------------------------------");
            writer.println("Producto\tPrecio\tCantidad\tSubtotal");
            writer.println("-------------------------------------------");
            for (Compra compra : carrito) {
                writer.printf("%-12s\t%.2f\t%d\t\t%.2f\n",
                        compra.getProducto().getNombre(),
                        compra.getProducto().getPrecio(),
                        compra.getCantidad(),
                        compra.getSubtotal());
            }
            writer.println("-------------------------------------------");
            writer.printf("TOTAL: %.2f\n", total);
            writer.printf("Descuento aplicado: %.2f (%.2f%% + %.2f€)\n", descuentoTotal, descPct, descEuros);
            writer.printf("TOTAL FINAL: %.2f\n", totalFinal);
            System.out.println("Ticket guardado en archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el ticket: " + e.getMessage());
        }
    }

    // CARGAR PRODUCTOS DESDE ARCHIVO
    private static Map<String, Producto> cargarProductosDesdeArchivo(String ruta) {

        Map<String, Producto> mapa = new LinkedHashMap<>();
        File file = new File(ruta);

        System.out.println("Buscando archivo en: " + file.getAbsolutePath()); // <---- línea para debug
        if (!file.exists()) {
            System.out.println("Archivo de productos no encontrado, iniciando almacén vacío.");
            return mapa;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim().toLowerCase();
                    double precio = Double.parseDouble(partes[1].trim());
                    mapa.put(nombre, new Producto(nombre, precio));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer archivo de productos: " + e.getMessage());
        }
        return mapa;
    }

    // GUARDAR PRODUCTOS EN ARCHIVO
    private static void guardarProductosEnArchivo(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Producto p : almacen.values()) {
                pw.println(p.getNombre() + "," + p.getPrecio());
            }
        } catch (IOException e) {
            System.out.println("Error guardando productos: " + e.getMessage());
        }
    }

    // UTILS

    private static void mostrarProductosConNumeros() {
        int i = 1;
        for (String clave : almacen.keySet()) {
            Producto p = almacen.get(clave);
            System.out.printf("%d. %s - %.2f €\n", i++, p.getNombre(), p.getPrecio());
        }
    }

    private static String obtenerClavePorNumero(int num) {
        if (num <= 0 || num > almacen.size()) return null;
        return (String) almacen.keySet().toArray()[num - 1];
    }

    private static int leerEntero() {
        while (true) {
            try {
                int val = Integer.parseInt(scanner.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Introduce un número entero: ");
            }
        }
    }

    private static int leerEnteroPositivo() {
        while (true) {
            int val = leerEntero();
            if (val > 0) return val;
            System.out.print("Introduce un número positivo: ");
        }
    }

    private static double leerDoublePositivo() {
        while (true) {
            try {
                double val = Double.parseDouble(scanner.nextLine());
                if (val > 0) return val;
                else System.out.print("Introduce un número positivo: ");
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Introduce un número válido: ");
            }
        }
    }

    private static double leerDoubleNoNegativo() {
        while (true) {
            try {
                double val = Double.parseDouble(scanner.nextLine());
                if (val >= 0) return val;
                else System.out.print("Introduce un número mayor o igual a cero: ");
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Introduce un número válido: ");
            }
        }
    }

    // CLASE PRODUCTO
    static class Producto {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
    }

    // CLASE COMPRA (producto + cantidad)
    static class Compra {
        private Producto producto;
        private int cantidad;

        public Compra(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        public Producto getProducto() {
            return producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void aumentarCantidad(int cantidad) {
            this.cantidad += cantidad;
        }

        public double getSubtotal() {
            return producto.getPrecio() * cantidad;
        }
    }
}

