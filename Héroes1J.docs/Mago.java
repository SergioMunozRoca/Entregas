package EjercicioHeroe;

import java.util.ArrayList;
import java.util.Scanner;

public class Mago extends Heroe{
    private static Scanner scanner = new Scanner(System.in);
    private int mana;

    public Mago(String nombre, int nivel, int puntosVida, armaEspecial armaespecial, int mana) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.mana = mana;
    }

    public void hechizar(){
        System.out.println("Lanza un hechizo.");
    }

    public Mago datos(){
        String nombre;
        int nivel;
        int puntosVida;
        int mana;

        do{
            System.out.print("Nombre del Mago/a: ");
            nombre = scanner.nextLine();

            if(!nombre.matches("[a-zA-Z]*")){
                System.out.println("Error. Solo puedes introducir letras.");
            }
        }while(!nombre.matches("[a-zA-Z]*"));

        do{
            try{
                System.out.print("Nivel: ");
                nivel = scanner.nextInt();

                scanner.nextLine();

                if(nivel >= 1000){
                    System.out.println("Error. El nivel máximo debe ser de 1000.");
                    nivel = -1;
                }
            }catch (Exception e){
                System.out.println("Error. solo puedes introducir números.");
                scanner.nextLine();
                nivel = -1;
            }
        }while(nivel < 0);

        do{
            try{
                System.out.print("Puntos de Vida: ");
                puntosVida = scanner.nextInt();

                scanner.nextLine();

                if(puntosVida >= 1000){
                    System.out.println("Error. Los puntos de vida máximos es de 1000.");
                    puntosVida = -1;
                }
            }catch (Exception e){
                System.out.println("Error. solo puedes introducir números.");
                scanner.nextLine();
                puntosVida = -1;
            }
        }while(puntosVida < 0);

        do{
            try{
                System.out.print("Mana: ");
                mana = scanner.nextInt();

                scanner.nextLine();

                if(mana >= 1000){
                    System.out.println("Error. La fuerza máxima es de 1000.");
                    mana = -1;
                }
            }catch (Exception e){
                System.out.println("Error. solo puedes introducir números.");
                scanner.nextLine();
                mana = -1;
            }
        }while(mana < 0);

        ArrayList<armaEspecial> armasSeleccionadas = new ArrayList<>();
        armaEspecial.obtenerArma(armasSeleccionadas);

        return new Mago(nombre, nivel, puntosVida, armasSeleccionadas.get(0), mana);
    }

    @Override
    public String toString() {
        return "Mago{Nombre: " + getNombre() + ", Nivel: " + getNivel() + ", Puntos de Vida: " + getPuntosVida() + ", Mana: " + mana + ", Arma Especial: " + getArmaespecial() + "}";
    }
}
