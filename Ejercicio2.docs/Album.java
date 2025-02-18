package Ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    private Cancion findSong (String titulo){
        for (Cancion cancion : canciones){
            if (cancion.getTitulo().equalsIgnoreCase(titulo)){
                return cancion;
            }
        }
        return null;
    }

    public boolean addSong (String titulo, double duracion){
        if (findSong(titulo) != null){
            System.out.println("Ya se encuentra en la lista");
            return false;
        }
        canciones.add(new Cancion(titulo, duracion));
        return true;
    }

    public boolean addToPlayList (String titulo, LinkedList<Cancion> listaReproduccion){
        Cancion cancion = findSong(titulo);
        if (cancion != null) {
            listaReproduccion.add(cancion);
            return true;
        }
        System.out.println("La cancion no se encuentra en la lista");
        return false;
    }

    public boolean addToPlayList (int numPista, LinkedList<Cancion> listaReproduccion){
        int index = numPista - 1;
        if (index >= 0 && index < canciones.size()){
            listaReproduccion.add(canciones.get(index));
            return true;
        }
        return false;
    }

}
