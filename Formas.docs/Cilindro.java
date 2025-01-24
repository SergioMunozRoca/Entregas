package Tarea3_Actividad4;

public class Cilindro extends Forma{

    protected double radio;
    protected double altura;

    public Cilindro(String nombre, double radio, double altura) {
        super(nombre);
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double area(){
        return Math.PI * radio * radio * altura;
    }

}
