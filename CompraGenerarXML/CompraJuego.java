package CompraGenerarXML;// Autor: Sergio Muñoz Roca

import java.util.ArrayList;
import java.util.Objects;

public class CompraJuego {

    public ArrayList<Compra> misJuegos;

    public CompraJuego() {
        this.misJuegos = new ArrayList<>();
    }

    private int findCompra(int id) {
        for (int i = 0; i < misJuegos.size(); i++) {
            if (misJuegos.get(i).getIdCompra() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewJuego(Compra compra) {
        if (compra == null || findCompra(compra.getIdCompra()) >= 0) {
            return false;
        }
        return misJuegos.add(compra);
    }

    public boolean removeCompra(int id) {
        Compra compra = queryCompra(id);
        if (compra != null) {
            misJuegos.remove(compra);
            return true;
        }
        return false;
    }

    public boolean updateCompra(Compra antigua, Compra nueva) {
        int posicion = findCompra(antigua.getIdCompra());
        if (posicion < 0 || nueva == null) {
            return false;
        }

        for (Compra compra : misJuegos) {
            if (compra.getIdCompra() == nueva.getIdCompra() && !Objects.equals(compra, antigua)) {
                return false;
            }
        }

        misJuegos.set(posicion, nueva);
        return true;
    }

    public Compra queryCompra(int id) {
        int index = findCompra(id);
        return index >= 0 ? misJuegos.get(index) : null;
    }

    public void printCompra() {
        if (misJuegos.isEmpty()) {
            System.out.println("No hay compras registradas.");
            return;
        }

        System.out.println("*******************");
        System.out.println("Lista de Compras");
        System.out.println("*******************");
        for (Compra compra : misJuegos) {
            System.out.println(compra);
        }
    }
}