package Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TelefonoMovil {

    private ArrayList<Contacto> myContacts;
    private String myNumber;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto.getName()) >= 0) {
            return false;
        }

        myContacts.add(contacto);
        return true;
    }

    public boolean updateContact(Contacto Antiguo, Contacto Nuevo) {

        int posicion = myContacts.indexOf(Antiguo);

        if (posicion < 0) {
            return false;
        }

        for (Contacto contacto: myContacts) {
            if (contacto.getName().equals(Nuevo.getName()) && !contacto.equals(Antiguo)) {
                return false;
            }
        }

        myContacts.set(posicion, Nuevo);
        return true;
    }

    public boolean removeContact (Contacto contacto) {
        int posicion = findContact(contacto.getName());

        if(posicion >= 0) {
            myContacts.remove(posicion);
            return true;
        }

        return false;
    }


    private int findContact(Contacto contacto) {
        if(myContacts.contains(contacto)) {
            return myContacts.indexOf(contacto);
        }else{
            return -1;
        }
    }

    private int findContact(String nombre) {
        int index = 0;
        for (Contacto contacto : myContacts) {
            if (contacto.getName().equalsIgnoreCase(nombre)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private int findContact2(String numero) {
        int index = 0;
        for (Contacto contacto : myContacts) {
            if (contacto.getPhoneNumber().equalsIgnoreCase(numero)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public Contacto queryContact(String nombre) {
        for (Contacto contacto: myContacts) {
            if(nombre.equals(contacto.getName())) {
                return contacto;
            }
        }
        return null;
    }

    public Contacto queryContact2(String numero) {
        for (Contacto contacto: myContacts) {
            if(numero.equals(contacto.getPhoneNumber())) {
                return contacto;
            }
        }
        return null;
    }

    public void ordenarNombre() {

        if (myContacts.isEmpty()) {
            System.out.println("No hay contactos para ordenar.");
            return;
        }

        Collections.sort(myContacts, Comparator.comparing(Contacto::getName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Contactos ordenados por nombre correctamente!!");
        printContacts();
    }

    public void borrarTodo() {
        if (myContacts.isEmpty()) {
            System.out.println("No hay contactos para eliminar.");
        } else {
            myContacts.clear();
            System.out.println("Todos los contactos han sido eliminados con éxito!!");
        }
    }


    public void printContacts() {
        System.out.println("*******************");
        System.out.println("Lista de Contactos");
        System.out.println("*******************");
        for (Contacto contacto : myContacts) {
            System.out.println(contacto.getName() + " -> " + contacto.getPhoneNumber());
        }
    }

    public void numeroContactos() {
        System.out.println("********************");
        System.out.println("Número de Contactos");
        System.out.println("********************");
        System.out.println(myContacts.size());

    }

}
