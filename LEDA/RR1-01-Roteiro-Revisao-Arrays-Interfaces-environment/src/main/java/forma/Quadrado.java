package forma;

public class Quadrado implements Forma{
    private double lado;
    
    public Quadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return Math.pow(this.lado, 2);
    }
}
