import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EjemploEscrituraBinarioArtistas {
    public static void main(String[] args) {

        Artista juan = new Artista("Juan","España");
        Artista laura = new Artista("Laura","Italia");


        try {
            FileOutputStream fos = new FileOutputStream("artistas.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(juan);
            oos.writeObject(laura);
            fos.close();
            oos.close();
                System.out.println("Objetos escritos en el fichero con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}