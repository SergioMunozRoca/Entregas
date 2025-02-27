package Vehiculos;

import java.util.ArrayList;

public class gestorVehiculo {

    private static ArrayList<Vehiculo> vehiculos;

    public gestorVehiculo(){
        vehiculos = new ArrayList<>();
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    private int findVehiculo(String modelo){
        int index = 0;
        for(Vehiculo vehiculo : vehiculos){
            if(vehiculo.getModelo().equalsIgnoreCase(modelo)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean addVehiculo(Vehiculo vehiculo){
        if(findVehiculo(vehiculo.getModelo()) >= 0){
            System.out.println("Este modelo ya existe.");
            return false;
        }
        vehiculos.add(vehiculo);
        return true;
    }

    public static Vehiculo queryVehiculo(String modelo){
        for(Vehiculo vehiculo : vehiculos){
            if(vehiculo.getModelo().equalsIgnoreCase(modelo)){
                return vehiculo;
            }
        }
        return null;
    }

    public boolean removeVehiculo(Vehiculo vehiculo){
        int index = findVehiculo(vehiculo.getModelo());

        if(index == -1){
            return false;
        }
        vehiculos.remove(index);
        return true;

    }
}
