package Tarea5;

public class PlanetaEnano extends CuerpoCeleste {
    private String nombrePlanetaEnano;
    private double periodoOrbitalPlanetaEnano;

    public PlanetaEnano(String nombreCeleste, double periodoOrbitalCeleste) {
        super(nombreCeleste, periodoOrbitalCeleste, TipoCuerpoCeleste.PLANETA_ENANO);
        this.nombrePlanetaEnano = nombreCeleste;
        this.periodoOrbitalPlanetaEnano = periodoOrbitalCeleste;
    }
}
