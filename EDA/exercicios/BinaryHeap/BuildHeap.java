package BinaryHeap;

import java.util.Arrays;
import java.util.Scanner;

class BuildHeap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] line = sc.nextLine().split(" ");
		int[] inteiros = new int[line.length];
		
		int index = 0;
		for (String num : line) {
			inteiros[index++] = Integer.parseInt(num);
		}
		
		buildHeap(inteiros);
		
		System.out.println(Arrays.toString(inteiros));
		
	}
	
	private static void buildHeap(int[] array) {
		for (int i = parent(array.length - 1); i >= 0; i--) {
			heapify(i, array);
		}
	}
	
	private static void heapify(int posicao, int[] array) {
		int maxIndex = maxIndex(posicao, array);
		
		if (maxIndex != posicao) {
			int aux = array[posicao];
			array[posicao] = array[maxIndex];
			array[maxIndex] = aux;
			
			heapify(maxIndex, array);
		}
	}
	
	private static int maxIndex(int posicao, int[] array) {
		int left = left(posicao);
		int right = right(posicao);
		
		int biggest = posicao;
		
		if (left < array.length
				&& array[biggest] < array[left]) {
			biggest = left;
		}
		
		if (right < array.length
				&& array[biggest] < array[right]) {
			biggest = right;
		}
		
		return biggest;
	}
	 
	private static int parent(int posicao) {
		return (posicao - 1) / 2;
	}
	
	private static int right(int posicao) {
		return 2 * (posicao + 1);
	}
	
	private static int left(int posicao) {
		return 2 * posicao + 1;
	}
}
