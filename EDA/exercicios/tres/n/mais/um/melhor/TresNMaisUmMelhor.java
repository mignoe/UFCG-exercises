package tres.n.mais.um.melhor;

public class TresNMaisUmMelhor {
	public static void main(String[] args) {
		System.out.println(tresNMaisUm(6));
	}
	
	public static int tresNMaisUm(int n) {
		int sequencia = 1;
		
		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
			
			sequencia++;
		}
		
		return sequencia;
	}
}
