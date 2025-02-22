package EjercicioHeroe;

import java.util.ArrayList;
import java.util.Scanner;

public class Asesino extends Heroe{
    private static Scanner scanner = new Scanner(System.in);
    private int sigilo;

    public Asesino(String nombre, int nivel, int puntosVida, armaEspecial armaespecial, int sigilo) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.sigilo = sigilo;
    }

    public void asesinar(){
        System.out.println("Realiza un asesinato en las sombras.");
    }

    public Asesino datos(){
        String nombre;
        int nivel;
        int puntosVida;
        int sigilo;

        do{
            System.out.print("Nombre del Asesino/a: ");
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
                System.out.print("Sigilo: ");
                sigilo = scanner.nextInt();

                scanner.nextLine();

                if(sigilo >= 1000){
                    System.out.println("Error. La fuerza máxima es de 1000.");
                    sigilo = -1;
                }
            }catch (Exception e){
                System.out.println("Error. solo puedes introducir números.");
                scanner.nextLine();
                sigilo = -1;
            }
        }while(sigilo < 0);

        ArrayList<armaEspecial> armasSeleccionadas = new ArrayList<>();
        armaEspecial.obtenerArma(armasSeleccionadas);

        return new Asesino(nombre, nivel, puntosVida, armasSeleccionadas.get(0), sigilo);
    }

}
