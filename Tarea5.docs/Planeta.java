package Tarea5;

public class Planeta extends CuerpoCeleste{

    private String nombrePlaneta;
    private double periodoOrbitalPlaneta;

    public Planeta(String nombreCeleste, double periodoOrbitalCeleste) {
        super(nombreCeleste, periodoOrbitalCeleste, TipoCuerpoCeleste.PLANETA);
        this.nombrePlaneta = nombreCeleste;
        this.periodoOrbitalPlaneta = periodoOrbitalCeleste;
    }

    public boolean addSateliteLuna(CuerpoCeleste luna){
        if(luna.getTipoCuerpo() == TipoCuerpoCeleste.LUNA){
            return addSateliteLuna(luna);
        }
        return false;
    }
}
