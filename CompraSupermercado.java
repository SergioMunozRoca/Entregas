import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompraSupermercado {
    public static void main(String[] args) {
        Map<String, Double> precios = Map.of(
                "avena", 2.21,
                "garbanzos", 2.39,
                "tomate", 1.59,
                "jengibre", 3.13,
                "quinoa", 4.50,
                "guisantes", 1.60
        );

        Map<String, Producto> compra = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Producto: ");
        String nombre = sc.nextLine();

        while(!nombre.equals("fin")) {

            if(!precios.containsKey(nombre)) {
                System.out.println("No existe el producto");
            }else{
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(sc.nextLine());

                double precio = precios.get(nombre);
                if (compra.containsKey(nombre)) {
                    compra.get(nombre).agregarCantidad(cantidad);
                }else{
                    compra.put(nombre, new Producto(nombre, precio, cantidad));
                }

            }

            System.out.print("Producto: ");
            nombre = sc.nextLine();
        }

        DecimalFormat df = new DecimalFormat("#.00");
        double total = 0.0;
        StringBuilder ticket = new StringBuilder();

        System.out.println();

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
        ticket.append("TOTAL:\t\t\t\t\t\t\t").append(df.format(total)).append("\n");

        System.out.println(ticket);

        try (FileWriter fw = new FileWriter("C:\\Users\\User\\Desktop\\ejemplo\\ticket.txt")) {
            fw.write(ticket.toString());
        } catch (IOException e) {
            System.out.println("Error escribiendo ticket: " + e.getMessage());
        }

    }
}