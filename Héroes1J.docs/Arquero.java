package EjercicioHeroe;

import java.util.ArrayList;
import java.util.Scanner;

public class Arquero extends Heroe{
    private static Scanner scanner = new Scanner(System.in);
    private int precision;

    public Arquero(String nombre, int nivel, int puntosVida, armaEspecial armaespecial, int precision) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.precision = precision;
    }

    public void disparar(){
        System.out.println("Realiza un disparo con su arco.");
    }

    public Arquero datos(){
        String nombre;
        int nivel;
        int puntosVida;
        int precision;

        do{
            System.out.print("Nombre del Arquero/a: ");
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
                System.out.print("Precisión: ");
                precision = scanner.nextInt();

                scanner.nextLine();

                if(precision >= 1000){
                    System.out.println("Error. La fuerza máxima es de 1000.");
                    precision = -1;
                }
            }catch (Exception e){
                System.out.println("Error. solo puedes introducir números.");
                scanner.nextLine();
                precision = -1;
            }
        }while(precision < 0);

        ArrayList<armaEspecial> armasSeleccionadas = new ArrayList<>();
        armaEspecial.obtenerArma(armasSeleccionadas);

        return new Arquero(nombre, nivel, puntosVida, armasSeleccionadas.get(0), precision);
    }

}
