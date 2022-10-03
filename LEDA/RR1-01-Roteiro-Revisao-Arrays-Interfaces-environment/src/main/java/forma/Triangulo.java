package forma;

public class Triangulo implements Forma{
    
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return (this.altura * this.base) / 2;
    }
}
