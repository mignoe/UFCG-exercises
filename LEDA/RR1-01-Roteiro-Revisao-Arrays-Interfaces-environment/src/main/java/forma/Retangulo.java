package forma;

public class Retangulo implements Forma{
    private double base;
    private double altura;
    
    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return this.altura * this.base;
    }
}
