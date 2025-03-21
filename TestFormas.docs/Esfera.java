package Formas;

public class Esfera extends Forma{

    private double radio;

    public Esfera(double radio){
        super("Esfera");
        this.radio = radio;
    }

    @Override
    public double area(){
        return 4 * Math.PI * radio * radio;
    }
}
