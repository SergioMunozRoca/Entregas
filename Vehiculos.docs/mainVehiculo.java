package Vehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class mainVehiculo {

    private static Scanner scanner = new Scanner(System.in);

    private static gestorVehiculo gestor = new gestorVehiculo();

    public static void imprimirMenu(){
        System.out.println("SISTEMA DE GESTIÓN DE VEHÍCULOS");
        System.out.println("1 - Agregar un vehículo");
        System.out.println("2 - Eliminar un vehículo");
        System.out.println("3 - Buscar un vehículo");
        System.out.println("4 - Listar todos los vehículos");
        System.out.println("5 - Salir");
    }

    public static void tipoVehiculo(){
        System.out.println("¿Qué tipo de vehículo deseas agregar?");
        System.out.println("1 - Automóvil");
        System.out.println("2 - Motocicleta");
        System.out.println("3 - Camión");
        System.out.println("4 - Autobús");
    }

    public static void addVehiculo(){
        String marca, modelo, tipoCombustible, anyo;

        System.out.println("AÑADIR NUEVO VEHÍCULO: ");

        int opcion;
        boolean continuar = true;
        tipoVehiculo();

        while(continuar){
            do{
                try{
                    System.out.println("......................");
                    System.out.print("Elige un tipo(0 para cancelar): ");
                    opcion = scanner.nextInt();

                    if (opcion == 0) {
                        System.out.println("Cancelando selección... Volviendo al menú principal.");
                        imprimirMenu();
                        return;
                    }

                    if(opcion < 0 || opcion > 4){
                        System.out.println("Error. Debes introducir una opción válida.");
                    }
                }catch (Exception e){
                    System.out.println("Error. Debes introducir números.");
                    scanner.next();
                    opcion = -1;
                }
            }while(opcion < 0 || opcion >4);

            scanner.nextLine();

            do{
                System.out.print("Ingrese la marca: ");
                marca = scanner.nextLine();

                if(!marca.matches("[a-zA-Z\\s]+")){
                    System.out.println("Error: solo puedes introducir letras en la marca.");
                }
            }while(!marca.matches("[a-zA-Z\\s]+"));

            System.out.print("Ingrese el modelo: ");
            modelo = scanner.nextLine();

            do{
                System.out.print("Ingrese el año: ");
                anyo = scanner.nextLine();

                if(!anyo.matches("\\d{4}")){
                    System.out.println("Error: solo puedes introducir números en el año.");
                }

            }while(!anyo.matches("\\d{4}"));


            do{
                System.out.print("Ingrese el tipo de combustible: ");
                tipoCombustible = scanner.nextLine();

                if(!tipoCombustible.matches("[a-zA-Z\\s]+")){
                    System.out.println("Error: solo puedes letras en el combustible.");
                }
            }while(!tipoCombustible.matches("[a-zA-Z\\s]+"));


            Vehiculo nuevoVehiculo = null;

            switch(opcion){
                case 1:
                    System.out.print("Ingrese el número de puertas: ");
                    int numPuertas = scanner.nextInt();
                    nuevoVehiculo = new Automovil(marca, modelo, anyo, tipoCombustible, numPuertas);
                    break;
                case 2:
                    System.out.print("Ingrese el tipo de manillar: ");
                    String tipoManillar = scanner.nextLine();
                    nuevoVehiculo = new Motocicleta(marca, modelo, anyo, tipoCombustible, tipoManillar);
                    break;
                case 3:
                    System.out.print("Ingrese la capacidad de carga (en toneladas): ");
                    double capacidadCarga = scanner.nextDouble();
                    nuevoVehiculo = new Camion(marca, modelo, anyo, tipoCombustible, capacidadCarga);
                    break;
                case 4:
                    System.out.print("Ingrese la capacidad de pasajeros: ");
                    int numPasajeros = scanner.nextInt();
                    nuevoVehiculo = new Autobus(marca, modelo, anyo, tipoCombustible, numPasajeros);
                    break;
            }

            if(gestor.addVehiculo(nuevoVehiculo)) {
                System.out.println("Vehículo agregado con éxito.");
            }else{
                System.out.println("Error: este modelo ya existe en el sistema.");
            }
            break;
        }
    }

    public static void imprimirVehiculos(){
        System.out.println("DATOS DE LOS VEHÍCULOS: ");

        ArrayList<Vehiculo> listaVehiculos = gestorVehiculo.getVehiculos();

        if(listaVehiculos.isEmpty()){
            System.out.println("No existen vehículos.");
            return;
        }

        for(Vehiculo vehiculo : listaVehiculos){
            System.out.println(vehiculo);
        }
    }

    public static void removeVehiculos(){

        String deleteVehiculo;

        if (gestor.getVehiculos().isEmpty()) {
            System.out.println("No existen vehículos.");
            return;
        }

        System.out.printf("Introduce el modelo del vehículo a eliminar: ");
        deleteVehiculo = scanner.nextLine();

        Vehiculo eliminado = gestorVehiculo.queryVehiculo(deleteVehiculo);

        if(eliminado != null){
            gestor.removeVehiculo(eliminado);
            System.out.println("Vehículo con modelo " + deleteVehiculo + " eliminado.");
        }else{
            System.out.println("El modelo de vehículo no existe.");
        }
    }

    public static void buscarVehiculo(){

        String modelo;
        System.out.println("BUSCAR VEHÍCULO POR MODELO: ");

        if (gestor.getVehiculos().isEmpty()) {
            System.out.println("No existen vehiculos.");
            return;
        }

        System.out.print("Modelo: ");
        modelo = scanner.nextLine().trim();

        Vehiculo encontrado = gestorVehiculo.queryVehiculo(modelo);

        if(encontrado == null){
            System.out.println("El modelo del vehículo no existe.");
        }else{
            System.out.println("Datos del vehículo: ");
            System.out.println(encontrado);
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
                    addVehiculo();
                    break;

                case 2:
                    removeVehiculos();
                    break;

                case 3:
                    buscarVehiculo();
                    break;

                case 4:
                    imprimirVehiculos();
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
