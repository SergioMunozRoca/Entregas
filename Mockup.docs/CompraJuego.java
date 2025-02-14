import Compra.Compra;
import Ejercicio1.Contacto;

import java.util.ArrayList;

public class CompraJuego {

    private ArrayList<Compra> misJuegos;

    public CompraJuego() {

        this.misJuegos = new ArrayList<>();
    }

    private int findCompra(Compra compra) {
        if(misJuegos.contains(compra)) {
            return misJuegos.indexOf(compra);
        }else{
            return -1;
        }
    }

    private int findCompra(int id) {
        int index = 0;
        for (Compra compra : misJuegos) {
            if (compra.getIdCompra() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean addNewJuego(Compra compra) {
        if (findCompra(compra.getIdCompra()) >= 0) {
            return false;
        }

        misJuegos.add(compra);
        return true;
    }

    public void borrarTodo() {
        if (misJuegos.isEmpty()) {
            System.out.println("No hay compras para eliminar.");
        } else {
            misJuegos.clear();
            System.out.println("Todas las compras han sido eliminadas con éxito!!");
        }
    }

    public boolean updateContact(Compra Antigua, Compra Nueva) {

        int posicion = misJuegos.indexOf(Antigua);

        if (posicion < 0) {
            return false;
        }

        for (Compra compra: misJuegos) {
            if (compra.getIdCompra() == (Nueva.getIdCompra()) && !compra.equals(Antigua)) {
                return false;
            }
        }

        misJuegos.set(posicion, Nueva);
        return true;
    }

    public Compra queryCompra(int id) {
        for (Compra compra: misJuegos) {
            if(id == compra.getIdCompra()) {
                return compra;
            }
        }
        return null;
    }

    public void printCompra() {
        System.out.println("*******************");
        System.out.println("Lista de Compras");
        System.out.println("*******************");
        for (Compra compra : misJuegos) {
            System.out.println(compra);
        }
    }
}
