package Vehiculos;

public class Camion extends Vehiculo{

    private double capacidadCarga;

    public Camion(String marca, String modelo, String anyo, String tipoCombustible, double capacidadCarga) {
        super(marca, modelo, anyo, tipoCombustible);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "capacidadCarga=" + capacidadCarga +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + anyo +
                '}';
    }
}
