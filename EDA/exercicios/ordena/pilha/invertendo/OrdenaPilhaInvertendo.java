package ordena.pilha.invertendo;

import java.util.Scanner;

class OrdenaPilhaInvertendo{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tamanho = Integer.parseInt(sc.nextLine());
		String[] linha = sc.nextLine().split(" ");
		
		Pilha pilha = new Pilha(tamanho);
		Pilha pilhaOrdenada = new Pilha(tamanho);

		for (String num : linha) {
			pilha.push(Integer.parseInt(num));
		}
		
		for(int i = 0; i < tamanho; i++) {
			inverte(pilha, getMaxIndex(pilha, tamanho - i - 1));
			pilhaOrdenada.push(pilha.pop());
		}
		
		String saida = "-\n";
		while(!pilhaOrdenada.isEmpty()) {
			saida += pilhaOrdenada.pop() + "\n";
		}
		
		System.out.println(saida.trim());
	}
	
	private static void inverte(Pilha pilha1, int index) {
		Pilha pilha2 = new Pilha(index + 1);
		Pilha pilha3 = new Pilha(index + 1);
		
		
		for (int i = 0; i <= index; i++) {
			pilha2.push(pilha1.pop());
		}
		
		while (!pilha2.isEmpty()) {
			pilha3.push(pilha2.pop());
		}

		while (!pilha3.isEmpty()) {
			pilha1.push(pilha3.pop());
		}
	}
	
	private static int getMaxIndex(Pilha pilha, int index) {
		
		Pilha pilha2 = new Pilha(index + 1);
		
		int maior = pilha.pop();
		pilha2.push(maior);
		int indiceMaior = 0;
		
		for (int i = 1; i <= index; i++) {
			int elemento = pilha.pop();
			if (elemento > maior) {
				maior = elemento;
				indiceMaior = i;
			}
			
			pilha2.push(elemento);
		}
		
		// Colocando valores de pilha 2 de volta na pilha
		while(!pilha2.isEmpty()) {
			pilha.push(pilha2.pop());
		}
		
		return indiceMaior;
	}
}

class Pilha {
	int tamanho;
	int[] array;
	int topo;
	
	public Pilha(int tamanho) {
		this.tamanho = tamanho;
		this.array = new int[tamanho];
		this.topo = -1;
	}
	
	public void push(int num) {
		this.array[++topo] = num;
	}
	
	public int pop() {
		return this.array[topo--];
	}
	
	public boolean isEmpty() {
		return this.topo == -1;
	}
}