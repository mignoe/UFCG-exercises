package inverte.pilha.index;

import java.util.Scanner;

class InvertePilhaIndex {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		int tamanho = Integer.parseInt(sc.nextLine());
				
		Pilha pilha1 = new Pilha(tamanho);
		
		for (String num : sc.nextLine().split(" ")) {
			pilha1.push(Integer.parseInt(num));
		}
		
		int index = Integer.parseInt(sc.nextLine());
		
		Pilha pilha2 = new Pilha(index + 1);
				
		for (int i = 0; i <= index; i++) {
			pilha2.push(pilha1.pop());
		}		
		
		String result = "";
		
		for (int i = 0; i <= index; i++) {
			result += pilha2.pop() + "\n";
		}
		for (int i = 0; i < tamanho - index - 1; i++) {
			result += pilha1.pop() + "\n";
		}
		
		System.out.println("-\n" + result.trim());
	}
	
}

class Pilha {
	
	int tamanho;
	int topo;
	int[] array;
	
	public Pilha(int tamanho) {
		this.array = new int[tamanho];
		this.tamanho = tamanho;
		topo = -1;		
	}
	
	public void push(int num) {
		array[++topo] = num;
	}
	
	public int pop() {
		return array[topo--];
	}
}
