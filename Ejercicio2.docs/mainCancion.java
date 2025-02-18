package Ejercicio2;

import java.util.*;

public class mainCancion {

    private static Scanner scanner = new Scanner(System.in);

    public static void imprimirMenu(){
        System.out.println("**********");
        System.out.println("CANCIONES");
        System.out.println("**********");
        System.out.println("0 -Salir de la lista de reproducción");
        System.out.println("1 -Reproducir siguiente canción en la lista");
        System.out.println("2 -Reproducir la canción previa de la lista");
        System.out.println("3 -Repetir canción actual");
        System.out.println("4 -Imprimir la lista de canciones en la playlist");
        System.out.println("5 -Volver a imprimir el menú");
        System.out.println("6 -Eliminar canción actual de la playlist");
        System.out.println("7 -Imprimir álbum");
        System.out.println(".............................................");
    }

    public static void main(String[] args) {
        ArrayList<Album> albumes = new ArrayList<>();

        Album album1 = new Album("Real Hasta La Muerte","Anuel AA");
        album1.addSong("Nada Nuevo",3.5);
        album1.addSong("Quiere Beber",4.0);
        album1.addSong("Brindemos",2.5);
        albumes.add(album1);

        Album album2 = new Album("Energía","Soge Culebra");
        album2.addSong("Ibiza",3.4);
        album2.addSong("Basilisco",2.2);
        album2.addSong("Ikigai",2.5);
        albumes.add(album2);

        Album album3 = new Album("Estrella", "Mora");
        album3.addSong("Pasajero", 2.5);
        album3.addSong("Fantasías",3.5);
        album3.addSong("Laguna",3.0);
        album3.addSong("Diamonds",2.5);
        albumes.add(album3);

        LinkedList<Cancion> listaReproducion = new LinkedList<>();
        album1.addToPlayList(2,listaReproducion);
        album2.addToPlayList("Ibiza",listaReproducion);
        album3.addToPlayList("Basilisco", listaReproducion);
        album3.addToPlayList(3, listaReproducion);
        album1.addToPlayList(4, listaReproducion);
        album2.addToPlayList(10, listaReproducion);
        album1.addToPlayList(1,listaReproducion);
        album3.addToPlayList(1,listaReproducion);

        System.out.println(listaReproducion);
        play(listaReproducion, albumes);

    }

    public static void printAlbum(ArrayList<Album> albumes){

        String findname;

        System.out.println("*************");
        System.out.println("BUSCAR ÁLBUM");
        System.out.println("*************");

        do{
            System.out.print("Introduce el nombre del álbum: ");
            findname = scanner.nextLine();

            if(!findname.matches("[a-zA-Z]*")) {
                System.out.println("Error: solo puedes introducir letras.");
            }
        }while(!findname.matches("[a-zA-Z]*"));

        boolean encontrado = false;
        for (Album album : albumes) {
            if (album.getNombre().equalsIgnoreCase(findname)) {
                System.out.println("Álbum encontrado: Nombre: " + album.getNombre() + " / Artista: " + album.getArtista() + " / Canciones: " + album.getCanciones());
                encontrado = true;
                break;
            }
        }

        if (!encontrado){
            System.out.println("No se encontró el álbum.");
        }

    }

    public static void printPlayList(LinkedList<Cancion> listaReproduccion, ArrayList<Album> albumes){
        Iterator<Cancion> iterator = listaReproduccion.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------");
    }

    public static void play(LinkedList<Cancion> listaReproduccion, ArrayList<Album> albumes) {
        boolean haciaAdelante = true;
        boolean continuar = true;
        ListIterator<Cancion> iterator = listaReproduccion.listIterator();
        int opcion = 0;
        imprimirMenu();

        while(continuar) {
            opcion = -1;

            do{
                try {
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();

                    if(opcion < 0 || opcion > 7) {
                        System.out.println("Error: tienes que introducir un número entre el intervalo.");
                    }

                }catch(Exception e) {
                    System.out.println("Error: solo puedes introducir números.");
                    scanner.next();
                    opcion = -1;
                }

            }while(opcion < 0 || opcion > 7);


            switch (opcion) {
                case 0:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;

                case 1:
                    if (!haciaAdelante) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        haciaAdelante = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Reproduciendo: " + iterator.next());
                    } else {
                        System.out.println("Has llegado al final de la lista de reproducción.");
                        haciaAdelante = false;
                    }
                    break;

                case 2:
                    if (haciaAdelante) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        haciaAdelante = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Reproduciendo: " + iterator.previous());
                    } else {
                        System.out.println("Has llegado al inicio de la lista de reproducción.");
                        haciaAdelante = true;
                    }
                    break;

                case 3:
                    if (haciaAdelante) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Repitiendo reproducción: " + iterator.previous());
                            haciaAdelante = false;
                        } else {
                            System.out.println("No se ha reproducido ninguna canción.");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("Repitiendo reproducción: " + iterator.next());
                            haciaAdelante = true;
                        }else {
                            System.out.println("No se ha reproducido ninguna canción");
                        }
                    }
                    if (listaReproduccion.isEmpty()){
                        System.out.println("La playlist está vacía.");
                    }
                    break;

                case 4:
                    System.out.println("------------");
                    System.out.println("*********");
                    System.out.println("PLAYLIST");
                    System.out.println("*********");
                    if (listaReproduccion.isEmpty()){
                        System.out.println("No hay canciones añadidas en la playlist");
                    }
                    printPlayList(listaReproduccion, albumes);
                    break;

                case 5:
                    imprimirMenu();
                    break;

                case 6:
                    iterator.remove();
                    System.out.println("CANCIÓN ELIMINADA");
                    if (iterator.hasNext()) {
                        System.out.println("Siguiente canción: " + iterator.next());
                    } else if (iterator.hasPrevious()) {
                        System.out.println("Canción anterior: " + iterator.previous());
                    } else if (listaReproduccion.isEmpty()){
                        System.out.println("No quedan canciones para eliminar.");
                        imprimirMenu();
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    printAlbum(albumes);
                    break;

                default:
                    System.out.println("Error: Introduce un número válido.");
            }
        }
    }
}
