package Vehiculos;

public class Autobus extends Vehiculo{

    private int numPasajeros;

    public Autobus(String marca, String modelo, String anyo, String tipoCombustible, int numPasajeros) {
        super(marca, modelo, anyo, tipoCombustible);
        this.numPasajeros = numPasajeros;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "numPasajeros=" + numPasajeros +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + anyo +
                '}';
    }
}
