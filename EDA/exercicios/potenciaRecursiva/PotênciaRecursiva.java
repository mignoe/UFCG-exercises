package potenciaRecursiva;

import java.util.*;

class PotênciaRecursiva {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int power = Integer.parseInt(sc.nextLine());
		
		System.out.println(potenciaRecursiva(num, power));
	}
	
	public static int potenciaRecursiva(int num, int power) {
		if (num == 0 && power != 0) return 0;
		
		if (power == 0) return 1;
		
		if (power == 1) return num;
		
		return num * potenciaRecursiva(num, power - 1);
	}
}

// 2 400 500
// 3 100 200	
