package marianaeoslivros;

import java.util.Arrays;
import java.util.Scanner;

class MarianaEOsLivros {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String[] livros = sc.nextLine().split(",");
	     
	    System.out.println(Arrays.toString(livros).substring(1, Arrays.toString(livros).length() - 1));
	    
	    insertionSort(livros);	
	}
	
	public static void insertionSort(String[] livros) {
		for (int i = 1; i < livros.length; i++) {
			for (int j = i; j > 0; j--){
				if (livros[j].compareTo(livros[j - 1]) < 0) {
					String aux = livros[j];
					
					livros[j] = livros[j - 1];
					livros[j - 1] = aux;
				} else { break; }
			}
			
			System.out.println(Arrays.toString(livros).substring(1, Arrays.toString(livros).length() - 1));
		}
	}
}
