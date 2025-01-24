package IMPRESORA;

public class MainEncapsulacion {
    public static void main(String[] args) {
        Impresora impresora = new Impresora(30, 2, true);

        System.out.println("Agregar tóner: " + impresora.agregarToner(70));
        System.out.println("Páginas a imprimir: " + impresora.imprimirPaginas(5));
        System.out.println("Páginas totales impresas: " + impresora.getPaginasImpresas());

    }
}
