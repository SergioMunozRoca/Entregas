package IMPRESORA;

public class Impresora {
    private int nivelToner;
    private int pagImpresas;
    private boolean dobleCara;

    public Impresora(int nivelToner, int pagImpresas, boolean dobleCara) {
        this.nivelToner = nivelToner;
        this.pagImpresas = pagImpresas;
        this.dobleCara = dobleCara;
    }

    public int agregarToner(int cantidadToner){
        nivelToner = nivelToner + cantidadToner;

        if(nivelToner < 0 || nivelToner > 100){
            return -1;
        }
        System.out.println("La cantidad total de tóner es: " + nivelToner);
        return cantidadToner;
    }

    public int imprimirPaginas(int pagAimprimir){

        if(dobleCara){
            pagAimprimir = pagAimprimir * 2;
        }
        pagImpresas = pagImpresas + pagAimprimir;
        return pagAimprimir;
    }

    public int getPaginasImpresas() {
        return pagImpresas;
    }
}
