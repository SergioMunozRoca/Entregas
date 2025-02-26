package Vuelos;

import java.util.ArrayList;
import java.util.Scanner;

public class mainVuelo {

    private static Scanner scanner = new Scanner(System.in);

    private static gestorVuelo gestor = new gestorVuelo();

    public static void imprimirMenu(){
        System.out.println("=====================================");
        System.out.println("  VUELOS DEL AEROPUERTO DE VALENCIA  ");
        System.out.println("=====================================");
        System.out.println("1 - Imprimir todos los vuelos");
        System.out.println("2 - Buscar un número de vuelo");
        System.out.println("3 - Buscar vuelo por clave");
        System.out.println("4 - Añadir vuelo nuevo");
        System.out.println("5 - Borrar vuelo por número");
        System.out.println("0 - SALIR");

    }

    public static void imprimirVuelos(){
        System.out.println("DATOS DE LOS VUELOS: ");

        ArrayList<Vuelo> listaVuelos = gestorVuelo.getVuelos();

        if(listaVuelos.isEmpty()){
            System.out.println("No existen vuelos.");
            return;
        }

        for (Vuelo vuelo : listaVuelos){
            System.out.println(vuelo);
        }
    }

    public static void buscarVuelo(){
        String numeroVuelo;
        System.out.println("BUSCAR VUELO POR Nº: ");

        if (gestor.getVuelos().isEmpty()) {
            System.out.println("No existen vuelos.");
            return;
        }

        do {
            System.out.print("Número de vuelo: ");
            numeroVuelo = scanner.nextLine().trim();

            if (!numeroVuelo.matches("\\d{4}-\\d{2}")) {
                System.out.println("Error: solo puedes introducir números con formato xxxx-yy.");
            }
        } while (!numeroVuelo.matches("\\d{4}-\\d{2}"));

        Vuelo encontrado = gestorVuelo.queryVuelos(numeroVuelo);

        if(encontrado == null){
            System.out.println("El número de vuelo no existe.");
        }else{
            System.out.println("Datos del vuelo: ");
            System.out.println(encontrado);
        }
    }

    public static void buscarClave() {

        if (gestor.getVuelos().isEmpty()) {
            System.out.println("No existen vuelos.");
            return;
        }

        String clave;
        do {
            System.out.print("Clave: ");
            clave = scanner.nextLine().trim();

            if (!clave.matches("numero|origen|destino|dia|clase")) {
                System.out.println("Error: solo puedes introducir una de las claves existentes.");
            }
        } while (!clave.matches("numero|origen|destino|dia|clase"));

        System.out.print("Valor: ");
        String valor = scanner.nextLine().trim();

        ArrayList<Vuelo> vuelosEncontrados = gestor.buscarPorClave(clave, valor);

        if (vuelosEncontrados.isEmpty()) {
            System.out.println("No se encontraron vuelos con " + clave + " = " + valor);
        } else {
            System.out.println("Vuelos encontrados:");
            for (Vuelo vuelo : vuelosEncontrados) {
                System.out.println(vuelo);
            }
        }
    }

    public static void addVuelo(){
        String numeroVuelo;
        String origen;
        String destino;
        String dia;
        String clase;

        System.out.println("AÑADIR NUEVO VUELO:");

        do {
            System.out.print("Número: ");
            numeroVuelo = scanner.nextLine().trim();

            if (!numeroVuelo.matches("\\d{4}-\\d{2}")) {
                System.out.println("Error: solo puedes introducir números con formato xxxx-yy.");
            }
        } while (!numeroVuelo.matches("\\d{4}-\\d{2}"));

        do {
            System.out.print("Origen: ");
            origen = scanner.nextLine().trim();

            if (!origen.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error: solo puedes introducir letras.");
            }
        } while (!origen.matches("[a-zA-Z\\s]+"));

        do {
            System.out.print("Destino: ");
            destino = scanner.nextLine().trim();

            if (!destino.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error: solo puedes introducir letras.");
            }
        } while (!destino.matches("[a-zA-Z\\s]+"));

        boolean fechaValida;
        do {
            System.out.print("Día (dd-mm): ");
            dia = scanner.nextLine().trim();
            fechaValida = true;

            if (!dia.matches("\\d{2}-\\d{2}")) {
                System.out.println("Error: El formato debe ser dd-mm.");
                fechaValida = false;
                continue;
            }

            String[] partes = dia.split("-");
            int day = Integer.parseInt(partes[0]);
            int month = Integer.parseInt(partes[1]);

            if(day < 1 || day > 31){
                System.out.println("Error: el día debe estar entre 01 y 31.");
                fechaValida = false;
            }

            if(month < 1 || month > 12){
                System.out.println("Error: el mes debe estar entre 01 y 12.");
                fechaValida = false;
            }

        } while (!fechaValida);


        do {
            System.out.print("Clase: ");
            clase = scanner.nextLine().trim();

            if (!clase.matches("turista|Turista|primera|Primera")) {
                System.out.println("Error: solo puedes introducir turista o primera.");
            }
        } while (!clase.matches("turista|Turista|primera|Primera"));

        Vuelo newVuelo = new Vuelo(numeroVuelo, origen, destino, dia, clase);

        if(gestor.addVuelo(newVuelo)){
            System.out.println("Vuelo añadido a la lista.");
        }else{
            System.out.println("El vuelo no se ha podido añadir.");
        }
    }

    public static void removeVuelo(){
        String deleteVuelo;

        ArrayList<Vuelo> listaVuelos = gestorVuelo.getVuelos();

        System.out.println("BORRAR VUELO:");

        if(listaVuelos.isEmpty()){
            System.out.println("No existen vuelos.");
            return;
        }

        do{
            System.out.printf("Número de vuelo: ");
            deleteVuelo = scanner.nextLine();

            if(!deleteVuelo.matches("\\d{4}-\\d{2}")){
                System.out.printf("Error: solo puedes introducir números en formato xxxx-yy.");
            }
        }while(!deleteVuelo.matches("\\d{4}-\\d{2}"));

        Vuelo eliminado = gestorVuelo.queryVuelos(deleteVuelo);

        if(eliminado != null){
            gestor.removeVuelo(eliminado);
            System.out.println("Vuelo nº " + deleteVuelo + " eliminado.");
        }else{
            System.out.println("El número de vuelo no existe.");
        }
    }

    public static void main(String[] args) {

        Vuelo vuelo1 = new Vuelo("2023-01","Valencia","Menorca","15-08","turista");
        Vuelo vuelo2 = new Vuelo("2023-02","Valencia","Tenerife","20-08","turista");
        Vuelo vuelo3 = new Vuelo("2023-03","París","Valencia","15-08","primera");
        Vuelo vuelo4 = new Vuelo("2023-04","Atenas","Valencia","20-08","primera");

        gestor.addVuelo(vuelo1);
        gestor.addVuelo(vuelo2);
        gestor.addVuelo(vuelo3);
        gestor.addVuelo(vuelo4);

        boolean continuar = true;
        int opcion;

        imprimirMenu();

        while (continuar) {
            System.out.println("----------------------------");
            System.out.print("Dame la opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, introduce un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    imprimirVuelos();
                    break;

                case 2:
                    buscarVuelo();
                    break;

                case 3:
                    buscarClave();
                    break;

                case 4:
                    addVuelo();
                    break;

                case 5:
                    removeVuelo();
                    break;

                case 0:
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
