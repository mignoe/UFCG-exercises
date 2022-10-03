package forma;

public class Circulo implements Forma {
    private double raio;
    
    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double calculaArea() {
        return Math.PI * Math.pow(this.raio, 2);
    }
}
