package BinaryHeap;

import java.util.Arrays;
import java.util.Scanner;

class Heap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] line = sc.nextLine().split(" ");
		int[] inteiros = new int[line.length];
		
		int index = 0;
		for (String num : line) {
			inteiros[index++] = Integer.parseInt(num);
		}
		
		
		System.out.println(isHeap(inteiros));
		
	}
	
	private static boolean isHeap(int[] array) {
		int height = (int) (Math.log(array.length) / Math.log(2));
		
		boolean isheap = true;
		for (int i = 0; i < Math.pow(2, height); i++) {
			int left = 2 * i + 1;
			int right = 2 * (i + 1);
			if(left < array.length 
					&& array[left] > array[i]) {
				isheap = false;
			}
			if(right < array.length 
					&& array[right] > array[i]) {
				isheap = false;
			}
			
		}
		
		return isheap;
	}
	
	private static int right(int posicao) {
		return 2 * (posicao + 1);
	}
	private static int left(int posicao) {
		return 2 * posicao + 1;
	}
}
