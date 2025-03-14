package BusElche;

import java.util.*;

public class mainBus {

    static Map<String, Paradas> lineaA = new HashMap<>();
    static Map<String, Paradas> lineaI = new HashMap<>();
    static Map<String, Paradas> lineaJ = new HashMap<>();
    static Map<String, Paradas> lineaF = new HashMap<>();
    static List<Tramo> tramos = new ArrayList<>();
    static Set<Paradas> paradas = new HashSet<>();

    private static void datosParadas() {
        Paradas parada001 = new Paradas(1, "Doctor Caro", "C/Doctor Caro");
        lineaA.put(parada001.getNombre(), parada001);
        paradas.add(parada001);

        Paradas parada002 = new Paradas(2, "Vicente Blasco Ibáñez", "Vicente Blasco Ibáñez, 22");
        lineaA.put(parada002.getNombre(), parada002);
        paradas.add(parada002);

        Paradas parada003 = new Paradas(3, "Vicente Blasco Ibáñez", "Vicente Blasco Ibáñez, 80");
        lineaA.put(parada003.getNombre(), parada003);
        paradas.add(parada003);

        Paradas parada004 = new Paradas(4, "Inem Carrús", "Inem Carrús");
        lineaA.put(parada004.getNombre(), parada004);
        paradas.add(parada004);

        Paradas parada005 = new Paradas(5, "Pedro Moreno Sastre", "Pedro Moreno Sastre, 62");
        lineaA.put(parada005.getNombre(), parada005);
        paradas.add(parada005);

        lineaI.put(parada003.getNombre(), parada003);
        paradas.add(parada003);

        Paradas parada071 = new Paradas(71, "Jorge Juan-Reina Victoria", "Jorge Juan-Reina Victoria");
        lineaI.put(parada071.getNombre(), parada071);
        paradas.add(parada071);

        Paradas parada335 = new Paradas(335, "Gabriel Miró", "Gabriel Miró");
        lineaI.put(parada335.getNombre(), parada335);
        paradas.add(parada335);

        Paradas parada346 = new Paradas(346, "Passeig de les Germanies", "Passeig de les Germanies");
        lineaI.put(parada346.getNombre(), parada346);
        paradas.add(parada346);

        Paradas parada347 = new Paradas(347, "Federico G.Lorca-Asilo", "Federico G.Lorca-Asilo");
        lineaI.put(parada347.getNombre(), parada347);
        paradas.add(parada347);

        Paradas parada115 = new Paradas(115, "Centre-Avg. C.Valenciana", "Centre-Avg. C.Valenciana");
        lineaJ.put(parada115.getNombre(), parada115);
        paradas.add(parada115);

        lineaJ.put(parada002.getNombre(), parada002);
        paradas.add(parada002);

        Paradas parada089 = new Paradas(89, "Avinguda Llibertat", "Avinguda Llibertat, 11");
        lineaJ.put(parada089.getNombre(), parada089);
        paradas.add(parada089);

        Paradas parada090 = new Paradas(90, "Renfe-Parc Municipal", "Renfe-Parc Municipal");
        lineaJ.put(parada090.getNombre(), parada090);
        paradas.add(parada090);

        Paradas parada117 = new Paradas(117, "Virgen de la Cabeza", "Virgen de la Cabeza-LI. del Pensionista");
        lineaJ.put(parada117.getNombre(), parada117);
        paradas.add(parada117);

        lineaF.put(parada115.getNombre(), parada115);
        paradas.add(parada115);

        lineaF.put(parada002.getNombre(), parada002);
        paradas.add(parada002);

        Paradas parada056 = new Paradas(56, "Cristóbal Sanz", "Cristóbal Sanz");
        lineaF.put(parada056.getNombre(), parada056);
        paradas.add(parada056);

        lineaF.put(parada089.getNombre(), parada089);
        paradas.add(parada089);

        lineaF.put(parada090.getNombre(), parada090);
        paradas.add(parada090);

        tramos.add(new Tramo("A", 1, 2, 75));
        tramos.add(new Tramo("A", 2, 3, 60));
        tramos.add(new Tramo("A", 3, 4, 40));
        tramos.add(new Tramo("A", 4, 5, 50));
        tramos.add(new Tramo("A", 5, 6, 80));

        tramos.add(new Tramo("I", 3, 71, 50));
        tramos.add(new Tramo("I", 71, 335, 100));
        tramos.add(new Tramo("I", 335, 346, 70));
        tramos.add(new Tramo("I", 346, 347, 50));
        tramos.add(new Tramo("I", 347, 400, 120));

        tramos.add(new Tramo("J", 115, 2, 125));
        tramos.add(new Tramo("J", 2, 89, 75));
        tramos.add(new Tramo("J", 56, 90, 40));
        tramos.add(new Tramo("J", 89, 117, 80));
        tramos.add(new Tramo("J", 90, 600, 40));

        tramos.add(new Tramo("F", 115, 2, 125));
        tramos.add(new Tramo("F", 2, 56, 45));
        tramos.add(new Tramo("F", 56, 89, 40));
        tramos.add(new Tramo("F", 89, 90, 75));
        tramos.add(new Tramo("F", 90, 900, 70));
    }

    private static Paradas obtenerParada(int numero) {
        for (Paradas parada : paradas) {
            if (parada.getNumero() == numero) {
                return parada;
            }
        }
        return null;
    }

    private static List<Tramo> calcularRuta(int inicio, int fin, String lineaInicial) {
        List<List<Tramo>> rutasPosibles = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();

        for (Tramo tramo : tramos) {
            if (tramo.getOrigen() == inicio) {
                List<Tramo> nuevaRuta = new ArrayList<>();
                nuevaRuta.add(tramo);
                rutasPosibles.add(nuevaRuta);
                visitados.add(inicio);
            }
        }

        while (!rutasPosibles.isEmpty()) {
            List<Tramo> rutaActual = rutasPosibles.remove(0);
            Tramo ultimoTramo = rutaActual.get(rutaActual.size() - 1);

            if (ultimoTramo.getDestino() == fin) {
                return rutaActual;
            }

            for (Tramo tramo : tramos) {
                if (tramo.getOrigen() == ultimoTramo.getDestino() && !visitados.contains(tramo.getDestino())) {
                    List<Tramo> nuevaRuta = new ArrayList<>(rutaActual);
                    nuevaRuta.add(tramo);
                    rutasPosibles.add(nuevaRuta);
                    visitados.add(tramo.getDestino());
                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {

        datosParadas();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Elige parada inicial: ");
        int paradaInicial = scanner.nextInt();
        Paradas origen = obtenerParada(paradaInicial);
        if (origen == null) {
            System.out.println("Parada no encontrada.");
            return;
        }
        System.out.println("Has elegido " + origen.getNombre() + " – " + origen.getDireccion());

        System.out.print("Bus Línea: ");
        String lineaInicial = scanner.next().toUpperCase();
        boolean lineaExiste = false;
        for (Tramo tramo : tramos) {
            if (tramo.getLinea().equalsIgnoreCase(lineaInicial)) {
                lineaExiste = true;
                break;
            }
        }
        if (!lineaExiste) {
            System.out.println("Línea no encontrada.");
            return;
        }

        System.out.print("Elige Parada final: ");
        int paradaFinal = scanner.nextInt();
        Paradas destino = obtenerParada(paradaFinal);
        if (destino == null) {
            System.out.println("Parada no encontrada.");
            return;
        }
        System.out.println("Has elegido " + destino.getNombre() + " – " + destino.getDireccion());

        List<Tramo> ruta = calcularRuta(paradaInicial, paradaFinal, lineaInicial);
        if (ruta.isEmpty()) {
            System.out.println("No se encontró una ruta válida.");
            return;
        }

        int tiempoTotal = 0;

        System.out.println();

        for (Tramo tramo : ruta) {
            System.out.println(tramo.getLinea() + " desde " + tramo.getOrigen() + " hasta " + tramo.getDestino() + " - " + tramo.getTiempo() + " segundos");
            tiempoTotal += tramo.getTiempo();
        }

        System.out.println();

        int minutos = tiempoTotal / 60;
        int segundos = tiempoTotal % 60;
        System.out.println("Duración trayecto: " + tiempoTotal + " segundos, " + minutos + " minutos y " + segundos + " segundos.");
    }
}
