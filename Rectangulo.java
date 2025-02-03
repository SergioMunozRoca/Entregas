import java.lang.Comparable;

public class Rectangulo implements Comparable<Rectangulo> {

    protected int ancho;
    protected int alto;

    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getArea() {
        return ancho * alto;
    }

    @Override
    public int compareTo(Rectangulo r) {
        int resultado = 0;

        if(this.getArea() < r.getArea()) {
            resultado = -1;
        } else if(this.getArea() > r.getArea()) {
            resultado = 1;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "ancho=" + ancho +
                ", alto=" + alto +
                ", Área=" + getArea() +
                '}';
    }
}
