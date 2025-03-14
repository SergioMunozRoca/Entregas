package BusElche;

public class Tramo {

    private String linea;
    private int origen;
    private int destino;
    private int tiempo;

    public Tramo(String linea, int origen, int destino, int tiempo) {
        this.linea = linea;
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
