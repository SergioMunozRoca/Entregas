import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EjemploLecturaBinarioArtistas {
    public static void main(String[] args) {

       File archivo=new File("artistas.dat");
        try {
             FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois= new ObjectInputStream(fis);
             while(fis.available()>0) {
                  Artista artista=(Artista) ois.readObject();
                  System.out.println(artista.toString());
             }
             fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }





    }
}