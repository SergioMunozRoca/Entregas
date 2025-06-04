package Ejercicio9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GuardarEmpleados {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("12345678A", "Juan Pérez", 30, 2500.50));
        empleados.add(new Empleado("87654321B", "María López", 28, 2800.75));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.dat"))) {
            oos.writeObject(empleados);
            System.out.println("Empleados guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
