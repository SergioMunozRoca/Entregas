package Tarea5;

public class Luna extends CuerpoCeleste{
    private String nombreLuna;
    private double periodoOrbitalLuna;

    public Luna(String nombreCeleste, double periodoOrbitalCeleste) {
        super(nombreCeleste, periodoOrbitalCeleste, TipoCuerpoCeleste.LUNA);
        this.nombreLuna = nombreCeleste;
        this.periodoOrbitalLuna = periodoOrbitalCeleste;
    }
}
