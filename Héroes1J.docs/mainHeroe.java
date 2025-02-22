package EjercicioHeroe;

import java.util.ArrayList;
import java.util.Scanner;

public class mainHeroe {

    private static Heroe heroe = new Heroe("Manolo",25,120,new armaEspecial("rama", 20));
    private static Guerrero guerrero = new Guerrero("Manolo",25,120,new armaEspecial("rama", 20),50);
    private static Mago mago = new Mago("Pepe",30,140,new armaEspecial("palo", 50),30);
    private static Arquero arquero = new Arquero("Jacinto",30,140,new armaEspecial("palo", 50),30);
    private static Asesino asesino = new Asesino("Rodolfo",30,140,new armaEspecial("palo", 50),30);

    private static Scanner scanner = new Scanner(System.in);

    public static void imprimirMenu(){
        System.out.println("***********************");
        System.out.println("BIENVENIDO A HÉROES 1J");
        System.out.println("***********************");
        System.out.println("1 -Añadir un nuevo héroe.");
        System.out.println("2 -Añadir un arma nueva al arsenal.");
        System.out.println("3 -Eliminar un héroe por su nombre.");
        System.out.println("4 -Buscar un héroe y mostrar sus detalles.");
        System.out.println("5 -Listar todos los héroes registrados en el gremio.");
        System.out.println("6 -Salir del programa.");

    }

    public static void tipoHeroe(){
        System.out.println("¿Qué tipo de héroe deseas añadir?");
        System.out.println("1: Guerrero/a");
        System.out.println("2: Mago/a");
        System.out.println("3: Arquero/a");
        System.out.println("4: Asesino/a");
    }

    private static void removeHeroe(){

        String deleteHeroe;

        do{
            System.out.printf("Introduce el nombre del héroe a eliminar: ");
            deleteHeroe = scanner.nextLine();

            if(!deleteHeroe.matches("[a-zA-Z]*")){
                System.out.printf("Error: solo puedes introducir letras en el nombre.");
            }
        }while(!deleteHeroe.matches("[a-zA-Z]*"));


        Heroe eliminado = heroe.queryHeroe(deleteHeroe);

        if (eliminado != null) {
            heroe.removeHeroe(eliminado);
            System.out.println("Héroe eliminado con éxito!!");

        } else {
            System.out.println("Héroe no encontrado.");
        }

    }

    public static void addHeroe(){

        System.out.println("*************");
        System.out.println("AÑADIR HÉROE");
        System.out.println("*************");
        int opcion;
        boolean continuar = true;
        tipoHeroe();

        while(continuar){
            do{
                try{
                    System.out.println("......................");
                    System.out.println("Elige una subopción: ");
                    opcion = scanner.nextInt();

                    if(opcion < 0 || opcion > 4){
                        System.out.println("Error. Debes introducir una opción válida.");
                    }
                }catch (Exception e){
                    System.out.println("Error. Debes introducir números.");
                    scanner.next();
                    opcion = -1;
                }
            }while(opcion < 0 || opcion >4);

            switch(opcion){
                case 0:
                    System.out.println("Cancelando selección...");
                    continuar = false;
                    imprimirMenu();
                    break;
                case 1:
                    Guerrero nuevoGuerrero = guerrero.datos();

                    if(guerrero.addHeroe(nuevoGuerrero)){
                        System.out.println(nuevoGuerrero.getNombre() + " ha sido añadido al gremio con su " + nuevoGuerrero.getArmaespecial().getNombre() + "!");
                    }else{
                        System.out.println("Este guerrero/a ya existe.");
                    }
                    break;
                case 2:
                    Mago nuevoMago = mago.datos();

                    if(mago.addHeroe(nuevoMago)){
                        System.out.println(nuevoMago.getNombre() + " ha sido añadido al gremio con su " + nuevoMago.getArmaespecial().getNombre() + "!");
                    }else{
                        System.out.println("Este mago/a ya existe.");
                    }
                    break;
                case 3:
                    Arquero nuevoArquero = arquero.datos();

                    if(arquero.addHeroe(nuevoArquero)){
                        System.out.println(nuevoArquero.getNombre() + " ha sido añadido al gremio con su " + nuevoArquero.getArmaespecial().getNombre() + "!");
                    }else{
                        System.out.println("Este arquero/a ya existe.");
                    }
                    break;
                case 4:
                    Asesino nuevoAsesino = asesino.datos();

                    if(arquero.addHeroe(nuevoAsesino)){
                        System.out.println(nuevoAsesino.getNombre() + " ha sido añadido al gremio con su " + nuevoAsesino.getArmaespecial().getNombre() + "!");
                    }else{
                        System.out.println("Este asesino/a ya existe.");
                    }
                    break;
            }
        }
    }

    public static void insertarArma(){
        boolean agregarOtra = true;
        ArrayList<armaEspecial> armas = new ArrayList<>();

        while (agregarOtra) {
            String nombreArma;
            int danyo;

            do {
                System.out.print("Introduce el nombre del arma: ");
                nombreArma = scanner.nextLine().trim();

                if (!nombreArma.matches("[a-zA-Z]+")) {
                    System.out.println("Error: solo puedes introducir letras en el nombre.");
                }
            } while (!nombreArma.matches("[a-zA-Z]+"));

            do {
                try {
                    System.out.print("Daño: ");
                    danyo = Integer.parseInt(scanner.nextLine().trim());

                    if (danyo < 0 || danyo > 1000) {
                        System.out.println("Error. El daño debe estar entre 0 y 1000.");
                        danyo = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error. Solo puedes introducir números.");
                    danyo = -1;
                }
            } while (danyo < 0);

            armaEspecial nuevaArma = new armaEspecial(nombreArma, danyo);
            armas.add(nuevaArma);
            System.out.println("Arma añadida con éxito!!");

            System.out.print("¿Quieres añadir otra arma? (S/N): ");
            String respuesta;
            do {
                respuesta = scanner.nextLine().trim();
                if (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
                    System.out.print("Respuesta no válida. Introduce S para sí o N para no: ");
                }
            } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));

            agregarOtra = respuesta.equalsIgnoreCase("S");
        }

        for (armaEspecial arma : armas) {
            armaEspecial.agregarArma(arma);
        }
        armaEspecial.mostrarArmas();
    }


    public static void listaHeroes(){
        System.out.println("***************");
        System.out.println("LISTA DE HÉROES");
        System.out.println("***************");

        ArrayList<Heroe> listaHeroes = Heroe.getHeroes();

        if(listaHeroes.isEmpty()){
            System.out.println("No se han encontrado héroes.");
            return;
        }

        for (Heroe heroe : listaHeroes){
            System.out.println(heroe);
        }
    }

    public static void buscarHeroe(){

        System.out.println("*************");
        System.out.println("BUSCAR HÉROE");
        System.out.println("*************");

        String nombreHeroe;

        do{
            System.out.print("Introduce el nombre del héroe a buscar: ");
            nombreHeroe = scanner.nextLine();

            if(!nombreHeroe.matches("[a-zA-Z]*")) {
                System.out.println("Error: solo puedes introducir letras en el nombre.");
            }
        }while(!nombreHeroe.matches("[a-zA-Z]*"));

        Heroe encontrado = Heroe.queryHeroe(nombreHeroe);

        if(encontrado == null){
            System.out.println("Héroe no encontrado.");
        }else{
            System.out.println("Héroe encontrado con éxto!!");
            System.out.println(encontrado);
        }

    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion;

        imprimirMenu();

        while (continuar) {
            System.out.println("..................");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, introduce un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    addHeroe();
                    break;

                case 2:
                    insertarArma();
                    break;

                case 3:
                    removeHeroe();
                    break;

                case 4:
                    buscarHeroe();
                    break;

                case 5:
                    listaHeroes();
                    break;

                case 6:
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
