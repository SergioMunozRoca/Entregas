package Vehiculos;

public class Automovil extends Vehiculo{

    private int numPuertas;

    public Automovil(String marca, String modelo, String anyo, String tipoCombustible, int numPuertas) {
        super(marca, modelo, anyo, tipoCombustible);
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "numPuertas=" + numPuertas +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + anyo +
                '}';
    }
}
