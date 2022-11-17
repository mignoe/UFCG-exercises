package troca.vizinhos;

class white_board {
	public static void main(String[] args) {
		System.out.println(multiplicando(80, 2));
	}
	
	public static int multiplicando(int k, int j) {
		if (k == 0 || j == 0) return 0;
		
		if (j == 1) return k;
		
		return k + multiplicando(k, j - 1);
	}
}
