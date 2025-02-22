package EjercicioHeroe;

import UD7.Ejercicio2.Cancion;

import java.util.ArrayList;

public class Heroe {

    private String nombre;
    private int nivel;
    private int puntosVida;
    private armaEspecial armaespecial;
    private static ArrayList<Heroe> heroes = new ArrayList<>();

    public Heroe(String nombre, int nivel, int puntosVida, armaEspecial armaespecial) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.armaespecial = armaespecial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public armaEspecial getArmaespecial() {
        return armaespecial;
    }

    public static ArrayList<Heroe> getHeroes() {
        return heroes;
    }

    public boolean addHeroe (Heroe heroe){
        if (findHeroe(heroe.getNombre()) >= 0){
            System.out.println("Ya existe este héroe.");
            return false;
        }
        heroes.add(heroe);
        return true;
    }

    private int findHeroe (String nombre){
        int index = 0;
        for (Heroe heroe : heroes){
            if (heroe.getNombre().equalsIgnoreCase(nombre)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean removeHeroe(Heroe heroe){
        int index = findHeroe(heroe.getNombre());

        if (index == -1){
            return false;
        }
        heroes.remove(index);
        return true;
    }

    public static Heroe queryHeroe(String nombre){
        for (Heroe heroe: heroes) {
            if(heroe.getNombre().equalsIgnoreCase(nombre)){
                return heroe;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Heroe{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", armaespecial=" + armaespecial +
                '}';
    }
}
