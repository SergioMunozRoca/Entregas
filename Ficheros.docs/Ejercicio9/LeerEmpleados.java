package Ejercicio9;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LeerEmpleados {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"))) {
            List<Empleado> empleados = (List<Empleado>) ois.readObject();
            System.out.println("Lista de empleados:");
            for (Empleado e : empleados) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
