package Tarea5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    static Set<CuerpoCeleste> planetas = new HashSet<>();
    static Set<CuerpoCeleste> lunas = new HashSet<>();
    static Set<CuerpoCeleste> lunasComunes = new HashSet<>();

    public static void main(String[] args) {

        CuerpoCeleste Mercurio = new Planeta("Mercurio", 88);
        sistemaSolar.put(Mercurio.getNombreCeleste(),Mercurio);
        planetas.add(Mercurio);

        CuerpoCeleste Venus = new Planeta("Venus", 225);
        sistemaSolar.put(Venus.getNombreCeleste(),Venus);
        planetas.add(Venus);

        CuerpoCeleste Tierra = new Planeta("La Tierra", 365);
        sistemaSolar.put(Tierra.getNombreCeleste(),Tierra);
        planetas.add(Tierra);

        CuerpoCeleste Marte = new Planeta("Marte", 687);
        sistemaSolar.put(Marte.getNombreCeleste(),Marte);
        planetas.add(Marte);

        CuerpoCeleste Jupiter = new Planeta("Júpiter", 4332);
        sistemaSolar.put(Jupiter.getNombreCeleste(),Jupiter);
        planetas.add(Jupiter);

        CuerpoCeleste Saturno = new Planeta("Saturno", 10759);
        sistemaSolar.put(Saturno.getNombreCeleste(),Saturno);
        planetas.add(Saturno);

        CuerpoCeleste Urano = new Planeta("Urano", 30660);
        sistemaSolar.put(Urano.getNombreCeleste(),Urano);
        planetas.add(Urano);

        CuerpoCeleste Neptuno = new Planeta("Neptuno", 165);
        sistemaSolar.put(Neptuno.getNombreCeleste(),Neptuno);
        planetas.add(Neptuno);

        CuerpoCeleste Pluton = new Planeta("Plutón", 248);
        sistemaSolar.put(Pluton.getNombreCeleste(),Pluton);
        planetas.add(Pluton);

        CuerpoCeleste PlutonEnano = new PlanetaEnano("Plutón", 884);
        sistemaSolar.put(PlutonEnano.getNombreCeleste(),PlutonEnano);
        planetas.add(PlutonEnano);

        CuerpoCeleste Luna = new Luna("Luna",27);
        sistemaSolar.put(Luna.getNombreCeleste(),Luna);
        Tierra.addSatelite(Luna);

        CuerpoCeleste Deimos = new Luna("Deimos",1.3);
        sistemaSolar.put(Deimos.getNombreCeleste(),Deimos);
        Marte.addSatelite(Deimos);

        CuerpoCeleste Phobos = new Luna("Phobos",0.3);
        sistemaSolar.put(Phobos.getNombreCeleste(),Phobos);
        Marte.addSatelite(Phobos);

        CuerpoCeleste Io = new Luna("Io",1.8);
        sistemaSolar.put(Io.getNombreCeleste(),Io);
        Jupiter.addSatelite(Io);

        CuerpoCeleste Europa = new Luna("Europa",3.5);
        sistemaSolar.put(Europa.getNombreCeleste(),Europa);
        Jupiter.addSatelite(Europa);

        CuerpoCeleste Ganymede = new Luna("Ganymede",7.1);
        sistemaSolar.put(Ganymede.getNombreCeleste(),Ganymede);
        Jupiter.addSatelite(Ganymede);

        CuerpoCeleste Callisto = new Luna("Callisto",16.7);
        sistemaSolar.put(Callisto.getNombreCeleste(),Callisto);
        Jupiter.addSatelite(Callisto);

        System.out.println("================");
        System.out.println("NOMBRE PLANETAS");
        System.out.println("================");

        for(CuerpoCeleste cuerpoCeleste : planetas){
            System.out.println(cuerpoCeleste);
        }

        System.out.println("===============");
        System.out.println("LUNAS DE MARTE");
        System.out.println("===============");

        for (CuerpoCeleste lunaMarte : Marte.getSatelites()) {
         System.out.println("Nombre: " + lunaMarte.getNombreCeleste() + ", Periodo Orbital: " + lunaMarte.getPeriodoOrbitalCeleste());
        }

        System.out.println("===================");
        System.out.println("UNIÓN DE LAS LUNAS");
        System.out.println("===================");

        for(CuerpoCeleste planeta : planetas){
         lunas.addAll(planeta.getSatelites());
        }

        for (CuerpoCeleste luna : lunas){
         System.out.println("Nombre: " + luna.getNombreCeleste() + ", Periodo Orbital: " + luna.getPeriodoOrbitalCeleste());
        }


        System.out.println("=====================");
        System.out.println("INTERSECCIÓN DE LUNAS");
        System.out.println("=====================");

        boolean primeraVez = true;
        for (CuerpoCeleste planeta : planetas) {
            if (!planeta.getSatelites().isEmpty()) {
                if (primeraVez) {
                    lunasComunes.addAll(planeta.getSatelites());
                    primeraVez = false;
                } else {
                    lunasComunes.retainAll(planeta.getSatelites());
                }
            }
        }

        if (lunasComunes.isEmpty()) {
            System.out.println("No hay lunas comunes entre los planetas.");
        } else {
            for (CuerpoCeleste luna : lunasComunes) {
                System.out.println("Luna: " + luna.getNombreCeleste() + ", Periodo Orbital: " + luna.getPeriodoOrbitalCeleste());
            }
        }


    }
}
