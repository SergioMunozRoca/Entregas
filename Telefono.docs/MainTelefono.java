package Ejercicio1;

import java.util.Scanner;

public class MainTelefono {

    private static Scanner scanner = new Scanner(System.in);
    private static TelefonoMovil telefonoMovil = new TelefonoMovil("644451404");

    public static void imprimirMenu() {
        System.out.println("**********");
        System.out.println("CONTACTOS");
        System.out.println("**********");
        System.out.println("0 - Salir");
        System.out.println("1 - Imprimir Contactos");
        System.out.println("2 - Añadir Contacto");
        System.out.println("3 - Actualizar Contacto");
        System.out.println("4 - Eliminar Contacto");
        System.out.println("5 - Buscar Contacto");
        System.out.println("6 - Imprimir menú");
        System.out.println("7 - Buscar Teléfono");
        System.out.println("8 - Ordenar por nombre");
        System.out.println("9 - Borrar Todo");
        System.out.println("10 - Número de Contactos");
    }

    private static void addNewContact() {
        String nombre;
        String numero;
        do{
            System.out.print("· Introduce el nombre del contacto: ");
            nombre = scanner.nextLine();

            if(!nombre.matches("[a-zA-Z]*")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir letras en el nombre." + Colores.RESET);
            }

        }while (!nombre.matches("[a-zA-Z]*"));

        do{
            System.out.print("· Introduce el número (máximo 9 dígitos): ");
            numero = scanner.nextLine();

            if(!numero.matches("[0-9]{1,9}")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir máximo 9 números." + Colores.RESET);
            }

        }while(!numero.matches("[0-9]{1,9}"));


        Contacto newContact = Contacto.createContact(nombre, numero);

        if (telefonoMovil.addNewContact(newContact)) {
            System.out.println(Colores.CYAN + "Contacto añadido correctamente!!" + Colores.RESET);
        } else {
            System.out.println(Colores.RED + "Error: El contacto ya existe." + Colores.RESET);
        }
    }

    private static void updateContact() {
        String NombreAntiguo;
        String nuevoNombre;
        String nuevoNumero;

        do{
            System.out.print("· Introduce el nombre del contacto a actualizar: ");
            NombreAntiguo = scanner.nextLine();

            if(!NombreAntiguo.matches("[a-zA-Z]*")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir letras en el nombre." + Colores.RESET);
            }
        }while(!NombreAntiguo.matches("[a-zA-Z]*"));

        Contacto existente = telefonoMovil.queryContact(NombreAntiguo);

        if (existente == null) {
            System.out.println(Colores.RED + "Contacto no encontrado." + Colores.RESET);
            return;
        }

        do{
            System.out.print("· Introduce el nuevo nombre: ");
            nuevoNombre = scanner.nextLine();

            if(!nuevoNombre.matches("[a-zA-Z]*")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir letras en el nombre." + Colores.RESET);
            }
        }while(!nuevoNombre.matches("[a-zA-Z]*"));

        do{
            System.out.print("· Introduce el nuevo número (máximo 9 dígitos): ");
            nuevoNumero = scanner.nextLine();

            if(!nuevoNumero.matches("[0-9]{1,9}")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir máximo 9 números." + Colores.RESET);
            }
        }while(!nuevoNumero.matches("[0-9]{1,9}"));


        Contacto ContactoActualizado = Contacto.createContact(nuevoNombre, nuevoNumero);

        if (telefonoMovil.updateContact(existente, ContactoActualizado)) {
            System.out.println(Colores.CYAN + "Contacto actualizado con éxito!!" + Colores.RESET);
        } else {
            System.out.println(Colores.RED + "Error: No se puede actualizar." + Colores.RESET);
        }
    }

    private static void removeContact() {

        String deleteContact;

        do{
            System.out.print("· Introduce el nombre del contacto a eliminar: ");
            deleteContact = scanner.nextLine();

            if(!deleteContact.matches("[a-zA-Z]*")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir letras en el nombre." + Colores.RESET);
            }
        }while(!deleteContact.matches("[a-zA-Z]*"));

        Contacto contactoEliminar = telefonoMovil.queryContact(deleteContact);

        if (contactoEliminar == null) {
            System.out.println(Colores.RED + "Contacto no encontrado." + Colores.RESET);
        } else {
            telefonoMovil.removeContact(contactoEliminar);
            System.out.println(Colores.CYAN + "Contacto eliminado con éxito!!" + Colores.RESET);
        }
    }

    private static void findContact() {

        String findName;

        do{
            System.out.print("· Introduce el nombre del contacto a buscar: ");
            findName = scanner.nextLine();

            if(!findName.matches("[a-zA-Z]*")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir letras en el nombre." + Colores.RESET);
            }
        }while(!findName.matches("[a-zA-Z]*"));

        Contacto encontrado = telefonoMovil.queryContact(findName);

        if (encontrado != null) {
            System.out.println("Contacto encontrado: " + encontrado.getName() + " -> " + encontrado.getPhoneNumber());
        } else {
            System.out.println(Colores.RED + "No se encontró el contacto." + Colores.RESET);
        }
    }

    private static void findContact2() {

        String findNumber;

        do{
            System.out.print("· Introduce el número del contacto a buscar: ");
            findNumber = scanner.nextLine();

            if(!findNumber.matches("[0-9]{1,9}")) {
                System.out.println(Colores.RED + "Error: solo puedes introducir máximo 9 números." + Colores.RESET);
            }
        }while(!findNumber.matches("[0-9]{1,9}"));

        Contacto encontrado = telefonoMovil.queryContact2(findNumber);

        if (encontrado != null) {
            System.out.println("Número de contacto encontrado: " + encontrado.getName() + " -> " + encontrado.getPhoneNumber());
        } else {
            System.out.println(Colores.RED + "No se encontró el número de contacto." + Colores.RESET);
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
                System.out.println("Por favor, introduce un número válido: ");
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
                    telefonoMovil.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    findContact();
                    break;

                case 6:
                    imprimirMenu();
                    break;

                case 7:
                    findContact2();
                    break;

                case 8:
                    telefonoMovil.ordenarNombre();
                    break;

                case 9:
                    telefonoMovil.borrarTodo();
                    break;

                case 10:
                    telefonoMovil.printNumbers();
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
