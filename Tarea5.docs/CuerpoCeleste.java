package Tarea5;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {

    public enum TipoCuerpoCeleste{
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }

    private String nombreCeleste;
    private double periodoOrbitalCeleste;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombreCeleste, double periodoOrbitalCeleste, TipoCuerpoCeleste tipoCuerpo) {
        this.nombreCeleste = nombreCeleste;
        this.periodoOrbitalCeleste = periodoOrbitalCeleste;
        this.tipoCuerpo = tipoCuerpo;
        satelites = new HashSet<>();
    }

    public String getNombreCeleste() {
        return nombreCeleste;
    }

    public double getPeriodoOrbitalCeleste() {
        return periodoOrbitalCeleste;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return satelites;
    }

    public boolean addSatelite(CuerpoCeleste cuerpoCeleste){
        if(satelites.add(cuerpoCeleste)){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object celeste) {
        if (this == celeste){
            return true;
        }
        if (celeste == null || getClass() != celeste.getClass()){
            return false;
        }

        CuerpoCeleste otrocuerpo = (CuerpoCeleste) celeste;
        return Objects.equals(nombreCeleste, otrocuerpo.nombreCeleste) && tipoCuerpo == otrocuerpo.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCeleste, tipoCuerpo);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCeleste + ", Tipo: " + tipoCuerpo + ", Periodo Orbital: " + periodoOrbitalCeleste;
    }
}
