package Vehiculos;

import java.util.ArrayList;

public class Vehiculo {

    protected String marca;
    protected String modelo;
    protected String anyo;
    private String tipoCombustible;


    public Vehiculo(String marca, String modelo, String anyo, String tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
        this.tipoCombustible = tipoCombustible;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnyo() {
        return anyo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void mostrarDetalles(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anyo);
        System.out.println("Tipo de combustible: " + tipoCombustible);

    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anyo=" + anyo +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                '}';
    }
}
