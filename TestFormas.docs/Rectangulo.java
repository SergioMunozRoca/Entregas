package Formas;

public class Rectangulo extends Forma{
    protected double longitud;
    protected double ancho;

    public Rectangulo(String nombre, double longitud, double ancho) {
        super(nombre);
        this.longitud = longitud;
        this.ancho = ancho;
    }

    @Override
    public double area(){
        return ancho * longitud;
    }
}
