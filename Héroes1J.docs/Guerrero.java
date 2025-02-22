package EjercicioHeroe;


import java.util.ArrayList;
import java.util.Scanner;

public class Guerrero extends Heroe{
    private static Scanner scanner = new Scanner(System.in);
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosVida, armaEspecial armaespecial, int fuerza) {
        super(nombre, nivel, puntosVida, armaespecial);
        this.fuerza = fuerza;
    }

    public void atacar(){
        System.out.println("Lanza un golpe fuerte.");
    }

    public Guerrero datos(){
        String nombre;
        int nivel;
        int puntosVida;
        int fuerza;

        do{
            System.out.print("Nombre del Guerrero/a: ");
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
                System.out.print("Fuerza: ");
                fuerza = scanner.nextInt();

                scanner.nextLine();

                if(fuerza >= 1000){
                    System.out.println("Error. La fuerza máxima es de 1000.");
                    fuerza = -1;
                }
            }catch (Exception e){
                System.out.println("Error. solo puedes introducir números.");
                scanner.nextLine();
                fuerza = -1;
            }
        }while(fuerza < 0);

        ArrayList<armaEspecial> armasSeleccionadas = new ArrayList<>();
        armaEspecial.obtenerArma(armasSeleccionadas);

        return new Guerrero(nombre, nivel, puntosVida, armasSeleccionadas.get(0), fuerza);
    }

}
