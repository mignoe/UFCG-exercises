package inverte_pilha_index;

import java.util.Scanner;

class InvertePilhaIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tamanho = Integer.parseInt(sc.nextLine());
		
		Pilha pilha = new Pilha(tamanho);
		
		
		for (String num : sc.nextLine().split(" ")) {
			pilha.push(Integer.parseInt(num));
		}
		
		int index = Integer.parseInt(sc.nextLine());
		
		Fila fila = new Fila(index + 1);
		
		for (int i = 0; i <= index; i++) {
			fila.push(pilha.pop());
		}
		
		for (int i = 0; i <= index; i++) {
			pilha.push(fila.pop());
		}
		
		
		for (int i = 1; i < tamanho; i++) {
			System.out.println(pilha.pop());
		}
		

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
		return array[tamanho--];
	}
}

class Fila {
	int tamanho;
	int head;
	int tail;
	int[] array;
	
	public Fila(int tamanho) {
		this.array = new int[tamanho];
		this.tamanho = tamanho;
		head = -1;
		tail = -1;
	}
	
	public void push(int num) {
		// x x x x x
		array[++tail % tamanho] = num;
		
		if (head == -1)
			head = 0;
	}
	
	public int pop() {
		return array[head++ % tamanho];
	}
	
	
}
