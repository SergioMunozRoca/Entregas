package Tarea3_Actividad4;

public class MainPintura {
    public static void main(String[] args) {

        Pintura pintura = new Pintura(250.0);

        Rectangulo rectangulo = new Rectangulo("Rectángulo",35.0, 20.0);

        Esfera esfera = new Esfera( 15);

        Cilindro cilindro = new Cilindro("Cilindro",10.0, 30.0);

        System.out.println("Cantidad de pintura necesaria para el " + rectangulo + ": " + pintura.cantidadPint(rectangulo));
        System.out.println("Cantidad de pintura necesaria para la " + esfera + ": " + pintura.cantidadPint(esfera));
        System.out.println("Cantidad de pintura necesaria para el " + cilindro + ": " + pintura.cantidadPint(cilindro));

    }
}
