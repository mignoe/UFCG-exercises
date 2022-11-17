package max.pilha.index;

import java.util.Scanner;

class MaxPilhaIndex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] sequencia = sc.nextLine().split(" ");
		int index = Integer.parseInt(sc.nextLine());
		
		Pilha pilha = new Pilha(sequencia.length);
		Pilha pilha2 = new Pilha(index + 1);
		
		for (int i = 0; i < sequencia.length; i++) {
			pilha.push(Integer.parseInt(sequencia[i]));
		}
		
		int maior = pilha.pop();
		pilha2.push(maior);
		
		for (int i = 0; i < index; i++) {
			int num = pilha.pop();
			if (num > maior)
				maior = num;
			
			pilha2.push(num);
		}
		
		for (int i = 0; i <= index; i++) {
			pilha.push(pilha2.pop());
		}
		
		System.out.println(maior);
	}
}

class Pilha{
	
	private int[] array;
	private int tamanho;
	private int top;
	
	public Pilha(int tamanho) {
		this.array = new int[tamanho];
		this.tamanho = tamanho;
		this.top = -1;
	}
	
	public int pop() {
		return array[top--];
	}
	
	public void push(int value) {
		this.array[++top] = value;
	}
}

