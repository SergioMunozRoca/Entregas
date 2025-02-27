package Vehiculos;

public class Motocicleta extends Vehiculo{

    private String tipoManillar;

    public Motocicleta(String marca, String modelo, String anyo, String tipoCombustible, String tipoManillar) {
        super(marca, modelo, anyo, tipoCombustible);
        this.tipoManillar = tipoManillar;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "tipoManillar='" + tipoManillar + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + anyo +
                '}';
    }
}
