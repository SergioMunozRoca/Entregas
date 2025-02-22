// Autor: Sergio Muñoz Roca

import java.time.LocalDate;
import java.util.Scanner;

public class Compra {
    private int idCompra;
    private LocalDate fCompra;
    private String metodoPago;
    private int idUsuario;

    // Constructor
    public Compra(int idCompra, LocalDate fCompra, String metodoPago, int idUsuario) {
        this.idCompra = idCompra;
        this.fCompra = fCompra;
        this.metodoPago = metodoPago;
        this.idUsuario = idUsuario;
    }

    // Getters
    public int getIdCompra() {
        return idCompra;
    }

    public LocalDate getFCompra() {
        return fCompra;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "idCompra = " + idCompra +
                ", fCompra = " + fCompra +
                ", metodoPago = " + metodoPago +
                ", idUsuario = " + idUsuario +
                '}';
    }
}
