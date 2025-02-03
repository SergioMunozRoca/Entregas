package ABSTRACCION.Ejercicio6;

import ABSTRACCION.Ejercicio5.Redimensionable;
import org.w3c.dom.css.Rect;package ABSTRACCION.Ejercicio5;

public class Rectangulo implements Comparable<Rectangulo> {

    protected int ancho;
    protected int alto;

    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void getArea() {
        System.out.println("Área rectángulo: " + ancho * alto);
    }

    public void getPerimeter() {
        System.out.println("Perímetro rectángulo: " + ((2*alto) + (2*ancho)));
    }

    @Override
    public void redimensionar(int x) {
        ancho = ancho * x;
        alto = alto * x;

        System.out.println("El área del rectángulo redimensionada es: ");
        getArea();
        System.out.println("El perímetro del rectángulo redimensionado es: ");
        getPerimeter();
    }
}

