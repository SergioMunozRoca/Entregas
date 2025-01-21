public class Main {
    public static void main(String[] args) {

        Cilindro cilindro = new Cilindro(5, 10);
        System.out.println("Radio: " + cilindro.getRadio());
        System.out.println("Altura: " + cilindro.getAltura());
        System.out.println("Área (Base): " + cilindro.getArea());
        System.out.println("Volumen: " + cilindro.getVolume());

        System.out.println();

        Circulo circulo = new Circulo(3);
        System.out.println("Radio: " + circulo.getRadio());
        System.out.println("Área (Base): " + circulo.getArea());

    }
}
