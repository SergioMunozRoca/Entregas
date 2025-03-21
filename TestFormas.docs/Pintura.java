package Formas;

public class Pintura {
    protected double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double cantidadPint(Forma forma){
        return forma.area()/cobertura;
    }
}
